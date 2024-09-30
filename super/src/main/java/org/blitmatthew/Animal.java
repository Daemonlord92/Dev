package org.blitmatthew;

public class Animal {
    private String name;
    private String sound;
    private Double weight;
    private Double height;

    public Animal() {}

    public Animal(String name, String sound, Double weight, Double height) {
        this.name = name;
        this.sound = sound;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
