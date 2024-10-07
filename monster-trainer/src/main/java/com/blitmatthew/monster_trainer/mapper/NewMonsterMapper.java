package com.blitmatthew.monster_trainer.mapper;

import com.blitmatthew.monster_trainer.dto.PostNewMonster;
import com.blitmatthew.monster_trainer.entity.Monster;
import com.blitmatthew.monster_trainer.entity.Trainer;
import com.blitmatthew.monster_trainer.service.TrainerService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")  // This makes the mapper a Spring-managed bean
public interface NewMonsterMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "trainer", ignore = true)
    Monster fromDto(PostNewMonster postNewMonster);

    // After mapping, set the trainer based on trainerId
    @AfterMapping
    default void setTrainer(@MappingTarget Monster monster, PostNewMonster postNewMonster, TrainerService trainerService) {
        if (postNewMonster.trainerId() != null && postNewMonster.trainerId() > 0) {
            Trainer trainer = trainerService.getTrainerById(postNewMonster.trainerId());
            monster.setTrainer(trainer);
        }
    }
}
