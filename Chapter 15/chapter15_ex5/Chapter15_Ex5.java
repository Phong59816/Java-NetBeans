package chapter15_ex5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;

/*
Name: Phong Tran
Date: 08/30/22
Project: Chapter 15 Exercise 5
Desciption: This program is an investment-value calculator
 */
public class Chapter15_Ex5 extends Application {
    //create text field pane
    private fieldPane CalPane = new fieldPane();
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();  
        pane.setAlignment(Pos.BOTTOM_RIGHT);
        //create and add button
        Button btCalc = new Button("Calculate");
        pane.getChildren().add(btCalc);
        //register handler
        btCalc.setOnAction(new CalcHandler());
        //create border pane and set alignment for both pane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(CalPane);
        borderPane.setBottom(pane);
        BorderPane.setAlignment(pane,Pos.BOTTOM_RIGHT);
        //display scene
        Scene scene = new Scene(borderPane,270,160);
        primaryStage.setTitle("Ch15_Ex5");
        primaryStage.setScene(scene);
        primaryStage.show();    
    }
    public class CalcHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            //get values
            double amount = fieldPane.getAmount();
            double year = fieldPane.getYear();
            double yRate = fieldPane.getRate() / 100;
            double mRate = yRate / 12;
            //calculate rate
            double fValue = amount * (Math.pow(1 + mRate, year * 12));
            //set value
            fieldPane.setValue(fValue);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
