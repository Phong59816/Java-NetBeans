package ch23_ex16;

import java.util.Arrays;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import java.util.Collections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
public class histogram extends BorderPane {
    Integer [] list = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    Pane pane = new Pane();
    HBox hBox = new HBox();
    Button btStep = new Button("Step");
    Button btReset = new Button("Reset");
    int loopIndex = 1;
    int swapIndex = 0;
    //construct histogram
    public histogram(){
        //layout setting
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btStep,btReset);
        hBox.setSpacing(5);
        setBottom(hBox);
        Collections.shuffle(Arrays.asList(list));
        setHeight(300);
        setWidth(420);
        Line line = new Line(0,getHeight(),getWidth(),getHeight());
        pane.getChildren().add(line);
        //assign reset button to clear pane,shuffle array,and redraw graph
        btReset.setOnAction(e->{
            loopIndex = 1;
            swapIndex = 0;
            pane.getChildren().clear();
            Collections.shuffle(Arrays.asList(list));
            drawRec(0);
            pane.getChildren().add(line);
        });
        //assign step button to clear pane,sort array once with bubble sort,and redraw graph
        btStep.setOnAction(e ->{
            if (loopIndex < 20){
                pane.getChildren().clear();
                if(swapIndex < list.length - loopIndex){
                    if (list[swapIndex] > list[swapIndex + 1]){
                        int temp = list[swapIndex];
                        list[swapIndex] = list[swapIndex + 1];
                        list[swapIndex + 1] = temp;
                    }
                }
                swapIndex++;
                if(swapIndex == 20){
                    loopIndex++;
                    swapIndex = 0;
                }
                pane.getChildren().add(line);
                drawRec(swapIndex);
            }
            //when finish sorting display complete
            else{
                Text complete = new Text(150,50,"Sorting complete");
                pane.getChildren().add(complete);
            }
        });
        drawRec(0);
        setCenter(pane);  
    }
    //get count array
    public Integer [] getList(){
        return list;
    }
    //set count
    public void setCount(int index,int value){
        list[index] = value;
    }
    //get value at index
    public int getValue(int index){
        return list[index];
    }
    //draw rectangle with colored rectangle at index
    public void drawRec(int index){
        int width = 20;
        int x = 10;
        int y = 50;
        for (int i = 0;i < list.length;i++){
            if (list[i] == 0){
                x = x + 20;
                continue;
            }
            //color rectangle red at index - 1
            if (i == index){
                Rectangle rec = new Rectangle(x,300 - list[i] * 10,width,list[i] * 10);
                rec.setFill(Color.RED);
                rec.setStroke(Color.BLACK);
                Text value = new Text(rec.getX(),rec.getY(),String.valueOf(getValue(i)));
                pane.getChildren().addAll(rec,value);
            }
            else{
                Rectangle rec = new Rectangle(x,300 - list[i] * 10,width,list[i] * 10);
                rec.setFill(Color.WHITE);
                rec.setStroke(Color.BLACK);
                Text value = new Text(rec.getX(),rec.getY(),String.valueOf(getValue(i)));
                pane.getChildren().addAll(rec,value);
            }
            x = x + 20;
        }
    }
}
