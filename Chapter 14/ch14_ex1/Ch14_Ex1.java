package ch14_ex1;

/*
Name: Phong Tran
Date: 08/22/22
Project: Chapter 14 Exercise 1
Description: This program display four images in a grid pane
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class Ch14_Ex1 extends Application {
    @Override
    public void start(Stage primaryStage){
        //create pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5,5,5,5));
        //load image
        Image us = new Image("image/us.gif");
        Image france = new Image("image/fr.gif");
        Image germany = new Image("image/germany.gif");
        Image china = new Image("image/china.gif");
        //position image
        pane.add(new ImageView(germany),0,0);
        pane.add(new ImageView(china),0,1);
        pane.add(new ImageView(france),1,0);
        pane.add(new ImageView(us),1,1);
        //set gap
        pane.setHgap(1);
        pane.setVgap(1);
        //create scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
