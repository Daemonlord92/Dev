package com.blitmatthew.monster_trainer.service;

import com.blitmatthew.monster_trainer.dto.PostNewMonster;
import com.blitmatthew.monster_trainer.entity.Monster;
import com.blitmatthew.monster_trainer.mapper.NewMonsterMapper;
import com.blitmatthew.monster_trainer.repository.MonsterRepository;
import com.blitmatthew.monster_trainer.repository.TrainerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class MonsterServiceImpl implements MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private NewMonsterMapper monsterMapper;  // Injected using Spring

    @Override
    public Monster saveMonster(PostNewMonster monster) {
        Monster newMonster = monsterMapper.fromDto(monster);  // Use the injected mapper
        return monsterRepository.save(newMonster);
    }

    @Override
    public List<Monster> getAllMonsters() {
        return monsterRepository.findAll();
    }

    @Override
    public Monster getMonsterById(Long id) {
        return monsterRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Monster with id of " + id + " was not found!"));
    }

    @Override
    public List<Monster> getMonsterBySpeciesType(String species) {
        return monsterRepository.findBySpecies(species);
    }

    @Override
    public List<Monster> getMonstersWithPriceGreaterThan(Double price) {
        return monsterRepository.findByPriceGreaterThan(price);
    }

    @Override
    public Monster updateMonster(Monster monster) {
        Monster oldMonsterData = monsterRepository.findById(monster.getId()).orElseThrow(() ->
                new EntityNotFoundException("Id not found"));
        return monsterRepository.save(monster);
    }

    @Override
    public void deleteMonster(Long id) {
        if(!monsterRepository.existsById(id)) throw new EntityNotFoundException("Monster with id " + id + " not found!");
        monsterRepository.deleteById(id);
    }
}
