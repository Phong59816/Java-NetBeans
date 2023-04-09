package ch34_ex1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

/*
Name: Phong Tran
Date: 10/4/22
Project: Chapter 34_Ex1
Description: this program allow user to view,inserts,and updates staff information stored in a database
 */
public class Ch34_Ex1 extends Application {
    //create connection and prepare statement
    Connection connection;
    private PreparedStatement stmt;
    //textfields
    TextField tfId = new TextField();
    TextField tfFirst = new TextField();
    TextField tfLast = new TextField();
    TextField tfMi = new TextField();
    TextField tfAddress = new TextField();
    TextField tfCity = new TextField();
    TextField tfState = new TextField();
    TextField tfPhone = new TextField();
    TextField tfEmail = new TextField();
    Label statusLabel = new Label();
    @Override
    public void start(Stage primaryStage) {
        //load driver and connect to database
        initializeDB();
        //pane layout settings
        HBox idBox = new HBox();
        Label idLabel = new Label("ID");
        idBox.getChildren().addAll(idLabel,tfId);
        
        HBox nameBox = new HBox();
        Label lastLabel = new Label("Last Name");
        Label firstLabel = new Label("First Name");
        Label miLabel = new Label("MI");
        tfMi.setPrefColumnCount(2);
        nameBox.getChildren().addAll(lastLabel,tfLast,firstLabel,tfFirst,miLabel,tfMi);
        
        HBox addressBox = new HBox();
        Label addressLabel = new Label("Address");
        addressBox.getChildren().addAll(addressLabel,tfAddress);
        
        HBox cityStateBox = new HBox();
        Label cityLabel = new Label("City");
        Label stateLabel = new Label("State");
        cityStateBox.getChildren().addAll(cityLabel,tfCity,stateLabel,tfState);
        
        HBox phoneBox = new HBox();
        Label phoneLabel = new Label("Telephone");
        phoneBox.getChildren().addAll(phoneLabel,tfPhone);
        
        HBox emailBox = new HBox();
        Label emailLabel = new Label("Email");
        tfEmail.setPrefColumnCount(20);
        emailBox.getChildren().addAll(emailLabel,tfEmail);
        //create buttons
        HBox buttonBox = new HBox();
        Button btView = new Button("View");
        Button btInsert = new Button("Insert");
        Button btUpdate = new Button("Update");
        Button btClear = new Button("Clear");
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(btView,btInsert,btUpdate,btClear);
        //set actions for buttons
        btView.setOnAction(e -> showStaff());
        btClear.setOnAction(e -> clearText());
        btInsert.setOnAction(e-> insertStaff());
        btUpdate.setOnAction(e -> updateStaff());
        //add all hbox to a vbox pane
        VBox pane = new VBox();
        pane.setSpacing(5);
        pane.getChildren().addAll(statusLabel,idBox,nameBox,addressBox,cityStateBox,phoneBox,emailBox,buttonBox);
        //display scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Ch34_Ex1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //load driver and connect to mysql database
    private void initializeDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Driver loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","Password");
            System.out.print("Database Connected");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //update staff
    private void updateStaff(){
        try{
            //create query string with place holders
            String query = "UPDATE Staff SET lastName=?,firstName=?,mi=?,address=?,city=?,state=?,telephone=?,email=? WHERE id=?";
            stmt = connection.prepareStatement(query);
            //get values from textfields into query
            stmt.setString(9, tfId.getText());
            stmt.setString(1, tfLast.getText());
            stmt.setString(2, tfFirst.getText());
            stmt.setString(3, tfMi.getText());
            stmt.setString(4, tfAddress.getText());
            stmt.setString(5, tfCity.getText());
            stmt.setString(6, tfState.getText());
            stmt.setString(7, tfPhone.getText());
            stmt.setString(8, tfEmail.getText());
            //execute query
            stmt.executeUpdate();
            //update status
            statusLabel.setText("Staff updated");
        }
        catch(SQLException e){
            e.printStackTrace();
        }    
    }
    //insert staff
    private void insertStaff(){
        try{
            //create query string with placeholders
            String query = "INSERT INTO Staff values(?,?,?,?,?,?,?,?,?)";
            stmt = connection.prepareStatement(query);
            //get values from textfields into placeholder
            stmt.setString(1, tfId.getText());
            stmt.setString(2, tfLast.getText());
            stmt.setString(3, tfFirst.getText());
            stmt.setString(4, tfMi.getText());
            stmt.setString(5, tfAddress.getText());
            stmt.setString(6, tfCity.getText());
            stmt.setString(7, tfState.getText());
            stmt.setString(8, tfPhone.getText());
            stmt.setString(9, tfEmail.getText());
            //execute query
            stmt.executeUpdate();
            statusLabel.setText("Staff inserted");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    //show staff
    private void showStaff(){
        String id = tfId.getText();
        try{
            statusLabel.setText("");
            //create query string
            String query = "select * from Staff where ID = " + id;
            stmt = connection.prepareStatement(query);
            //read data from table
            ResultSet rset = stmt.executeQuery();
            //if record exist load text into appropriate textfields
            if(rset.next()){
                tfLast.setText(rset.getString(2));
                tfFirst.setText(rset.getString(3));
                tfMi.setText(rset.getString(4));
                tfAddress.setText(rset.getString(5));
                tfCity.setText(rset.getString(6));
                tfState.setText(rset.getString(7));
                tfPhone.setText(rset.getString(8));
                tfEmail.setText(rset.getString(9));
            }
            //display record not found and clear textfields
            else{
                clearText();
                statusLabel.setText("Record not found");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    //clear textfields
    private void clearText(){
        tfId.setText("");
        tfLast.setText("");
        tfFirst.setText("");
        tfMi.setText("");
        tfAddress.setText("");
        tfCity.setText("");
        tfState.setText("");
        tfPhone.setText("");
        tfEmail.setText("");
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}