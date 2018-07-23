package co.grandcircus.lab7;

import java.util.Scanner;

public class UserInfoValidator {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		// Prompt for name
		getValidName(scnr);

		// Prompt for email
		getValidEmail(scnr);

		// Prompt for phone
		getValidPhoneNumber(scnr);

		// Prompt for date
		getValidDate(scnr);

		scnr.close();
	}

	private static String getValidName(Scanner scnr) {
		System.out.println("Please enter your first name (capitalized, letters only, 30 or less characters): ");
		String input = scnr.nextLine();
		try {
			Validators.validateAlphabeticOnly(input);
			Validators.validateStartsWithCapitalLetter(input);
			Validators.validateThirtyMaxCharacters(input);
			return input;
		} catch (IllegalArgumentException iae) {
			System.out.printf("%n%s%n%n", iae.getMessage());
			return getValidName(scnr);
		}
	}
	
	private static String getValidEmail(Scanner scnr) {
		System.out.println("Please enter your e-mail address: ");
		String input = scnr.nextLine();
		try {
			Validators.validateEmail(input);
			return input;
		} catch (IllegalArgumentException iae) {
			System.out.printf("%n%s%n%n", iae.getMessage());
			return getValidEmail(scnr);
		}
	}
	
	private static String getValidPhoneNumber(Scanner scnr) {
		System.out.println("Please enter your phone number (###-###-####): ");
		String input = scnr.nextLine();
		try {
			Validators.validatePhoneNumber(input);
			return input;
		} catch (IllegalArgumentException iae) {
			System.out.printf("%n%s%n%n", iae.getMessage());
			return getValidPhoneNumber(scnr);
		}
	}
	
	private static String getValidDate(Scanner scnr) {
		System.out.println("Please enter your birthday (DD/MM/YYYY): ");
		String input = scnr.nextLine();
		try {
			Validators.validateDate(input);
			return input;
		} catch (IllegalArgumentException iae) {
			System.out.printf("%n%s%n%n", iae.getMessage());
			return getValidDate(scnr);
		}
		
	}

}
