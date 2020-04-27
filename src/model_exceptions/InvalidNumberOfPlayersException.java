package model_exceptions;

public class InvalidNumberOfPlayersException extends Exception{
	int numOfPlayers;
	public InvalidNumberOfPlayersException(String msg, int numOfPlayers){
		super(msg);
		this.numOfPlayers = numOfPlayers;
	}
}
