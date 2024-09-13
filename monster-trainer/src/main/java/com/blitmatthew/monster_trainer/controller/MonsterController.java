package com.blitmatthew.monster_trainer.controller;

import com.blitmatthew.monster_trainer.entity.Monster;
import com.blitmatthew.monster_trainer.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/monster")
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    @PostMapping("/")
    public ResponseEntity<Monster> postNewMonster(@RequestBody Monster monster){
        return ResponseEntity.ok(monsterService.saveMonster(monster));
    }
}
