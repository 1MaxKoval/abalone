package view;

import java.util.Scanner;

public class AbaloneTui {
	
	/**
	 * Asks users to input the name of the players.
	 */
	public static String getPlayerName() {
		String input = AbaloneTui.getInput();
		return input; 
	}
	
	/**
	 * Asks users to input the number of players that are going to play the game.
	 */
	public static String getNumOfPlayers() {
		String input = AbaloneTui.getInput();
		return input;
	}

	/**
	 * Information.
	 * @return An integer that represents that color.
	 */
	public static String getColor() {
		String input = AbaloneTui.getInput();
		return input;
	}
	
	/**
	 * Prints out a message on the standard output.
	 * @requires msg != null
	 */
	public static void printMessage(String msg) {
		System.out.println(msg);
	}
	
	/**
	 * Get a line input from the user.
	 * @return a string
	 */
	public static String getInput() {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		return s;
	}
	
	public static void printTitle() {
	  String resultString = new String();
	  resultString = "   __    ____    __    __    _____  _  _  ____ \n" + 
	        "  /__\\  (  _ \\  /__\\  (  )  (  _  )( \\( )( ___)\n" + 
	          " /(__)\\  ) _ < /(__)\\  )(__  )(_)(  )  (  )__) \n" + 
	          "(__)(__)(____/(__)(__)(____)(_____)(_)\\_)(____)\n" + 
	          "                                               \n";
	  printMessage(resultString);

	}

}