package com.smart.helper;

import org.springframework.stereotype.Service;

@Service
public class Validators {
    private final int PASSWORD_LENGTH=6;

    public boolean is_Valid_Password(String password) {

        if (password.length() < PASSWORD_LENGTH) return false;

        int charCount = 0;
        int numCount = 0;
        int spec=0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (is_Numeric(ch)) numCount++;
            else if (is_Letter(ch)) charCount++;
            else spec++;
        }
        return (charCount >= 2 && numCount >= 2 && spec>=1);
    }

    public boolean is_Letter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }

    public boolean is_Numeric(char ch) {
        return (ch >= '0' && ch <= '9');
    }
}
