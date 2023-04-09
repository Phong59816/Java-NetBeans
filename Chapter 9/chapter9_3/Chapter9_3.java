
package chapter9_3;

/*
Name: Phong Tran
Date: 10/20/21
Project: Chapter 9 Exercise 3
Description: This program display the date and time after the given elapse time since Jan,1 1970
*/
public class Chapter9_3 {

    public static void main(String[] args) {
        //create date object from library
        java.util.Date date = new java.util.Date();
        //set elapse time
        date.setTime(10000);
        //print date after elapse time
        System.out.println(date.toString());
         //set elapse time
        date.setTime(100000);
        //print date after elapse time
        System.out.println(date.toString());
         //set elapse time
        date.setTime(1000000);
        //print date after elapse time
        System.out.println(date.toString());
         //set elapse time
        date.setTime(10000000);
        //print date after elapse time
        System.out.println(date.toString());
         //set elapse time
        date.setTime(100000000);
        //print date after elapse time
        System.out.println(date.toString());
         //set elapse time
        date.setTime(1000000000);
        //print date after elapse time
        System.out.println(date.toString());
         //set elapse time
        date.setTime(10000000000l);
        //print date after elapse time
        System.out.println(date.toString());
                 //set elapse time
        date.setTime(100000000000l);
        //print date after elapse time
        System.out.println(date.toString());
    }
    
}
