
package chapter5_ex17;
/*
Name: Phong Tran
Date: 09/16/21
Project: Chapter 5 exercise 17
Description: This program will displays a number pyramid base on the number of 
lines entered by the user.
*/
import java.util.Scanner;
public class Chapter5_Ex17 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //prompt the user to enter the number of lines
        System.out.print("Enter the number of lines: ");
        //declaring variables
        int lines = input.nextInt();
        
        //printing pyramid
        for (int i = 1; i <= lines; i++){//outer loop
            for (int j = 1; j <= (lines - i) * 2; j++){
                System.out.print(" ");//adding space to shape the pyramid
            }
            for (int k = i; k >= 1; k--){//use loop to decrease k value as it get closer to center
                System.out.print(" " + k);//left side
                }
            for (int l = 2; l <= i; l++){// use loop to increase l value as it get further from center
                System.out.print(" " + l);//right side
                }   
            System.out.println();
        }
    }
}