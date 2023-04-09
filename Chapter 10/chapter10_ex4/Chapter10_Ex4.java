
package chapter10_ex4;
/*
Name: Phong Tran
Date: 10/26/21
Project: Chapter 10 Exercise 4
Description: This program calculate the distance between 2 points
*/
public class Chapter10_Ex4 {

    public static void main(String[] args) {
        //create point at (0,0)
        MyPoint one = new MyPoint();
        //create point at (10,30.5)
        MyPoint two = new MyPoint(10, 30.5);
        System.out.print("The distance between point (0,0) and point (10,30.5) is: " + MyPoint.distance(one,two));
    }
    
}
