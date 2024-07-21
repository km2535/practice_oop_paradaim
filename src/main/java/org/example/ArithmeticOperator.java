package org.example;

import java.util.Arrays;

public enum ArithmeticOperator {
    ADDITION("*") {
        @Override
        public int arithmeticCalculator(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTION("-") {
        @Override
        public int arithmeticCalculator(int operand1, int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculator(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/") {
        @Override
        public int arithmeticCalculator(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;
    ArithmeticOperator(String s) {
        this.operator = s;
    }
    public abstract int arithmeticCalculator(final int operand1, final int operand2);

    public static int calculator(int operand1, String operatorArg, int operand2) {
      ArithmeticOperator arithmeticOperator =  Arrays.stream(values())
                .filter(v -> v.operator.equals(operatorArg))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown operator: " + operatorArg));

      return arithmeticOperator.arithmeticCalculator(operand1, operand2);
    }


}
