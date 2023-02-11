package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FizzBuzzTest {
    private FizzBuzz fizzBuzz;
    @BeforeEach
    void setUp() {
        fizzBuzz  = new FizzBuzz();
    }

    @Test
    void inputAnyNumber_returnString() {
        String s = fizzBuzz.fizzBuzz(124);
        assertTrue(s instanceof String);
    }

    @Test
    void inputMultipleOfThree_expectFizz() {
        String s = fizzBuzz.fizzBuzz(9);
        assertEquals("Fizz", s);
    }

    @Test
    void inputMultipleOfFive_expectBuzz() {
        String s = fizzBuzz.fizzBuzz(25);
        assertEquals("Buzz", s);
    }

    @Test
    void inputMultipleOfThreeAndFive_expectFizzBuzz() {
        String s = fizzBuzz.fizzBuzz(15);
        assertEquals("FizzBuzz", s);
    }
}