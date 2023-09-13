package uk.co.gamma.scrumpoker.generator;

import java.util.ArrayList;
import java.util.List;

public class FibonacciCardValuesGenerator implements CardValuesGenerator {
    private final Integer numberOfCards;

    public FibonacciCardValuesGenerator(Integer numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    @Override
    public List<Integer> generateValues() {
        return generateFibonacciValuesFromThirdValue();
    }

    private List<Integer> generateFibonacciValuesFromThirdValue() {

        List<Integer> values = new ArrayList<>();

        int num1 = 1;
        int num2 = 1;

        for(int i = 0; i < this.numberOfCards; i++) {
            values.add(num2);
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }

        return values;
    }
}
