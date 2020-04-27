package model;

import java.util.ArrayList;

import model_exceptions.InvalidDirectionException;
import model_exceptions.InvalidNumberOfFieldsException;
import model_exceptions.InvalidXCoordinateException;
import model_exceptions.InvalidYCoordinateException;


//Holds a move that has a possibility of performing a Sumito.
public class Move {
	//Holds values for the type of move.
	static public enum MoveType{SIDE, INLINE};

	//Holds true if the move is obstructed by oponents or own marbles for all marbles selected in this move.
	private boolean isObstr;

	//Holds the type of move that is being made.
	private	MoveType moveType;  

	//Holds the marbles that have been selected for this move
	private ArrayList<Field> selectedFields;

	//Holds the direction of the move. //TO-DO Reference to the final report about how does an integer translate to direction.
	private int direction; 

//--------CONSTRUCTOR--------
	
	/**
	 * Creates a Move that can be done and can possibly trigger a Sumito.
	 * @requires direction!=null && 1<direction<=6 //TO-DO Reference to the final report integer->direction translation
	 * @requires ArrayList<Marble>.size() > 1 && ArrayList<Marble> <= 3 //TO-DO reference to the final report the user can select only up to 3 marbles
	 * @param selectedMarbles an array of marbles selected by the player.
	 */
	//Use information from constructor.
	
//------ GETTERS AND SETTERS--------- 
	public void setSelectedFields(ArrayList<Field> selectedFields){
		this.selectedFields = selectedFields; 
	}
	
	public void setSelectedField(Field field) {
	    this.selectedFields.add(field); 
	}
	
	public void setSelectedFields(String string) throws InvalidNumberOfFieldsException, InvalidXCoordinateException, InvalidYCoordinateException {
	    String result = string.replaceAll("\\s+", "");
	    String[] fields = result.split(";");
	    if (fields.length < 1 || fields.length > 3) {
	        throw new InvalidNumberOfFieldsException("The number of fields input is invalid", fields);
	    }
	    for(String field : fields) {
	        Field objectField = new Field(field);
	        setSelectedField(objectField);
	    }
	}

	public ArrayList<Field> getSelectedSelectedFields() {
		return selectedFields;
	}
	
	public void setIsObstr(boolean isObstr){
		this.isObstr = isObstr;
	}
	
	public boolean getIsObstr() {
		return isObstr; 
	}
	
	public void setMoveType(MoveType moveType) {
		this.moveType = moveType;  
	}
	
	public MoveType getMoveType() {
		return moveType;
	}
	
	public void setDirection(int direction) throws InvalidDirectionException {
	    if(direction<1 || direction>6) {
	        throw new InvalidDirectionException("Invalid direction input", direction);
	    }
	    this.direction = direction;
	}
	
	public int getDirection() {
		return this.direction;
	}
}
