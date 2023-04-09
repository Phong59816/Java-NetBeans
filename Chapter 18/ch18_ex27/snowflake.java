package ch18_ex27;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
 class snowflake extends BorderPane {
     private int order;
     TextField orderField = new TextField();
     Label label = new Label("Enter an order: ");
     Pane pane = new Pane();
     //constructor
     snowflake(){
         orderField.setText("0");
         //get field input on enter
         orderField.setOnKeyPressed(e ->{
             if(e.getCode() == KeyCode.ENTER){
                 order = Integer.parseInt(orderField.getText());
                 setOrder(order);
                 //prevent order from going below 0
             }
             //clear previous flake and draw new one
             pane.getChildren().clear();
             draw();
         });
         setCenter(pane);
         HBox hBox = new HBox(label,orderField);
         hBox.setAlignment(Pos.CENTER);
         setBottom(hBox);
         //draw order 0 shape at start
         draw();
     }
        //set order
        public void setOrder(int order){
            this.order = order;
            draw();
        }
        //draw base triangle
        public void draw(){
            drawFlake(order,20,280,280,280);
            drawFlake(order,280,280,150,20);
            drawFlake(order,150,20,20,280);
        }
        //recursion to draw flake
        public void drawFlake(int order,double x1,double y1,double x5,double y5){
            double delX,delY,x2,y2,x3,y3,x4,y4;
            //draw triangle at order 0
            if(order <= 0){
                Line line = new Line(x1,y1,x5,y5);
                pane.getChildren().add(line);
            }
            else{
                //calculate point for new vertices
                delX = x5 - x1;
                delY = y5 - y1;
                x2 = x1 + delX / 3;
	    	y2 = y1 + delY / 3;
	    	x3 = (int) (0.5 * (x1 + x5) + Math.sqrt(3) * (y1 - y5) / 6);
	    	y3 = (int) (0.5 * (y1 + y5) + Math.sqrt(3) * (x5 - x1) / 6);
                x4 = x1 + 2 * delX /3;
	    	y4 = y1 + 2 * delY /3;
	    	drawFlake (order - 1, x1, y1, x2, y2);
	    	drawFlake (order - 1, x2, y2, x3, y3);
	    	drawFlake (order - 1, x3, y3, x4, y4);
	    	drawFlake (order - 1, x4, y4, x5, y5);
            }
            
        }
}
