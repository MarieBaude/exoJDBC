package com.simplon.java;
import java.sql.*;

public class Exo4v2
{
    public static void main( String[] args )
    {
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		PreparedStatement stat = connect.prepareStatement("SELECT * FROM emp INNER JOIN serv ON service = ?;");
    		stat.setString(1, "INFORMATIQUE");
    		
    		ResultSet result = stat.executeQuery();
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom") + "; Prénom : "  + result.getString("prenom") + "; Service : "  + result.getString("service"));
        	}
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
}
