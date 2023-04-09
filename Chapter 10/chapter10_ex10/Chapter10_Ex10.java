
package chapter10_ex10;
/*
Name: Phong Tran
Date: 11/1/21
Project Chapter 10 Exercise 10
Description: This program store,add,remove,and display integers in a queue
*/
public class Chapter10_Ex10 {

    public static void main(String[] args) {
         Queue queue = new Queue();
        // add numbers from 1 - 20 into queue
        for (int i = 1; i < 21; i++) {
            queue.enqueue(i);
        }
        // dequeue and display dequeue numbers
        for (int i = 0; i < 20; i++) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
