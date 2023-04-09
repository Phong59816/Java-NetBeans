package ch16_ex25;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
public class fieldPane extends HBox {
    //labels and text fields
    private Label car1 = new Label("Car 1: ");
    private Label car2 = new Label("Car 2: ");
    private Label car3 = new Label("Car 3: ");
    private Label car4 = new Label("Car 4: ");
    private static TextField carOne = new TextField("0");
    private static TextField carTwo = new TextField("0");
    private static TextField carThree = new TextField("0");
    private static TextField carFour = new TextField("0");
    //constructor
    fieldPane(){
        setPrefWidth(500);
        carOne.setPrefColumnCount(3);
        carTwo.setPrefColumnCount(3);
        carThree.setPrefColumnCount(3);
        carFour.setPrefColumnCount(3);
        setAlignment(Pos.CENTER);
        setSpacing(5);
        getChildren().add(car1);
        getChildren().add(carOne);
        getChildren().add(car2);
        getChildren().add(carTwo);
        getChildren().add(car3);
        getChildren().add(carThree);
        getChildren().add(car4);
        getChildren().add(carFour);  
    }
    //get values
    public static double getCar1(){
        return Double.parseDouble(carOne.getText());
    }
    public static double getCar2(){
        return Double.parseDouble(carTwo.getText());
    }
    public static double getCar3(){
        return Double.parseDouble(carThree.getText());
    }
    public static double getCar4(){
        return Double.parseDouble(carFour.getText());
    }
}
