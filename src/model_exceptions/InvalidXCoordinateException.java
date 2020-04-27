package model_exceptions;

public class InvalidXCoordinateException extends Exception {
    char xOor; 
    public InvalidXCoordinateException(String msg, char xOor) {
        super(msg); 
        this.xOor = xOor;
    }
}
