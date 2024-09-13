package com.blitmatthew.monster_trainer.repository;

import com.blitmatthew.monster_trainer.entity.Monster;
import org.springframework.data.repository.ListCrudRepository;

public interface MonsterRepository extends ListCrudRepository<Monster, Long> {
}
