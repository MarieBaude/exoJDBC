package com.simplon.java;
import java.sql.*;

public class DBConnect {
    final static String URL = "jdbc:postgresql://localhost:5432/entreprise";
    final static String USER = "yassen";
    final static String PASS = "azerty";
    
    DBConnect() {
    	
    }
    
    public static Connection connectToPg() {
    	Connection connect = null;
    	
    	try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection(URL, USER, PASS);  	
        	
        } catch (Exception e) {
        	e.printStackTrace();
        } 
    	
    	return connect;
    }
}
