package model_exceptions;

public class InvalidYCoordinateException extends Exception {
    int yOor;
    public InvalidYCoordinateException(String msg, int yOor) {
        super(msg);
        this.yOor = yOor;
    }
}
