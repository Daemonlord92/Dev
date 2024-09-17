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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
