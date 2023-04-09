//File: StackedPiratesTerminal.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023

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
    Player player = initializeGame();
    if(player != null){
      prln("Welcome to Stacked Pirates!");
      pr("You are " + player.getFname() + " " + player.getLname() + ".\nYou are ");
      pr("Level " + player.getLevelText(),LEVELCOLOUR);
      pr(", have no cards, But do have ");
      prln(player.getGold() + " gold.", GOLDCOLOUR);
      Port port = new Port("Bruh", true, 0);
      port.enter(player);
      closeScanner();
    }
  }

  /*
   * Method for generating game world and files
   */
  private static Player initializeGame(){
    //Clean any CSV files that need to be
    cleanCSVFiles();

    // Load name files into memory
    LoadNameFiles();

    // Load the scanner
    initializeScanner();

    // Ask for additional settings
    // ...
    //Generate world

    return new Player("Fuzzy", "Pants");
  }

  /*
   * Method for the gameplay loop
   * @param player the player
   */
  public static void gameplayLoop(Player player){

  }
}