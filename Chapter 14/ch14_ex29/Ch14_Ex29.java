package ch14_ex29;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/*
Name: Phong Tran
Date: 8/25/22
Project: Chapter 14 Exercise 29
Description: this display a bean machine
 */
public class Ch14_Ex29 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(5,5,100,100));
        int x = 200;
        int y = 100;
        int startX = 200;
        //create pyramid
        for(int row = 0;row < 7;row++){
            for (int col = 0;col <= row;col++){
                Circle(pane,x,y);
                x = x + 20;
                if(row == 6){
                    Line(pane,x - 20,y + 5,x - 20,y + 30);
                }
            }
            y = y + 20;
            startX = startX - 10;
            x = startX;
        }
        //wall
        Line(pane,x - 10,y - 20,x - 10,y + 10);
        Line(pane,x + 150,y - 20,x + 150,y + 10);
        Line(pane,x - 10,y + 10,x + 150,y + 10);
        Line(pane,x - 10,y - 20,190,90);
        Line(pane,x + 150,y - 20,210,90);
        Line(pane,190,90,190,70);
        Line(pane,210,90,210,70);
        
        
        //create scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_29");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public static void Circle(Pane pane,int x,int y){
        Circle cir = new Circle(x,y,5);
        cir.setFill(Color.GREEN);
        pane.getChildren().add(cir);
    }
    public static void Line(Pane pane,int x,int y,int x2,int y2){
        Line line = new Line(x,y,x2,y2);
        line.setStroke(Color.BLACK);
        pane.getChildren().add(line);
    }
    
}