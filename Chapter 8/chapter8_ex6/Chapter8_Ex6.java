
package chapter8_ex6;

/*
Name: Phong Tran
Date: 10/07/21
Project: Chapter 8 Ex 6
Description: This program nultiply 2 matrices
*/
import java.util.Scanner;
public class Chapter8_Ex6 {
     public static void main(String[] args) {
         //prompt user for maxtrix1 inputs
         Scanner input = new Scanner(System.in);
         System.out.print("Enter matrix1: ");
         //create matrix1 using inputs
         double[][]matrix1 = new double[3][3];
         
         for (int row = 0; row < matrix1.length;row++){
             for (int column = 0; column < matrix1[row].length;column++){
                 matrix1[row][column] = input.nextDouble();
                 }
             }
         //prompt user for matrix 2 input
         System.out.print("Enter matrix2: ");
         //create matrix 2 using inputs
         double[][]matrix2 = new double[3][3];
         
         for (int row = 0; row < matrix2.length;row++){
             for (int column = 0; column < matrix2[row].length;column++){
                 matrix2[row][column] = input.nextDouble();
                 }
             }
         System.out.println("The multiplication of the matrices is: ");
         //print result of multiplication
         for (int row = 0;row < matrix1.length;row++){
             for (int column = 0; column < matrix1[row].length;column++){
                 //print matrix1
                 System.out.print(matrix1[row][column] + " ");
             }
             //spacing matrix and printing multiplication mark
             if (row == 1){
                 System.out.print("  *  ");
             }
             else{
             System.out.print("     ");
             }
             for (int column = 0; column < matrix2.length; column++){
                 //print matrix2
                 System.out.print(matrix2[row][column] + " ");
             }
             //spacing matrix and print equal sign
             if (row == 1){
                 System.out.print("  =  ");
             }
             else{
             System.out.print("     ");
             }
             for (int column = 0;column < matrix1[row].length;column++){
                 //invoke multiplyMatrix method
                 System.out.print(Math.round(multiplyMatrix(matrix1,matrix2)[row][column] *10.0) / 10.0 + " ");
                 }
             System.out.println();
             }
         }
     public static double [][]multiplyMatrix (double [][] a,double [][] b){
         //create matrix for result
         double [][]Matrix = new double [3][3];
         double result = 0;
         //loop to transfer result into matrix
         for (int row = 0; row < a.length;row++){
             for (int column = 0; column < a[row].length;column++){
                 //calculation for multiplication result
                 result = a[row][0] * b[0][column] + a[row][1] * b[1][column] + a[row][2] * b[2][column];
                 Matrix[row][column] = result;
                 }
             }
         return Matrix;
         }
}