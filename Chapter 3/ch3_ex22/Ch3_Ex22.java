
package ch3_ex22;

import java.util.Scanner;
public class Ch3_Ex22 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a point with two coordinates: ");
        
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = 0;
        double y2 = 0;
        double distance = Math.pow(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)),0.5);
        
        if (distance <= 10)
            System.out.print("Point ("+ x1 + ", " + y1 + ") is in the circle.");
        else
            System.out.print("Point ("+ x1 + ", " + y1 + ") is not in the circle.");
              
    }
    
}
