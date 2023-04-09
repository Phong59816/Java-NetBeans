
package chapter10_ex10;
public class Queue {
    private int[] elements;
    private int size;
    //Queue constructor with default capacity of 8
    public Queue(){
        elements = new int[8];
    }
    //add element into queue
    public void enqueue(int v){
        //add element into queue
        elements[size++] = v;
        
        //double size if capacity exceed size
        if (size >= elements.length) {
            int[] temp = new int[size * 2];
            //transfer elements from elements[] to temp[]
            System.arraycopy(elements, 0, temp, 0, size);
            //give elements[] temp[]'s values
            elements = temp;
        }
    }
    //remove and return element from queue
    public int dequeue(){
        int removed = elements[0];
        //decrease size
        size--;
        //move elements one position to the left
        for (int i = 0; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        //return removed element
        return removed;
    } 
    //check if queue is empty
     public boolean empty() {
        return size == 0;
     }
     //get queue's size
     public int getSize(){
         return size;
     }
    
}
