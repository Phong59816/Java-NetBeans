package ch23_ex15;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
Name: Phong Tran
Date: 9/21/22
Project: Chapter 23_Ex15
Description: This program animate selection sort alsorithm
 */
public class Ch23_Ex15 extends Application {
    
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
