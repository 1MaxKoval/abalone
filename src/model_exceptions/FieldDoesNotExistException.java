package model_exceptions;

import model.Field;

public class FieldDoesNotExistException extends Exception{
	Field field;
	public FieldDoesNotExistException(String msg, Field field) {
		super(msg);
		this.field = field;
	}
}
