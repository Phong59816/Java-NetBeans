package ch13_ex7;
public abstract class GeometricObject implements Comparable<GeometricObject> {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    
    //Construct default geometric object
    protected GeometricObject(){
        dateCreated = new java.util.Date();
    }
    //Construct a geometric object with color and filled value
    protected GeometricObject(String color,boolean filled){
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    //return color
    public String getColor(){
        return color;
    }
    //set color
    public void setColor(String color){
        this.color = color;
    }
    //return filled
    public boolean isFilled(){
        return filled;
    }
    //set filled
    public void setFilled(Boolean filled){
        this.filled = filled;
    }
    //return date
    public java.util.Date getDateCreated(){
        return dateCreated;
    }
    //compareTo
    public int compareTo(GeometricObject o){
        if(getArea() > o.getArea()){
            return 1;
        }
        else if(getArea() < o.getArea()){
            return -1;
        }
        else{
            return 0;
        }
    }
    //max method
    public static String max(GeometricObject obj1,GeometricObject obj2){
        int result = obj1.compareTo(obj2);
        if (result > 0){
            return obj1.toString() + " one is larger than " + obj2.toString() + " two";
        }
        else if(result < 0){
            return obj2.toString() + " two is larger than " + obj1.toString() + " one";
        }
        else {
            return "both object have the same area";
        }
    }
    @Override
    public String toString(){
        return "created on " + dateCreated + "/ncolor:" + color + " and filled: " + filled;
    }
    //abstract getArea
    public abstract double getArea();
    //abstract getPerimeter
    public abstract double getPerimeter();
}