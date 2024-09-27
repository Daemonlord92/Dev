package com.blitmatthew.monster_trainer.service;

import com.blitmatthew.monster_trainer.dto.PostNewMonster;
import com.blitmatthew.monster_trainer.entity.Monster;

import java.util.List;

public interface MonsterService {
    Monster saveMonster(PostNewMonster monster);
    List<Monster> getAllMonsters();
    Monster getMonsterById(Long id);
    List<Monster> getMonsterBySpeciesType(String species);
    List<Monster> getMonstersWithPriceGreaterThan(Double price);
    Monster updateMonster(Monster monster);
    void deleteMonster(Long id);
}
