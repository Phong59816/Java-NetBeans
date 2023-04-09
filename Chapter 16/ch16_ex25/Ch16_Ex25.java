
package ch16_ex25;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
/*
Name: Phong Tran
Date: 9/9/22
Project: Chapter 16_Ex25
Description: This program allow you to set the speed of racing car
 */
public class Ch16_Ex25 extends Application {
    fieldPane field = new fieldPane();
    carPane car1 = new carPane();
    carPane car2 = new carPane();
    carPane car3 = new carPane();
    carPane car4 = new carPane();
    @Override
    public void start(Stage primaryStage) {
        VBox box = new VBox();
        //add field and car panes to VBox
        box.getChildren().add(field);
        box.getChildren().add(car1);
        box.getChildren().add(car2);
        box.getChildren().add(car3);
        box.getChildren().add(car4);
        //get speed from text field and run car
        field.setOnKeyPressed(e -> {
           car1.setRate(field.getCar1()/100);
           car2.setRate(field.getCar2()/100);
           car3.setRate(field.getCar3()/100);
           car4.setRate(field.getCar4()/100);
        });
        //display scene
        Scene scene = new Scene(box);
        primaryStage.setTitle("Ch16_Ex25");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
