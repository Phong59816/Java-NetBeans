
package chapter11_ex08;

/*
Name: Phong Tran
Date: 10/11/21
Project: Chapter 11 Exercise 8
Description: This program simulate a bank account
 */
public class Chapter11_Ex08 {

    public static void main(String[] args) {
        //create account with name,id,and balance
        Account george1122 = new Account("George",1122,1000);
        
        //set interest rate
        george1122.setAnnualInterestRate(1.5);
        
        //print result
        System.out.println("Account Summary");
        System.out.println("Name: " + george1122.getName());
        System.out.println("Balance: " + george1122.getBalance());
        System.out.println("Annual Interest Rate: " + george1122.getAnnualInterestRate() + "\n");
        
        //deposit and withdrawals
        george1122.deposit(30);
        george1122.deposit(40);
        george1122.deposit(50);
        george1122.withdraw(5);
        george1122.withdraw(4);
        george1122.withdraw(2);
        
        //printing transactions
        System.out.println("Transactions \n");
        
        //loop to print all elements of transactions inside transaction array
        for (int i = 0; i < george1122.getTransaction().size(); i++){
            System.out.print(george1122.toString(george1122.getTransaction().get(i)));
        }
    }
    
}
