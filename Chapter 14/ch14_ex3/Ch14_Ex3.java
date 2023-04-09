package ch14_ex3;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import static javafx.application.Application.launch;
/*
Name: Phong Tran
Date: 08/24/22
Project: Chapter 14 Exercise 3
Description: This program display 3 random card from a deck
 */
public class Ch14_Ex3 extends Application {
    @Override
    public void start(Stage primaryStage) {
        //create pane
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5,5,5,5));
        //create array
        int [] deck = new int[52];
        for(int i = 0;i < 52;i++){
            deck[i] = i + 1;
        }
        //shuffle
        shuffleArray(deck);
        //load image
        Image card1 = new Image("card/" + deck[0] + ".png");
        pane.getChildren().add(new ImageView(card1));
        Image card2 = new Image("card/" + deck[1] + ".png");
        pane.getChildren().add(new ImageView(card2));
        Image card3 = new Image("card/" + deck[2] + ".png");
        pane.getChildren().add(new ImageView(card3));
        
        //create scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Chapter14_Ex3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    //shuffle method
    public static void shuffleArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }    
    }
}
