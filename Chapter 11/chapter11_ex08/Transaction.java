
package chapter11_ex08;
import java.util.*;
public class Transaction {
  private java.util.Date dateCreated;
  private char type;
  private double  amount;
  private double balance;
  private String description;
  
  //constructor with specified date,type,amount,balance,and description
  public Transaction(Date dateCreated,char type,double amount,double balance,String description){
      this.dateCreated = dateCreated;
      this.type = type;
      this.amount = amount;
      this.balance = balance;
      this.description = description;   
  }
  //getter date
  public Date getDateCreated(){
      return dateCreated;
  }
  //getter type
  public char getType(){
      return type;
  }
  //setter type
  public void setType(){
      this.type = type;
  }
  //getter amount
  public double getAmount(){
      return amount;
  }
  //setter amount
  public void setAmount(double amount){
      this.amount = amount;
  }
  //getter balance
  public double getBalance(){
      return balance;
  }
  //setter balance
  public void setBalance(double balance){
      this.balance = balance;
  }
  //getter description
  public String getDescription(){
      return description;
  }
  //setter description
  public void setDescription(String description){
      this.description = description;
  }
}
