package chapter7_ex18;

/*
Name: Phong Tran
Date : 10/03/21
Project: Programming project Exercise 7.18
Description: This project sort 10 number using bubble sort algorithm
*/
import java.util.Arrays;
import java.util.Scanner;
public class Chapter7_Ex18 {

    public static void main(String[] args) {
        //create scanner and prompt user for 10 numbers
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 10 numbers: ");
        //create array
        double [] number = new double [10];
        //placing numbers from input into array
        for (int i = 0;i < 10;i++){
            number[i] = input.nextDouble();
        }
        //invoke sort method
        sort(number);
        
    }
    //create sort method
    public static void sort(double[] num){
        //placeholder for swapping numbers
        double temp = 0;
        //comparing 2 numbers at a time and swapping larger value to the right
        for (int i = 0; i < 9;i++){
            for (int j = 0; j < 9 - i; j++){
                if (num[j] > num[j + 1]){
                    temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
            //printing each number in order
            System.out.print(num[i] + " ");
        }
    }
}
 