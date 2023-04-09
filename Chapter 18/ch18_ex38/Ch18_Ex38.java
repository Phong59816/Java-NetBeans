package ch18_ex38;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
Name: Phong Tran
Date: 9/15/22
Project: Chapter 18_Ex38
Description: This program draw a recursive tree base on input order
 */
public class Ch18_Ex38 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //create and display tree pane
        treePane tree = new treePane();
        Scene scene = new Scene(tree,500,350);
        primaryStage.setTitle("Ch18_Ex38");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
