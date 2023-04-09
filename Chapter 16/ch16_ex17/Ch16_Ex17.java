package ch16_ex17;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/*
Name: Phong Tran
Date: 9/9/22
Project: Chapter 16_Ex17
Description: This program display a text and allow user to change color and opacity with sliders
 */
public class Ch16_Ex17 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //make sliders and set value
        Slider redSlide = new Slider();
        Slider greenSlide = new Slider();
        Slider blueSlide = new Slider();
        Slider opaSlide = new Slider();
        redSlide.setValue(0);
        redSlide.setMax(1);
        greenSlide.setValue(0);
        greenSlide.setMax(1);
        blueSlide.setValue(0);
        blueSlide.setMax(1);
        opaSlide.setValue(1);
        opaSlide.setMax(1);
        
        //make labels and set font size
        Label text = new Label("Show Colors");
        text.setFont(new Font(30));
        Label redLab = new Label("Red");
        redLab.setFont(new Font(15));
        Label greenLab = new Label("Green");
        greenLab.setFont(new Font(15));
        Label blueLab = new Label("Blue");
        blueLab.setFont(new Font(15));
        Label opaLab = new Label("Opacity");
        opaLab.setFont(new Font(15));
        
        //make panes and set up layout
        HBox textBox = new HBox(text);
        textBox.setAlignment(Pos.CENTER);
        VBox labels = new VBox(redLab,greenLab,blueLab,opaLab);
        VBox sliders = new VBox(redSlide,greenSlide,blueSlide,opaSlide);
        sliders.setSpacing(10);
        HBox labSlide = new HBox(labels,sliders);
        labSlide.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(textBox,labSlide);
        //red slider
        redSlide.valueProperty().addListener(ov ->{
            Color c = (Color) text.getTextFill();
           text.setTextFill(Color.color(redSlide.getValue(), c.getGreen(), c.getBlue()));
        });
        //green slider
        greenSlide.valueProperty().addListener(ov ->{
            Color c = (Color) text.getTextFill();
           text.setTextFill(Color.color(c.getRed(), greenSlide.getValue(), c.getBlue()));
        });
        //blue slider
        blueSlide.valueProperty().addListener(ov ->{
            Color c = (Color) text.getTextFill();
           text.setTextFill(Color.color(c.getRed(), c.getGreen(), blueSlide.getValue()));
        });
        //opacity slider
        opaSlide.valueProperty().addListener(ov ->{
           text.setOpacity(opaSlide.getValue());
        });
        //display scene
        Scene scene = new Scene(vBox,300,200);
        primaryStage.setTitle("Ch16_Ex17");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
