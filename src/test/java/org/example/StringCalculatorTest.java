package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void expectedReturn0ForBlankString(){
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
    void expectedReturnThatNumberIfStringContainsANumberAndASeparate(){
        String oneNumberAndASeparateString = "5,";
        assertEquals(5, calculator.add(oneNumberAndASeparateString));
    }

    @Test
    void expectedReturnSumOfTwoNumberIfStringContainsTwoNumberAndSeparate() {
        String twoNumberAndASeparateString = "5,10";
        assertEquals(15, calculator.add(twoNumberAndASeparateString));
    }
}