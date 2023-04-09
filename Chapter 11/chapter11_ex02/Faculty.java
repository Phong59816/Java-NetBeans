
package chapter11_ex02;

public class Faculty extends Employee {
    private String officeHour;
    private String rank;
    
    //constructor
    public Faculty(String officeHour,String rank,String Name,String Address,String phoneNumber,String emailAddress,String office,Double salary,MyDate dateHired){
        super(Name,Address,phoneNumber,emailAddress,office,salary,dateHired);
        this.rank = rank;
        this.officeHour = officeHour;
    }
    //to string override
    public String toString(){
        return super.toString().replace("an employee","a faculty member");
    }
}
