package co.grandcircus.lab7;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validators {

	/**
	 * This method takes a string input and throws an illegal argument exception if the input
	 * is not entirely alphabetical.
	 * 
	 * @param input (String)
	 */
	public static void validateAlphabeticOnly(String input) {
		if (!input.matches("[A-Za-z]+")) {
			throw new IllegalArgumentException(
					"-- You may only enter alphabetic characters (no numbers, special characters, or spaces) --");
		}
	}
	
	/**
	 * This method takes a string input and throws an illegal argument exception if the input
	 * does not start with a capitalized letter.
	 * 
	 * @param input (String)
	 */
	public static void validateStartsWithCapitalLetter(String input) {
		if (!Character.isUpperCase(input.charAt(0))) {
			throw new IllegalArgumentException("-- Name must start with a capital letter --");
		}
	}

	/** This method takes a string input and throws an illegal argument exception if the input
	 * is longer than 30 characters.
	 * 
	 * @param input (String)
	 */
	public static void validateThirtyMaxCharacters(String input) {
		if (input.length() > 30) {
			throw new IllegalArgumentException("-- Name must be less than 30 characters --");
		}
	}

	/**
	 * This method takes a string input and throws an illegal argument exception if it does not
	 * have an e-mail format of 5-30 alpha-numerals, followed by an "@" symbol, followed by 5-10
	 * alpha-numerals, followed by a ".", followed by 2-3 alpha-numerals.
	 * 
	 * @param input (String)
	 */
	public static void validateEmail(String input) {
		if (!input.matches("^[A-Za-z0-9]{5,30}@[A-Za-z0-9]{5,10}\\.[A-Za-z0-9]{2,3}$")) {
			throw new IllegalArgumentException(
					"-- Email format must be [5-30 alpha-numerals]@[5-10 alpha-numerals].[2-3 alpha-numerals] -- ");
		}
	}
	
	/**
	 * This method takes a string input and throws an illegal argument exception if it does not have
	 * a phone number format of ###-###-####.
	 * 
	 * @param input (String)
	 */
	public static void validatePhoneNumber(String input) {
		if (!input.matches("^[0-9]{3}-[0-9]{3}-[0-9]{4}$")) {
			throw new IllegalArgumentException("-- Phone number format must be ###-###-#### --");
		}
	}

	/**
	 * This method takes a string input and throws an illegal argument exception if it does not have
	 * a date format of "dd/mm/yyyy".
	 * 
	 * @param input (String)
	 */
	public static void validateDate(String input) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false);
		try {
			// Try to parse a date (non-leniently) from the input
			format.parse(input);
		} catch (ParseException pe) {
			throw new IllegalArgumentException("-- Date format must be DD/MM/YYYY --");
		}
		
		// Check for dates that could be parsed but do not follow dd/mm/yyyy format
		// For example, 01/01/12345 could be successfully parsed, but it does not
		// match the specified format.
		if (!input.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$")) {
			throw new IllegalArgumentException("-- Date format must be DD/MM/YYYY --");
		}
	
		
	}

}
