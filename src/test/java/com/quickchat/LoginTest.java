package com.quickchat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
  
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @Mosetsanyana Margaret Manong
 */
public class LoginTest {
    
//This is my login object that will be used for testing
Login myLogin;

//This method will runs before every single test
//This will create a fresh login page each time

@BeforeEach
public void setUp(){
    myLogin= new Login();
    myLogin.FirstName="Kyle";
    myLogin.LastName="Smith";
    myLogin.username="kyl_1";
    myLogin.password="Ch&&sec@ke99!";
    myLogin.cellnumber="+27838968976";
    
}

//Username Tests

//Test 1 username is correct
@Test
public void testUsernameCorrect(){
    myLogin.username="kyl_1";
    assertEquals(
    "Registration sucessful!, Welcome Kyle Smith",
    myLogin.RegisterUser()
    );
    
   
    }
 //Test 2 username is incorrect

@Test
public void testUsernameIncorrect() {
    myLogin.username="Kyle!!!";
    assertEquals(
    "Username is not correctly not correctly formatted;please ensure that your username contains an underscore and is no more than five characters in length",
    myLogin.RegisterUser()
            );
}
//--Password tests
//Test 3 - Password meets requirements
@Test
public void testPasswordCorrect(){
    myLogin.password= "Ch&&sec@ke99!";
    assertEquals(
    "Password successfully captured",
    myLogin.checkpasswordRequirements() == true ?
            "Password successfully captured." : 
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character."
    );
    
}
   //Test 4 password does not meet requirements
@Test
public void testPasswordIncorrect(){
    myLogin.password= "password";
    assertEquals(
    "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
    myLogin.checkpasswordRequirements() == true ?
             "Password successfully captured." :
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character."
        );
}
//Test 5
//cellnumber is correct
public void testCellnumberCorrect() {
    myLogin.cellnumber = "0658200398";
    assertEquals(
    "Cell number successfully captured.",
    myLogin.checkcellphonenumber() == true ? 
            "Cellphone number successfully captured." :
            "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again."
    );
    
}
 // Test 6 - cell number is wrong
    @Test
    public void testCellNumberWrong() {
        myLogin.cellnumber = "08966553";
        assertEquals(
            "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.",
            myLogin.checkcellphonenumber() == true ?
            "Cell number successfully captured." :
            "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again."
        );
    }
    // ── LOGIN TESTS ──
    
    // Test 7 - login successful
    @Test
    public void testLoginSuccessful() {
        assertTrue(myLogin.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
    
    // Test 8 - login failed
    @Test
    public void testLoginFailed() {
        assertFalse(myLogin.loginUser("wronguser", "wrongpass"));
    }
    
   //assertTrue/assertFalse tests
    
    // Test 9 - username correctly formatted
    @Test
    public void testUsernameCorrectlyFormatted() {
        myLogin.username = "kyl_1";
        assertTrue(myLogin.checkusername());
    }
    
    // Test 10 - username incorrectly formatted
    @Test
    public void testUsernameIncorrectlyFormatted() {
        myLogin.username = "kyle!!!!";
        assertFalse(myLogin.checkusername());
    }
    
    // Test 11 - password meets requirements
    @Test
    public void testPasswordMeetsRequirements() {
        myLogin.password = "Ch&&sec@ke99!";
        assertTrue(myLogin.checkpasswordRequirements());
    }
    
    // Test 12 - password does not meet requirements
    @Test
    public void testPasswordDoesNotMeetRequirements() {
        myLogin.password = "password";
        assertFalse(myLogin.checkpasswordRequirements());
    }
    
    // Test 13 - cell number correctly formatted
    @Test
    public void testCellNumberCorrectlyFormatted() {
        myLogin.cellnumber = "+27658200398";
        assertTrue(myLogin.checkcellphonenumber());
    }
    
    // Test 14 - cell number incorrectly formatted
    @Test
    public void testCellNumberIncorrectlyFormatted() {
        myLogin.cellnumber = "08966553";
        assertFalse(myLogin.checkcellphonenumber());
    }
    
}


/*References:
Baeldung, 2023. Guide to JUnit 5 [Online]. Available at: https://www.baeldung.com/junit-5 [Accessed: March 2026]
GeeksforGeeks, 2023. How to write JSON object to file in Java [Online]. Available at: https://www.geeksforgeeks.org/how-to-write-json-object-to-file-in-java/ [Accessed: March 2026]
Oracle, 2023. Java Documentation - Character class [Online]. Available at: https://docs.oracle.com/en/java/docs/api/java.base/java/lang/Character.html [Accessed: March 2026]
Oracle, 2023. Java Documentation - String class [Online]. Available at: https://docs.oracle.com/en/java/docs/api/java.base/java/lang/String.html [Accessed: March 2026]
QuickBlox, 2023. Beginners guide to chat app architecture [Online]. Available at: https://quickblox.com/blog/beginners-guide-to-chat-app-architecture/ [Accessed: March 2026]
UIBakery, 2023. Regex library - Phone number [Online]. Available at: https://uibakery.io/regex-library/phone-number [Accessed: March 2026]

YouTube Video References:
Amigoscode, 2021. JUnit 5 Tutorial - Learn how to write unit tests [Online video]. Available at: https://www.youtube.com/watch?v=MOhiM2SXZl0 [Accessed: March 2026]
Amigoscode, 2021. GitHub Actions - Automate your tests with Maven [Online video]. Available at: https://www.youtube.com/watch?v=oz0Qd5H4Onk [Accessed: March 2026]
Kharkov, B., 2022. GitHub Desktop Tutorial - How to use GitHub Desktop [Online video]. Available at: https://www.youtube.com/watch?v=bUgFv1Y5LJw [Accessed: March 2026]


*/
