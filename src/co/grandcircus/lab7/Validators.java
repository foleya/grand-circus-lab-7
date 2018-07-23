package co.grandcircus.lab7;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validators {

	public static void validateAlphabeticOnly(String input) {
		if (!input.matches("[A-Za-z]+")) {
			throw new IllegalArgumentException(
					"-- You may only enter alphabetic characters (no numbers, special characters, or spaces) --");
		}
	}

	public static void validateStartsWithCapitalLetter(String input) {
		if (!Character.isUpperCase(input.charAt(0))) {
			throw new IllegalArgumentException("-- Name must start with a capital letter --");
		}
	}

	public static void validateThirtyMaxCharacters(String input) {
		if (input.length() > 30) {
			throw new IllegalArgumentException("-- Name must be less than 30 characters --");
		}
	}

	public static void validateEmail(String input) {
		if (!input.matches("^[A-za-z0-9]{5,30}@[A-Za-z0-9]{5,10}\\.[A-Za-z0-9]{2,3}$")) {
			throw new IllegalArgumentException(
					"-- Email format must be [5-30 alpha-numerals]@[5-10 alpha-numerals].[2-3 alpha-numerals] -- ");
		}
	}
	
	public static void validatePhoneNumber(String input) {
		if (!input.matches("^[0-9]{3}-[0-9]{3}-[0-9]{4}$")) {
			throw new IllegalArgumentException("-- Phone number format must be ###-###-#### --");
		}
	}

	public static void validateDate(String input) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false);
		try {
			Date date = format.parse(input);
			System.out.println(date);
		} catch (ParseException pe) {
			throw new IllegalArgumentException("-- Date format must be DD/MM/YYYY --");
		}
		
		if (!input.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$")) {
			throw new IllegalArgumentException("-- Date format must be DD/MM/YYYY --");
		}
	
		
	}

}
