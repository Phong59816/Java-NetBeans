package ch32_ex4;

import java.util.concurrent.*;

/*
Name: Phong Tran
Date: 9/26/22
Project: Chapter 32_Ex
Description: This program launch 1000 threads that add 1 to sum with and without synchronization
 */
public class Ch32_Ex4 {
    private static Sum sum = new Sum();
    public static void main(String[] args) {
        //create fixed thread pool with maximum 1000 threads
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        ExecutorService executorSync = Executors.newFixedThreadPool(1000);
        //create and launch 1000 threads
        for(int i = 0;i < 1000;i++){
            executor.execute(new plusOne());
        }
        executor.shutdown();
        //wait till all tasks are finished
        while(!executor.isTerminated()){ 
        }
        //print sum without synchronized
        System.out.println("Sum without synchronization is " + sum.getSum());
        //reset sum value to 0
        sum.reset();
        //launch 1000 threads using synchronized
        for(int i = 0;i < 1000;i++){
            executorSync.execute(new plusOneSync());
        }
        executorSync.shutdown();
        //wait till all tasks are finished
        while(!executorSync.isTerminated()){
        }
        //print result of synchronized task
        System.out.println("Sum with synchronization is " + sum.getSum());
    }
    //thread for increment sum value
    private static class plusOne implements Runnable{
        @Override
        public void run(){
            sum.increment();
        }
    }
    //thread for synchronized increment sum value
    private static class plusOneSync implements Runnable{
        @Override
        public void run(){
            sum.syncIncrement();
        }
    }
    //inner class for sum
    private static class Sum{
        private int value = 0;
        //return sum
        public int getSum(){
            return value;
        }
        //increment sum
        public void increment(){
            int newSum = value + 1;
            try{
                Thread.sleep(5);
            }
            catch(InterruptedException ex){
            }
            value = newSum;
        }
        //reset sum to 0
        public void reset(){
            value = 0;
        }
        //synchronized increment sum
         public synchronized void syncIncrement(){
            int newSum = value + 1;
            try{
                Thread.sleep(5);
            }
            catch(InterruptedException ex){
            }
            value = newSum;
        }
    }
}
