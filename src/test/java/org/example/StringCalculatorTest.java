package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {
	StringCalculator calculator = new StringCalculator();

	@Test
	void expectedReturn0ForEmptyString() {
		String empty = "";
		assertEquals(0, calculator.add(empty));
	}

	@Test
	void expectedReturn0ForNullString() {
		assertEquals(0, calculator.add(null));
	}

	@Test
	void expectedReturn0ForBlankString() {
		assertEquals(0, calculator.add("  "));
	}

	@Test
	void expectedReturn0ForOnlyContainsCommaString() {
		assertThrows(IllegalArgumentException.class, () -> calculator.add(","));
	}

	@Test
	void expectedThrowExceptionIfStringContainsOneNumber() {
		String oneNumberString = "5";
		assertEquals(5, calculator.add(oneNumberString));
	}

	@Test
	void expectedReturnSumOfTwoNumberIfStringContainsTwoNumberAndSeparate() {
		String twoNumberAndASeparateString = "5,10";
		assertEquals(15, calculator.add(twoNumberAndASeparateString));
	}

	@Test
	void expectedReturnSumOfMoreThanTwoNumberIfStringContains() {
		String multipleNumberAndSeparatedString = "1,2,3,4,5,6";
		assertEquals(21, calculator.add(multipleNumberAndSeparatedString));
	}

	@Test
	void expectedReturnSumWithNewLineAsSeparator() {
		String newLineSeparator = "1\n3";
		assertEquals(4, calculator.add(newLineSeparator));
	}

	@Test
	void expectedReturnSumWithNewLineAndCommaAsSeparator() {
		String input = "1,2\n3";
		assertEquals(6, calculator.add(input));
		String input2 = "3\n2,1";
		assertEquals(6, calculator.add(input2));
	}

	@Test
	void expectedThrowErrorIfSeparatorAtTheEndOfInput() {
		String input = "5,6,";
		assertThrows(IllegalArgumentException.class, () -> calculator.add(input));
	}
}