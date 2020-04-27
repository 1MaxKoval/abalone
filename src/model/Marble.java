package model;

import java.util.ArrayList;

import model_exceptions.InvalidNumberOfPlayersException;

public class Marble {

	Player player;
	String color;
	
//------CONSTRUCTORS--------
	/**
	 * Constructor that instantiates a player.
	 * @param player
	 */
	public Marble(Player player) {
		this.player = player;
		this.color = player.getColor();
	}

//-------ORIGINAL METHODS---------
	
	/**
	 * Takes a player object and creates an ArrayList of Marbles for that player. 
	 * The number of marbles in the ArrayList varies depending on how many players are playing the game so adjust the number of marbles accordingly.
	 * This function also throws a InvalidNumberOfPlayersException if the number of players is inadequate. 
	 * @param numOfPlayers - number of players that are going to play the game. 
	 * @ensures 2<=numOfPlayer<=4
	 * @return
	 */
	public static ArrayList<Marble> getPlayerMarbles(int numOfPlayers, Player player) throws InvalidNumberOfPlayersException{
		switch(numOfPlayers) {
		case(2):
			return Marble.generateMarbleSet(14, player);
		case(3):
			return Marble.generateMarbleSet(11, player);
		case(4):
			return Marble.generateMarbleSet(9, player);
		default:
			throw new InvalidNumberOfPlayersException("The number of players input is invalid", numOfPlayers);
		}
	}
	
	public static ArrayList<Marble> generateMarbleSet(int numOfMarbles, Player player){
		ArrayList<Marble> marbles = new ArrayList<>();
		for(var i =0; i<numOfMarbles ; i++) {
			marbles.add(new Marble(player));
		} return marbles;
	}
	
//------GETTERS AND SETTERS----------
	public Player getPlayer() {
		return this.player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color; 
	}
	
	/**
	 * @return - The first character of the color.
	 */
	public String toString() {
		String[] arr = color.split("");
		return arr[0];
	}
}
