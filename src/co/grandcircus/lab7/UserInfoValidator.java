package co.grandcircus.lab7;

import java.util.Scanner;

public class UserInfoValidator {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		System.out.println("Hello new user! When you're ready, hit enter to "
				+ " enter a few details about yourself.");
		scnr.nextLine();
		
		// Prompt for name
		String name = getValidName(scnr);

		// Prompt for email
		String email = getValidEmail(scnr);

		// Prompt for phone
		String phoneNumber = getValidPhoneNumber(scnr);

		// Prompt for date
		String birthday = getValidDate(scnr);
		
		System.out.printf("\nThanks, %s!%nWe'll try to reach you at %s or %s to wish you"
				+ "%na happy birthday on %s next year! Goodbye for now!",
				name, email, phoneNumber, birthday.substring(0, 5));

		scnr.close();
	}

	// Takes user input and returns it only when all name validators are satisfied.
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
	
	// Takes user input and returns it only when all name email validators are satisfied.
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
	
	// Takes user input and returns it only when all phone number validators are satisfied.
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
	
	// Takes user input and returns it only when all date validators are satisfied.
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
