
package chapter10_ex3;
public class MyInteger {
    private int value;
    //constructor
    public MyInteger(int value){
        this.value = value;
    }
    //get value method
    public int getValue(){
        return value;
    }
    //even method
    public boolean isEven(){
        if (value % 2 == 0) {
            return true;
        }
        else{
            return false;
        }
    }
    //odd method
    public boolean isOdd(){
        if (value % 2 != 0){
            return true;
        }
        else{
            return false;
        }
    }
    //prime method
    public boolean isPrime(){
        boolean notPrime = false;
        for(int i = 2; i <= value / 2; i++){
            if (value % i == 0){
                notPrime = true;
                break;
            }
            else{
                notPrime = false;
            }
        }
        if (notPrime == true){
            return false;
        }
        else{
            return true;
        }
    }
    //static MyInteger even method
    public static boolean isEven(MyInteger x){
        return x.isEven();
    }
    //static MyInteger odd method
    public static boolean isOdd(MyInteger x){
        return x.isOdd();
    }
    //static MyInteger prime method
    public static boolean isPrime(MyInteger x){
        return x.isPrime();
    }
    //equals method
    public boolean equals(int intValue){
        return value == intValue;
    }
    //equals MyInteger method
    public boolean equals(MyInteger myInt) {
        return myInt.value == this.value;
    }
    //convert char array to int value method
    public static int parseInt(char[] values) {
        String array = String.valueOf(values);
        return Integer.parseInt(array);
    }
    //convert string to int value method
    public static int parseInt(String value) {
        return Integer.parseInt(value);
    }
}
