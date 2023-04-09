package ch16_ex6;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
    public class columnPane extends HBox{
        //create label and textfields
        private Label label = new Label("Column Size ");
        private static TextField text = new TextField("12");

        //constructor for text field pane
        public columnPane(){
            setAlignment(Pos.CENTER);
            setSpacing(10);
            getChildren().add(label);
            getChildren().add(text);
            text.setPrefColumnCount(2);
            text.setAlignment(Pos.CENTER_RIGHT);
        }
        //return num1 textfield
        public static int getField(){
            return Integer.parseInt(text.getText());
        }  
    }