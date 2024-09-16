package com.blitmatthew.monster_trainer.repository;

import com.blitmatthew.monster_trainer.entity.Monster;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface MonsterRepository extends ListCrudRepository<Monster, Long> {
    List<Monster> findBySpecies(String species);
    List<Monster> findByPriceGreaterThan(Double price);
}
