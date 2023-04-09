package chapter8_ex22;

/*
Name: Phong Tran
Date: 10/13/21
Project: Chapter 8 Exercise 22
Description: This program generate a 6x6 matrix fill with 1s and 0s and check each row and columns for even number of 1s
*/
public class Chapter8_Ex22 {

    public static void main(String[] args) {
        //create matrix
        int matrix[][] = new int[6][6];
        //create matrix with random values of 0s and 1s
        genRandom(matrix);
        //check if all row and columns have even number of 1s
        count1(matrix);
        //create matrix with even number of 1s in each row and columns
        genEven(matrix);
        //check if all row and columns have even number of 1s
        count1(matrix);
        }
    //method to generate random matrix of 1s and 0s
     public static void genRandom (int[][] matrix){
         //pass random value of 1s and 0s into matrix
         for (int row = 0; row < matrix.length;row++){
             for (int col = 0;col < matrix[row].length;col++){
                 matrix[row][col] = (int)(Math.random() * 2);
             }
             //print matrix
             for (int col = 0;col < matrix[row].length;col++){
                 System.out.print(matrix[row][col] + " ");
             }
             System.out.println();
         }
    }
     //method to generate a matrix with even number of 1s in each row and columns
     public static void genEven (int [][] matrix){
         //create matrix with even number of 1s in each row and columns
         int [][]evenMatrix = {{1,0,1,0,1,1},
                               {0,1,1,0,0,0},
                               {1,0,0,1,0,0},
                               {0,1,1,1,1,0},
                               {1,1,0,1,0,1},
                               {1,1,1,1,0,0}};
         for (int row = 0; row < matrix.length;row++){
             for (int col = 0; col < matrix[row].length;col++){
                 //pass even matrix values into matrix and print
                 matrix[row][col] = evenMatrix[row][col];
                 System.out.print(matrix[row][col] + " ");
             }
             System.out.println();
         }
     }
     //method to check if all row and column have even number of 1s
     public static void count1 (int[][] matrix){
         boolean evenRow = true;
         boolean evenCol = true;
         //count number of 1s in each columns
         for (int col = 0; col < matrix[0].length;col++){
             int counter = 0;
             for (int row = 0; row < matrix.length;row++){
             //increment counter for 1s
             if (matrix[row][col] == 1){
                 counter++;
             }
             }
             // end if number of 1s in each col are not even
             if (counter % 2 != 0){
                 evenRow = false;
                 System.out.println("Not all rows and columns have even number of 1s");
                 break;
             }
         }
         //count number of 1s in each row
         for (int row = 0; row < matrix.length;row++){
             int counter = 0;
             for(int col = 0; col < matrix[0].length;col++){
                 //increment counter for 1s
                 if (matrix[row][col] == 1){
                     counter++;
                 }
             }
             //end if number of 1s in each row are not even
             if (counter % 2 != 0 && evenRow == true){
                 evenCol = false;
                 System.out.println("Not all rows and columns have even number of 1s");
                 break;
         }
     }
         //if both row and columns have even number of 1s
         if (evenRow == true && evenCol == true){
             System.out.println("All rows and columns have even number of 1s");
         }
     }
}
