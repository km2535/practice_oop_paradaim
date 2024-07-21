package org.example;

import org.example.calculate.*;

import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> newArithmeticOperators = List.of(
            new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator()
    );

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
//      return ArithmeticOperator.calculator(operand1,operator,operand2);
        return newArithmeticOperators.stream()
                .filter(newArithmeticOperators -> newArithmeticOperators.supports(operator))
                .map(newArithmeticOperators -> newArithmeticOperators.calculate(operand1, operand2))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No such operator: " + operator));
    }
}
