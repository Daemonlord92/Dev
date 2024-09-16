package com.blitmatthew.monster_trainer.repository;

import com.blitmatthew.monster_trainer.entity.Trainer;
import org.springframework.data.repository.ListCrudRepository;

public interface TrainerRepository extends ListCrudRepository<Trainer, Long> {
}
