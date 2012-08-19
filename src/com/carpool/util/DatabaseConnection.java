package com.carpool.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static String databaseName="durban";
	private static String username="root";
	private static String password="test1234";
	private static String databaseHost="localhost";
	private static String databasePort="3306";
	private static String mysqlURL="jdbc:mysql://"+databaseHost+":"+databasePort+"/"+databaseName;
    private static Connection conn=null;      

    public static Connection connectToDatabase()
    {
        
        try
        {
            
            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            conn = DriverManager.getConnection (mysqlURL, username, password);
            System.out.println ("Database connection established");
        }
        catch (Exception e)
        {
            System.err.println ("Cannot connect to database server " + e.getMessage());
        }
        finally
        {
            /*if (conn != null)
            {
                try
                {
                    conn.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) {  ignore close errors  }
            }*/
        }
        return conn;
      }
    
    public static void closeConnection(){
    	try{
    		conn.close();
    		System.out.println("Database connection closed");
    	}
    	catch(Exception e){
    		System.err.println("Failed to close connection "+ e.getMessage());
    	}
    }
        

}
