//File: StackedPiratesTerminal.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-11-2023

import Humans.*;

import static Globals.Tools.*;
import static Globals.Constants.*;
import Encounters.*;

public class StackedPiratesTerminal{
  /*
   * Main method
   * @param args command line arguments
   */
  public static void main(String args[]){
    prln("Start a new game or load a saved game?");
    prln("1. Load Game");
    prln("2. New Game");
    int input = 2; // = askIn();
    if(input == 1){
      //Player player = initializeLoadGame();
      //return;
    } else if(input == 2){
      // prln("Are you sure you want to start a new game?");
      // prln("This will delete any saved game",RED);
      // prln("1. Start New Game");
      // prln("Q. Cancel");
      // input = askIn();
      // if(input == 1){
      //   prln("Starting new game");
      // } else {
      //   prln("Cancelling");
      //   return;
      // }
      Player player = initializeNewGame();
      if(player != null){
        pr("Welcome to Stacked Pirates");
        pr(" Captain" + player.getName() + "!\nYou are ");
        pr("Level " + player.getLevelText(),LEVELCOLOUR);
        pr(", have no cards, But do have ");
        prln(player.getGold() + " gold.", GOLDCOLOUR);
        Port port = new Port(true, 0);
        port.enter(player);
        closeScanner();
      }
    }
  }

  /*
   * Method for generating game world and files
   */
  private static Player initializeNewGame(){
    //Clean any CSV files that need to be
    cleanCSVFiles();

    // Load name files into memory
    LoadNameFiles();

    // Load the scanner
    initializeScanner();

    // Ask for player name
    //pr("What would you like your name to be? ");
    //String name = askStr();
    
    // Ask for additional settings
    // ...
    //Generate world

    return new Player("FuzzyPants");
  }

  private static Player initializeLoadGame(){
    // Load name files into memory
    LoadNameFiles();

    // Load the scanner
    initializeScanner();

    return new Player();
  }

  /*
   * Method for the gameplay loop
   * @param player the player
   */
  public static void gameplayLoop(Player player){

  }
}