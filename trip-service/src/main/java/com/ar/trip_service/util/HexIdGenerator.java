package com.ar.trip_service.util;

import java.util.Random;

public class HexIdGenerator {

    private static final String HEX_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int ID_LENGTH = 12;
    private static final Random random = new Random();

    public static String generateHexId() {
        StringBuilder hexId = new StringBuilder(ID_LENGTH);

        // First character must be a letter
        hexId.append(LETTERS.charAt(random.nextInt(LETTERS.length())));

        // Remaining characters from HEX_LIST
        for (int i = 1; i < ID_LENGTH; i++) {
            hexId.append(HEX_LIST.charAt(random.nextInt(HEX_LIST.length())));
        }
        return hexId.toString();
    }


    public static String generateDriverId() {
        int idNumber = new Random().nextInt(1,100);

        return "Driver " + idNumber;
    }

    public static String generateVehicleId() {
        int idNumber = new Random().nextInt(1,100);

        return "Vehicle " + idNumber;
    }
}
