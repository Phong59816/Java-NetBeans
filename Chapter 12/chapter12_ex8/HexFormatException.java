
package chapter12_ex8;
public class HexFormatException extends Exception {
    //default constructor
    public HexFormatException(){
        super("Illegal hex character");
    }
    //constructor with specified message
    public HexFormatException(String message){
        super(message);
    }
}
