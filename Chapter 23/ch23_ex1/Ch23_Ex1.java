package ch23_ex1;
import java.util.Comparator;
/*
Name: Phong Tran
Date: 9/16/22
Project: Ch23_Ex1
Description: This program test the bubble sort algorithm using comparable and comparator interface
 */
public class Ch23_Ex1 {
    public static void main(String[] args) {
        System.out.print("Random list: ");
        //create random array to test bubble sort
        Integer [] array = new Integer[5];
        for (int i = 0;i < array.length;i++){
            array[i] = (int)(Math.floor(Math.random() * 101));
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.print("Sorted list: ");
        //sort array
        bubbleSort(array);
        for (int i = 0;i < array.length;i++){
            System.out.print(array[i] + " ");
        }
    }
    //bubble sort using comparable
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
    //bubble sort using comparator
    public static <E> void bubbleSort(E[] list,Comparator<? super E> comparator){
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (comparator.compare(list[i], list[i + 1]) > 0) { //comparator
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
}