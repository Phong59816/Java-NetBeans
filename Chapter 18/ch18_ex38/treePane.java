package ch18_ex38;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
public class treePane extends BorderPane{
    TextField orderField = new TextField();
    Label lbOrder = new Label("Enter an order: ");
    int order;
    double size = 70;
    Pane pane = new Pane();
    //constructor tree pane
    public treePane(){
        //draw tree at 0 order
        drawTree();
        //layout setting
        orderField.setText("0");
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(lbOrder);
        hBox.getChildren().add(orderField);
        setBottom(hBox);
        setCenter(pane);
        //set order and draw on enter key
        orderField.setOnKeyPressed(e ->{
             if(e.getCode() == KeyCode.ENTER){
                 order = Integer.parseInt(orderField.getText());
                 setOrder(order);
             }
             //clear previous tree and draw new
             pane.getChildren().clear();
             drawTree();
        });
    }
    //recursion helper
    public void drawTree(){
        drawTree(order,250,300,-90,size);
    }
    //recursion to draw tree
    public void drawTree(int order,double x, double y,double angle,double size){
        //draw trunk and end when at order 0
        if (order <= 0){
            double x2 = x + Math.cos(Math.toRadians(angle)) * size;
            double y2 = y + Math.sin(Math.toRadians(angle)) * size;
            Line line = new Line(x,y,x2,y2);
            pane.getChildren().add(line);
            return;
        }
        //calculate (x,y) coordinate of branch
        else{
            double x2 = x + Math.cos(Math.toRadians(angle)) * size;
            double y2 = y + Math.sin(Math.toRadians(angle)) * size;
            Line line = new Line(x,y,x2,y2);
            pane.getChildren().add(line);
            drawTree(order - 1,x2,y2,angle - 30,size / 1.5);
            drawTree(order - 1,x2,y2,angle + 30,size / 1.5);
        }
    }
    //set order
    public void setOrder(int order){
        this.order = order;
    }
}
