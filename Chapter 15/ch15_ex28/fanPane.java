package ch15_ex28;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class fanPane extends Pane {
    private Circle cir;
    private Arc[] fan = new Arc[4];
    private int radius = 120;
    private int width = 300;
    private int height = 300;
    private int bladeRad = 100;
    private int increment = 1;
    //buttons
    Button btPause = new Button("Pause");
    Button btResume = new Button("Resume");
    Button btReverse = new Button("Reverse");
    HBox hBox = new HBox(btPause,btResume,btReverse);
    Timeline spinTime;
    
    fanPane(){
        //pane size
        setMinWidth(width);
        setMinHeight(height);
        //create circle
        cir = new Circle(width / 2,height / 2,radius);
        cir.setFill(Color.WHITE);
        cir.setStroke(Color.BLACK);
        //create blade
        for(int i = 0;i < fan.length;i++ ){
            fan[i] = new Arc(cir.getCenterX(), cir.getCenterY(),bladeRad, bladeRad,(i * 90) + 30, 35);
            fan[i].setFill(Color.RED);
            fan[i].setType(ArcType.ROUND);
        }
        getChildren().addAll(cir);
        getChildren().addAll(fan);
        //run animation
        KeyFrame keyFrame = new KeyFrame(Duration.millis(10), e -> spin());
        spinTime = new Timeline(keyFrame);
        spinTime.setCycleCount(Timeline.INDEFINITE);
        spinTime.play();
        //pause fan
        btPause.setOnAction(e ->{
            if (spinTime.getStatus() == Animation.Status.RUNNING) {
               spinTime.pause();
            }
         });
        //resume fan
        btResume.setOnAction(e ->{
            if(spinTime.getStatus() == Animation.Status.PAUSED){
            spinTime.play();
            }
        });
        //reverse
        btReverse.setOnAction(e -> increment *= -1);
    }
    //spin
     private void spin() {
         for (Arc blade : fan) {
            double StartAngle = blade.getStartAngle();
            blade.setStartAngle(StartAngle - increment);
         }
      }
}
