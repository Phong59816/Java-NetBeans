
package ch4_ex15;
//import scanner
import java.util.Scanner;
public class Ch4_Ex15 {

    public static void main(String[] args) {
        //prompt the user to enter a letter
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        
        //read string input from scanner
        String letter = input.nextLine();
        
        //convert and print out corresponding number
        switch (letter){
            case "a":
            case "b":
            case "c":
            case "A":
            case "B":
            case "C":
                System.out.print("The corresponding number is 2");
                break;
            case "d":
            case "e":
            case "f":
            case "D":
            case "E":
            case "F":
                System.out.print("The corresponding number is 3");
                break;
            case "g":
            case "h":
            case "i":
            case "G":
            case "H":
            case "I":
                System.out.print("The corresponding number is 4");
                break;
            case "j":
            case "k":
            case "l":
            case "J":
            case "K":
            case "L":
                System.out.print("The corresponding number is 5");
                break;
            case "m":
            case "n":
            case "o":
            case "M":
            case "N":
            case "O":
                System.out.print("The corresponding number is 6");
                break;
            case "p":
            case "q":
            case "r":
            case "s":
            case "P":
            case "Q":
            case "R":
            case "S":
                System.out.print("The corresponding number is 7");
                break;
            case "t":
            case "u":
            case "v":
            case "T":
            case "U":
            case "V":
                System.out.print("The corresponding number is 8");
                break;
            case "w":
            case "x":
            case "y":
            case "z":
            case "W":
            case "X":
            case "Y":
            case "Z":
                System.out.print("The corresponding number is 9");
                break;
                //print invalid when wrong value is input
            default:
                System.out.print(letter + " is an invalid input");
            
        }

    }
    
}
