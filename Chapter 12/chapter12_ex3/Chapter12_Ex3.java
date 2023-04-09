package chapter12_ex3;

/*
Name: Phong Tran
Date: 11/17/21
Project: Chapter 12 Exercise 3
Description: this program generate an array with 100 random integers and return value based on the index input by the user
*/
import java.util.Scanner;
public class Chapter12_Ex3 {
    public static void main(String[] args) {
        //prompt user for index
        System.out.print("Enter an index: ");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        //create array
        int [] array = new int[100];
        //pass random integers(0-100) into array
        for (int i = 0;i < array.length;i++){
            array[i] = (int)(Math.random() * 100);
        }
        //try and catch index out of bounds exception
        try{
            System.out.print("The value at index " + index + " is " + array[index]);
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.print("Out of Bounds");
        }
    }
    
}
