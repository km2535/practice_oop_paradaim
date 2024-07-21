package org.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PasswordValidatorTest {



    @DisplayName("비밀번호가 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest(){
        assertThatCode(()->new  PasswordValidator("serverwizard")).doesNotThrowAnyException();
    }
    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaaa", "aaaaaaaaaaaaa"})
    void validatePasswordTest2(String password){
        assertThatCode(()->new  PasswordValidator(password)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
