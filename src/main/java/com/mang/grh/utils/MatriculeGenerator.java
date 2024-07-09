package com.mang.grh.utils;

import java.security.SecureRandom;

public class MatriculeGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int MATRICULE_LENGTH = 8;

    public static String generateMatricule() {
        SecureRandom random = new SecureRandom();
        StringBuilder matricule = new StringBuilder(MATRICULE_LENGTH);

        for (int i = 0; i < MATRICULE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            matricule.append(CHARACTERS.charAt(index));
        }

        return matricule.toString();
    }

}
