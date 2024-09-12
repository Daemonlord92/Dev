package com.blitmatthew.DemonBook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Demon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(nullable = false, unique = true, length = 300)
    @NotNull(message = "You have to fill out this field")
    @Size(min = 3, max = 75, message = "Name has to be between 3 to 75 characters long")
    private String name;

    @NotNull(message = "You have to fill out this field")
    @Min(value = 1, message = "Demon cannot shorter than 1 feet")
    @Max(value = 20, message = "Demons cannot bigger than 20 feet")
    private Double height;

    @NotNull(message = "You have to fill out this field")
    @Min(value = 5,message = "No demon should weigh less then 5 pounds")
    @Max(value = 2000, message = "No Demon should weigh more then 2 tons, or you should run for the hills")
    private Double weight;

    @NotNull(message = "You have to fill out this field")
    @Size(min = 25, max = 300, message = "You have to describe the demon within 25 to 300 characters")
    private String description;

    public Demon() {
    }

    public Demon(String name, Double height, Double weight, String description) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
