package ch16_ex25;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
public class carPane extends Pane {
    Circle Fwheel = new Circle(50,45,5);
    Circle Bwheel = new Circle(30,45,5);
    Rectangle rec = new Rectangle(20,30,40,10);
    Line tBorder = new Line(0,0,500,0);
    Line road = new Line(0,35,500,35);
    Polygon polygon = new Polygon();
    PathTransition pt = new PathTransition();
    //construct car pane
    public carPane(){
        road.setStroke(Color.TRANSPARENT);
        getChildren().add(road);
        rec.setFill(Color.RED);
        polygon.setFill(Color.BROWN);
        getChildren().add(tBorder);
        //make trapazoid
        polygon.getPoints().addAll(new Double[]{25.0,30.0,55.0,30.0,45.0,20.0,35.0,20.0});
        //make car group
        Group carG = new Group(rec,polygon,Fwheel,Bwheel);
        getChildren().add(carG);
        //car animation
        pt.setRate(0);
        pt.setPath(road);
        pt.setNode(carG);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();
    }
    //set speed
    public void setRate(double rate){
        if (rate < 0){
            rate = 0;
        }
        else if(rate > 100){
            rate = 100;
        }
        pt.setRate(rate);
    }
}