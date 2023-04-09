package ch18_ex18;

/*
Name: Phong Tran
Date: 9/12/22
Project: Ch18_Ex18
Description: This program tell how many moves is needed to move disks from tower A to tower B
 */
import java.util.Scanner;
public class Ch18_Ex18 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = input.nextInt();
        System.out.println("The total number of move is: "+ moveDisks(n,'A','B','C'));
    }
    public static int moveDisks(int n, char fromTower, char toTower, char auxTower){
        //increment count
        count++;
        //end recursive when n == 1
        if(n == 1){
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        }
        //recursively move disks
        else{
            moveDisks(n - 1, fromTower,auxTower,toTower);
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);;
            moveDisks(n - 1,auxTower,toTower,fromTower);
        }
        return count;
    }   
}
