package com.blitmatthew.monster_trainer.mapper;

import com.blitmatthew.monster_trainer.dto.PostNewMonster;
import com.blitmatthew.monster_trainer.entity.Monster;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewMonsterMapper {
    NewMonsterMapper INSTANCE = Mappers.getMapper(NewMonsterMapper.class);

    Monster fromDto(PostNewMonster postNewMonster);
}
