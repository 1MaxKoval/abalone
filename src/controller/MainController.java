package controller;
//TO-DO to be tested fix main controller

import java.util.ArrayList;

import model.Field;
import model.Game;
import model.Move;
import model.Player;
import model_exceptions.ColorOccupiedException;
import model_exceptions.InvalidColorException;
import model_exceptions.InvalidNumberOfFieldsException;
import model_exceptions.InvalidNumberOfPlayersException;
import model_exceptions.InvalidXCoordinateException;
import model_exceptions.InvalidYCoordinateException;
import model_exceptions.NameAlreadyExistsException;
import view.AbaloneTui;

public class MainController {

    /**
     * Used for testing the class. 
     */
    public static void main(String[] args) {
        AbaloneTui.printTitle();
        getAndSetPlayersData();
        System.out.println(Game.players);
    }

    /**
     * Gets the number of players of the user and adds an the desired amount of players to the game.
     */
    public static void getAndSetPlayersData() {
        int numberOfPlayers = getNumberOfPlayers();
        for (var i = 0; i < numberOfPlayers; i++) {
            Game.addPlayer(getAndSetPlayerData());
        }
    }

    /**
     * The following method instantiates a player object gets appropriate attributes for it and returns the object.
     * @return Player object that has the attributes name and color set appropriately.
     * */
    public static Player getAndSetPlayerData() {
        while (true) {
            Player player = new Player();
            AbaloneTui.printMessage("Please input the name of the player");
            String name = AbaloneTui.getPlayerName();
            try {
                player.setName(name);
            } catch (NameAlreadyExistsException e) {
                AbaloneTui.printMessage(e.getMessage());
                continue;
            }
            AbaloneTui.printMessage("");
            AbaloneTui.printMessage(Player.printColors());
            AbaloneTui.printMessage("Please choose the color of the marbles for the player");
            String color = getPlayerColor();
            try {
                player.setColor(color);
            } catch (ColorOccupiedException e) {
                AbaloneTui.printMessage(e.getMessage());
            }
            return player;
        }
    }

    /**
     * Receives the number of players from the user.
     * After which it sets the game class instance to have that number of players.
     * @return Returns the number of players that are going to play the game.
     * @return 2<=return<=4
     */
    private static int getNumberOfPlayers() {
        while (true) {
            AbaloneTui.printMessage("Please input the number of players (integer): ");
            String input = AbaloneTui.getNumOfPlayers();
            try {
                int numberOfPlayers = Integer.parseInt(input);
                Game.setNumberOfPlayers(numberOfPlayers);
                return numberOfPlayers;
            } catch (NumberFormatException e) {
                AbaloneTui.printMessage("The input is invalid");
                continue;
            } catch (InvalidNumberOfPlayersException e) {
                AbaloneTui.printMessage(e.getMessage());
                continue;
            }
        }
    }

    /**
     * Receives the name of the player.
     * @ensures return!=""
     */
    public static String getPlayerName() {
        while (true) {
            AbaloneTui.printMessage("Please input the name of the player");
            String input = AbaloneTui.getPlayerName();
            if (input == "") {
                AbaloneTui.printMessage("Invalid name");
                continue;
            }
            return input;
        }
    }

    /**
     * Returns a color that is valid.
     * @ensures That the color is valid (please see the methods that throw the exceptions for "precise" definitions).
     * @return - a color of the player.
     */
    public static String getPlayerColor() {
        while (true) {
            Player.printColors();
            AbaloneTui.printMessage("Please input an integer that corresponds to the color you want");
            String input = AbaloneTui.getColor();
            try {
                int colorNum = Integer.parseInt(input);
                String resultString = Player.numToColor(colorNum);
                return resultString;
            } catch (NumberFormatException e) {
                AbaloneTui.printMessage("The input is invalid, please try again");
                continue;
            } catch (InvalidColorException e) {
                AbaloneTui.printMessage(e.getMessage());
                continue;
            }
        }
    }

    public static Move getandSetPlayerFields(Move playerMove){
        while (true) {
        AbaloneTui.printMessage("Please input 3 fields separated by a delimiter (;)");
        String input = AbaloneTui.getInput();
        try {
            playerMove.setSelectedFields(input);
            return playerMove; 
        } catch (InvalidNumberOfFieldsException e) {
            AbaloneTui.printMessage(e.getMessage());
            continue;
        } catch (InvalidXCoordinateException e) {
            AbaloneTui.printMessage(e.getMessage());
            continue;
        } catch (InvalidYCoordinateException e) {
            AbaloneTui.printMessage(e.getMessage());
            continue;
        }
        }

    }

}