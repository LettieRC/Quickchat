package com.quickchat;

/**
 * Login class for QuickChat application.
 * Handles user registration and login functionality.
 */
public class Login {

    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // ─────────────────────────────────────────────
    // Constructors
    // ─────────────────────────────────────────────

    public Login() {}

    public Login(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // ─────────────────────────────────────────────
    // Getters and Setters
    // ─────────────────────────────────────────────

    public String getUsername()                     { return username; }
    public void   setUsername(String username)      { this.username = username; }

    public String getPassword()                     { return password; }
    public void   setPassword(String password)      { this.password = password; }

    public String getCellPhoneNumber()              { return cellPhoneNumber; }
    public void   setCellPhoneNumber(String cell)   { this.cellPhoneNumber = cell; }

    public String getFirstName()                    { return firstName; }
    public void   setFirstName(String firstName)    { this.firstName = firstName; }

    public String getLastName()                     { return lastName; }
    public void   setLastName(String lastName)      { this.lastName = lastName; }

    // ─────────────────────────────────────────────
    // Validation Methods
    // ─────────────────────────────────────────────

    /**
     * Checks that the username contains an underscore
     * and is no more than five characters long.
     *
     * @return true if the username is valid, false otherwise.
     */
    public boolean checkUserName() {
        if (username == null) return false;
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Checks that the password meets complexity requirements:
     * - At least 8 characters long
     * - Contains at least one capital letter
     * - Contains at least one digit
     * - Contains at least one special character
     *
     * @return true if the password is valid, false otherwise.
     */
    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) return false;

        boolean hasUpper   = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit   = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = password.chars().anyMatch(c ->
                "!@#$%^&*()_+-=[]{}|;':\",./<>?".indexOf(c) >= 0);

        return hasUpper && hasDigit && hasSpecial;
    }

    /**
     * Validates a South African cell phone number using a regular expression.
     * The number must start with the international country code (+27)
     * followed by exactly 9 digits (total: 12 characters including the +).
     *
     * Regex reference:
     * Adapted from:https://uibakery.io/regex-library/phone-number
     * Pattern: ^\+[0-9]{1,3}[0-9]{9,10}$
     * - ^\+        : must start with a '+' sign (international code indicator)
     * - [0-9]{1,3} : 1–3 digit country code (e.g. 27 for South Africa)
     * - [0-9]{9,10}: 9–10 digit local number
     * - $          : end of string
     *
     * @return true if the cell phone number is correctly formatted, false otherwise.
     */
    public boolean checkCellPhoneNumber() {
        if (cellPhoneNumber == null) return false;
        String regex = "^\\+[0-9]{1,3}[0-9]{9,10}$";
        return cellPhoneNumber.matches(regex);
    }

    // ─────────────────────────────────────────────
    // Registration & Login Methods
    // ─────────────────────────────────────────────

    /**
     * Attempts to register the user by validating username, password,
     * and cell phone number in sequence.
     *
     * @return a status message describing the result of registration.
     */
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username " +
                   "contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password " +
                   "contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "Registration successful! Welcome " + firstName + " " + lastName + ".";
    }

    /**
     * Verifies that the provided credentials match the stored credentials.
     *
     * @param enteredUsername the username entered at login.
     * @param enteredPassword the password entered at login.
     * @return true if both username and password match, false otherwise.
     */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (enteredUsername == null || enteredPassword == null) return false;
        return enteredUsername.equals(this.username) && enteredPassword.equals(this.password);
    }

    /**
     * Returns a login status message based on whether the provided
     * credentials are correct.
     *
     * @param enteredUsername the username entered at login.
     * @param enteredPassword the password entered at login.
     * @return a welcome message on success, or an error message on failure.
     */
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}