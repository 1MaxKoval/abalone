package model;

import java.util.ArrayList;
import java.util.Arrays;

import model_exceptions.ColorOccupiedException;
import model_exceptions.InvalidColorException;
import model_exceptions.NameAlreadyExistsException;

public class Player {
	public static final String BLACK = "Black"; 
	public static final String WHITE = "White";
	public static final String RED = "Red";
	public static final String BLUE= "Blue";
	private String color; 
    private String name;
    private static ArrayList<String> playerNames = new ArrayList<>();
    private static ArrayList<String> occupiedColors = new ArrayList<>();
    
//-------MAIN TEST CLASS-----
    public static void main(String args[]) {
    }

     public String toString() {
         String returnString  = String.format("(%s, %s)", this.name, this.color); 
         return returnString;
     }
     //-----ORIGINAL METHODS-------
     
     /**
      *@requires name != null;
      *@ensures That there is only a single instance of name in the list Player.playerNames 
      */
     public static void addPlayerName(String name) throws NameAlreadyExistsException{
         name = name.toUpperCase();
    	 if(Player.playerNames.contains(name)) {
    		 throw new NameAlreadyExistsException(String.format("Another player already has the name %s", name), name );
    	 }
    	 Player.playerNames.add(name);
     }
     
     /**
      *@ensures return == Player.BLACK || return == Player.WHITE || return == Player.RED || return Player == Player.BLUE. 
      */
     public static String numToColor(int num) throws InvalidColorException {
    	switch(num) {
    	case (1):
    		return Player.BLACK;
    	
    	case (2): 
    		return Player.WHITE;
    	
    	case (3):
    		return Player.RED;
    	
    	case (4):
    		return Player.BLUE;
    	
    	default:
    		throw new InvalidColorException("Invalid color exception=");
    	}
     }
     
     /**
      *@ensures return == false || return == true
      *@requires color  != null.
      */
     public static boolean isColorOccupied(String color) {
    	 if(Player.occupiedColors.contains(color)) {
    		 return true;
    	 } else {
    		 return false;
    	 }
    	 
     }

//----------GETTERS AND SETTERS-----
     public String getColor() {
    	return this.color;
     }
     
     /**
      * @param color
      */
     public void setColor(String color) throws ColorOccupiedException{
    	 if (Player.isColorOccupied(color)) {
    		 throw new ColorOccupiedException(String.format("The color %s has already been chosen by another user", color), color);
    	 }
    	 Player.occupiedColors.add(color);
    	 this.color = color;
     }
     
     public String getName() {
    	 return this.name; 
     }
     
     public void setName(String name) throws NameAlreadyExistsException {
    	Player.addPlayerName(name);
    	this.name = name;
     }
     
    public static ArrayList<String> getPlayerNames() {
    	return Player.playerNames;
     }
    
    public static ArrayList<String> getOccupiedColors(){
    	return Player.occupiedColors;
    }
    
    public static String printColors() {
    	String result = new String();
    	result += String.format("1: %s \n", Player.BLACK);
    	result += String.format("2: %s \n", Player.WHITE);
    	result += String.format("3: %s \n", Player.RED);
    	result += String.format("4: %s \n", Player.BLUE);
    	return result;
    }
}