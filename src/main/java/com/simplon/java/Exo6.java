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
    	String userSearch = sc.nextLine();
	    
	    /*if(userSearch.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")){
	        SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
	        Date date = f.parse(userSearch);
	    }
	    else {
	        System.out.println("Erreur format");
	    }*/
	    
    	String request = "SELECT * FROM emp WHERE embauche = '" + userSearch + "'";
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		Statement stat = connect.createStatement();
    		
    		ResultSet result = stat.executeQuery(request);
        	
        	while (result.next()) {
        		System.out.println("Date d'embauche : " + result.getString("embauche"));
        	}
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
}
