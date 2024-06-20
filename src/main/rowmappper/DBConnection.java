package main.rowmappper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Connection con;
    DBConnection(){
        Properties properties= new Properties();
        try {
            con= DriverManager.getConnection(properties.getUrl(), properties.getUser(), properties.getPassword());

            if(con== null){
                System.out.println("Failed to connect to DB. Retry.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    Connection getConnection(){
        return con;
    }
}
