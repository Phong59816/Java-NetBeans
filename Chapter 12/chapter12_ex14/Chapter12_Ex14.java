
package chapter12_ex14;
/*
Name: Phong Tran
Date: 11/18/21
Project: Chapter 12 Exercise 14
Description: this program read scores from a text file and display their total and average
*/
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class Chapter12_Ex14 {
    public static void main(String[] args) {
        //prompt user for file name
        System.out.print("Enter the file name: ");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        File file = new File(fileName);
        try{
            double total = 0;
            int counter = 0;
            Scanner scan = new Scanner(file);
            //loop through entire length of file to get score total
            while(scan.hasNextDouble()){
                counter++;
                total += scan.nextDouble();
            }
            //calculate average and print result
            double average = total / counter;
            System.out.println("The total score is " + total);
            System.out.println("The average score is " + average);
            
        }
        //catching exception
        catch(FileNotFoundException ex){
            System.out.print("file not found");
        }
        
    }
    
}

