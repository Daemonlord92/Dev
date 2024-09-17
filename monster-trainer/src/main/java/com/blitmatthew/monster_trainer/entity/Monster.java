package com.blitmatthew.monster_trainer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 100)
    private String species;
    @Column(nullable = false, columnDefinition = "DOUBLE CHECK (weight >= 0.5)")
    private Double weight;
    @Column(nullable = false, columnDefinition = "DOUBLE CHECK (height >= 1.0)")
    private Double height;
    private Double price;
    @Column(nullable = false)
    private Long attackPower;
    @Column(nullable = false)
    private Long defensePower;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Trainer trainer;
}
