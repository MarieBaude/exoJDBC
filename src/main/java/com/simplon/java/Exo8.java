package com.simplon.java;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Exo8
{
    public static void main( String[] args )
    {
    	System.out.println("Saisissez un salaire de référence :");
    	Scanner sc = new Scanner(System.in);
    	int userSearch = sc.nextInt();
	    
    	String request = "SELECT * FROM emp WHERE sal > '" + userSearch + "'";
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		Statement stat = connect.createStatement();
    		
    		ResultSet result = stat.executeQuery(request);
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom") + "; Prénom : " + result.getString("prenom") + "; Emploi : " + result.getString("emploi") + "; Service : " + result.getString("noserv"));
        	}
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
}
