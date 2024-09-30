package org.blitmatthew;

public class Bird extends Animal{
    private Boolean isFly;

    public Bird() {
        super();
    }

    public Bird(String name, String sound, Double weight, Double height, Boolean isFly) {
        super(name, sound, weight, height);
        this.isFly = isFly;
    }
}
