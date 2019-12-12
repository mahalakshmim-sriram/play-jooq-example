package com.example.util;

import org.mindrot.jbcrypt.BCrypt;

import java.nio.charset.Charset;
import java.security.SecureRandom;

public class Crypto {

    public static String generateRandomPassword() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] pass = new byte[20];
        secureRandom.nextBytes(pass);
        String password = new String(pass, Charset.defaultCharset());
        return password;
    }

    public static boolean validatePassword(String hashPassword, String userInputPassword) {
        return BCrypt.checkpw(userInputPassword, hashPassword);
    }
}
