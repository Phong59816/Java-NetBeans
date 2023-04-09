package ch32_ex19;

import java.util.Arrays;
import java.util.Collections;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
This program animate insertion sort, bubble sort, and selection sort of an array
size 50 that run parallel to each other
 */
public class Ch32_Ex19 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox box = new HBox();
        //create list 1 - 50
        Integer[] list = new Integer[50]; 
        for (int i = 0; i < list.length; i++) { 
            list[i] = i + 1;
        }
        //shuffle list and make 3 copy
        Collections.shuffle(Arrays.asList(list));
        Integer [] bubbleList = list.clone();
        Integer [] selectionList = list.clone();
        Integer [] insertionList = list.clone();
        //create panes for each sorting method and add to HBox
        bubbleHistogram bubble = new bubbleHistogram(bubbleList);
        selectionHistogram selection = new selectionHistogram(selectionList);
        insertionHistogram insertion = new insertionHistogram(insertionList);
        box.getChildren().add(selection);
        box.getChildren().add(bubble);
        box.getChildren().add(insertion);
        box.setPrefSize(1600, 350);
        box.setAlignment(Pos.CENTER);
        //create and launch thread
        Thread bubbleThread = new Thread(bubble);
        Thread selectionThread = new Thread(selection);
        Thread insertionThread = new Thread(insertion);
        selectionThread.start();
        bubbleThread.start();
        insertionThread.start();
        //display program
        Scene scene = new Scene(box);
        primaryStage.setTitle("Ch32_Ex19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //create bubble sort pane
    public class bubbleHistogram extends Pane implements Runnable{
        Integer [] list;
        public bubbleHistogram(Integer [] list){
            setPadding(new Insets(5,5,5,5));
            this.list = list;
        }
        //implement runnable and run thread to animate bubble sort
        @Override
        public void run(){
            try{
                int len = list.length;
                for (int i = 0;i < len - 1;i++){
                    final int k = i;
                    Platform.runLater(() -> {
                        for(int j = 1; j < len - k; j++){
                            if(list[j - 1] > list[j]){
                                int temp = list[j-1];
                                list[j - 1] = list[j];
                                list[j] = temp;
                                drawRec(j);
                            }  
                        }
                    });
                    Thread.sleep(500);
                }
            }
            catch(InterruptedException ex){  
            }
        }
        //return value at index
        public int getValue(int index){
            return list[index];
        }
        //draw graph
        public void drawRec(int index){
            getChildren().clear();
            Text name = new Text(250,30,"Bubble Sort");
            getChildren().add(name);
            int width = 10;
            int x = 10;
            for (int i = 0;i < list.length;i++){
                if (list[i] == 0){
                    x = x + 10;
                    continue;
                }
            //color rectangle red at given index
                if (i == index){
                    Rectangle rec = new Rectangle(x,300 - list[i] * 5,width,list[i] * 5);
                    rec.setFill(Color.RED);
                    rec.setStroke(Color.BLACK);
                    getChildren().add(rec);
                }
                //draw white rectangle
                else{
                    Rectangle rec = new Rectangle(x,300 - list[i] * 5,width,list[i] * 5);
                    rec.setFill(Color.WHITE);
                    rec.setStroke(Color.BLACK);
                    getChildren().add(rec);
                }
                x = x + 10;
            }
        }
    }
    //create selection sort pane
    public class selectionHistogram extends Pane implements Runnable{
        Integer [] list;
        public selectionHistogram(Integer [] list){
            setPadding(new Insets(5,5,5,5));
            this.list = list;
        }
        //implement runnable and run thread to animate selection sort
        @Override
        public void run(){
            try{
                int len = list.length;
                for (int i = 0;i <= len - 1;i++){
                    final int k = i;
                    Platform.runLater(() -> {
                        int minIndex = k;
                        for (int j = k + 1;j < len;j++){
                            if(list[j] < list[minIndex]){
                                minIndex = j;
                            }
                        }
                        int temp = list[minIndex];
                        list[minIndex] = list[k];
                        list[k] = temp;
                        drawRec(k + 1);
                    });
                    Thread.sleep(500);
                }
            }
            catch(InterruptedException ex){  
            }
        }
        //return value at index
        public int getValue(int index){
            return list[index];
        }
        //draw graph
        public void drawRec(int index){
            getChildren().clear();
            Text name = new Text(250,30,"Selection Sort");
            getChildren().add(name);
            int width = 10;
            int x = 10;
            int y = 50;
            for (int i = 0;i < list.length;i++){
                if (list[i] == 0){
                    x = x + 10;
                        continue;
                }
            //color rectangle red at index
                if (i == index - 1){
                    Rectangle rec = new Rectangle(x,300 - list[i] * 5,width,list[i] * 5);
                    rec.setFill(Color.RED);
                    rec.setStroke(Color.BLACK);
                    getChildren().add(rec);
                }
                //draw white rectangle
                else{
                    Rectangle rec = new Rectangle(x,300 - list[i] * 5,width,list[i] * 5);
                    rec.setFill(Color.WHITE);
                    rec.setStroke(Color.BLACK);
                    getChildren().add(rec);
                }
                x = x + 10;
            }
        }
    }
    //create pane for insertion sort
    public class insertionHistogram extends Pane implements Runnable{
        Integer [] list;
        int index = 1;
        public insertionHistogram(Integer [] list){
            setPadding(new Insets(5,5,5,5));
            this.list = list;
        }
        //implement runnable and run thread to animate insertion sort
        @Override
        public void run(){
            try{
                int len = list.length;
                for(int i = 1;i < len;i++){
                    final int k = i;
                    Platform.runLater(() -> {
                        int key = list[k];
                        int j  = k - 1;
                        while(j >= 0 && list[j] > key){
                            list[j + 1] = list[j];
                            j = j - 1;
                        }
                        list[j + 1] = key; 
                        drawRec(getIndex(list[j + 1]));
                    });
                    Thread.sleep(500);
                }
            }
            catch(InterruptedException ex){  
            }
        }
        //return value at index
        public int getValue(int index){
            return list[index];
        }
        //return index at given value
        public int getIndex(int value){
            return Arrays.asList(list).indexOf(value);
        }
        //draw graph
        public void drawRec(int index){
            getChildren().clear();
            Text name = new Text(250,30,"Insertion Sort");
            getChildren().add(name);
            int width = 10;
            int x = 10;
            for (int i = 0;i < list.length;i++){
                if (list[i] == 0){
                    x = x + 10;
                        continue;
                }
            //color rectangle red at index
                if (i == index - 1){
                    Rectangle rec = new Rectangle(x,300 - list[i] * 5,width,list[i] * 5);
                    rec.setFill(Color.RED);
                    rec.setStroke(Color.BLACK);
                    getChildren().add(rec);
                }
                //draw white rectangle
                else{
                    Rectangle rec = new Rectangle(x,300 - list[i] * 5,width,list[i] * 5);
                    rec.setFill(Color.WHITE);
                    rec.setStroke(Color.BLACK);
                    getChildren().add(rec);
                }
                x = x + 10;
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}