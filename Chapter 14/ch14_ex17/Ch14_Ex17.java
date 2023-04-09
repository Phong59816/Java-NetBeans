package ch14_ex17;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/*
Name: Phong Tran
Date: 8/25/22
Project: Chapter 14 Exercise 17
Description: this program draw a hangman
 */
public class Ch14_Ex17 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(5,5,5,5));
        //Lines pole
        Line pole = new Line(100,420,100,50);
        pole.setStrokeWidth(1);
        pane.getChildren().add(pole);
        Line pole2 = new Line(100,50,310,50);
        pole2.setStrokeWidth(1);
        pane.getChildren().add(pole2);
        Line pole3 = new Line(310,50,310,120);
        pole3.setStrokeWidth(1);
        pane.getChildren().add(pole3);
        //Lines body
        Line body = new Line(310,180,310,270);
        body.setStrokeWidth(1);
        pane.getChildren().add(body);
        Line leg1 = new Line(310,270,250,320);
        leg1.setStrokeWidth(1);
        pane.getChildren().add(leg1);
        Line leg2 = new Line(310,270,370,320);
        leg2.setStrokeWidth(1);
        pane.getChildren().add(leg2);
        Line arm1 = new Line(310,150,220,250);
        arm1.setStrokeWidth(1);
        pane.getChildren().add(arm1);
        Line arm2 = new Line(310,150,400,250);
        arm2.setStrokeWidth(1);
        pane.getChildren().add(arm2);
        //Circle head
        Circle cir = new Circle(310,150,30);
        cir.setStroke(Color.BLACK);
        cir.setFill(Color.WHITE);
        pane.getChildren().add(cir);
        //Arc stand
        Arc arc = new Arc(100,500,100,80,30,120);
        arc.setStroke(Color.BLACK);
        arc.setFill(Color.WHITE);
        pane.getChildren().add(arc);
        //create scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_17");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
