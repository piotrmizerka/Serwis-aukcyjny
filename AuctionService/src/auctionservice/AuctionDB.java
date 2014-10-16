package auctionservice;

import java.sql.*;

public class AuctionDB {
    private final static String URL = "jdbc:mysql://localhost:83/auction";
    private final static String USER = "root";
    private final static String PASSWORD = "";
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    
    private final static String query1 = "SELECT * FROM ";
    private final static String query2 = " WHERE id = ";
    private static Connection connection;
    private Statement statement;
       
    public static ResultSet result;
    
    public static Connection connect(){
        connection = null;
        try{
            Class.forName(DRIVER);
        }
        catch(ClassNotFoundException e){
            System.out.println("Error when loading the database driver " + e);
            return null;
        }
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch(SQLException e){
            System.out.println("Unable to connect to database " + e);
            return null;
        }
        return connection;
    }
    
    public static ResultSet executeQuery(Connection conn, String query){
        try{
            Statement stm = conn.createStatement();
            result = stm.executeQuery(query);
        }
        catch(SQLException e){
            System.out.println("An error occurred while executing query " + e);
        }
        return result;
    }
    
    public static void getAuction(Connection conn, int id){
        try {
            Statement stm = conn.createStatement();
            result = stm.executeQuery(query1 + "auction" + query2 + id);
            while(result.next() == true){
                int ownerId = result.getInt("owner_id");
                String name = result.getString("name");
                String category = result.getString("category");
                float price = result.getFloat("price");
                System.out.println(ownerId + " " + name + " " + category + " " + price);
            }
        } 
        catch (SQLException e) {
            System.out.println("An error occurred while getting results " + e);
        }    
    } 
    
    public static void getUser(Connection conn, int id){
        try {
            Statement stm = conn.createStatement();
            result = stm.executeQuery(query1 + "users" + query2 + id);
            while(result.next() == true){
                String name = result.getString("name");
                String lastName = result.getString("last_name");
                String address = result.getString("address");
                String nick = result.getString("nick");
                System.out.println(nick + " " + name + " " + lastName + " " + address);
            }
        } 
        catch (SQLException e) {
            System.out.println("An error occurred while getting results " + e);
        }    
    } 
}
