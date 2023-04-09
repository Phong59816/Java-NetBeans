package chapter.pkg13.exercise.pkg5;

/*
Name: Phong Tran
Date: 8/18/22
Project: Chapter 13 Exercise 5
Description: Use the max method to find the larger of two circles and larger of two rectangle
 */
import java.util.Scanner;
public class Chapter13Exercise5 {

    public static void main(String[] args) {
        //create 2 circle and rectangle
        GeometricObject circle1 = new Circle(5);
        GeometricObject circle2 = new Circle (8);
        
        GeometricObject rec1 = new Rectangle(5,3);
        GeometricObject rec2 = new Rectangle(3,5);
        //use max method to print result
        System.out.println(GeometricObject.max(rec1, rec2));
        System.out.println(GeometricObject.max(circle1,circle2));
        
    }
    
}
