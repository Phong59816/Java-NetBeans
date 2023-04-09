
package ch4_ex12;
//import scanner
import java.util.Scanner;
public class Ch4_Ex12 {


    public static void main(String[] args) {
Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
		String isbn = input.next();
		
		int digit1 = isbn.charAt(0);
                
                System.out.print(digit1);
        
        

    }
    
}
