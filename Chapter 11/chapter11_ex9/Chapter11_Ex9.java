
package chapter11_ex9;

/*
Name: Phong Tran
Date: 11/12/21
Project: Chapter 11 Exercise 9
Description: This program create a n-by-n matrix and randomly fills in 0s and 1s then finds the rows and columns with the most 1s
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Chapter11_Ex9 {
    public static void main(String[] args) {
        //prompt user for size
        System.out.print("Enter the array size n: ");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        
        //create matrix based on size
        int [][] matrix = new int[size][size];
        
        //fill matrix with 0s and 1s and print matrix
        for(int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[row].length;col++){
                matrix[row][col] = (int)(Math.random() * 2);
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        //create arrayList for number of 1s in each row and col
        ArrayList<Integer>mostRow = new ArrayList<>();
        ArrayList<Integer>mostCol = new ArrayList<>();
        //add number of 1s in each row into array list
        for(int row = 0; row < matrix.length; row++){
            int counterRow = 0;
            for (int col = 0; col < matrix[row].length;col++){
                if (matrix[row][col] == 1){
                    counterRow++;
                }
            }
            mostRow.add(counterRow);
        }
        //add number of 1s in each column into array list
        for(int col = 0; col < matrix.length; col++){
            int counterCol = 0;
            for (int row = 0; row < matrix[col].length;row++){
                if (matrix[row][col] == 1){
                    counterCol++;
                }
            }
            mostCol.add(counterCol);
        }
        //find highest value in array list
        int maxValRow = Collections.max(mostRow);
        int maxValCol = Collections.max(mostCol);
        //search for index with highest value and print index for row
        System.out.print("The largest row index: ");
        int counterRow = 0;
        for (int row = 0; row < mostRow.size(); row++){
            if (mostRow.get(row) == maxValRow){
                counterRow++;
                if(counterRow == 1){
                    System.out.print(row);
                }
                else{
                    System.out.print( "," + row);
                }
            }
        }
        System.out.println();
        //search for index with highest value and print index for column
        System.out.print("The largest column index: ");
        int counterCol = 0;
        for (int col = 0; col < mostCol.size(); col++){
            if (mostCol.get(col) == maxValCol){
                counterCol++;
                if (counterCol == 1){
                    System.out.print(col);
                }
                else{
                    System.out.print("," + col);
                }
            }
        }    
    }    
}