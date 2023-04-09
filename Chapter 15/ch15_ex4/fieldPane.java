package ch15_ex4;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
    public class fieldPane extends HBox{
        //create label and textfields
        private Label labOne = new Label("Number 1:");
        private Label labTwo = new Label("Number 2:");
        private Label labRes = new Label("Result:");
        private static TextField num1 = new TextField();
        private static TextField num2 = new TextField();
        private static TextField num3 = new TextField();
        //constructor for text field pane
        public fieldPane(){
            setSpacing(10);
            getChildren().add(labOne);
            getChildren().add(num1);
            getChildren().add(labTwo);
            getChildren().add(num2);
            getChildren().add(labRes);
            getChildren().add(num3);   
        }
        //return num1 textfield
        public static Double getField1(){
            return Double.parseDouble(num1.getText());
        }
        //return num2 textfield
        public static Double getField2(){
            return Double.parseDouble(num2.getText());
        }
        //set result
        public static void setResult(Double result){
            num3.setText(String.valueOf(result));
        }        
    }
