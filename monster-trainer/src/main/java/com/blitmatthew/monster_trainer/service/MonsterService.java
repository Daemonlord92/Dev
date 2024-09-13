package com.blitmatthew.monster_trainer.service;

import com.blitmatthew.monster_trainer.entity.Monster;

import java.util.List;

public interface MonsterService {
    Monster saveMonster(Monster monster);
    List<Monster> getAllMonsters();
    Monster getMonsterById(Long id);
}
