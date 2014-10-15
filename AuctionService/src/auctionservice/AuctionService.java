package auctionservice;

import java.sql.*;

public class AuctionService {

    public static void main(String[] args) {
        Connection conn = AuctionDB.connect();
      
        if(conn == null){
            System.out.println("Unable to connect to database ");
            System.exit(-1);
        }
        
        //operacje na bazie
        AuctionDB.getAuction(conn, 1);
        AuctionDB.getUser(conn, 1);
        
        
        try{
            conn.close();
        }
        catch(SQLException e){
            System.out.println("An error occurred when closing the database connection " + e);
        }
        System.out.println("Connection closed successfully");
    }
    
}
