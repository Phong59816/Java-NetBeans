
package ch16_ex6;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
    public class fieldPane extends HBox{
        //create label and textfields
        private Label label = new Label("Text Field ");
        private static TextField text = new TextField();

        //constructor for text field pane
        public fieldPane(){
            setAlignment(Pos.CENTER);
            setSpacing(10);
            getChildren().add(label);
            getChildren().add(text);
            text.setPrefColumnCount(12);
        }
        //set alignment right
        public static void setRight(){
            text.setAlignment(Pos.CENTER_RIGHT);
        }
        //set alignment center
        public static void setCenter(){
            text.setAlignment(Pos.CENTER);
        }
        //set alignment left
        public static void setLeft(){
            text.setAlignment(Pos.CENTER_LEFT);
        }
        public static void setCol(int value){
            text.setPrefColumnCount(value);
        }
    }
