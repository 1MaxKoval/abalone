package model_exceptions;

public class ColorOccupiedException extends Exception {
	String color;
	public ColorOccupiedException(String msg, String color) {
		super(msg);
		this.color = color;
	}

}
