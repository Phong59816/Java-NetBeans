package ch16_ex11;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
    public class fieldPane extends HBox{
        //create label and textfields
        private Label label = new Label("File Name: ");
        private static TextField text = new TextField();

        //constructor for text field pane
        public fieldPane(){
            setAlignment(Pos.CENTER);
            setSpacing(10);
            getChildren().add(label);
            getChildren().add(text);
            text.setPrefColumnCount(12);
        }
        //getText
        public static String getField(){
            return text.getText();
        }
    }
