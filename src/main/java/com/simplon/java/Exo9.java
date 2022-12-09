package com.simplon.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Exo9 {
	
	private static int menuData() {
		int selection;
		Scanner sc7 = new Scanner (System.in);
		System.out.println("Selectionner votre option : ");
		System.out.println("1) Listes des employés");
		System.out.println("2) Afficher le détail d'un employé");
		System.out.println("3) Ajouté un employé");
		System.out.println("4) Modifier un employé");
		System.out.println("5) Supprimer un employé");

		System.out.println("Votre sélection est : ");
		selection = sc7.nextInt();
		return selection;
	}
	
	public static void listOfAll() {
		System.out.println("Liste de tout les employés : ");
		String request = "SELECT * FROM emp";
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		Statement stat = connect.createStatement();
    		
    		ResultSet result = stat.executeQuery(request);
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom") + "; Prénom : "  + result.getString("prenom"));
        	}
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static void details() {
		System.out.println("détails");
	}
	
	public static void add() {
		System.out.println("add");
	}
	
	public static void update() {
		System.out.println("up");
	}
	
	public static void delete() {
		System.out.println("del");
	}

	public static void main( String[] args ) throws IOException {
    	
    	int userSelected;
    		
    	do {
    		userSelected = menuData();
    		switch(userSelected) {
    		case 1:
    			listOfAll();
    			break;
    		case 2:
    			details();
    			break;
    		case 3:
    			add();
    			break;
    		case 4:
    			update();
     			break;
    		case 5:
    			delete();
    			break;
    		default:
    			break;
    		}
    	}
    	while(userSelected > 5);
    }

}
