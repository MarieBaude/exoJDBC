package com.simplon.java;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Exo6
{
    public static void main( String[] args )
    {
    	System.out.println("Saisissez une date (AAAA-MM-JJ) :");
    	Scanner sc = new Scanner(System.in);
    	int userSearch = sc.nextInt();
	    
    	String request = "SELECT * FROM emp WHERE EXTRACT (YEAR FROM embauche) = '" + userSearch + "'";
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		Statement stat = connect.createStatement();
    		
    		ResultSet result = stat.executeQuery(request);
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom") + "; Prénom : " + result.getString("prenom") + "; Date d'embauche : " + result.getString("embauche"));
        	}
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
}
