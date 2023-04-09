package ch15_ex28;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
/*
Name: Phong Tran
Date: 9/2/22
Project: Chapter 15_Ex28
Description: This program display a running fan animation
 */
public class Ch15_Ex28 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //create buttons
        fanPane pane = new fanPane();
        BorderPane bPane = new BorderPane();
        bPane.setCenter(pane);
        pane.hBox.setAlignment(Pos.CENTER);
        pane.hBox.setSpacing(5);
        bPane.setBottom(pane.hBox);
        //display
        Scene scene = new Scene(bPane);
        primaryStage.setTitle("Ch15_Ex28");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }   
}
