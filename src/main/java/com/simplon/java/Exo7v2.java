package com.simplon.java;
import java.sql.*;
import java.util.Scanner;

public class Exo7v2
{
    public static void main( String[] args )
    {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Saisir une recherche de nom : ");
	    String userSearch = sc.nextLine().toUpperCase();
	    userSearch = "%" + userSearch + "%";
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		PreparedStatement stat = connect.prepareStatement("SELECT * FROM emp WHERE nom LIKE ?");
    		stat.setString(1, userSearch);
    		
    		ResultSet result = stat.executeQuery();
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom"));
        	}
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
}
