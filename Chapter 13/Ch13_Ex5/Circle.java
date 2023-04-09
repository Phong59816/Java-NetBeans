
package chapter.pkg13.exercise.pkg5;
public class Circle extends GeometricObject{
    private double radius;
    public Circle(){
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle (double radius,String color,boolean filled){
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }
    //return radius
    public double getRadius(){
        return radius;
    }
    //set radius
    public void setRadius(double radius){
        this.radius = radius;
    }
    //return area
    public double getArea(){
        return radius * radius * Math.PI;
    }
    public double getDiameter(){
        return 2 * radius;
    }
    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }
    public void printCircle(){
        System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
    }
    public String toString(){
        return "circle";
    }
}
