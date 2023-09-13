package uk.co.gamma.scrumpoker.generator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciCardValuesGeneratorTest {
    @Test
    void generateWith7NumbersCorrectly() {
        FibonacciCardValuesGenerator generator = new FibonacciCardValuesGenerator(7);
        List<Integer> expectedValues = List.of(1, 2, 3, 5, 8, 13, 21);

        List<Integer> actualValues = generator.generateValues();

        assertEquals(expectedValues, actualValues);
    }
}