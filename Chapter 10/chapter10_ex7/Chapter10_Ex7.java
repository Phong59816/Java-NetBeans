package chapter10_ex7;

/*
Name: Phong Tran
Date: 10/28/21
Project: Chapter 10 Exercise 7
Description: This program simulate an atm machine
*/
import java.util.Scanner;
public class Chapter10_Ex7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //create array of account with balance of 100$
        Account[] accounts = new Account[10];
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i, 100.0);
        }
        //prompt user for ID
        System.out.print("Enter an id: ");
        int ID = input.nextInt();
        //loop if ID is invalid
        while(ID > 9 || ID < 0){
            System.out.print("Invalid ID try again :");
            ID = input.nextInt();
        }
        //loop to keep displaying menu
        while (true){
            //call display menu method
            displayMenu();
            int choice = input.nextInt();
            //loop if choice is invalid
            while(choice > 4 || choice < 1){
            System.out.print("Invalid choice try again :");
            choice = input.nextInt();
            }
            //display balance
            if (choice == 1){
                System.out.println("The account balance is:" + accounts[ID].getBalance());
            }
            //execute deposit method
            if (choice == 2){
                System.out.print("Enter a deposit amount: ");
                double depositAmount = input.nextDouble();
                accounts[ID].deposit(depositAmount);
            }
            //execute withdraw method
            if (choice == 3){
                System.out.print("Enter withdraw amount: ");
                double withdrawAmount = input.nextDouble();
                accounts[ID].withdraw(withdrawAmount);
            }
            //prompt for ID
            if (choice == 4) {
                System.out.print("Enter an id: ");
                ID = input.nextInt();
                while(ID > 9 || ID < 0){
                    System.out.print("Invalid ID try again :");
                    ID = input.nextInt();
                }
            }
            
        }
    }
    //display menu method
    public static void displayMenu(){
        System.out.println("Main Menu");
        System.out.println("1: check balance");
        System.out.println("2: deposit");
        System.out.println("3: withdraw");
        System.out.println("4: exit");
        System.out.print("Enter a choice: ");
    }
}