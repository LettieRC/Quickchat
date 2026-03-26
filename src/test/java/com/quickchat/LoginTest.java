package com.quickchat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Login class.
 * Uses the exact test data specified in the PoE brief.
 */
public class LoginTest {

    private Login login;

    /**
     * Sets up a default registered user before each test.
     * Uses the test data from the PoE brief where applicable.
     */
    @BeforeEach
    public void setUp() {
        // A fully valid user used for login tests
        login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
    }

    // ─────────────────────────────────────────────
    // assertEquals Tests
    // ─────────────────────────────────────────────

    /** Username correctly formatted — should return the welcome string. */
    @Test
    public void testUsernameCorrectlyFormatted_ReturnsWelcomeMessage() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setCellPhoneNumber("+27838968976");
        assertEquals(
            "Registration successful! Welcome Kyle Smith.",
            login.registerUser()
        );
    }

    /** Username incorrectly formatted — should return the error message. */
    @Test
    public void testUsernameIncorrectlyFormatted_ReturnsErrorMessage() {
        login.setUsername("kyle!!!!!!!");
        assertEquals(
            "Username is not correctly formatted; please ensure that your username " +
            "contains an underscore and is no more than five characters in length.",
            login.registerUser()
        );
    }

    /** Password meets complexity requirements. */
    @Test
    public void testPasswordMeetsComplexity_ReturnsSuccess() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setCellPhoneNumber("+27838968976");
        // registerUser only gets here after username passes; verify password message
        // by checking checkPasswordComplexity independently:
        assertTrue(login.checkPasswordComplexity(),
            "Password 'Ch&&sec@ke99!' should meet complexity requirements.");
    }

    /** Password does not meet complexity requirements — returns error message. */
    @Test
    public void testPasswordDoesNotMeetComplexity_ReturnsErrorMessage() {
        login.setUsername("kyl_1");
        login.setPassword("password");
        assertEquals(
            "Password is not correctly formatted; please ensure that the password " +
            "contains at least eight characters, a capital letter, a number, and a special character.",
            login.registerUser()
        );
    }

    /** Cell phone correctly formatted — returns success message. */
    @Test
    public void testCellPhoneCorrectlyFormatted_ReturnsSuccess() {
        login.setCellPhoneNumber("+27838968976");
        assertTrue(login.checkCellPhoneNumber(),
            "Cell phone +27838968976 should be valid.");
    }

    
    /** Cell phone incorrectly formatted — returns error message. */
    @Test
    public void testCellPhoneIncorrectlyFormatted_ReturnsError() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setCellPhoneNumber("08966553");
        assertEquals(
            "Cell phone number incorrectly formatted or does not contain international code.",
            login.registerUser()
        );
    }

    // ─────────────────────────────────────────────
    // assertTrue / assertFalse Tests
    // ─────────────────────────────────────────────

    /** Login successful — loginUser() returns true. */
    @Test
    public void testLoginSuccessful_ReturnsTrue() {
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"),
            "Login with correct credentials should return true.");
    }

    /** Login failed — loginUser() returns false. */
    @Test
    public void testLoginFailed_ReturnsFalse() {
        assertFalse(login.loginUser("wrong", "wrongPass1!"),
            "Login with incorrect credentials should return false.");
    }

    /** Username correctly formatted — checkUserName() returns true. */
    @Test
    public void testCheckUserName_CorrectlyFormatted_ReturnsTrue() {
        login.setUsername("kyl_1");
        assertTrue(login.checkUserName(),
            "Username 'kyl_1' should be valid.");
    }

    /** Username incorrectly formatted — checkUserName() returns false. */
    @Test
    public void testCheckUserName_IncorrectlyFormatted_ReturnsFalse() {
        login.setUsername("kyle!!!!!!!");
        assertFalse(login.checkUserName(),
            "Username 'kyle!!!!!!!' should be invalid.");
    }

    /** Password meets complexity — checkPasswordComplexity() returns true. */
    @Test
    public void testCheckPasswordComplexity_MeetsRequirements_ReturnsTrue() {
        login.setPassword("Ch&&sec@ke99!");
        assertTrue(login.checkPasswordComplexity(),
            "Password 'Ch&&sec@ke99!' should pass complexity check.");
    }

    /** Password does not meet complexity — checkPasswordComplexity() returns false. */
    @Test
    public void testCheckPasswordComplexity_DoesNotMeetRequirements_ReturnsFalse() {
        login.setPassword("password");
        assertFalse(login.checkPasswordComplexity(),
            "Password 'password' should fail complexity check.");
    }

    /** Cell phone correctly formatted — checkCellPhoneNumber() returns true. */
    @Test
    public void testCheckCellPhoneNumber_CorrectlyFormatted_ReturnsTrue() {
        login.setCellPhoneNumber("+27838968976");
        assertTrue(login.checkCellPhoneNumber(),
            "Cell +27838968976 should be valid.");
    }

    /** Cell phone incorrectly formatted — checkCellPhoneNumber() returns false. */
    @Test
    public void testCheckCellPhoneNumber_IncorrectlyFormatted_ReturnsFalse() {
        login.setCellPhoneNumber("08966553");
        assertFalse(login.checkCellPhoneNumber(),
            "Cell 08966553 should be invalid (no international code, too short).");
    }
}
