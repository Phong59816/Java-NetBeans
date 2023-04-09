package ch32_ex11;

/*
Name: Phong Tran
Date: 9/27/22
Project: Chapter 32_Ex11
Description: This program demonstrate a deadlock
 */
public class Ch32_Ex11 {
    //create object to lock on
   public static Object object1 = new Object();
   public static Object object2 = new Object();
   public static void main(String args[]) {
       //create thread
      deadThread dead = new deadThread();
      Thread tDead = new Thread(dead);
      lockThread lock = new lockThread();
      Thread tLock = new Thread(lock);
      //run thread
      tDead.start();
      tLock.start();
   }
   //thread lock on object 1 before object 2
   private static class deadThread implements Runnable {
       @Override
      public void run() {
          //acquire lock on object 1
         synchronized (object1) {
            System.out.println("Thread 1 acquired lock on onject 1");
            try {
                Thread.sleep(5); 
            }
            catch (InterruptedException e){
            }
            //wait for lock on object 2
            System.out.println("Thread 1 waiting for lock on object 2");
            synchronized (object2) {
               System.out.println("Thread 1 has both lock");
            }
         }
      }
   }
   //thread lock on object 2 before object 1
   private static class lockThread implements Runnable {
       @Override
      public void run() {
          //acquire lock for object 2
         synchronized (object2) {
            System.out.println("Thread 2 acquire lock for object 2");
            try {
                Thread.sleep(5); 
            }
            catch (InterruptedException e){
            }
            //waiting for lock on object 1
            System.out.println("Thread 2 waiting for lock on object 1");
            synchronized (object1) {
               System.out.println("Thread 2 has both lock");
            }
         }
      }
   }
}