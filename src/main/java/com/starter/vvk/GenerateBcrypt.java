package com.starter.usermanagement;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerateBcrypt {
    public static void main(String[] args) {
        String password = "admin"; // your desired password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode(password);
        System.out.println("Bcrypt hash: " + hash);
    }
}
