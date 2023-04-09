package ch34_ex4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.sql.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

/*
Name: Phong Tran
Date: 10/6/22
Project: Chapter34_Ex4
Description: This program read table from a mysql database and display all the grades of a specified student
 */
public class Ch34_Ex4 extends Application {
Connection connection;
    private PreparedStatement stmt;
    Label statusLabel = new Label();
    TextField tfSNN = new TextField();
    TextArea taText = new TextArea();
    @Override
    public void start(Stage primaryStage) {
        //load driver and connect to database
        initializeDB();
        //pane layout setting
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        Label lbSNN = new Label("SNN");
        ScrollPane textPane = new ScrollPane(taText);
        BorderPane pane = new BorderPane();
        //create button and set action for show grade button
        Button btShowGrade = new Button("Show Grade");
        btShowGrade.setOnAction(e -> showGrade());
        box.getChildren().addAll(lbSNN,tfSNN,btShowGrade);
        //add panes to border panes
        pane.setTop(box);
        pane.setCenter(textPane);
        pane.setBottom(statusLabel);
        //display scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise34_04");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //show grade
    public void showGrade(){
        //get ssn from textfield
        String ssn = tfSNN.getText();
        try{
            statusLabel.setText("");
            //create query string
            String query = "select firstName, mi, " +       
                "lastName, title, grade from Student, Enrollment, Course " +
                "where Student.ssn = '" + ssn +
                "' and Enrollment.courseId = Course.courseId " +
                " and Enrollment.ssn = Student.ssn";
            //create statement
            stmt = connection.prepareStatement(query);
            //execute statement
            ResultSet rset = stmt.executeQuery();
            //if courses found
            if(rset.next()){
                //count number of courses
                int counter = 0;
                //loop through table and get student data
                while(rset.next()){
                    String lastName = rset.getString(1);
                    String mi = rset.getString(2);
                    String firstName = rset.getString(3);
                    String title = rset.getString(4);
                    String grade = rset.getString(5);
                    //add data to text area
                    taText.appendText(firstName + " " + mi + " " + lastName + 
                            "'s grade on course " + title + " is " + grade + "\n");
                    //increment course counter
                    counter++;
                }
                //display number of course found
                statusLabel.setText(counter + " courses found");
            }
            //display no courses found
            else{
                statusLabel.setText("No courses found");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    //load driver and connect to database
    private void initializeDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Driver loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","password");
            System.out.print("Database Connected");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}