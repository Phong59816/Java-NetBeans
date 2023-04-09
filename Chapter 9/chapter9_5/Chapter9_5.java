package chapter9_5;

/*
Name:Phong Tran
Date: 10/20/21
Project: Chapter 9 Exercise 5
Description: This program display 50 random integer between 0 and 100 using the Random class
*/
public class Chapter9_5 {

    public static void main(String[] args) {
        //create random number object and set seed to 1000
        java.util.Random number = new java.util.Random(1000);
        //loop to print out first 50 random number between 0 and 100
        for (int i = 0; i < 50; i++){
            System.out.print(number.nextInt(100) + " ");
        }
    }
    
}
