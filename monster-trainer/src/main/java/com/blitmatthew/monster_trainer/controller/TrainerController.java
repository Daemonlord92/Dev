package com.blitmatthew.monster_trainer.controller;

import com.blitmatthew.monster_trainer.entity.Trainer;
import com.blitmatthew.monster_trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainer")
public class TrainerController {
    @Autowired
    @Qualifier("ADMIN")
    private TrainerService trainerService;

    @GetMapping("/")
    public ResponseEntity<List<Trainer>> getTrainers() {
        return ResponseEntity.ok(trainerService.getAllTrainers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Trainer> postNewTrainer(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.createNewTrainer(trainer));
    }

    @PutMapping("/update")
    public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.updateTrainer(trainer));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainerById(id);
        return ResponseEntity.ok().build();
    }
}
