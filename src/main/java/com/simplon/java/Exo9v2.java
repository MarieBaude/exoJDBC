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
	
	/**
	 * Content of the menu
	 * 
	 * @author Marie Baude
	 */
	private static int menuData() {
		int selection;
		Scanner sc7 = new Scanner (System.in);
		System.out.println("Selectionner votre option : ");
		System.out.println("1) Listes des employés");
		System.out.println("2) Afficher le détail d'un employé");
		System.out.println("3) Ajouté un employé");
		System.out.println("4) Modifier un employé");
		System.out.println("5) Supprimer un employé");
		System.out.println("6) Quitter le programme");

		System.out.println("Votre sélection est : ");
		selection = sc7.nextInt();
		return selection;
	}
	
	/**
	 * A function for display all the employee
	 * 
	 * @author Marie Baude
	 */
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
	
	/**
	 * A function for display the employee detail with his id
	 * 
	 * @author Marie Baude
	 */
	public static void details() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir l'id : ");
	    int numEmp = sc.nextInt();
    	
    	try {
    		Connection connect = DBConnect.connectToPg();
    		PreparedStatement stat = connect.prepareStatement("SELECT * FROM emp WHERE noemp = ?");
    		stat.setInt(1, numEmp);
    		
    		ResultSet result = stat.executeQuery();
        	
        	while (result.next()) {
        		System.out.println("Nom : " + result.getString("nom") + "; Prénom : " + result.getString("prenom") + "; Emploi : " + result.getString("emploi") + "; Sup : " + result.getString("sup") + "; Date d'embauche : " + result.getString("embauche") + "; Salaire : " + result.getString("sal") + "; Commision : " + result.getString("comm") + "; Numéro de service : " + result.getString("noserv"));
        	}
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * For add a new employee
	 * 
	 * @author Marie Baude
	 */
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
	
	/**
	 * For update a employee with his id
	 * 
	 * @author Marie Baude
	 */
	public static void update() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir l'id : ");
	    int numEmp = sc.nextInt();
			   
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
    		PreparedStatement stat = connect.prepareStatement("UPDATE emp SET noemp = ?, nom = ?, prenom = ?, emploi = ?, sup = ?, embauche = ?, sal = ?, comm = ?, noServ = ? WHERE noemp = ?");
    		
    		stat.setInt(1, numEmp);
    		stat.setString(2, lastName);
    		stat.setString(3, firstName);
    		stat.setString(4, emploi);
    		stat.setInt(5, sup);
    		stat.setDate(6, finalDate);
    		stat.setInt(7, sal);
    		stat.setInt(8, comm);
    		stat.setInt(9, noServ);
    		stat.setInt(10, numEmp);
        	
    		stat.executeUpdate();
    		
    		connect.close();
        	System.out.println("Nouvelle information bien enregistrer");
    	} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Delete a employee with his id
	 * 
	 * @author Marie Baude
	 */
	public static void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir l'id : ");
	    int numEmp = sc.nextInt();
	    sc.nextLine();
	    
    	try {
    		Connection connect = DBConnect.connectToPg();
    		PreparedStatement stat = connect.prepareStatement("DELETE FROM emp WHERE noemp = ? ");
    		stat.setInt(1, numEmp);
    		
    		stat.executeUpdate();
        
        	System.out.println("Employé bien supprimer");
        	
        	
        	connect.close();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
	    
	    
	}
	
	/**
	 * Main with a console menu
	 * 
	 * @author Marie Baude
	 */
	public static void main( String[] args ) throws IOException {
    	
    	int userSelected;
    	boolean exit=false;
    		
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
    		case 6:
    			System.out.println("Programme fermé");
    			exit=true;
    			break;
    		default:
    			break;
    		}
    	}
    	while(!exit);
    }

}
