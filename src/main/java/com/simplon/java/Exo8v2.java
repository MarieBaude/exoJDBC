package com.simplon.java;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Exo8v2
{
    public static void main( String[] args )
    {
    	System.out.println("Saisissez un salaire de référence :");
    	Scanner sc = new Scanner(System.in);
    	int userSearch = sc.nextInt();
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		PreparedStatement stat = connect.prepareStatement("SELECT * FROM emp WHERE sal > ?");
    		stat.setInt(1, userSearch);
    		
    		ResultSet result = stat.executeQuery();
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom") + "; Prénom : " + result.getString("prenom") + "; Emploi : " + result.getString("emploi") + "; Service : " + result.getString("noserv"));
        	}
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
}
