package ch16_ex11;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Histogram extends Pane {
    private int [] counts = new int [26];
    private Line line = new Line(0,400,700,400);
    //construct histogram
    public Histogram(){
        setWidth(700);
        setHeight(500);
        getChildren().add(line);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(2);
        setZero(counts);
    }
    //get count array
    public int [] getArray(){
        return counts;
    }
    //set count
    public void setCount(int index,int count){
        counts[index] = count;
    }
    //get value at index
    public int getValue(int index){
        return counts[index];
    }
    //set all value to 0
    public void setZero(int [] counts){
        for (int i = 0;i < counts.length;i++){
            counts[i] = 0;
        }
    }
    //draw rectangle and alphabet
    public void drawRec(){
        char abc = 'A';
        int width = 8;
        int x = 62;
        int y = 50;
        for (int i = 0;i < counts.length;i++){

            if (counts[i] == 0){
                x = x + 20;
                continue;
            }
            Rectangle rec = new Rectangle(x,getHeight() - counts[i] * 50,width,counts[i] * 50);
            rec.setFill(Color.WHITE);
            rec.setStroke(Color.BLACK);
            getChildren().add(rec);
            Label lab = new Label(Character.toString(abc));
            lab.relocate(x, getHeight());
            getChildren().add(lab);
            x = x + 23;
            ++abc;
        }
    }
}
