
package chapter11_ex02;
public class Employee extends Person {
    private String office;
    private Double salary;
    private MyDate dateHired;
    
    //constructor
    public Employee(String Name,String Address,String phoneNumber,String emailAddress,String office,Double salary,MyDate dateHired){
        super(Name,Address,phoneNumber,emailAddress);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }
    //to string override
    public String toString(){
        return super.toString().replace("a person","an employee");
    }
}
