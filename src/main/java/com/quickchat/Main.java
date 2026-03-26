package com.quickchat;

import java.util.Scanner;

/**
 * Main entry point for the QuickChat console application.
 * Handles user registration and login via console input.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login user = new Login();

        System.out.println("===========================================");
        System.out.println("         Welcome to QuickChat              ");
        System.out.println("===========================================");

        // ── Registration ──────────────────────────────────────────
        System.out.println("\n--- Registration ---");

        System.out.print("Enter your first name: ");
        user.setFirstName(scanner.nextLine().trim());

        System.out.print("Enter your last name: ");
        user.setLastName(scanner.nextLine().trim());

        // Username validation loop
        boolean usernameValid = false;
        while (!usernameValid) {
            System.out.print("Enter a username (must contain '_' and be ≤5 characters): ");
            user.setUsername(scanner.nextLine().trim());
            if (user.checkUserName()) {
                System.out.println("Username successfully captured.");
                usernameValid = true;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your " +
                        "username contains an underscore and is no more than five characters in length.");
            }
        }

        // Password validation loop
        boolean passwordValid = false;
        while (!passwordValid) {
            System.out.print("Enter a password (≥8 chars, 1 capital, 1 number, 1 special character): ");
            user.setPassword(scanner.nextLine().trim());
            if (user.checkPasswordComplexity()) {
                System.out.println("Password successfully captured.");
                passwordValid = true;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the " +
                        "password contains at least eight characters, a capital letter, a number, " +
                        "and a special character.");
            }
        }

        // Cell phone validation loop
        boolean cellValid = false;
        while (!cellValid) {
            System.out.print("Enter your cell phone number (international format, e.g. +27831234567): ");
            user.setCellPhoneNumber(scanner.nextLine().trim());
            if (user.checkCellPhoneNumber()) {
                System.out.println("Cell phone number successfully added.");
                cellValid = true;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        System.out.println("\n" + user.registerUser());

        // ── Login ─────────────────────────────────────────────────
        System.out.println("\n--- Login ---");

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine().trim();

            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine().trim();

            System.out.println(user.returnLoginStatus(enteredUsername, enteredPassword));

            if (user.loginUser(enteredUsername, enteredPassword)) {
                loggedIn = true;
            }
        }

        scanner.close();
    }
}
