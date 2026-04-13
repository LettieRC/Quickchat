/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quickchat;

/**
 *
 //Mosetsanyana_Margaret_Manong
 */

public class Login{
    
    
    //My variables for logging in
    //All strings
    String username;
    String password;
    String FirstName;
    String LastName;
    String cellnumber;
    
    //Next I'm going to create a method
    //Boolean for checking whether a condition is true or false
    public boolean checkusername() {
        
//This will check whether it matches my conditions for signing in
//The first condition it should check if username has an underscore
       if(username.contains("_") && username.length() <= 5) { 
           return true;
       }
       else {
           return false;
       }

   }
    public boolean checkpasswordRequirements() {
        //Boolean for checking password requirements
        
        //Will check password lentght
        if(password.length() <8) {
            return false;
        }
        //This will check if password complies
        boolean hasCapital=false;
        boolean hasNumber=false;
        boolean hasSpecial=false;
        
        //incrementation
        for ( int i=0;  i < password.length(); i++) {
            //char means characters
            char c = password.charAt(i);
             
            if(Character.isUpperCase(c)) {
                hasCapital = true;
            }
            if (Character.isDigit(c)) {
                hasNumber=true;
            }
            if(!Character.isLetterOrDigit(c)){
                hasSpecial = true;
            }
        }
        
        if (hasCapital && hasNumber && hasSpecial) {
            return true;
        }
        else {
            return false;
        }
        
        }
    
    
    //Next I'm gonna create a method using Boolean
//it will check if it will start wiht an international code

//This will check if the number is valid
public boolean checkcellphonenumber(){
    String pattern = "^\\+[0-9]{1,3}[0-9]{9,10}$";
    
    //This will check if the number follows the pattern
    //It will act like a boolean value returning true or flase
    if (cellnumber.matches(pattern)) {
        return true;
        
    }
    else {
        return false;
        
    }
}

public String RegisterUser(){
    
    //it checks the username
    if (checkusername() ==false) {
        
        return "Username is not correctly formatted,please ensure that your username contains an underscore and is no more than five characters in length.\"" ;
    } 
    //Next check the password
    
   if (checkpasswordRequirements() == false) {
       
       return "\"Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.\";" ;
   }
  
   if(checkcellphonenumber() == false) {
       return "\"Cellphone number incorrectly formatted or doesn't contain international code.";
}
   //If All conditions meet 
   return "Registration successful! Welcome " + FirstName + " " + LastName + ". " ;
   }

//The boolean method contains variables
//enteredUsername variable have stored the username
//EnteredPassword variable have stored the password

public boolean loginUser(String enteredUsername, String EnteredPassword) {

//This will check if the entered username and password match what was saved
if (enteredUsername.equals(username) && EnteredPassword.equals(password)) {
    return true;
}
else {
    return false;
}
}
    //This method will return a result based on the login result
  public String returnLoginStatus(String enteredUsername, String EnteredPassword) {
        
        //this will validate if the entered details or credentials are correct
        if (loginUser(enteredUsername, EnteredPassword) == true ) {
            return "Welcome " + FirstName + " , " + LastName  + " it is great to see you again." ;
        } 
        else {
            return "Username or Password incorrect,Please try again";
        }
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


  
    

