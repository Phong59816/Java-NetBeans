
package chapter6_ex4;

/*
Name: Phong Tran
Date: 09/22/21
Project: Chapter 6 exercise 4
Description: This project display the number input by the user in reverse order
*/
import java.util.Scanner;
public class Chapter6_Ex4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //prompt user to enter a number and store it in a variable
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        //invoking reverse method
        reverse(number);
    }
    public static void reverse(int number){
        //convert number into a string
        String num = number + ""; 
        //looping through length of string and print out character in reverse
        for (int i = num.length() - 1; i >= 0; i--)
            System.out.print(num.charAt(i));
    }
}
