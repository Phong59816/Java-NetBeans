package ch15_ex9;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/*
Name: Phong Tran
Date: 8/31/22
Project: Chapter 15 Exercise 9
Description: This program draw lines using arrow keys
 */
public class Ch15_Ex9 extends Application {
    //initial line coordinate
    double X = 100; 
    double Y = 100; 
    double X2 = 100; 
    double Y2 = 100; 
    double hX;
    double hY;
    //length of line
    double length = 30;
    
    @Override
    public void start(Stage primaryStage) {
        //create pane for line
        Pane myPane = new Pane();
        Scene scene = new Scene(myPane, 300, 300);
        //create line
        Line line = new Line(X,Y,X2,Y2);
        line.setStrokeWidth(2);
        line.setStroke(Color.BLACK);
        myPane.getChildren().add(line);
        //when a key is pressed
        scene.setOnKeyPressed(e -> {
            //switch case base on arrow key pressed
            switch (e.getCode()) {
                case DOWN:
                    //adjust y and draw new line down from current position
                    hY = Y ;
                    Y += length;
                    Y2 = Y; 
                    Line line2 = new Line(X,hY,X2,Y2); 
                    line2.setStrokeWidth(2);
                    line2.setStroke(Color.BLACK);
                    myPane.getChildren().add(line2);
                    break;
                case UP:
                    //adjust y and draw new line up from current position
                    hY = Y;
                    Y -= length;
                    Y2 = Y;
                    Line line3 = new Line(X,hY,X2,Y2);
                    line3.setStrokeWidth(2);
                    line3.setStroke(Color.BLACK);
                    myPane.getChildren().add(line3);
                    break;
                case LEFT:
                    //adjust x and draw new line left from current position
                    hX = X;
                    X -= length;
                    X2 = X;
                    Line line4 = new Line(hX,Y, X2, Y2);
                    line4.setStrokeWidth(2);
                    line4.setStroke(Color.BLACK);
                    myPane.getChildren().add(line4);
                    break;
                case RIGHT: 
                    //adjust x and draw new line right from current position
                    hX = X;
                    X += length;
                    X2 = X;
                    Line line5 = new Line(hX,Y,X2,Y2);
                    line5.setStrokeWidth(2);
                    line5.setStroke(Color.BLACK);
                    myPane.getChildren().add(line5);
                    line5.getStrokeLineJoin();
                    break;
                default:
                    break;
            }
        }
        );
        //create and display scene
    
    primaryStage.setTitle("Ch15_Ex9");
    primaryStage.setScene(scene);
    primaryStage.show();
}
public static void main(String[] args) {
    launch(args);
}
}

