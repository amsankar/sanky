package org.rams.app;

import java.io.Console;
import java.util.Scanner;

public class Sanky {

	public static void main(String[] args) {

		//authendicate();

		String firstName = getCmdInputValue("First Name");
		String lastName = getCmdInputValue("Last Name");
		String key = getCmdInputValue(" ");

		if (validateKey(firstName, lastName, key)) {
			System.out.println("Hello  " + firstName + " " + lastName + "!");

		}

	}

	private static void authendicate() {
		String pass = getCmdPassword(); 
		
		if (pass.substring(1, 2).equals("a") && pass.substring(4, 5).equals("a") ) {
			
		}else{
			System.exit(0);
		}
	     
	}

	private static String getCmdPassword() {
		Console console = System.console();
		
		if (console==null) {
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