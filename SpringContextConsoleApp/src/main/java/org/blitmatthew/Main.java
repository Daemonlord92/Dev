package org.blitmatthew;

import org.blitmatthew.entity.Vehicle;
import org.blitmatthew.repository.VehicleRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Connection connection = context.getBean("connection", Connection.class);
        if(connection.isValid(30)) {
            System.out.println("Database Connection is open!");
        }
        VehicleRepository vehicleRepository = context.getBean("vehicleRepository", VehicleRepository.class);
        Vehicle testCar = new Vehicle("Sudan", "Chevy", "Sonic", 7995.00);
        vehicleRepository.save(testCar);

    }
}