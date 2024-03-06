package main.databasePrograms;

import java.sql.Connection;
import java.sql.DriverManager;
    import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class Postgres1 {
    public static void main(String[] args) throws SQLException {
        ConnectionCreate obj= new ConnectionCreate();
        Connection con= obj.getConnection();

        //table creation 1
/*
        String query = "CREATE TABLE table1 (id SERIAL PRIMARY KEY,name VARCHAR(255),age INT)";
        PreparedStatement pst = con.prepareStatement(query);
        boolean a= pst.execute();
        System.out.println("Table created successfully."+ a);
*/

        //table creation 2
/*
        Map<String , String> rows= new HashMap<>();
        rows.put("id", "INTEGER");
        rows.put("name", "varchar");
        rows.put("user", "INTEGER");
        createTable(con, "table2", rows);
*/

        //insert single row into table
/*
        PreparedStatement pst= con.prepareStatement("INSERT INTO table1 VALUES ( ?, ?, ?)");
        pst.setInt(1, 1);
        pst.setString(2, "Shivam");
        pst.setInt(3, 23);

        int a= pst.executeUpdate();
        System.out.println(a);
*/

        //insert 10 000 rows
/*
        PreparedStatement pst= con.prepareStatement("INSERT into goods values(?, ?)");
        for(int i=0; i< 10000; i++){
            pst.setString(1, "good"+i);
            pst.setInt(2, 10*i);
            pst.addBatch();
        }
        int[] res= pst.executeBatch();
        System.out.println("10000 rows inserted");
        for(int a: res){
            System.out.print(a+", ");
        }
        System.out.println();

*/


        //insert 100 000 row
/*
        PreparedStatement pst= con.prepareStatement("INSERT INTO table1 VALUES(?, ?, ?)");
        for(int i=2; i< 100000; i++){
            pst.setInt(1, i);
            pst.setString(2, "User"+i);
            pst.setInt(3, (20+i));
            pst.addBatch();
        }
        int[] res= pst.executeBatch();
        System.out.println(res+" rows added successfully");
*/

        //insert 10 000 000 rows
/*
        PreparedStatement pst= con.prepareStatement("Insert into books values(?, ?)");
        for(int i=0; i< 10000000; i++){
            pst.setString(1, "BookName");
            pst.setDouble(2, (i*10.0));
            pst.addBatch();
        }
        int[] res= pst.executeBatch();
        System.out.println("Inserted 1,00,00,000  rows successfully");
*/




    }
    static void createTable(Connection con, String tableName, Map<String, String> mp) throws SQLException {
        String query= "Create table "+ tableName+" (";
        for(Map.Entry<String, String> e: mp.entrySet()){
            query+= e.getKey()+" "+ e.getValue()+", ";
        }
        query= query.substring(0, query.length()-2);
        query+= ");";

        PreparedStatement pst= con.prepareStatement(query);
        boolean res= pst.execute();
        if (res){
            System.out.println(tableName+" table created");
        }
        else{
            System.out.println("Creation failed");
        }
    }
}

class ConnectionCreate{
    Connection con;
    ConnectionCreate(){
        try {
//            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "mysecretpassword");
//            docker run --name postgres-db -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres
            con= DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/netcore1", "postgres", "mysecretpassword");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    Connection getConnection(){
        if(con == null){
            System.out.println("Connection failed. Try again");
            return null;
        }
        System.out.println("Connection successful");
        return con;
    }
}