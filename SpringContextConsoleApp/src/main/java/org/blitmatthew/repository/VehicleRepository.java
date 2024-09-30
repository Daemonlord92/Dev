package org.blitmatthew.repository;

import org.blitmatthew.entity.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehicleRepository {
    private Connection connection;

    public VehicleRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(Vehicle vehicle) throws SQLException {
        System.out.println("MJM:l17:VehicleRepository:save: start of the save method");
        String sql = "INSERT INTO vehicles (car_type, make, model, price, vin) VALUE (?,?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println("MJM:l20:VehicleRepository:save: inside the preparedStatement: " + statement.toString());
            statement.setString(1, vehicle.getCarType());
            statement.setString(2, vehicle.getMake());
            statement.setString(3, vehicle.getModel());
            statement.setDouble(4, vehicle.getPrice());
            statement.setString(5, vehicle.getVin().toString());
            System.out.println("MJM:l26:VehicleRepository:save: after inserting datapoint in statement: " + statement.toString());
            int row = statement.executeUpdate();
            if(row > 0) {
                System.out.println("Car Created");
                System.out.println("MJM:l30:VehicleRepository:save: successfully execution");
            }
        }
    }
}
