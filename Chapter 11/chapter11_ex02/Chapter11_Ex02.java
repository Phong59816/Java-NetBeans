
package chapter11_ex02;
/*
Name: Phong Tran
Date: 11/9/21
Project: Chapter 11 Exercise 2
Description: This program display the properties of the person class and its subclasses(students,employee,faculty,and staff)
*/
public class Chapter11_Ex02 {

    public static void main(String[] args) {
        //create objects
        Person Per1 = new Person("Phong 1","fake addresss","fake phone number","fake email address");
        Student Stu2 = new Student("senior","Phong 2","fake address 2","fake phone number 2","fake email address 2");
        MyDate dateHired = new MyDate(11,9,21);
        Employee Emp3 = new Employee("Phong 3","fake address 3","fake phone number 3","fake email address 3","fake office 3",100.0,dateHired);
        Faculty Fac4 = new Faculty("fake office hour 4","fake rank 4","Phong 4","fake address 4","fake phone number 4","fake email address 4","fake office hour 4",100.0,dateHired);
        Staff Sta5 = new Staff("fake title 5","Phong 5","fake address 5","fake phone number 5","fake email address 5","fake office 5",100.0,dateHired);
        
        //print toString methods
        System.out.println(Per1.toString());
        System.out.println(Stu2.toString());
        System.out.println(Emp3.toString());
        System.out.println(Fac4.toString());
        System.out.println(Sta5.toString());
    }
    
}
