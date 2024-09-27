package com.blitmatthew.monster_trainer.dto;

public record PostNewMonster(
        String name,
        String species,
        Double weight,
        Double height,
        Double price,
        Long attackPower,
        Long defensePower,
        Long trainerId
) {
    public PostNewMonster(
            String name,
            String species,
            Double weight,
            Double height,
            Double price,
            Long attackPower,
            Long defensePower){
        this(name,
                species,
                weight,
                height,
                price,
                attackPower,
                defensePower,
                0L);
    }
}
