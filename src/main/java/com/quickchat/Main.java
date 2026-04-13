/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quickchat;
import java.util.Scanner;
/**
 *
 * @Mosetsanyana Margaret Manong
 */

//This is the main class that runs thje program
public class Main { 
    
    public static void main(String[] args) {
        
        //Scanner allows us to read what the user Inputs
        Scanner scanner = new Scanner(System.in);
        
        //THis will create a login object
        Login user = new Login();
        
         System.out.println("======================");
         System.out.println("    Welcome  to my Quickchat");
         System.out.println("======================");
         
         //Registration 
         System.out.println("\n--- Registration ---");
         
       //Ask for name
       System.out.println("Enter your first Name: ");
       user.FirstName=scanner.nextLine();
       
       //Ask user for last name
       System.out.println("Enter your Last Name: ");
       user.LastName=scanner.nextLine();
       
       //Ask for username till it is valid
       boolean usernameAccepted = false;
       //while loop
       while(usernameAccepted==false) {
           
           System.out.println("Enter username (username must have _ and 5 chars or less )");
           user.username=scanner.nextLine();
           
           if (user.checkusername() == true) {
               System.out.println("Username has been successfully captured");
               usernameAccepted = true;
           }
           else {
               System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
           }
       }
       //Ask for password and it will keep asking till correct
           boolean passwordAccepted = false;
           while (passwordAccepted == false) {
           System.out.print("Enter password (8+ chars, capital, number, special): ");
           user.password=scanner.nextLine();
           
           if (user.checkpasswordRequirements() ==true ) {
               System.out.println("Password successfully captured." );
           passwordAccepted = true;
           } else {
                 System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
           }
           }
           //Will ask the user for mobile number until the user provides the number in a correct format
           boolean cellAccepted = false;
           while (cellAccepted == false) {
               System.out.print("Enter cell number (e.g. +27658200397):");
               user.cellnumber=scanner.nextLine();
               
               if (user.checkcellphonenumber() ==true){
                   System.out.println("Cellphone number has been successfully added");
                   cellAccepted=true;
               }
               else {
                   System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
               
                   
               }
           }
           //This will show  registration result:
           System.out.println(" \n " + user.RegisterUser());
           
           //Login
           System.out.println("\n--- Login ---");
           
           //This will keep asking until login is successful
           boolean LoggedIn= false;
           while(LoggedIn == false) {
               System.out.println("Enter username: ");
               String enteredUsernsme=scanner.nextLine();
               
               System.out.println("Enter password : ");
               String enteredPassword = scanner.nextLine();
               
               //This will show login status
               System.out.println(user.returnLoginStatus(enteredUsernsme, enteredPassword));
               
               //This will check if login is correct
               if(user.loginUser(enteredUsernsme, enteredPassword) == true) {
                   LoggedIn = true;
               }
               
               
           }
           
           
           scanner.close();
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
}
       
    
    

