package com.blitmatthew.monster_trainer;

import com.blitmatthew.monster_trainer.entity.Monster;
import com.blitmatthew.monster_trainer.repository.MonsterRepository;
import com.blitmatthew.monster_trainer.service.MonsterServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class MonsterServiceTest {
    @InjectMocks
    private MonsterServiceImpl monsterService;

    @Mock
    private MonsterRepository monsterRepository;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void takeDown() throws Exception {
        closeable.close();
    }

    @Test
    public void MonsterServiceImpl_updateMonster_Success() {
         Monster monster = Monster.builder()
                 .id(1L)
                 .name("Koko")
                 .species("Skinwalker")
                 .height(10.5)
                 .weight(350.00)
                 .price(70000.00)
                 .attackPower(150l)
                 .defensePower(250l)
                 .trainer(null)
                 .build();
         Mockito.when(monsterRepository.findById(monster.getId())).thenReturn(Optional.of(monster));
         Mockito.when(monsterRepository.save(monster)).thenReturn(monster);

         Monster monster1 = monsterService.updateMonster(monster);

         assertThat(monster1).isEqualTo(monster);
         assertEquals(monster, monster1);
    }

    @Test
    public void MonsterServiceImpl_updateMonster_MissingIdThrowsException() {
        Monster monster = Monster.builder()
                .name("Koko")
                .species("Skinwalker")
                .height(10.5)
                .weight(350.00)
                .price(70000.00)
                .attackPower(150l)
                .defensePower(250l)
                .trainer(null)
                .build();

        Throwable throwable = assertThrows(EntityNotFoundException.class, () -> monsterService.updateMonster(monster));

        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
        assertThat(throwable.getMessage()).isEqualTo("Id not found");
    }

    @ParameterizedTest
    @ValueSource(longs = {-42l, 0l, -15l, 500l})
    public void MonsterServiceImpl_updateMonster_InvalidIdsThrowsExceptions(long id) {
        Monster monster = Monster.builder()
                .id(id)
                .name("Koko")
                .species("Skinwalker")
                .height(10.5)
                .weight(350.00)
                .price(70000.00)
                .attackPower(150l)
                .defensePower(250l)
                .trainer(null)
                .build();

        Throwable throwable = assertThrows(EntityNotFoundException.class, () -> monsterService.updateMonster(monster));

        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
        assertThat(throwable.getMessage()).isEqualTo("Id not found");
    }

    @Test
    public void MonsterServiceImpl_updateMonster_ValidationOfChange() {
        Monster oldMonster = Monster.builder()
                .id(1L)
                .name("Koko")
                .species("Skinwalker")
                .height(10.5)
                .weight(350.00)
                .price(70000.00)
                .attackPower(150l)
                .defensePower(250l)
                .trainer(null)
                .build();

        Monster newMonster = Monster.builder()
                .id(1L)
                .name("Nazi")
                .species("Devil")
                .height(5.1)
                .weight(400.00)
                .attackPower(25L)
                .defensePower(25L)
                .price(100000.00)
                .trainer(null)
                .build();
        Mockito.when(monsterRepository.findById(newMonster.getId())).thenReturn(Optional.of(oldMonster));
        Mockito.when(monsterRepository.save(newMonster)).thenReturn(newMonster);

        Monster result = monsterService.updateMonster(newMonster);

        assertNotEquals(oldMonster, result);
        assertEquals(newMonster, result);
    }

    @Test
    public void MonsterServiceImpl_deleteMonster_Success() {
        Long id = 1L;

        Mockito.when(monsterRepository.existsById(id)).thenReturn(true);

        monsterService.deleteMonster(id);

        verify(monsterRepository).deleteById(id);
    }

    @ParameterizedTest
    @ValueSource(longs = {-15l, 0l, 500l})
    public void MonsterServiceImpl_deleteMonster_InvalidIdThrowsException(long id) {
        Mockito.when(monsterRepository.existsById(id)).thenReturn(false);
        Throwable throwable = assertThrows(EntityNotFoundException.class, () -> monsterService.deleteMonster(id));
        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
        assertThat(throwable.getMessage()).isEqualTo("Monster with id " + id + " not found!");
    }
}
