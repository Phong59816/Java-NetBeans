
package chapter12_ex30;

/*
Name: Phong Tran
Date: 11/28/21
Project: Chapter 12 Exercise 30
Description: This program count the number of letters in a text file
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Chapter12_Ex30 {
    public static void main(String[] args)throws FileNotFoundException {
        //prompt user for file name
        System.out.print("Enter a file name: ");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        //counter array for each letter
        int[] count = new int[26];
        //read file from user input
        File file = new File(fileName);
        //scanner to scan file
        Scanner scan = new Scanner(file);
        //loop through entire file text
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            //convert all string to lower case
            line = line.toLowerCase();
            //convert string to char array
            char[] characters = line.toCharArray();
            //loop through char array and increment counts for each letters
            for (int i = 0; i< characters.length ; i++) {
                if((characters[i] >= 'a') && (characters[i] <= 'z')) {
                     count[characters[i] -'a' ]++;
                }
            }
        }
        //print result
        for (int i = 0; i < 26; i++) {
            System.out.print("Number of " + (char) (i + 'a'));
            System.out.println(": " + count[i]);
        }
    }
}