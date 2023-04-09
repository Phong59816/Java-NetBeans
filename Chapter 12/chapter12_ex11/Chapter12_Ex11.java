
package chapter12_ex11;

/*
Name: Phong Tran
Date: 11/18/21
Project: Chapter 12 Exercise 11
Description: this program remove all occurences of a specified string from a text file
*/
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class Chapter12_Ex11 {
    public static void main(String[] args){
        //prompt user for string to be remove
        System.out.print("Enter the string to be removed: ");
        Scanner input = new Scanner(System.in);
        String remove = input.next();
        
        try{
            //read file from command
            File fileName = new File(args[0]);
        
            //scanner to scan file
            Scanner scan = new Scanner(fileName);
            //add text from file to ArrayList
            ArrayList<String> fileString = new ArrayList<>();
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                fileString.add(line);
            }
            //creat printWriter
            PrintWriter writer = new PrintWriter(fileName);
            //loop through text lines and replace removed word with empty string
            for (int i = 0;i < fileString.size();i++){
                String line = fileString.get(i);
                //cheeck for word to be remove
                if(line.contains(remove)){
                    String temp = remove + " ";
                    line = line.replaceAll(temp, "");
                    temp = " " + remove;
                    line = line.replaceAll(temp, "");
                }
                //printing result to file
                writer.print(line);
                writer.println();
            }
            //closing writer and scanner
            writer.close();
            scan.close();

        }
        
        //catching file not found exception
        catch(FileNotFoundException ex){
            System.out.println("File not found");
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("No argument from command line");
        }
    }
    
}
