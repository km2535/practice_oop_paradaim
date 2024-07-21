package org.example.calculate;

public class PositiveNumber {
    private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if(isNegativeNumber(value)){
            throw new IllegalArgumentException("Negative numbers and zero number are not allowed");
        }
    }

    private boolean isNegativeNumber(final int value) {
        return value <= 0;
    };
    public int getValue() {
        return value;
    }

}
