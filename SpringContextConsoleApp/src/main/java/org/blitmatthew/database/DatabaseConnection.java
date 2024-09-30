package org.blitmatthew.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConnection {

    @Bean
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/carshow?createDatabaseIfNotExist=true",
                    "root",
                    "Gudmord92!"
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
