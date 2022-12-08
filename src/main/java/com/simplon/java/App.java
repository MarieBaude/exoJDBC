package com.simplon.java;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String url = "jdbc:postgresql://localhost:5432/entreprise";
        String user = "yassen";
        String pass = "azerty";
        
        try {
        	Class.forName("org.postgresql.Driver");
        	Connection conn = DriverManager.getConnection(url, user, pass);
        	
        	Statement stat = conn.createStatement();
        	
        	ResultSet result = stat.executeQuery("SELECT * FROM emp");
        	
        	while (result.next()) {
        		System.out.println(result.getString("nom"));
        	}
        	
        	
        } catch (Exception e) {
        	e.printStackTrace();
        } 
    }
}
