package com.simplon.java;
import java.sql.*;

public class Exo4
{
    public static void main( String[] args )
    {
    	String request = "SELECT * FROM emp WHERE service = 'INFORMATIQUE' INNER JOIN serv ON emp.noserv = serv.noserv";
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		Statement stat = connect.createStatement();
    		
    		ResultSet result = stat.executeQuery(request);
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom") + "; Prénom : "  + result.getString("prenom") + "; Service : "  + result.getString("service"));
        	}
        	
        	connect.close();
    		
    	} catch (Exception e){
    		
    	}
    	
    }
}
