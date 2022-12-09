package com.simplon.java;
import java.sql.*;
import java.util.Scanner;

public class Exo6v2
{
    public static void main( String[] args )
    {
    	System.out.println("Saisissez une année :");
    	Scanner sc = new Scanner(System.in);
    	int userSearch = sc.nextInt();
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		PreparedStatement stat = connect.prepareStatement("SELECT * FROM emp WHERE EXTRACT (YEAR FROM embauche) = ?");
    		stat.setInt(1, userSearch);
    		
    		ResultSet result = stat.executeQuery();
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom") + "; Prénom : " + result.getString("prenom") + "; Date d'embauche : " + result.getString("embauche"));
        	}
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
}
