
package ch23_ex10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
Name: Phong Tran
Date: 9/19/22
Project: Chapter23_Ex10
Description: This program display a heap graphically
 */
public class Ch23_Ex10 extends Application {
    @Override
    public void start(Stage primaryStage) {
        //create and display heap pane
        heapPane heap = new heapPane();
        Scene scene = new Scene(heap,1000,400);
        primaryStage.setTitle("Ch23_Ex10");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}