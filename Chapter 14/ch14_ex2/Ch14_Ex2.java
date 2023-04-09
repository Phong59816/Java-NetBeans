package ch14_ex2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/*
Name: Phong Tran
Date: 08/24/22
Projct: Chapter 14 Exercise 2
Description: This program display O, X, or nothing in a 3x3 grid pane;
 */
public class Ch14_Ex2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //create pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20,75,20,75));
        pane.setAlignment(Pos.CENTER);
        //load image into array
        Image[] OX = new Image[3];
        OX[1] = new Image("image/o.gif");
        OX[2] = new Image("image/x.gif");
        
        //loop through grid pane
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                //generate random 0-2 and add image to pane
                int random = (int)Math.floor(Math.random() * (3) + 0);
                pane.add(new ImageView(OX[random]),i,j);
                
            }
        }
        //set gap
        pane.setHgap(5);
        pane.setVgap(5);
        //create scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
