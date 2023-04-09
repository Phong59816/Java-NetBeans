package ch23_ex13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
Name: Phong Tran
Date: 9/20/22
Project: Chapter23_Ex13
Description: This program display the execution time of each type of sorting methods for arrays of increasing input size
*NOTE* EXECUTION TIME IS ROUGHLY 30MIN
 */
public class Ch23_Ex13 extends Application {
    
 @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        //text layout
        Text arrayTxt = new Text(10,10,"Array");
        Text sizeTxt = new Text(10,20,"Size");
        Text selectTxt = new Text(100,10,"Selection Sort");
        Text bubbleTxt = new Text(200,10,"Bubble Sort");
        Text mergeTxt = new Text(300,10,"Merge Sort");
        Text quickTxt = new Text(400,10,"Quick Sort");
        Text heapTxt = new Text(500,10,"Heap Sort");
        Text radixTxt = new Text(600,10,"Radix Sort");
        Text fifty = new Text(10,40,"50,000");
        Text one = new Text(10,60,"100,000");
        Text onefifty = new Text(10,80,"150,000");
        Text two = new Text(10,100,"200,000");
        Text twofifty = new Text(10,120,"250,000");
        Text three = new Text(10,140,"300,000");
        Line xLine = new Line(0,25,700,20);
        Line yLine = new Line(90,0,90,150);
        pane.getChildren().addAll(arrayTxt,sizeTxt,selectTxt,bubbleTxt,mergeTxt,quickTxt,heapTxt,radixTxt,fifty,one,onefifty,two,twofifty,three,xLine,yLine);
        //array of list size
        int [] size = {50000,100000,150000,200000,250000,300000};
        int y = 40;
        //loop to run sort and display execution time
        for(int i = 0;i < size.length;i++){
            int x = 100;
            Integer [] list = createList(size[i]); //create random list base on size
            Text select = new Text(x,y,String.valueOf(selectTime(list)));//get execution time for sort
            x += 100; //increment x coordinate
            //repeat for each type of sorting method
            list = createList(size[i]);
            Text bubble = new Text(x,y,String.valueOf(bubbleTime(list)));
            x += 100;
            list = createList(size[i]);
            Text merge = new Text(x,y,String.valueOf(mergeTime(list)));
            x += 100;
            list = createList(size[i]);
            Text quick = new Text(x,y,String.valueOf(quickTime(list)));
            x += 100;
            list = createList(size[i]);
            Text heap = new Text(x,y,String.valueOf(heapTime(list)));
            x += 100;
            list = createList(size[i]);
            Text radix = new Text(x,y,String.valueOf(radixTime(list)));
            //add execution time to pane
            pane.getChildren().addAll(select,bubble,merge,quick,heap,radix);
            //increment y coordinate
            y += 20;        
    }
        //display scene
        Scene scene = new Scene(pane,700,150);
        primaryStage.setTitle("Ch23_Ex13");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    //perform radix sort and get time
    public long radixTime (Integer [] list){
        long startTime = System.nanoTime();
        radixSort(list);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        return executionTime;
    }
    //perform heap sort and get time
    public long heapTime (Integer [] list){
        long startTime = System.nanoTime();
        heapSort(list);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        return executionTime;
    }
    //perform quicksort and get time
    public long quickTime (Integer [] list){
        long startTime = System.nanoTime();
        quickSort(list);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        return executionTime;
    }
    //perform merge sort and get time
    public long mergeTime (Integer [] list){
        long startTime = System.nanoTime();
        mergeSort(list);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        return executionTime;
    }
    //perform bubble sort and get time
    public long bubbleTime (Integer [] list){
        long startTime = System.nanoTime();
        bubbleSort(list);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        return executionTime;
    }
    //perform selection sort and get time
    public long selectTime (Integer [] list){
        long startTime = System.nanoTime();
        selectionSort(list);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        return executionTime;
    }
    //generate random [] list base on input size
    public static Integer [] createList(int size){
        Integer[] randomList = new Integer[size];
        for(int i = 0;i < size;i++){
            randomList[i] = (int)(Math.random() * (size - 0 + 1) + 0);
        }
        return randomList;
    }
    //heap sort
    public static <E extends Comparable<E>> void heapSort(E [] list){
        Heap<E> heap = new Heap();
        for (int i = 0;i < list.length;i++){
            heap.add(list[i]);
        }
        for(int i = list.length - 1;i >= 0;i--){
            list[i] = heap.remove();
        }
    }
    //bubble sort
    public static <E extends Comparable<E>> void bubbleSort(E[] list){
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) { //compare to
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
     //merge sort
    public static void mergeSort(Integer [] list){
        if(list.length > 1){
            Integer [] firstHalf = new Integer[list.length / 2];
            System.arraycopy(list,0,firstHalf,0,list.length / 2);
            mergeSort(firstHalf);
             
            int secondHalfLength = list.length - list.length / 2;
            Integer [] secondHalf = new Integer[secondHalfLength];
            System.arraycopy(list,list.length / 2,secondHalf,0,secondHalfLength);
            mergeSort(secondHalf);
            merge(firstHalf,secondHalf,list);
        }
    }
    public static void merge(Integer[] list1,Integer[] list2, Integer[] temp){
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;
        while(current1 < list1.length && current2 < list2.length){
            if(list1[current1] < list2[current2]){
                temp[current3++] = list1[current1++];
            }
            else{
                temp[current3++] = list2[current2++];
            }
        }
        while (current1 < list1.length){
            temp[current3++] = list1[current1++];
        }
        while (current2 < list2.length){
            temp[current3++] = list2[current2++];
        }
    }
     //selection sort
    public static void selectionSort(Integer [] list){
        int n = list.length;
        for(int i = 0;i < n - 1;i++){
            int minIndex = i;
            for(int j = i + 1;j < n;j++){
                if(list[j] < list[minIndex]){
                    minIndex = j;
                }
            }
            int temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }
    //quick sort
    public static void quickSort(Integer[] list){
        quickSort(list,0,list.length - 1);
    }
    public static void quickSort(Integer[] list,int first,int last){
        if(last > first){
            int pivotIndex = partition(list,first,last);
            quickSort(list,first,pivotIndex - 1);
            quickSort(list,pivotIndex + 1,last);
        }
    }
    public static int partition(Integer[] list,int first,int last){
        int pivot = list[first];
        int low = first + 1;
        int high = last;
        while(high > low){
            while(low <= high && list[low] <= pivot){
                low++;
            }
            while(low <= high && list[high] > pivot){
                high--;
            }
            if(high > low){
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while(high > first && list[high] >= pivot){
            high--;
        }
        if(pivot > list[high]){
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else{
            return first;
        }
    }
    //radix sort
    public static void countingSort(Integer[] list, int place) {
        int[] output = new int[list.length + 1];
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max)
                max = list[i];
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < max; ++i){
            count[i] = 0;
        }
        for (int i = 0; i < list.length; i++){
            count[(list[i] / place) % 10]++;
        }
        for (int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
        for (int i = list.length - 1; i >= 0; i--) {
            output[count[(list[i] / place) % 10] - 1] = list[i];
            count[(list[i] / place) % 10]--;
        }
        for (int i = 0; i < list.length; i++){
            list[i] = output[i];
        }
    }
    public static int getMax(Integer array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }
    public static void radixSort(Integer [] list) {
        int max = getMax(list, list.length);
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(list, place);
    }
}