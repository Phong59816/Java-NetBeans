
package chapter10_ex7;
public class Account {
    private double balance;
    //account constructor
    public Account(int ID,double balance){
        this.balance = balance;
    }
    //get balance method
    public double getBalance(){
        return balance;
    }
    //withdraw method
    public void withdraw(double withdrawAmount){
        if(withdrawAmount <= balance){
        balance -= withdrawAmount;
        System.out.println("Withdrawal complete");
        }
        else{
            System.out.println("Insufficient fund");
        }
    }
    //deposit method
    public void deposit(double depositAmount){
        balance += depositAmount;
        System.out.println("Deposit complete");
    }
}
