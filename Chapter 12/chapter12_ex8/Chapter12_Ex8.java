package chapter12_ex8;

/*
Name: Phong Tran
Date: 11/17/21
Project: Chapter 12 Exercise 8
Description: This program convert user input hex string into decimal numbers
*/
import java.util.Scanner;
public class Chapter12_Ex8 {
    public static void main(String[] args)throws HexFormatException{
        //prompt user for hex
        System.out.print("Enter a hex number: ");
        Scanner input = new Scanner(System.in);
        String hex = input.next();
        //call parseHex method to print hex value
        System.out.print("The value of this hex is: " + parseHex(hex));
        
    }
    //convert hex char to decimal
    public static int convertHexToDec (char ch) throws HexFormatException {
        if (ch == 'A')
            return 10;
        else if (ch == 'B')
            return 11;
        else if (ch == 'C')
            return 12;
        else if (ch == 'D')
            return 13;
        else if (ch == 'E')
            return 14;
        else if (ch == 'F')
            return 13;
        else if(ch <= '9' && ch >= '0')
            return ch - '0';
        else
            throw new HexFormatException("Illegal hex character " + ch);
    }
    //convert entire hex string to decimal
    public static int parseHex(String hexString) throws HexFormatException{
        int value = convertHexToDec(hexString.charAt(0));
        //loop through every char in the entire string
        for (int i = 1;i < hexString.length();i++){
            value = value * 16 + hexString.charAt(i) - '0';
        }
        return value;
    }
    
}
