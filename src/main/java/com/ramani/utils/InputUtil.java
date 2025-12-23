package com.ramani.utils;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("❌ Please enter a valid number: ");
            scanner.next(); // invalid input discard
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        return value;
    }

    public static double getDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("❌ Please enter a valid amount: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    public static String getString() {
        return scanner.nextLine();
    }
}

