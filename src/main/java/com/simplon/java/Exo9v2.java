package com.simplon.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Exo9v2 {
	
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
		Scanner sc = new Scanner(System.in);
	    System.out.print("Saisir le nom de famille: ");
	    String lastNameSearch = sc.nextLine().toUpperCase();
	    
	    Scanner sc2 = new Scanner(System.in);
	    System.out.print("Saisir le prénom : ");
	    String firstNameSearch = sc2.nextLine().toUpperCase();
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		PreparedStatement stat = connect.prepareStatement("SELECT * FROM emp WHERE nom = ? AND prenom = ?");
    		stat.setString(1, lastNameSearch);
    		stat.setString(2, firstNameSearch);
    		
    		ResultSet result = stat.executeQuery();
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom") + "; Prénom : " + result.getString("prenom") + "; Emploi : " + result.getString("emploi") + "; Sup : " + result.getString("sup") + "; Date d'embauche : " + result.getString("embauche") + "; Salaire : " + result.getString("sal") + "; Commision : " + result.getString("comm") + "; Numéro de service : " + result.getString("noserv"));
        	}
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static void add() {
		Scanner scLastName = new Scanner(System.in);
	    System.out.print("Saisir le nom de famille: ");
	    String lastName = scLastName.nextLine().toUpperCase();
	    
	    Scanner scFirstName = new Scanner(System.in);
	    System.out.print("Saisir le prénom: ");
	    String firstName = scFirstName.nextLine().toUpperCase();
	    
	    Scanner scEmploi = new Scanner(System.in);
	    System.out.print("Saisir l'emploi: ");
	    String emploi = scEmploi.nextLine().toUpperCase();
	    
	    Scanner scSup = new Scanner(System.in);
	    System.out.print("Saisir le sup (nombre): ");
	    int sup = scSup.nextInt();
	    
	    Scanner in = new Scanner(System.in);
	    System.out.println("Saisir la date d'embauche : ");
	  
		System.out.println("Jour :");
		int day = in.nextInt();
		System.out.println("Mois : ");
		int month = in.nextInt();
		System.out.println("Année : ");
		int year = in.nextInt();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		Date finalDate = new Date(calendar.getTimeInMillis());
	    
	    Scanner scSal = new Scanner(System.in);
	    System.out.print("Saisir le salaire: ");
	    int sal = scSal.nextInt();
	    
	    Scanner scComm = new Scanner(System.in);
	    System.out.print("Saisir la commission: ");
	    int comm = scComm.nextInt();
	    
	    Scanner scNoServ = new Scanner(System.in);
	    System.out.print("Saisir le numéro de service: ");
	    int noServ = scNoServ.nextInt();

	    
	    try {
    		Connection connect = DBConnect.connectToPg();
    		PreparedStatement stat = connect.prepareStatement("INSERT INTO emp VALUES (5168, ?, ?, ?, ?, ?, ?, ?, ?);");
    		stat.setString(1, lastName);
    		stat.setString(2, firstName);
    		stat.setString(3, emploi);
    		stat.setInt(4, sup);
    		stat.setDate(5, finalDate);
    		stat.setInt(6, sal);
    		stat.setInt(7, comm);
    		stat.setInt(8, noServ);
    		
    		stat.executeUpdate();
        	
        	System.out.println("Nouvel emploi bien enregistré");
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static void update() {
		Scanner scNumEmp = new Scanner(System.in);
	    System.out.print("Saisir l'id : ");
	    String numEmp = scNumEmp.nextLine().toUpperCase();
		
	    Scanner scLastName = new Scanner(System.in);
	    System.out.print("Saisir le nom de famille: ");
	    String lastName = scLastName.nextLine().toUpperCase();
	    
	    Scanner scFirstName = new Scanner(System.in);
	    System.out.print("Saisir le prénom: ");
	    String firstName = scFirstName.nextLine().toUpperCase();
	    
	    Scanner scEmploi = new Scanner(System.in);
	    System.out.print("Saisir l'emploi: ");
	    String emploi = scEmploi.nextLine().toUpperCase();
	    
	    Scanner scSup = new Scanner(System.in);
	    System.out.print("Saisir le sup (nombre): ");
	    int sup = scSup.nextInt();
	    
	    Scanner scDate = new Scanner(System.in);
	    System.out.print("Saisir la date d'embauche (jj/mm/aaaa): ");
	    String date = scDate.nextLine();
	    
	    Scanner scSal = new Scanner(System.in);
	    System.out.print("Saisir le salaire: ");
	    int sal = scSal.nextInt();
	    
	    Scanner scComm = new Scanner(System.in);
	    System.out.print("Saisir la commission: ");
	    int comm = scComm.nextInt();
	    
	    Scanner scNoServ = new Scanner(System.in);
	    System.out.print("Saisir le numéro de service: ");
	    int noServ = scNoServ.nextInt();
	
	    
	    try {
    		Connection connect = DBConnect.connectToPg();
    		PreparedStatement stat = connect.prepareStatement("UPDATE emp SET nom = ?, prenom = ?, emploi = ?, sup = ?, embauche = ?, sal = ?, comm = ?, noServ = ? WHERE noemp = ?");
    		stat.executeUpdate();
    		stat.setString(1, lastName);
    		stat.setString(2, firstName);
    		stat.setString(3, emploi);
    		stat.setInt(4, sup);
    		stat.setString(5, date);
    		stat.setInt(6, sal);
    		stat.setInt(7, comm);
    		stat.setInt(8, noServ);
        	
        	System.out.println("Nouvelle information bien enregistrer");
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static void delete() {
		Scanner scLastName = new Scanner(System.in);
	    System.out.print("Saisir le nom de famille: ");
	    String lastName = scLastName.nextLine().toUpperCase();
	    
	    Scanner scFirstName = new Scanner(System.in);
	    System.out.print("Saisir le prénom: ");
	    String firstName = scFirstName.nextLine().toUpperCase();
	    
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		PreparedStatement stat = connect.prepareStatement("DELETE FROM emp WHERE nom = ? AND prenom = ? ");
    		stat.setString(1, lastName);
    		stat.setString(2, firstName);
    		
    		stat.executeUpdate();
        
        	System.out.println("Employé bien supprimer");
        	
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
	    
	    
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
