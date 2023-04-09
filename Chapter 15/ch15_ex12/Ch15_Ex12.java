package ch15_ex12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/*
Name: Phong Tran
Date: 8/31/22
Project: Chapter 15_Ex12
Description: This program display a message indicating whether the mouse point is inside or outside the circle
 */
public class Ch15_Ex12 extends Application {  
    @Override
    public void start(Stage primaryStage) {
        //create pane and scene
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 300, 200);
        //create and add circle
        Circle circle = new Circle(100,60,50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);
        // create String for inside,outside,and text
        String inside = "Mouse point is inside the circle";
        String outside = "Mouse point is outside the circle";  
        Text text = new Text();
        //event action when mouse move
        scene.setOnMouseMoved(e ->{
            //when inside circle change text and adjust coordinate to mouse
            if(circle.contains(e.getX(),e.getY())){
                text.setText(inside);
                text.setX(e.getX());
                text.setY(e.getY());
            }
            //when outside circle change text and adjust coordinate to mouse
            else{
                text.setText(outside);
                text.setX(e.getX());
                text.setY(e.getY());
            }
        });
        //add text to pane
        pane.getChildren().addAll(text);
        //display
        primaryStage.setTitle("Ch15_Ex12");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
