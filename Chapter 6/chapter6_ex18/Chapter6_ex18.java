package chapter6_ex18;

/*
Name: Phong Tran
Date: 09/22/21
Project: Chapter 6 exercise 18
Description: This program check if the password input by the user is valid
*/
import java.util.Scanner;
public class Chapter6_ex18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //prompt user to enter a password and store it in a variable
        System.out.print("Enter a password: ");
        String password = input.nextLine();
        //invoking password method
        pass(password);
    }
    public static void pass(String password){
        //declaring variables
        int digitCount = 0;
        int symbol = 0;
        //loop through password and count number of digits
        for (int i = password.length() - 1; i > 0; i--){
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9'){
                digitCount++;
            }
        }
        //loop through password and find any non letters and digits
        for (int j = password.length() - 1; j > 0; j--){
            if (!((password.charAt(j) >= 'A' && password.charAt(j) <= 'Z') || 
                    (password.charAt(j) >= 'a' && password.charAt(j) <= 'z') ||
                    (password.charAt(j) >= '0' && password.charAt(j) <= '9')))
                symbol++;
        }
        //check if there are at least 2 digits
        if (digitCount < 2){
            System.out.print("Invalid Password");
        }
        //check if password is at least 8 characters
        else if (password.length() < 8){
            System.out.print("Invalid Password");
        }
        //check if there are any non letter and digit 
        else if (symbol > 0)
            System.out.print("Invalid Password");
        else{
            System.out.print("Valid Password");
        }
    }
    
}