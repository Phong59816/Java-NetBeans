package ch13_ex7;
public class Square extends GeometricObject implements Colorable {
    private double side;
    
    //no-arg constructor
    public Square(){
    }
    //constructor
    public Square(double side){
        this.side = side;
    }
    //get side
    public double getSide(){
        return side;
    }
    //set side
    public void setSide(double side){
        this.side = side;
    }
    public double getPerimeter(){
        return side * 4;
    }
    public double getArea(){
        return side * side;
    }
    public void howToColor(){
        System.out.print("Color all four sides");
    }
}
