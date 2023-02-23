package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	/**
	 * Requirement 1:
	 * Take upto two numbers that seperated by a comma then return sum of that number. If that string is empty, then return 0.
	 * Ex: "1,2" => 3
	 * Requirement 2:
	 * Also take n number of numbers that seperated by commas then return sum of that number.
	 * Requirement 3:
	 * Also take newlines as separators
	 * Requirement 4:
	 * Not allow a separator at the end of string
	 *
	 * @param input string contains upto two numbers
	 * @return sum of input
	 */
	public int add(String input) throws IllegalArgumentException {
		int result = 0;
		List<String> listOfNumbers = new ArrayList<>();

		if (input == null || input.isEmpty() || input.isBlank()) return result;

		if (input.length() == 1) {
			return Integer.parseInt(input);
		}

		validateInput(input);

		if (input.contains(",")) {
			listOfNumbers.addAll(separatedInput(input, ","));
			input = clearSeparatedNumber(listOfNumbers, input, ",");
		}

		if (input.contains("\n")) {
			listOfNumbers.addAll(separatedInput(input, "\n"));
			input = clearSeparatedNumber(listOfNumbers, input, "\n");
		}

		for (String number : listOfNumbers) {
			if (number.isBlank()) {
				continue;
			}

			result += Integer.parseInt(number);
		}

		return result;
	}

	private void validateInput(String input) {
		if (!containsDigit(input)) {
			throw new IllegalArgumentException("Input only contains characters");
		}

		if (!Character.isDigit(input.charAt(input.length() - 1))) {
			throw new IllegalArgumentException("Separator cannot be at the end of input");
		}
	}

	private boolean containsDigit(final String aString) {
		return aString != null && !aString.isEmpty() && aString.chars().anyMatch(Character::isDigit);
	}

	/**
	 * Separate input of numbers into list of string number with separator
	 *
	 * @param input     list of numbers with separator
	 * @param separator a mark that indicate input have multiple number
	 * @return list of numbers without provided separator
	 */
	private List<String> separatedInput(String input, String separator) {
		List<String> result = new ArrayList<>();

		String[] listOfNumbers = input.split(separator);

		for (String number : listOfNumbers) {
			if (number.matches("\\d+")) {
				result.add(number);
			}
		}

		return result;
	}

	private String clearSeparatedNumber(List<String> numbers, String input, String separator) {
		String result = "";
		for (String number : numbers) {
			result = input.replace(number, "");
			result = result.replace(separator, "");
		}

		return result;
	}
}
