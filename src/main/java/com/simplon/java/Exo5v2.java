package com.simplon.java;
import java.sql.*;
import java.util.Scanner;

public class Exo5v2
{
    public static void main( String[] args )
    {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Saisir le nom : ");
	    String userSearch = sc.nextLine().toUpperCase();
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		PreparedStatement stat = connect.prepareStatement("SELECT * FROM emp WHERE nom = ?");
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
