
package ch3_ex8;

import java.util.Scanner;
public class Ch3_Ex8 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the first interger: ");
        int int1 = input.nextInt();
        
        System.out.print("Enter the second interger: ");
        int int2 = input.nextInt();
        
        System.out.print("Enter the third interger: ");
        int int3 = input.nextInt();
        
        int min;
        int mid;
        int max;
        
        if (int1 > int2){
            if (int1 > int3){
                max = int1;
                if (int2 > int3){
                    mid = int2;
                    min = int3;
                }
            else{
                    mid = int3;
                    min = int2;
                }
            }
            else { 
                mid = int1;
                max = int3;
                min = int2;
            }
        }
        else {
            if (int2 > int3){
                max = int2;
                if (int1 > int3){
                    mid = int1;
                    min = int3;
                }
                
                else {
                    mid = int3;
                    min = int1;
                }
            }
            else {
                 mid = int2;
                 max = int3;
                 min = int1;
                        }
        }
        System.out.print(min + " " + mid + " "+ max);
    }
}
                   
                    
                    
 