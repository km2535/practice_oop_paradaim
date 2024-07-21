package org.example;

public class PasswordValidator {
    final int passwordLength;
    final String WRONG_PASSWORD_LENGTH= "비밀번호는 최소 8자 이상 12자 이하여야 한다.";
    final static int MIN = 8;
    final static int MAX = 12;
    public PasswordValidator(final String password) {
        if(password.length() < MIN || password.length() > MAX) {
            throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH);
        }
        this.passwordLength = password.length();
    }

}
