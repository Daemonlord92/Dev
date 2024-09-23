package com.blitmatthew.monster_trainer.service;

import com.blitmatthew.monster_trainer.entity.Trainer;
import com.blitmatthew.monster_trainer.repository.TrainerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Trainer with the id " + id + " not found"));
    }

    @Override
    public Trainer createNewTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    public Trainer updateTrainer(Trainer trainer) {
        if(!trainerRepository.existsById(trainer.getId())) throw new EntityNotFoundException("Trainer with the id " + trainer.getId() + " not found");
        return trainerRepository.save(trainer);
    }

    @Override
    public void deleteTrainerById(Long id) {
        if (!trainerRepository.existsById(id)) throw new EntityNotFoundException("Trainer with the id " + id + " not found");
        trainerRepository.deleteById(id);
    }
}
