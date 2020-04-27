package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import model_exceptions.ColorOccupiedException;
import model_exceptions.FieldDoesNotExistException;
import model_exceptions.InvalidNumberOfPlayersException;
import model_exceptions.InvalidXCoordinateException;
import model_exceptions.InvalidYCoordinateException;
import model_exceptions.NameAlreadyExistsException;

/**
 *Contains visual representation of the board and is responsible 
 *for generating information and values
 *about the status of the board.
 */
public class Board {
  //A one to one map matching the fields to its contents.
	HashMap<Field,Marble> board;
  //--------CONSTRUCTOR----------

	
	/**
 	 * Constructs, generates and fills in a board of players.
	 * @param players
	 * @throws InvalidNumberOfPlayersException
	 * @throws FieldDoesNotExistException
	 * @throws InvalidYCoordinateException 
	 * @throws InvalidXCoordinateException 
	 */
  public Board(ArrayList<Player> players) throws InvalidNumberOfPlayersException, FieldDoesNotExistException, InvalidXCoordinateException, InvalidYCoordinateException{
	  this.board = this.generateBoard();
	  this.fillInBoard(players);
  }
  
  public static void main(String args[]) throws NameAlreadyExistsException, ColorOccupiedException, InvalidNumberOfPlayersException, FieldDoesNotExistException, InvalidXCoordinateException, InvalidYCoordinateException {
	 Player player = new Player();
	 player.setName("Agata");
	 player.setColor("White");
	 Player player2 = new Player();
	 player2.setName("Jagvir");
	 player2.setColor("Red");
	 Player player3 = new Player();
	 player3.setName("Adiane");
	 player3.setColor("Black");
	 Player player4 = new Player();
	 player4.setName("Max");
	 player4.setColor("Blue");
	 ArrayList<Player> players = new ArrayList<>(Arrays.asList(player, player2, player3, player4));
	 Board board = new Board(players);
	 System.out.println(board);
  }

  /**
*Creates a data structure of the board with all fields being set to null;
*Should be called inside the constructor and give value to the instance variable board.
*@ensures return != null
*@return A data-structure of the board.
 * @throws InvalidYCoordinateException 
 * @throws InvalidXCoordinateException 
*/
  public HashMap<Field, Marble> generateBoard() throws InvalidXCoordinateException, InvalidYCoordinateException {
    HashMap<Field, Marble> map = new HashMap<>();
    ArrayList<Field> fields = new ArrayList<>();
    for(int i=1 ; i<6; i++) {
    	fields.add(new Field('A',i));
    }
    for(int i=1 ; i<7 ; i++) {
    	fields.add(new Field('B', i));
    }
    for(int i=1 ; i<8 ; i++) {
    	fields.add(new Field('C', i));
    }
    for(int i=1 ; i<9 ; i++) {
    	fields.add(new Field('D', i));
    }
    for(int i=1 ; i<10 ; i++) {
    	fields.add(new Field('E', i));
    }
    for(int i=2 ; i<10 ; i++) {
    	fields.add(new Field('F', i));
    }
    for(int i=3 ; i<10 ; i++) {
    	fields.add(new Field('G', i));
    }
    for(int i=4 ; i<10 ; i++) {
    	fields.add(new Field('H', i));
    }
    for(int i=5 ; i<10 ; i++) {
    	fields.add(new Field('I', i));
    }
    for(Field field : fields) {
    	map.put(field, null);
    }
    return map;
  }
  
  /**
   * Given an array of players determines how the board should be filled and fills it in
   * with player marbles accordingly.
   * @param players
 * @throws FieldDoesNotExistException 
 * @throws InvalidNumberOfPlayersException 
 * @throws InvalidYCoordinateException 
 * @throws InvalidXCoordinateException 
   */
  public void fillInBoard(ArrayList<Player> players) throws InvalidNumberOfPlayersException, FieldDoesNotExistException, InvalidXCoordinateException, InvalidYCoordinateException {
	  switch(players.size()) {
	  case(2):
		  this.fillInBoard2Players(players);
	  case(3):
		  this.fillInBoard3Players(players);
	  case(4):
		  this.fillInBoard4Players(players);
	  }
  }
  
  /**
   * Fills in the board according to the specification when there are 2 players.
   * @param players
   * @throws InvalidNumberOfPlayersException
   * @throws FieldDoesNotExistException
   */
  public void fillInBoard2Players(ArrayList<Player> players) throws InvalidNumberOfPlayersException, FieldDoesNotExistException {
	  Iterator<Marble> marbleIter = Marble.getPlayerMarbles(2, players.get(0)).iterator();
	  this.fillInRow('I', marbleIter);
	  this.fillInRow('H', marbleIter);
	  this.fillInRange(2, 4, 'G', marbleIter);
	  marbleIter = Marble.getPlayerMarbles(2, players.get(1)).iterator();
	  this.fillInRange(2, 4, 'C', marbleIter);
	  this.fillInRow('B', marbleIter);
	  this.fillInRow('A', marbleIter);
  }
  
  /**
   * Fills in the board according to the rules of the game when there are 3 players.
   * @param players
   * @throws InvalidNumberOfPlayersException
   * @throws FieldDoesNotExistException
 * @throws InvalidYCoordinateException 
 * @throws InvalidXCoordinateException 
   */
  public void fillInBoard3Players(ArrayList<Player> players) throws InvalidNumberOfPlayersException, FieldDoesNotExistException, InvalidXCoordinateException, InvalidYCoordinateException {
	  Iterator<Marble> marbleIter  = Marble.getPlayerMarbles(3, players.get(0)).iterator();
	  this.fillInColumns(0, 5, 0, 1, marbleIter);
	  Field extraField = this.getField('D',1);
	  this.setMarble(extraField, marbleIter.next());
	  marbleIter = Marble.getPlayerMarbles(3, players.get(1)).iterator();
	  this.fillInColumnsReverse(0, 5, 3, 4, marbleIter);
	  extraField = this.getField('D',8);
	  this.setMarble(extraField, marbleIter.next());
	  marbleIter  = Marble.getPlayerMarbles(3, players.get(2)).iterator();
	  this.fillInRow('B',marbleIter);
	  this.fillInRow('A', marbleIter);
  }
  
  /**
   * Fills in the board with marbles of different players according to the game rules when there are 4 players.
   * @param players
   * @throws InvalidNumberOfPlayersException
   * @throws FieldDoesNotExistException
   */
  public void fillInBoard4Players(ArrayList<Player> players) throws InvalidNumberOfPlayersException, FieldDoesNotExistException {
	 Iterator<Marble> marbleIter = Marble.getPlayerMarbles(4, players.get(0)).iterator(); 
	 this.fillInRange(0, 3, 'I', marbleIter);
	 this.fillInRange(1, 3, 'H', marbleIter);
	 this.fillInRange(2, 3, 'G', marbleIter);
	 marbleIter = Marble.getPlayerMarbles(4, players.get(1)).iterator();
	 this.fillInRange(5, 5, 'H', marbleIter);
	 this.fillInRange(5, 6, 'G', marbleIter);
	 this.fillInRange(5, 7, 'F', marbleIter);
	 this.fillInRange(6, 8, 'E', marbleIter);
	 marbleIter = Marble.getPlayerMarbles(4, players.get(2)).iterator();
	 this.fillInRange(0, 2, 'E', marbleIter);
	 this.fillInRange(0, 2, 'D', marbleIter);
	 this.fillInRange(0, 1, 'C', marbleIter);
	 this.fillInRange(0, 0, 'B', marbleIter);
	 marbleIter = Marble.getPlayerMarbles(4, players.get(2)).iterator();
	 this.fillInRange(3, 4, 'C', marbleIter);
	 this.fillInRange(2, 4, 'B', marbleIter);
	 this.fillInRange(1, 4, 'A', marbleIter);
  }
  
  /**
   * Acts int the same way as fill in columns (see below) however it diagonally replaces fields from top right to bottom left.
   * @param y1
   * @param y2
   * @param x1
   * @param x2
   * @param marbleIter
   * @throws FieldDoesNotExistException
   */
  public void fillInColumns(int y1, int y2, int x1, int x2, Iterator<Marble> marbleIter) throws FieldDoesNotExistException {
	  ArrayList<String> rows = new ArrayList<>(Field.characters); 
	  Collections.reverse(rows);
	  for(var i = y1; i<y2; i++) {
		 char xCoor = rows.get(i).charAt(0);
		 this.fillInRange(x1, x2, xCoor, marbleIter);
	  }
  }
  
  /**
   * Fills in column in the board diagonally from top left to down right The y determines the width of the rows that are going to replaced
   * And X determines the height or the number of rows that are going to replaced 
   * @param y1 - Determines the beggining Y coordinate
   * @param y2 - Determines the ending Y coordinate
   * @param x1 - Determines the beggining X coordinate
   * @param x2 - Determines the ending X coordinate
   * @param marbleIter
   * @throws FieldDoesNotExistException
   */
  public void fillInColumnsReverse(int y1, int y2, int x1, int x2, Iterator<Marble> marbleIter) throws FieldDoesNotExistException {
	 ArrayList<String> rows = new ArrayList<>(Field.characters); 
	 Collections.reverse(rows);
	 for(var i = x1; i<x2; i++) {
		 char xCoor = rows.get(i).charAt(0);
		 this.fillInRange(y1, y2, xCoor, marbleIter);
		 y1++; 
		 y2++;
	 }

  }
  
  
  /**
   * Given a row and a iterator of marbles fills that row with the marbles available in the iterator.
   * @param row - A character that represents a row.
   * @param marbleIter - An iterator of marbles from a specific player.
   * @throws FieldDoesNotExistException 
   */
  public void fillInRow(char row, Iterator<Marble> marbleIter) throws FieldDoesNotExistException {
	  ArrayList<Field> fields = this.getRow(row);
	  for(Field field : fields) {
		  if(!marbleIter.hasNext()) {
			 break; 
		  }
		  this.setMarble(field, marbleIter.next());
	  }
  }
  
  public void fillInRange(int a, int b, char row, Iterator<Marble> marbleIter) throws FieldDoesNotExistException {
	  ArrayList<Field> fields = this.getRow(row);
	  for( int i = a; i<=b ; i++) {
		  Field field = fields.get(i);
		  this.setMarble(field, marbleIter.next());
	  }

  }
	
  /**
* Creates a textual visualization of the board. 
* @return A textual visualization of the board.
*/
  public String toString() {
	  ArrayList<String> characters = new ArrayList<>(Field.characters);
	  Collections.reverse(characters);
	  int extra_space = 0;
	  String result = new String();
	  boolean reverse = false;
	  for(String character : characters) {
		  ArrayList<Field> fields = this.getRow(character.charAt(0));
		  result+=Board.visualize(" ", extra_space);
		  result+=this.visualizeRow(fields);
		  if(extra_space==12 || reverse) {
			  extra_space-=3;
			  reverse = true;
		  } else {
		  extra_space+=3;
		  }
	  }
	  return result;
  }
  
  /**
   * Returns a string of a character .
   * @param symbol instanceOf Strin
   * @param number - integer
   * @return return != null
   */
  public static String visualize(String symbol, int number) {
	 String value = new String();
	 for(var i = 0; i<number ; i++) {
		 value = value + symbol;
	 }
	 return value;
  }
  
  public static int initialSpace(int deviationFromCenterRow) {
	  return (deviationFromCenterRow*10);
  }
  
  /**
   * Creates a visualization of a single row
   * @param fields - An array that contains 
   * @return
   */
  public String visualizeRow(ArrayList<Field> fields){
	String result = new String();
	result+=Board.visualize(" ", Board.initialSpace(9-fields.size()));
	for(Field field : fields) {
		result+=this.printField(field);
		result+=Board.visualize(" ", 10);
	}
	result+="\n";
	result+="\n";
	return result;


  }
  
  /**
   * 
   * @param field - A field
   * @return Boolean - depending if a field exist or does not in the board datastructure.
   * @throws FieldDoesNotExistException - if the field does not exist in the data structure the exception is thrown.
   */
  public boolean isContained(Field field) throws FieldDoesNotExistException{
	  HashMap<Field, Marble> marbleBoard = getBoard();
	  HashSet<Field> fields = new HashSet<Field>(marbleBoard.keySet());
	  if(fields.contains(field)) {
		  return true;
	  } else {
		 throw new FieldDoesNotExistException(String.format("This field does not exist %s", field), field);
	  }
  }
	

  //--------GETTERS AND SETTERS---------- /** * Given a specified field of the board return a marble. * @return return == null

  //Possibly does not work because it will not return the right reference needs testing.
  /**
   * 
   * @param field - A field 
   * @return A reference of marble contained in the field that is given as a parameter.
   * @throws FieldDoesNotExistException - in the case the field does not exist throw this error.
   */
  public Marble getMarble(Field field) throws FieldDoesNotExistException {
	  if(this.isContained(field)) {
		 return this.board.get(field);
	  } 
	  return null;
  }
  
  /**
   * Returns a reference of the field object from the board datastructure.
   * @param xCoor - The X ordinate of a field
   * @param yCooa r The Y ordinate of a field.
   * @return
   * @throws FieldDoesNotExistException
 * @throws InvalidYCoordinateException 
 * @throws InvalidXCoordinateException 
   */
  //rewrite logic maybe later
  public Field getField(char xCoor, int yCoor) throws FieldDoesNotExistException, InvalidXCoordinateException, InvalidYCoordinateException {
	  Field field = new Field(xCoor, yCoor);
	  HashSet<Field> fields = this.getAllFields();
	  for(Field containedField: fields) {
		  if(field.equals(containedField)) {
			  return containedField;
		  }
	  }
	  throw new FieldDoesNotExistException("This field does not exist", field);
  }

  
  /**
   * @return A set of all fields
   */
  public HashSet<Field> getAllFields(){
	  HashSet<Field> fields =  new HashSet<>(this.getBoard().keySet());
	  return fields;
  }

  /**
   * Returns 
   * @requires coorX != null
   * @ensures return != null
   * @param coorX - The x coordinate
   * @return An array of sorted fields, the fields are sorted by their Y coordinate
   */
  public ArrayList<Field> getRow(char coorX){
	  HashSet<Field> fields = this.getAllFields();
	  ArrayList<Field> fieldsArr = new ArrayList<>();
	  for(Field field : fields) {
		  if(field.getCoordinateX() == coorX) {
			 fieldsArr.add(field); 
		  }
	  }
	  Collections.sort(fieldsArr);
	  return fieldsArr;
  }
  
  
  /**
   * Returns the board data structure
   * @return return!=null
   */
  public HashMap<Field, Marble> getBoard(){
	  return this.board;
  }
  

  /**
   * Creates a visualization of a specific field and what it contains.
   * @param field
   * @return String != null
   */
  public String printField(Field field){
	  Marble marble = this.board.get(field);
	  if(marble == null) {
		  return new String(field.toString() + "/" + "X");
	  }
	  else {
		  return new String(field.toString() + "/" + marble.toString()); 
	  }
  }
  
  /**
   * Sets a marble to a specific field in the map.
   * @param field - Field that the marble is going to be set in
   * @param marble - A marble that is going to be put into a field.
   * @throws FieldDoesNotExistException - In the case the field does not exist an exception is thrown.
   */
  public void setMarble(Field field, Marble marble) throws FieldDoesNotExistException {
	  if(this.isContained(field)) {
		  this.board.put(field, marble);
	  }
  }

}

