package chapter9_8;

/*
Name: Phong Tran
Date: 10/20/21
Project: Chapter 9 Exercise 8
Description: This program create a fan class and display all its properties
*/
public class Chapter9_8 {

    public static void main(String[] args) {
        //create new default fan with no args constructor
        Fan fan1 = new Fan();
        //set speed
        fan1.setSpeed(3);
        //set color
        fan1.setColor("yellow");
        //set radius
        fan1.setRadius(10);
        //turn on
        fan1.Switch();
        //print description
        System.out.println(fan1.toString());
        //create new fan using contructor
        Fan fan2 = new Fan(2,false,5,"blue");
        //print descriptions
        System.out.println(fan2.toString());
    }
    
}
