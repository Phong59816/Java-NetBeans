package chapter15_ex5;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.geometry.Pos;
    public class fieldPane extends GridPane{
        //create label and textfields
        private Label labAmount = new Label("Investment Amount:");
        private Label labYear = new Label("Number of Years:");
        private Label labRate = new Label("Annual Interest Rate:");
        private Label labValue = new Label("Future Value:");
        private static TextField amount = new TextField();
        private static TextField year = new TextField();
        private static TextField rate = new TextField();
        private static TextField fValue = new TextField();
        //constructor for text field pane
        public fieldPane(){
            setHgap(5);
            setVgap(5);
            //add label and textfield to gridpane
            add(labAmount,0,0);
            add(amount,1,0);
            add(labYear,0,1);
            add(year,1,1);
            add(labRate,0,2);
            add(rate,1,2);
            add(labValue,0,3);
            add(fValue,1,3);
            //set text alignment in text field
            amount.setAlignment(Pos.CENTER_RIGHT);
            year.setAlignment(Pos.CENTER_RIGHT);
            rate.setAlignment(Pos.CENTER_RIGHT);
            fValue.setAlignment(Pos.CENTER_RIGHT);
        }
        //return num1 textfield
        public static Double getAmount(){
            return Double.parseDouble(amount.getText());
        }
        //return num2 textfield
        public static Double getYear(){
            return Double.parseDouble(year.getText());
        }
        //get rate
        public static Double getRate(){
            return Double.parseDouble(rate.getText());
        }
        //set value
        public static void setValue(Double value){
            Locale locale = new Locale("en", "US");      
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            String sValue = currencyFormatter.format(value);
            fValue.setText(sValue);
        }        
    }
