package model_exceptions;

public class NameAlreadyExistsException extends Exception{
	String name; 
	public NameAlreadyExistsException(String message, String name) {
		super(message);
		this.name = name;
	}
	
}
