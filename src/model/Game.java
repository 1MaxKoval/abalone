package model;

import java.util.ArrayList;

import model_exceptions.InvalidNumberOfPlayersException;

public class Game {
	//Contains the number of players in the current game
	static private int numberOfPlayers; 
	//Array containing the players of the current game.
	public static ArrayList<Player> players = new ArrayList<>();

//-----GETTERS AND SETTERS-------
	static public int getNumberOfPlayers() {
		return Game.getNumberOfPlayers();
	}
	
	/**
	 * @ensures numberOfPlayers<=4 && numberOfPlayers>=2
	 */
	public static void setNumberOfPlayers(int numberOfPlayers) throws InvalidNumberOfPlayersException{
		if(numberOfPlayers>4 || numberOfPlayers<2) {
			throw new InvalidNumberOfPlayersException(String.format("The input number of players was %d, which is invalid" , numberOfPlayers), numberOfPlayers);
		}
		Game.numberOfPlayers = numberOfPlayers;
	}
	
	/**
	 * Adds a player to the game.
	 * @param player
	 */
	public static void addPlayer(Player player) {
		Game.players.add(player);
	}
	
}
