package com.simplon.java;
import java.sql.*;
import java.util.Scanner;

public class Exo7
{
    public static void main( String[] args )
    {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Saisir une recherche de nom : ");
	    String userSearch = sc.nextLine().toUpperCase();
	    
    	String request = "SELECT * FROM emp WHERE nom LIKE '" + '%' + userSearch + "%'";
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		Statement stat = connect.createStatement();
    		
    		ResultSet result = stat.executeQuery(request);
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom"));
        	}
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
}
