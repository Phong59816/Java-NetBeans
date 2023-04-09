package ch15_ex4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;

/*
Name: Phong Tran
Date: 08/29/22
Project: Chapter 15 Exercise 4
Description: This program is a simple calculator
 */
public class Ch15_Ex4 extends Application {
    private fieldPane CalPane = new fieldPane();
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        //create and add buttons
        Button btAdd = new Button("Add");
        Button btSub = new Button("Subtract");
        Button btMul = new Button("Multiply");
        Button btDiv = new Button("Divide");
        hBox.getChildren().add(btAdd);
        hBox.getChildren().add(btSub);
        hBox.getChildren().add(btMul);
        hBox.getChildren().add(btDiv);
        //create and register handler
        btAdd.setOnAction(new AddHandler());
        btSub.setOnAction(new SubHandler());
        btMul.setOnAction(new MulHandler());
        btDiv.setOnAction(new DivHandler());
        //create borderpane and set alignment
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(CalPane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox,Pos.CENTER);
        //display scene
        Scene scene = new Scene(borderPane,700,80);
        primaryStage.setTitle("Ch15_Ex4");
        primaryStage.setScene(scene);
        primaryStage.show();    
    }
    //handle addition
    public class AddHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            double field1 = fieldPane.getField1();
            double field2 = fieldPane.getField2();
            double result = field1 + field2;
            fieldPane.setResult(result);
        }
    }
    //handle subtraction
    public class SubHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            double field1 = fieldPane.getField1();
            double field2 = fieldPane.getField2();
            double result = field1 - field2;
            fieldPane.setResult(result);           
        }
    }
    //handle multiplication
    public class MulHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            double field1 = fieldPane.getField1();
            double field2 = fieldPane.getField2();
            double result = field1 * field2;
            fieldPane.setResult(result);
        }
    }
    //handle division
    public class DivHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            double field1 = fieldPane.getField1();
            double field2 = fieldPane.getField2();
            double result = field1 / field2;
            fieldPane.setResult(result);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }  
}
