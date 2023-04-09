package ch16_ex11;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
/*
Name: Phong Tran
Date: 9/7/22
Project: Chapter16_Ex11
Description: This program read a file name and display a histogram displaying the occurence of each letter. input test.txt in the text field
 */
public class Ch16_Ex11 extends Application {
    fieldPane field = new fieldPane();
    Histogram histo = new Histogram();
    @Override
    public void start(Stage primaryStage){
        //add text field,alpha,and histogram to VBox
        VBox vbox = new VBox();
        vbox.getChildren().add(histo);
        vbox.getChildren().add(field);
        //get file and count characters
        field.setOnKeyPressed(e -> {
         if (e.getCode() == KeyCode.ENTER) {
             try {
                 count();
                 histo.drawRec();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(Ch16_Ex11.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
      });
        
        Scene scene = new Scene(vbox);     
        primaryStage.setTitle("Ch16_Ex11");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //count alphabet in file into array
    public void count() throws FileNotFoundException {
        String fileName = field.getField();
        //read file from user input
        File file = new File(fileName);
        //scanner to scan file
        Scanner scan = new Scanner(file);
        //loop through entire file text
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            //convert all string to lower case
            line = line.toLowerCase();
            //convert string to char array
            char[] characters = line.toCharArray();
            //loop through char array and increment counts for each letters
            for (int i = 0; i< characters.length ; i++) {
                if((characters[i] >= 'a') && (characters[i] <= 'z')) {
                     histo.setCount(characters[i] - 'a',histo.getValue(characters[i] - 'a') + 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
