package org.example;

import java.util.Arrays;

public class StringCalculator {
    /**
     * Requirement 1:
     * Take upto two number that seperated by a comma then return sum of that number. If that string is empty, then return 0.
     * Ex: "1,2" => 3
     *
     * @param numbers string contains upto two numbers
     * @return sum of input
     */
    public int add(String numbers) throws IllegalArgumentException{
        int result = 0;

        if (numbers == null || numbers.isEmpty() || numbers.isBlank())
            return result;

        if (numbers.contains(",")) {
            if (!numbers.matches((".*\\d+.*"))) {
                throw new IllegalArgumentException("Input only contains characters");
            }
        }

        String[] listOfNumber = numbers.split(",");
        for (String number: listOfNumber) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}
