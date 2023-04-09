package ch23_ex16;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
Name: Phong Tran
Date: 9/22/22
Project: Chapter23_Ex16
Description: This program animate bubble sort algorithm
 */
public class Ch23_Ex16 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //create and display diagram
        histogram histoPane = new histogram();
        Scene scene = new Scene(histoPane);
        primaryStage.setTitle("Ch23_Ex15");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
