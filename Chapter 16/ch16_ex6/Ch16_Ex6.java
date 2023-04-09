package ch16_ex6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

/*
Name: Phong Tran
Date: 9/6/22
Project: Chapter 16_Ex6
Description: This program set the horizontal alignment and column size properties of a text field dynamically
 */
public class Ch16_Ex6 extends Application {
    private fieldPane textPane = new fieldPane();
    private columnPane column = new columnPane();
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        //create and add buttons
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
        RadioButton rbRight = new RadioButton("Right");
        //create toggle for buttons
        ToggleGroup group = new ToggleGroup();
        rbLeft.setToggleGroup(group);
        rbRight.setToggleGroup(group);
        rbCenter.setToggleGroup(group);
        rbLeft.setSelected(true);
        //add to pane
        hBox.getChildren().add(rbLeft);
        hBox.getChildren().add(rbCenter);
        hBox.getChildren().add(rbRight);
        hBox.getChildren().add(column);
        //set action for button
        rbRight.setOnAction(e ->{
            if(rbRight.isSelected()){
                textPane.setRight();
            }
        });
        rbLeft.setOnAction(e ->{
            if(rbLeft.isSelected()){
                textPane.setLeft();
            }
        });
        rbCenter.setOnAction(e ->{
            if(rbCenter.isSelected()){
                textPane.setCenter();
            }
        });
         column.setOnKeyPressed(e -> {
         if (e.getCode() == KeyCode.ENTER) {
            textPane.setCol(column.getField());
         }
      });
        //create borderpane and set alignment
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(textPane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox,Pos.CENTER);
        //display scene
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Ch15_Ex4");
        primaryStage.setScene(scene);
        primaryStage.show();    
    }
    public static void main(String[] args) {
        launch(args);
    }  
}
