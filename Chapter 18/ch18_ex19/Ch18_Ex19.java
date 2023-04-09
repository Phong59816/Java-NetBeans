
package ch18_ex19;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
/*
Name: Phong Tran
Date: 9/7/22
Project: Chapter18_Ex19
Description: This program create a Sierpinski triangle base on input order
*/

public class Ch18_Ex19 extends Application {
    
    @Override
public void start(Stage primaryStage) {
        SierpinskiTrianglePane pane = new SierpinskiTrianglePane();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        Scene scene = new Scene(borderPane,200,210);
        //increment and decrement on mouse click
        scene.setOnMouseClicked(e->{
            if(e.getButton() == MouseButton.PRIMARY){
                pane.incrementOrder();
            }
            else if(e.getButton() == MouseButton.SECONDARY && pane.getOrder() > 0){
                pane.decrementOrder();
            }
        });
        //increment and decrement based on plus,minus,up,and down key
        scene.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.UP || e.getCode() == KeyCode.ADD){
                pane.incrementOrder();
            }
            else if((e.getCode() == KeyCode.DOWN && pane.getOrder() > 0) || (e.getCode() == KeyCode.SUBTRACT && pane.getOrder() > 0)){
                pane.decrementOrder();
            }
        });
        //display scene
        primaryStage.setTitle("Ch18_Ex19");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov->pane.paint());
    }
    public static void main(String[] args) {
        launch(args);
    }
    //pane for displaying triangle
    static class SierpinskiTrianglePane extends Pane{
        private int order = 0;
        //set order
        public void setOrder(int order){
            this.order = order;
            paint();
        }
        //get order
        public int getOrder(){
            return this.order;
        }
        public void incrementOrder(){
            this.order += 1;
            paint();
        }
        public void decrementOrder(){
            this.order -= 1;
            paint();
        }
        //constructor
        SierpinskiTrianglePane(){
        }
        //paint original triangle base on pane's size
        protected void paint(){
            Point2D p1 = new Point2D(getWidth() / 2,10);
            Point2D p2 = new Point2D(10,getHeight() - 10);
            Point2D p3 = new Point2D(getWidth() - 10,getHeight() - 10);
            this.getChildren().clear();
            displayTriangles(order,p1,p2,p3);
        }
        //recursive display triangle base on mid point from edge of triangle
        private void displayTriangles(int order,Point2D p1,Point2D p2,Point2D p3){
            if (order == 0){
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(p1.getX(),p1.getY(),p2.getX(),p2.getY(),p3.getX(),p3.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(Color.WHITE);
                this.getChildren().add(triangle);
            }
            else{
                //get midpoint on each edge in triangle
                Point2D p4 = p1.midpoint(p2);
                Point2D p5 = p2.midpoint(p3);
                Point2D p6 = p3.midpoint(p1);
                //recursive display triangle
                displayTriangles(order - 1,p1,p4,p6);
                displayTriangles(order - 1,p4, p2,p5);
                displayTriangles(order - 1,p6,p5, p3);
            }
        }
    }
}