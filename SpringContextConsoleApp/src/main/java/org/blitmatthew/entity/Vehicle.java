package org.blitmatthew.entity;

import java.util.Objects;
import java.util.UUID;

public class Vehicle {
    private Long id;
    private String carType;
    private String make;
    private String model;
    private Double price;
    private UUID vin;

    public Vehicle() {
    }

    public Vehicle(String carType, String make, String model, Double price) {
        this.carType = carType;
        this.make = make;
        this.model = model;
        this.price = price;
        this.vin = UUID.randomUUID();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UUID getVin() {
        return vin;
    }

    public void setVin(UUID vin) {
        this.vin = vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getId(), vehicle.getId()) && Objects.equals(getCarType(), vehicle.getCarType()) && Objects.equals(getMake(), vehicle.getMake()) && Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getPrice(), vehicle.getPrice()) && Objects.equals(getVin(), vehicle.getVin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCarType(), getMake(), getModel(), getPrice(), getVin());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", carType='" + carType + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", vin=" + vin +
                '}';
    }
}
