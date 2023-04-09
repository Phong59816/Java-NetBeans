
package chapter5_ex19;
/*
Name: Phong Tran
Date: 09/16/21
Project: Chapter 5 exercise 19
Description: This program will displays a number pyramid with the number become
2x larger as it get closer to the center
*/
public class Chapter5_Ex19 {

    public static void main(String[] args) {
        int n = 8; //number of lines
        // outer loop
        for (int i = 1; i <= n; i++) {
            // space to shape the pyramid
            for (int j = 1; j <= (n - i); j++) {
                System.out.print("    ");
            }
            // Printing number increamentally and adding appropriate amount of space
            for (int j = 0; j < i; j++) {
                if (j <= 4)
                    System.out.print("   " +(int) Math.pow(2, j));
                else if (j <= 6)
                    System.out.print("  " +(int) Math.pow(2, j));
                else if (j == 7)
                    System.out.print(" " +(int) Math.pow(2, j));
                    
            }
            // Printing number decreamentally and adding appropriate amount of space
            for (int j = i - 2; j >= 0; j--) {
                if (j <= 2)
                    System.out.print("   " + (int)Math.pow(2, j));
                else if (j <= 7)
                    System.out.print("  " + (int)Math.pow(2, j));
                }
            System.out.println();
        }
    }
}