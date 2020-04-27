package model_exceptions;

public class InvalidNumberOfFieldsException extends Exception {
    String[] fields; 
    public InvalidNumberOfFieldsException(String msg, String[] fields) {
        super(msg);
        this.fields=fields;
    }
}
