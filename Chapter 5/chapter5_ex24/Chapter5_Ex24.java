
package chapter5_ex24;
/*
Name: Phong Tran
Date: 09/16/21
Project: Chapter 5 exercise 24
Description: This program will compute the sum of fractions with numerator incremented
by 2 from 1 to 97 and denominator increment by 2 from 3 to 99
*/
public class Chapter5_Ex24 {

    public static void main(String[] args) {
        
        //declaring variables
        double numerator;
        double sum = 0;
        
        for (numerator = 1.0; numerator <= 97.0; numerator += 2){//use loop to increment numerator value
            sum += numerator / (numerator + 2);//calculating sum
            }
        System.out.print("The sum is " + sum);//display answer
        
    }
}
