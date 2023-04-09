
package chapter9_6;

/*
Name:Phong Tran
Date: 10/20/21
Project: Chapter 9 Exercise 6
Description: This program create a stopwatch and use it to measure the execution time of sorting 100,000 numbers using selection sort
*/
public class Chapter9_6 {

    public static void main(String[] args) {
        //create array of 100,000 random numbers
        int [] random = new int[100000];
        for (int i = 0;i < random.length;i++){
            random[i] = (int) (Math.random()*100000);
        }
        //create stopwatch
        StopWatch stopWatch = new StopWatch();
        //let user know sorting is in progress
        System.out.println("Sorting...");
        //run stopwatch
        stopWatch.start();
        //begin sorting random array
        selectionSort(random);
        //end stopwatch
        stopWatch.stop();
        //print result
        System.out.println("The execution time of sorting 100,000 numbers is " + stopWatch.getElapsedTime()+ " milliseconds" );
    }
    //selection sort method
    public static void selectionSort(int[]a){
        //loop through entire array
        for (int i = 0; i < a.length - 1; i++) {
            int currentMin = a[i];
            int currentIndex = i;
            //find current min and its index
            for (int j = i + 1; j < a.length; j++) {
                if (currentMin > a[j]) {
                    currentMin = a[j];
                    currentIndex = j;
                }
            }
            //place current min at correct index
            if (currentIndex != i) {
                a[currentIndex] = a[i];
                a[i] = currentMin;
            }
        }
    }
}

