package main.rowmappper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerClass {
    DBConnection dbConnection;
    ControllerClass(){
        dbConnection= new DBConnection();
    }
    void addRow(){

    }
    void showRow() throws SQLException {
        int id= 10;
        PreparedStatement pst= dbConnection.getConnection().prepareStatement("Select * from person where id= ?");
        pst.setInt(1, id);
//         Person person= PersonMapper


    }
}
