package ch23_ex9;

import java.util.Comparator;

/*
Name: Phong Tran
Date: 9/18/22
Project: Chapter 23_Ex9
Description: 
 */
public class Ch23_Ex9 {

    public static void main(String[] args) {
         System.out.print("Random list: ");
        //create random array to test heap sort
        Integer [] array = new Integer[5];
        for (int i = 0;i < array.length;i++){
            array[i] = (int)(Math.floor(Math.random() * 101));
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.print("Sorted list: ");
        //sort array
        heapSort(array);
        for (int i = 0;i < array.length;i++){
            System.out.print(array[i] + " ");
        }
        
    }
    //using comparable interface
    public static <E extends Comparable<E>> void heapSort(E [] list){
        Heap<E> heap = new Heap();
        for (int i = 0;i < list.length;i++){
            heap.add(list[i]);
        }
        for(int i = list.length - 1;i >= 0;i--){
            list[i] = heap.remove();
        }
    }
    //using comparator interface 
     public static <E> void heapSort(E[] list, Comparator<? super E> comparator){
         Heap<E> heap = new Heap<E>(comparator);
         for (int i = 0; i < list.length; i++){
             heap.add(list[i]);
         }
         for (int i = list.length - 1; i >= 0; i--){
             list[i] = heap.remove();
         }
     }
}
