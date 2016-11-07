package org.rams.app;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sanky {

	public static void main(String[] args) {

		// authendicate();

		MSAccessTest();

	}
	
	private static Connection getWHADConnection() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			return  DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:\\amsankar\\db\\workhelper.accdb");
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		return null;
	}
	

	private static void MSAccessTest() {

		System.out.println("MS Access Test  ");

		// variables
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		// Step 1: Loading or registering Oracle JDBC driver class
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException cnfex) {
			System.out.println("Problem in loading MS Access JDBC driver");
			cnfex.printStackTrace();
		}

		System.out.println("MS Access Test  2");

		// Step 2: Opening database connection
		try {

			String msAccessDBName = "C:\\amsankar\\db\\workhelper.accdb";
			String dbURL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+ msAccessDBName + "";
			
			System.out.println(dbURL);

			// Step 2.A: Create and get connection using DriverManager class
			connection = DriverManager.getConnection(dbURL);

			System.out.println("MS Access Test  3");

			// Step 2.B: Creating JDBC Statement
			statement = connection.createStatement();

			// Step 2.C: Executing SQL & retrieve data into ResultSet
			resultSet = statement.executeQuery("SELECT * FROM Application");

			System.out.println("ID\tName\t\t\tAge\tMatches");
			System.out.println("==\t================\t===\t=======");

			// processing returned data and printing into console
			while (resultSet.next()) {
				System.out.println(
						resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
			}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {

			// Step 3: Closing database connection
			try {
				if (null != connection) {

					// cleanup resources, once after processing
					resultSet.close();
					statement.close();

					// and then finally close connection
					connection.close();
				}
			} catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}

	}

	private static void Test() {
		String firstName = getCmdInputValue("First Name");
		String lastName = getCmdInputValue("Last Name");
		String key = getCmdInputValue(" ");

		if (validateKey(firstName, lastName, key)) {
			System.out.println("Hello  " + firstName + " " + lastName + "!");

		}
	}

	private static void authendicate() {
		String pass = getCmdPassword();

		if (pass.substring(1, 2).equals("a") && pass.substring(4, 5).equals("a")) {

		} else {
			System.exit(0);
		}

	}

	private static String getCmdPassword() {
		Console console = System.console();

		if (console == null) {
			return getCmdInputValueOnly();
		}

		return new String(console.readPassword());
	}

	private static String getCmdInputValue(String inputName) {

		System.out.print("Enter " + inputName + " : ");
		return new Scanner(System.in).nextLine();
	}

	private static String getCmdInputValueOnly() {

		return new Scanner(System.in).nextLine();
	}

	private static boolean validateKey(String n1, String n2, String n3) {

		try {

			if ((n1.substring(0, 1).equals(n3.substring(0, 1))) && (n2.substring(1, 2).equals(n3.substring(1, 2)))
					&& (n1.substring(2, 3).equals(n3.substring(2, 3)))
					&& (n2.substring(3, 4).equals(n3.substring(3, 4)))) {

				return true;
			}

		} catch (Exception e) {

		}

		return false;

	}

}