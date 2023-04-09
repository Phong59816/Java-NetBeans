
package chapter11_ex02;

public class Person {
    private String Name;
    private String Address;
    private String phoneNumber;
    private String emailAddress; 
    
    //constructor
    public Person(String Name,String Address,String phoneNumber,String emailAddress){
        this.Name = Name;
        this.Address = Address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }
    
    //to string method
    public String toString(){
        return Name + " is a person";
    }
    
}
