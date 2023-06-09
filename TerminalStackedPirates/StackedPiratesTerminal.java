//File: StackedPiratesTerminal.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 06-07-2023

import Humans.*;
import static Globals.Tools.*;
import static Globals.Constants.*;
import Globals.WorldMap;
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
      Pair<WorldMap, Player> pair = initializeNewGame();
      //WorldMap map = pair.getFirst();
      Player player = pair.getSecond();
      //prMap();
      if(player != null){
        pr("Welcome to Stacked Pirates");
        pr(" Captain " + player.getName() + "!\nYou are ");
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
  private static Pair<WorldMap,Player> initializeNewGame(){
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
    pr("Generating World.... ");
    WorldMap map = new WorldMap(false);
    prln(" Done!",GREEN);

    //Load blank ship into CSV
    writeToCSV(PLAYERSHIPCSV, "StackedPiratesTerminal.java",false,PLAYERSHIPHEADER, PLAYERSHIPFORMAT,MINLEVEL,(MINLEVEL + 1) * 100,0,4,0,-1,-1,-1,-1,-1);
    
    return new Pair<WorldMap,Player>(map,new Player("FuzzyPants"));
  }

  // private static Pair<WorldMap,Player> initializeLoadGame(){
  //   // Load name files into memory
  //   LoadNameFiles();

  //   // Load the scanner
  //   initializeScanner();

  //   return new Pair<WorldMap,Player>(map,new Player();
  // }

  /*
   * Method for the gameplay loop
   * @param player the player
   */
  public static void gameplayLoop(Player player){

  }
}