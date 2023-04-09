package ch34_ex5;
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
Date: 10/10/22
Project: Chapter 34_Ex5
Description: This program allow the user to input a table name and it display the table's content
 */
public class Ch34_Ex5 extends Application {
    private PreparedStatement stmt;
    Connection connection;
    TextField tfTable = new TextField();
    TextArea taText = new TextArea();
    DatabaseMetaData dbMetaData;
    @Override
    public void start(Stage primaryStage) {
        //load driver and connect to database
        initializeDB();
        //pane layout settings
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        Label lbSNN = new Label("Table Name");
        ScrollPane textPane = new ScrollPane(taText);
        BorderPane pane = new BorderPane();
        //create button and set action for show grade button
        Button btShowContent = new Button("Show Contents");
        //assign action to button
        btShowContent.setOnAction(e -> showContents());
        box.getChildren().addAll(lbSNN,tfTable,btShowContent);
        //add panes to border panes
        pane.setTop(box);
        pane.setCenter(textPane);
        //display scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Ch34_Ex5");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //display table content
    public void showContents(){
        //reset text area to empty
        taText.setText("");
        //get user input from text field
        String tableName = tfTable.getText();
        try{
            dbMetaData = connection.getMetaData();
            //create query using user input table name
            String query = "select * from " + tableName;
            //execute query
            stmt = connection.prepareStatement(query);
            ResultSet rset = stmt.executeQuery();
            ResultSetMetaData rsMetaData = rset.getMetaData();
            //loop to get table's column name and append to text area
            for(int i = 1;i <= rsMetaData.getColumnCount();i++){
                        String format = String.format("%-12s\t",rsMetaData.getColumnName(i));
                        taText.appendText(format);
                    }
            //add new line
            taText.appendText("\n");
            //check if table contain values
            while(rset.next()){
                //loop to get data from table and append to text area
                for(int i = 1;i <= rsMetaData.getColumnCount();i++){
                    String format = String.format("%-12s\t",rset.getObject(i));
                    taText.appendText(format);
                }
                //add new line after each loop
                taText.appendText("\n");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    //load driver and connect to mysql database
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
