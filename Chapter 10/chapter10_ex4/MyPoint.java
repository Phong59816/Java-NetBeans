
package chapter10_ex4;
public class MyPoint {
    private double x = 0;
    private double y = 0;
    //no args constructor (0,0)
    public MyPoint(){
    }
    //specified point constructor
    public MyPoint(double x,double y){
        this.x = x;
        this.y = y;
    }
    //get distance from (0,0) to specified MyPoint
    public double distance(MyPoint one){
        return Math.sqrt((x - one.x) * (x - one.x) + (y - one.y) * (y - one.y));
    }
    //get distance from(0,0) to specified x,y coordinante
    public double distance(double x2,double y2){
        return Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2));
    }
    //get distance from 2 specified MyPoint
    public static double distance(MyPoint one, MyPoint two){
        return Math.sqrt((two.x - one.x) * (two.x - one.x) + (two.y - one.y) * (two.y - one.y));
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
}
