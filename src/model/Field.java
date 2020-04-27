package model;

import java.util.ArrayList;
import java.util.Arrays;

import model_exceptions.InvalidDirectionException;
import model_exceptions.InvalidXCoordinateException;
import model_exceptions.InvalidYCoordinateException;

/**
* Represents a single cell/field on the board.
*/
public class Field implements Comparable<Field>{
	public static final ArrayList<String> characters = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I"));
  /**
* The stored character X.
* @requires The stored character X must be of the values A,B,C,D,E,F,G,H,I (all capitalized)
*/
  private char coorX;
  /**
* This representation assumes that the value y appropriately matches the value of x. 
* (Reference to the final report).
* @requires The stored Y value must be : 1<=y<=9.
*/
  private int coorY;
	
  
  
  
  public static void main(String[] args) {
  }
 //------CONSTRUCTORS----------
  /**
* Creates an empty field with given coordinates. 
* @param CoorX
* @param CoorY
*/
	public Field(char coorX, int coorY) throws InvalidXCoordinateException, InvalidYCoordinateException{
	    setCoordinateX(coorX);
	    setCoordinateY(coorY);
	}
	
	public Field(String coordinates) throws InvalidXCoordinateException, InvalidYCoordinateException {
	   setCoordinates(coordinates); 
	}
	
//-----ORIGINAL-METHODS--------
	/**
	 * Converts the x and y representations into a string representation for visual output.
	 */
	public String toString(){
		String x = String.valueOf(this.coorX);
		String y = String.valueOf(this.coorY);
		return x+y;
	}
	
	/**
	 * Decreases the value of this.x in alphabetical order (eg. A -> B) 
	 * @throws InvalidYCoordinateException 
	 * @throws InvalidXCoordinateException 
	 * @ensures this.x decremented by one in alphabetical order
	 */
	public Field upRow() throws InvalidXCoordinateException, InvalidYCoordinateException {
		char x = this.getCoordinateX();;
		x++;
		return new Field(x, this.getCoordinateY());
	}

	/**
	 * Increases the value of this.x in alphabetical order (eg. B -> A)
	 * @throws InvalidYCoordinateException 
	 * @throws InvalidXCoordinateException 
	 * @ensures this.x incremented by one in alphabetical order
	 */
	public Field downRow() throws InvalidXCoordinateException, InvalidYCoordinateException{
		char x = this.getCoordinateX();
		x--;
		return new Field(x, this.getCoordinateY());
	}
	
	/**
	 * Decrement the value of this.y by 1;
	 * @throws InvalidYCoordinateException 
	 * @throws InvalidXCoordinateException 
	 * @ensures this.y decremented by 1
	 */
	public Field left() throws InvalidXCoordinateException, InvalidYCoordinateException{
		int y = this.getCoordinateY();
		y--;
		return new Field(this.getCoordinateX(), y);

	}
	
	/**
	 * Increment the value of this.y by 1;
	 * @throws InvalidYCoordinateException 
	 * @throws InvalidXCoordinateException 
	 * @ensures this.y incremented by 1
	 */
	public Field right() throws InvalidXCoordinateException, InvalidYCoordinateException{
		int y = this.getCoordinateY();
		y++;
		return new Field(this.getCoordinateX(), y);
	}
	
	/**
	 *Find coordinate with this.x decreased by one (eg.A -> B) and this.y stays the same
	 * @throws InvalidYCoordinateException 
	 * @throws InvalidXCoordinateException 
	 *@ensures upRow() performs for this.x, this.y value is not changed 
	 */
	public Field upperLeft() throws InvalidXCoordinateException, InvalidYCoordinateException{
		return this.upRow();
	}
	
	/**
	 * Find coordinate with this.x decreased by one (eg.A -> B) and this.y increased by 1
	 * @throws InvalidYCoordinateException 
	 * @throws InvalidXCoordinateException 
	 * @ensures upRow() performs for this.x, rightColumn() performs for this.y
	 */
	public Field upperRight() throws InvalidXCoordinateException, InvalidYCoordinateException{
		Field field = this.upRow();
		return field.right();
	}
	
	/**
	 * Find coordinate with this.x increased by one (eg.B -> A) and this.y decreased by 1
	 * @throws InvalidYCoordinateException 
	 * @throws InvalidXCoordinateException 
	 * @ensures downRow() performs for this.x, leftColumn() performs for this.y
	 */
	public Field bottomLeft() throws InvalidXCoordinateException, InvalidYCoordinateException{
		Field field = this.downRow();
		return field.left();
	}
	
	/**
	 * Find coordinate with this.x increased by one (eg.B -> A) and this.y stays the same
	 * @throws InvalidYCoordinateException 
	 * @throws InvalidXCoordinateException 
	 * @ensures downRow() performs for this.x, this.y value is not changed 
	 */
	public Field bottomRight() throws InvalidXCoordinateException, InvalidYCoordinateException{
		return this.downRow();
	}
	
	/**
	 *Returns a field relative to the field in the specified direction. 
	 *@requires field has coordinates of x y that are within the boundaries of the board.
	 *@return Field that is relative to the given field with the given direction.
	 * @throws InvalidYCoordinateException 
	 * @throws InvalidXCoordinateException 
	 */
	public Field getRelativeField(int direction) throws InvalidDirectionException, InvalidXCoordinateException, InvalidYCoordinateException {
		switch(direction) {
		case(1):
			return this.upperLeft();
		case(2):
			return this.upperRight();
		case(3):
			return this.left();
		case(4):
			return this.right();
		case(5):
			return this.bottomLeft();
		case(6):
			return this.bottomRight();
		default:
			throw new InvalidDirectionException("The input direction is invalid", direction);
		}
	}
	
	/**
	 * Returns an array of fields relative to the fields (given in the parameter) in the specified direction. 
	 * @requires Field objects have coordinates that are within the board.
	 * @return An ArrayList of Field that maintains the order of the fields parameter.
	 * @throws InvalidDirectionException 
	 * @throws InvalidYCoordinateException 
	 * @throws InvalidXCoordinateException 
	 * @ensures The order of Field objects inside the returned ArrayList corresponds to the order of the input fields. (Reference to the final report)
	 */
	public static ArrayList<Field> getRelativeFields(int direction, ArrayList<Field> fields) throws InvalidDirectionException, InvalidXCoordinateException, InvalidYCoordinateException{
		ArrayList<Field> resultFields = new ArrayList<>();
		for(Field field : fields) {
			resultFields.add(field.getRelativeField(direction));
		}
		return fields;
	}
	
//--------GETTERS AND SETTERS-----------
	public void setCoordinates(char x, int y) {
		this.coorX = x;
		this.coorY = y; 
	}
	
	/**
	 * The parameter takes in an appropriate string (see requires) and sets the variables of this.x and this.y appropriately
	 * @throws InvalidXCoordinateException 
	 * @throws InvalidYCoordinateException 
	 * @requires xy is in the form of "CI" where C is a character and I is an integer.  
	 * @requires xy!=null
	 * @ensures this.x!=null && this.y!=null
	 */
	public void setCoordinates(String xy) throws InvalidXCoordinateException, InvalidYCoordinateException{
	    String[] arrayXy = xy.split("");
	    char xCoor = arrayXy[0].charAt(0);
	    int yCoor = Integer.parseInt(arrayXy[1]);
	    setCoordinateX(xCoor);
	    setCoordinateY(yCoor);
	}
	
	public void setCoordinateX(char coorX) throws InvalidXCoordinateException {
	    if(coorX < 'A' || coorX > 'I') {
            throw new InvalidXCoordinateException("The input X coordinate is invalid", coorX);
        }
		this.coorX = coorX;
	}
	
	public void setCoordinateY(int coorY) throws InvalidYCoordinateException {
	    if(coorY < 1 || coorY > 9) {
            throw new InvalidYCoordinateException("The input Y coordinate is invalid", coorY);
        }
		this.coorY = coorY;

	}
	
	public char getCoordinateX(){
		return this.coorX;
	}
	
	public int getCoordinateY(){
		return this.coorY;
	}


	/**
	 * A compareTo that allows fields to be sorted by their x coordinate.
	 */
	@Override
	public int compareTo(Field field) {
		if(field.getCoordinateY() < this.getCoordinateY()) {
			return 1;
		}
		else if (field.getCoordinateY() > this.getCoordinateY()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public boolean equals(Field field) {
		if(this.getCoordinateX() == field.getCoordinateX() && this.getCoordinateY() == field.getCoordinateY()) {
			return true;
		} else {
			return false;
		}
	}
	
}
