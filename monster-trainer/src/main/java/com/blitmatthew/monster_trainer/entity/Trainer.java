package com.blitmatthew.monster_trainer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer noOfYears;
    private Integer wins;
    private Integer losses;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Monster> monsterList;
}
