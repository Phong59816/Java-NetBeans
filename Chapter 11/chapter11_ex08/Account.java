package chapter11_ex08;
import java.util.*;
import java.util.ArrayList;
public class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated = new Date() ;
    private String Name;
    private ArrayList<Transaction>transactions = new ArrayList<>();
    
    //constructor with specified name,id,balance
    public Account(String Name,int id,double balance){
        this.Name = Name;
        this.id = id;
        this.balance = balance;
    }
    public String getName(){
        return Name;
    }
    //no args constructor
    public Account(){
    }
    //constructor with specified id and balance
    public Account(int id,double balance){
        this.id = id;
        this.balance = balance;
    }
    //getter id
    public int GetId(){
        return id;
    }
    //getter balance
    public double getBalance(){
        return balance;
    }
    //getter interest rate
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    //setter id
    public void setId(int id){
        this.id = id;
    }
    //setter balance
    public void setBalance(double balance){
        this.balance = balance;
    }
    //setter annual interest rate
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    //getter date
    public Date getDateCreated(){
        return dateCreated;
    }
    //getter monthly interest rate
    public double getMonthlyInterestRate(){
        return annualInterestRate/ 100 / 12;
    }
    //getter monthly interest
    public double getMonthlyInterest(){
        return balance * (annualInterestRate / 100 / 12);
    }
    //withdraw method
    public void withdraw(double amount){
        balance -= amount;
        Transaction withdrawal = new Transaction(getDateCreated(),'W',-amount,getBalance(),"a withdrawal was made");
        transactions.add(withdrawal);
    }
    //deposit method
    public void deposit(double amount){
        balance += amount;
         Transaction deposit = new Transaction(getDateCreated(),'D',amount,getBalance(),"a deposit was made");
        transactions.add(deposit);
    }
    //getter transactions
    public ArrayList<Transaction> getTransaction(){
        return transactions;
    }
    //override tostring
    public String toString(Transaction transaction){
        return dateCreated + "\n" + "Type: " + transaction.getType() + "\n" + "amount: " + transaction.getAmount() + "\n" + "balance: " + transaction.getBalance() + "\n" + transaction.getDescription() +"\n\n";
    }
}
