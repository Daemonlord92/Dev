package org.blitmatthew;

import java.util.Objects;

public class Person {
    private String name;
    private Integer age;
    private Integer noOfFingers;
    private Double height;
    private Double weight;
    private String gender;

    public Person() {
    }

    public Person(String name, Integer age, Integer noOfFingers, Double height, Double weight, String gender) {
        this.name = name;
        this.age = age;
        this.noOfFingers = noOfFingers;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNoOfFingers() {
        return noOfFingers;
    }

    public void setNoOfFingers(Integer noOfFingers) {
        this.noOfFingers = noOfFingers;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) && Objects.equals(getAge(), person.getAge()) && Objects.equals(getNoOfFingers(), person.getNoOfFingers()) && Objects.equals(getHeight(), person.getHeight()) && Objects.equals(getWeight(), person.getWeight()) && Objects.equals(getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getNoOfFingers(), getHeight(), getWeight(), getGender());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", noOfFingers=" + noOfFingers +
                ", height=" + height +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                '}';
    }
}
