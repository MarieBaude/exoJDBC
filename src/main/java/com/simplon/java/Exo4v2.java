package com.simplon.java;
import java.sql.*;

public class Exo4v2
{
    public static void main( String[] args )
    {
    	String request = "SELECT * FROM emp INNER JOIN serv ON service = 'INFORMATIQUE';";
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		Statement stat = connect.createStatement();
    		
    		ResultSet result = stat.executeQuery(request);
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom") + "; Prénom : "  + result.getString("prenom") + "; Service : "  + result.getString("service"));
        	}
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
}
