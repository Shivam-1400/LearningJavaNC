package main.databasePrograms;

import java.sql.*;
import java.time.Period;
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

//------------------------------------------------

        //insert 10 000 rows in goods table
/*        PreparedStatement pst= con.prepareStatement("INSERT into goods values(?, ?)");
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
        System.out.println();*/

        //read all rows form goods table
/*
        PreparedStatement pst= con.prepareStatement("SELECT * from goods");
        ResultSet rs= pst.executeQuery();
        System.out.println(rs);
        while (rs.next()){
            System.out.println(rs.getString("name")+" -> "+ rs.getInt("weight"));
        }
*/

//------------------------------------------------

        //insert 100 000 row into table1
/*
    PreparedStatement pst= con.prepareStatement("INSERT INTO table1 VALUES(?, ?, ?)");
        for(int i=0; i< 100000; i++){
            pst.setInt(1, i);
            pst.setString(2, "User"+i);
            pst.setInt(3, (20+i));
            pst.addBatch();
        }
        int[] res= pst.executeBatch();
        System.out.println(res+" rows added successfully");
*/

        //read rows from table1 whose age is between 100-999 and print username and id
/*
        PreparedStatement pst= con.prepareStatement("Select id, name from table1 where age>99 and age<1000");
        ResultSet rs= pst.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("name")+" -> "+ rs.getInt("id"));
        }
*/

//------------------------------------------------

        //insert 10 000 000 rows in books table
/*
        PreparedStatement pst= con.prepareStatement("Insert into books values(?, ?)");
        for(int i=0; i< 10000000; i++){
            pst.setString(1, "BookName"+((char)('A'+ (i%25))));
            pst.setDouble(2, (i*10.0));
            pst.addBatch();
        }
        int[] res= pst.executeBatch();
        System.out.println("Inserted 1,00,00,000  rows successfully");
*/

        //read and print all rows of books table
/*       PreparedStatement pst2= con.prepareStatement("SELECT * FROM books");
        ResultSet rs= pst2.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("name")+"  ->  "+ rs.getDouble("price"));
        }
*/

        //read and print rows of books where book-name ends with 'A'
/*
        PreparedStatement pst= con.prepareStatement("SELECT * from books where name like '%A'");
        ResultSet rs= pst.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("name")+ "  -> "+ rs.getDouble("price"));
        }
*/

        //count rows number of rows where book-name ends with 'I'
/*
        PreparedStatement pst2= con.prepareStatement("SELECT count(price) as cnt from books where name like '%I'");
        ResultSet rs2= pst2.executeQuery();
        while (rs2.next()){
            System.out.println("Count of book ending with 'I'= "+ rs2.getInt("cnt"));
        }
*/

        //count grouped data by group name ending character
/*
        String qry = "SELECT SUBSTRING(name, LENGTH(name)) AS last_char, COUNT(*) AS count FROM books GROUP BY SUBSTRING(name, LENGTH(name))";
        PreparedStatement pst = con.prepareStatement(qry);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt("count")+" -> "+ rs.getString("last_char"));
        }

*/

        //alter table, add new column  author in books
/*
        PreparedStatement pst= con.prepareStatement("Alter table books add column author varchar (10)");
        pst.executeUpdate();
*/

        //update table books, set author = Awick where book-name end with A, and so on
/*
        PreparedStatement pst= con.prepareStatement("UPDATE books set author= ? where name like ?");
        for(int i=0; i<26; i++){
            String name= (char)('A'+ i)+ "wick";
            pst.setString(1, name);
            pst.setString(2, "%"+(char)('A'+ i));
            pst.addBatch();
        }
        pst.executeBatch();
        System.out.println("Author name updated");
*/




//        String qry= "DELETE FROM books where name like '%e'";
//        String qry= "select count(*) as count, author, name, max(price) as price from books group by author, name;";

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