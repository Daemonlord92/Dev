package com.blitmatthew.monster_trainer.service;

import com.blitmatthew.monster_trainer.entity.Trainer;

import java.util.List;

public interface TrainerService {
    List<Trainer> getAllTrainers();
    Trainer getTrainerById(Long id);
    Trainer createNewTrainer(Trainer trainer);
    Trainer updateTrainer(Trainer trainer);
    void deleteTrainerById(Long id);
}
