
package ch2_ex11;

import java.util.Scanner;
public class Ch2_Ex11 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of years: ");
        
        double year = input.nextDouble();
        double currentPop = 312_032_486 ;
        double secPerDay = 86_400;
        double population = (currentPop+((secPerDay/7)*(365*year))+((secPerDay/45)*(365*year))-(secPerDay/13)*(365*year));
        
        System.out.println("The population in "+ (int)year + " years is " + (int)population);

    }
    
}
