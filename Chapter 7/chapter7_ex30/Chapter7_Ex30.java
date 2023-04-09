
package chapter7_ex30;

/*
Name: Phong Tran
Date : 10/03/21
Project: Programming project Exercise 7.30
Description: This program check if a series contain 4 consecutive number with
the same value
*/
import java.util.Scanner;
public class Chapter7_Ex30 {

    public static void main(String[] args) {
        //create Scanner and prompt user for array size
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of values: ");
        int size = input.nextInt();
        //create array with given size
        int []values = new int [size];
        //prompt user to enter the values
        System.out.print("Enter the values: ");
        //placing numbers from input into array
        for (int i = 0;i < size;i++){
            values[i] = input.nextInt();
        }
        //invoke isConsecutiveFour method and print result
        if (isConsectutiveFour(values)){
            System.out.print("The list has consecutive fours ");
        }
        else{
            System.out.print("The list has no consecutive fours");
        }
        
    }
    public static boolean isConsectutiveFour(int[] values){
        //counter for consecutive
        int counter = 0;
        //check next adjacent value for consecutive and incrementing count
        for (int i = 0; i < values.length - 1 ; i++){
            for (int j = i + 1; j < values.length; j++){
                if (values[i] == values[j]){
                    counter++;
                    //break from loop if there's enough consecutive
                    if (counter == 3){
                    break;
                    }
                    }
                //reset counter if not consecutive
                else{
                    counter = 0;
                }
                //break from loop to only compare the adjacent number
                break;
                
            }
            //break from outer loop when there's enough consecutive
            if (counter == 3){
                        break;
        }
        }
        //return result
        if (counter == 3){
        return true;
        }
        else{
        return false;
        }
    }
}
