package com.blitmatthew.monster_trainer.controller;

import com.blitmatthew.monster_trainer.entity.Monster;
import com.blitmatthew.monster_trainer.service.MonsterService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/monster")
public class MonsterController {

    private MonsterService monsterService;

    @Autowired
    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @PostMapping("/")
    public ResponseEntity<Monster> postNewMonster(@RequestBody Monster monster){
        return ResponseEntity.ok(monsterService.saveMonster(monster));
    }

    @GetMapping("/")
    public ResponseEntity<List<Monster>> getMonsters() {
        return ResponseEntity.ok(monsterService.getAllMonsters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monster> getMonsterById(@PathVariable Long id) {
        return ResponseEntity.ok(monsterService.getMonsterById(id));
    }

    @GetMapping("/species/{species}")
    public ResponseEntity<List<Monster>> getMonstersBySpecies(@PathVariable String species) {
        return ResponseEntity.ok(monsterService.getMonsterBySpeciesType(species));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<Monster>> getMonstersByGreaterPrice(@PathVariable Double price) {
        return ResponseEntity.ok(monsterService.getMonstersWithPriceGreaterThan(price));
    }

    @PutMapping("/update")
    public ResponseEntity<Monster> postUpdateMonster(@RequestBody Monster monster) {
        return ResponseEntity.ok(monsterService.updateMonster(monster));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> postDeleteMonster(@PathVariable Long id) {
        monsterService.deleteMonster(id);
        return ResponseEntity.ok().body("Monster has been delete");
    }
}
