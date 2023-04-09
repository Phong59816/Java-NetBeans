package chapter10_ex3;

/*
Name:Phong Tran
Date:10/26/21
Project: Chapter 10 Exercise 3
Description: This program check if an integer is odd,even,or prime
*/
import java.util.Scanner;
public class Chapter10_Ex3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //prompt user for number
        System.out.print("Enter a number: ");
        MyInteger myInt = new MyInteger(input.nextInt());
        //test get value method
        System.out.println("My number is: " + myInt.getValue());
        //test even method
        System.out.println("Is my number even? " + myInt.isEven());
        //test odd method
        System.out.println("Is my number odd? " + myInt.isOdd());
        //test prime method
        System.out.println("Is my number a prime? " + myInt.isPrime());
        //test equals method
        System.out.println("Is my number equal to 23? " + myInt.equals(23));
        System.out.print("Enter a another number: " );
        MyInteger myInt2 = new MyInteger(input.nextInt());
        //test equals MyInteger method
        System.out.println("Is my first number equal to my second number? " +myInt.equals(myInt2));
        //test static MyInteger even method
        System.out.println("is my new number even? " + MyInteger.isEven(myInt2));
        //test static MyInteger odd method
        System.out.println("Is my new number odd? " + MyInteger.isOdd(myInt2));
        //test static MyInteger prime method
        System.out.println("Is my new number a prime? " + MyInteger.isPrime(myInt2));
        //prompt user for array and create array
        System.out.print("Enter the size of array: ");
        char [] array = new char[input.nextInt()];
        System.out.print("Enter the values for the array: ");
        for (int i = 0; i < array.length;i++){
            array[i] = input.next().charAt(0);
        }
        //test convert char array to int value method
        int charArray = MyInteger.parseInt(array);
        System.out.println("The array of number you enter: " + charArray +" is now an int value");
        //prompt user for a number string
        System.out.println("Enter a string of number: ");
        String numString = input.next();
        //test convert string to int value method
        int numStr = MyInteger.parseInt(numString);
        System.out.println("The number you entered: " + numStr +  " is now an int value");
    }
    
}
