package ch32_ex2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/*
Name: Phong Tran
Date: 9/26/22
Project: Chapter 32_Ex2
Description: This program is the racing car rewritten using thread to control the car
 */
public class Ch32_Ex2 extends Application {
    //create shape for car
    Circle Fwheel = new Circle(50,45,5);
    Circle Bwheel = new Circle(30,45,5);
    Rectangle rec = new Rectangle(20,30,40,10);
    Line tBorder = new Line(0,0,500,0);
    Polygon polygon = new Polygon();
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        rec.setFill(Color.RED);
        polygon.setFill(Color.BROWN);
        pane.getChildren().add(tBorder);
        //make trapazoid
        polygon.getPoints().addAll(new Double[]{25.0,30.0,55.0,30.0,45.0,20.0,35.0,20.0});
        //make car group and add to pane
        Group carG = new Group(rec,polygon,Fwheel,Bwheel);
        pane.getChildren().addAll(carG);
        //create thread
        new Thread(()->{
            //try and catch interrupted exception
            try{
                //loop to run animation
                while(true){
                    //run thread
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run(){
                            //increment x value of car while inside pane
                            if(carG.getLayoutX() < pane.getWidth()){
                                carG.setLayoutX(carG.getLayoutX() + 1);
                            }
                            //reset x position of car if it is outside pane
                            else{
                                carG.setLayoutX(0);
                            }
                        }
                    });
                    //sleep
                    Thread.sleep(10);
                }
            }
            catch(InterruptedException ex){
            }
        }).start(); //start thread
        //display scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Ch32_Ex2");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}

