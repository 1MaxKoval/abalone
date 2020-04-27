package model_exceptions;

public class InvalidDirectionException extends Exception{

    int direction;

    public InvalidDirectionException(String message, int direction) {
        super(message);
        this.direction = direction;
    }
}
