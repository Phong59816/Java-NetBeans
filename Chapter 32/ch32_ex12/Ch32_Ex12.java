package ch32_ex12;

/*
Name: Phong Tran
Date: 9/27/22
Project: Chapter 32_Ex12
Description: This program compre the execution time of how long it take to create
a random list of 9,000,000 elements using fork/join framework vs sequential algorithm
 */
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
public class Ch32_Ex12 {
    public static void main(String[] args) {
        //create list with 9,000,000 elements
        int [] list = new int[9000000];
        //get execution time for creating parallel list and number of processor available
        long startTime = System.currentTimeMillis();
        parallelList(list);
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel time with " + Runtime.getRuntime().availableProcessors() +
                " processor is " + (endTime - startTime) + " milliseconds");
        //get execution time for creating sequential list
        startTime = System.currentTimeMillis();
        randomListSequential(list);
        endTime = System.currentTimeMillis();
        System.out.println("Sequential time is " + (endTime - startTime) + " milliseconds");
    }
    //create random sequential list
    public static void randomListSequential(int [] list){
        Random random = new Random();
        for (int i = 0;i < list.length;i++){
            list[i] = random.nextInt();
        }
    }
    //create fork join task and pool
    public static void parallelList(int [] list){
        RecursiveAction maintask = new createList(list,0,list.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(maintask);
    }
    //main task
    private static class createList extends RecursiveAction{
        private int [] list;
        private int THRESHOLD = 500000;
        private int start;
        int end;
        //main task constructor
        public createList(int[] list,int start,int end){
            this.list = list;
            this.start = start;
            this.end = end;
        }
        @Override
        //perform task
        public void compute(){
            Random random = new Random();
            //generate random value for small list
            if(end - start < THRESHOLD){
                for(int i = start;i < end;i++){
                    list[i] = random.nextInt();
                }
            }
            //break list into smaller half lists if larger than threshold and recursive task
            else{
                int mid = (start + end) / 2;
                invokeAll(new createList (list,start,mid),new createList(list,mid,end));
            }
        }
    }
}
