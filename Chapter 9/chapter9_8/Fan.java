
package chapter9_8;

public class Fan {
    
    public static final int SLOW = 1, MEDIUM = 2, FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    //no args constructor for default fan
    public Fan(){
        speed = SLOW;
        on = false;
        radius = 5;
        color = "blue";
    }
    //Fan constructor
    public Fan(int speed,boolean on,double radius,String color){
        //set properties
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    //get speed
    public String getSpeed(){
        if(speed == 1){
            return "SLOW";
        }
        else if(speed == 2){
            return "MEDIUM";
        }
        else{
            return "FAST";
        }
    }
    //check if on
    public boolean isOn(){
        return on;
    }
    //get radius
    public double getRadius(){
        return radius;
    }
    //get color
    public String getColor(){
        return color;
    }
    //set speed
    public void setSpeed(int newSpeed){
        this.speed = newSpeed;
    }
    //set color
    public void setColor(String newColor){
        this.color = newColor;
    }
    //set radius
    public void setRadius(double newRadius){
        this.radius = newRadius;
    }
    //turn on/off
    public void Switch(){
        if (this.on == true){
            this.on = false;
        }
        else if(this.on == false){
           this.on = true;
        }
    }
    //print descriptions
    public String toString(){
        if (isOn() == true){
            return "The speed is " + getSpeed() + ", the color is " + getColor() + ", the radius is " + getRadius();
        }
        else{
            return "The color is " + getColor() + "," + " the radius is " + getRadius() + ", the fan is off";
        }
    }
}