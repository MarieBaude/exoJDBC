package com.simplon.java;
import java.sql.*;

public class Exo2
{
    public static void main( String[] args )
    {
    	String request = "SELECT * FROM emp";
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		Statement stat = connect.createStatement();
    		
    		ResultSet result = stat.executeQuery(request);
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom") + "; Prénom : "  + result.getString("prenom"));
        	}
        	
        	connect.close();
    		
    	} catch (Exception e){
    		
    	}
    	
    }
}
