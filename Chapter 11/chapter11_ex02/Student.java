
package chapter11_ex02;
public class Student extends Person {
    private static String status;
    
    //constructor
    public Student(String Status,String Name,String Address,String phoneNumber,String emailAddress){
        super(Name,Address,phoneNumber,emailAddress);
        this.status = status;
    }
    
    //to string override
    public String toString(){
        return super.toString().replace("person","student");
    }
    
}
