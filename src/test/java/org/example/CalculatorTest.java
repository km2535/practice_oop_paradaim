package org.example;

import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 요구사항
 * 간단한 사칙연산
 * 양수로만 계산
 * 나눗셈에서 0을 나누는 경우 IllegalArgument리턴
 * MVC 패턴 기반으로 구현
 */

public class CalculatorTest {

    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculatorTest(int operand1, String operator, int operand2, int result){
        int calculated = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
        assertThat(calculated).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                Arguments.arguments(1,"+",2,3),
                Arguments.arguments(1,"-",2,-1),
                Arguments.arguments(2,"*",2,4),
                Arguments.arguments(4,"/",2,2)
        );
    }

    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
    @Test
    void calculateExceptionTest(){
        assertThatCode(() -> Calculator.calculate( new PositiveNumber(10) ,"/" , new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negative numbers and zero number are not allowed");
    }
}
