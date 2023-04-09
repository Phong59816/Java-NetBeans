package ch23_ex10;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class heapPane extends BorderPane{
    private Button btInsert = new Button("Insert");
    private Button btRemove = new Button("Remove the root");
    Label label = new Label("Enter a key: ");
    TextField tfKey = new TextField();
    HBox hBox = new HBox();
    Pane pane = new Pane();
   private ArrayList<Integer> heapList = new ArrayList<>();
   //heap pane constructor
    public heapPane(){
        //layout setting
        tfKey.setPrefColumnCount(3);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);
        hBox.getChildren().add(label);
        hBox.getChildren().add(tfKey);
        hBox.getChildren().add(btInsert);
        hBox.getChildren().add(btRemove);
        setBottom(hBox);
        //assign action to insert button
        btInsert.setOnAction(e -> {
            //clear pane,add text field value to list,and draw heap
            pane.getChildren().clear();
            heapList.add(Integer.parseInt(tfKey.getText()));
            tfKey.setText("");
            drawHeap();
        });
        //assign action to remove button
        btRemove.setOnAction(e ->{
            //clear pane,remove root,and draw heap if heap is not empty
           pane.getChildren().clear();
           if(heapList.size() > 0){
               heapList.remove(heapList.size() - 1);
               drawHeap();
           }
           //display heap is empty
           else{
               pane.getChildren().clear();
               Text empty = new Text(getWidth() / 2,getHeight() / 2,"Heap is empty");
               pane.getChildren().add(empty);
           }
        });
        getChildren().add(pane);
    }
    //recursion helper
    public void drawHeap(){
        if(heapList.size() > 0) {
            drawHeap(0,(int) getWidth() / 2, 60, 1); 
        } 
    }
    //recursion to draw heap
    public void drawHeap(int i, int x, int y, int order) {
        //sort heap
        heapSort(heapList);
        //draw heap lines at left child position
        if(2 * i + 1 < heapList.size()) {
            Line line = new Line(x, y, x - (200 / order), y + 50);
            pane.getChildren().add(line);
            drawHeap(2 * i + 1, x - (200 / order), y + 50, order * 2);
        }
        //draw heap lines at right child position
        if(2 * i + 2 < heapList.size()) {
            Line line = new Line(x, y, x + (200 / order), y + 50);
            pane.getChildren().add(line);
            drawHeap(2 * i + 2, x + (200 / order), y + 50, order * 2);
        }
        //draw circle at (x,y)
        Circle cir = new Circle(x, y, 30);
        cir.setFill(Color.WHITE);
        cir.setStroke(Color.BLACK);
        pane.getChildren().add(cir);
        //display value of reversed heap where circle is
        Text value = new Text(x,y,String.valueOf(reverseArrayList(heapList).get(i)));
        pane.getChildren().add(value);
    }
    //heap sort from smallest to largest
    public static <E extends Comparable<E>> void heapSort(ArrayList<Integer> list){
        Heap<Integer> heap = new Heap();
        for (int i = 0;i < list.size();i++){
            heap.add(list.get(i));
        }
        for(int i = list.size() - 1;i >= 0;i--){
            list.set(i,heap.remove());
        }
    }
    //reverse array
     public ArrayList<Integer> reverseArrayList(ArrayList<Integer> alist)
    {
        // Arraylist for storing reversed elements
        ArrayList<Integer> revArrayList = new ArrayList<Integer>();
        for (int i = alist.size() - 1; i >= 0; i--) {
            // Append the elements in reverse order
            revArrayList.add(alist.get(i));
        }
        // Return the reversed arraylist
        return revArrayList;
    }
}
