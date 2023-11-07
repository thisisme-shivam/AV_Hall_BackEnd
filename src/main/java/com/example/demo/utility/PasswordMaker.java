package com.example.demo.utility;

import java.security.SecureRandom;

public class PasswordMaker {
    public static String generatePassword() {
        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String lower = upper.toLowerCase();
        final String digits = "0123456789";
        final String special = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";

        final String allCharacters = upper + lower + digits + special;
        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(index));
        }

        return password.toString();
    }
}
