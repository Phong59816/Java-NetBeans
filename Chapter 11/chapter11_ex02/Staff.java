
package chapter11_ex02;
public class Staff extends Employee {
    private String title;
    
    //constructor
    public Staff(String title,String Name,String Address,String phoneNumber,String emailAddress,String office,Double salary,MyDate dateHired){
        super(Name,Address,phoneNumber,emailAddress,office,salary,dateHired);
        this.title = title;
    }
    //to string override
    public String toString(){
        return super.toString().replace("an employee","a staff member");
    }
}
