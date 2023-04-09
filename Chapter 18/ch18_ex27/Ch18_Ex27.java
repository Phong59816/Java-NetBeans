package ch18_ex27;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
Name: Phong Tran
Date: 9/7/22
Project: Chapter18_Ex27
Description: This program display a koch fractal snowflake based on input order
 */
public class Ch18_Ex27 extends Application {
    @Override
    public void start(Stage primaryStage) {
        //create and display snowflake
        snowflake snow = new snowflake();
        Scene scene = new Scene(snow,300,400);
        primaryStage.setTitle("Ch18_Ex19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}