//File: StackedPiratesTerminal.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023

package Globals;

import static Globals.Tools.*;
import Humans.*;
import Encounters.*;

public class StackedPiratesTerminal{
  /*
   * Main method
   * @param args command line arguments
   */
  public static void main(String args[]){
    initializeScanner();
    cleanCSVFiles();
    //LoadNameFiles();
    prln("Welcome to Stacked Pirates!");
    Player player = new Player("Fuzzy", "Pants");
    pr("You are " + player.getFname() + " " + player.getLname() + ".\nYou are ");
    pr("Level " + player.getLevel(),"35");
    pr(", have no cards, But do have ");
    prln(player.getGold() + " gold.", "33");
    Port port = new Port("Bruh", true);
    port.enter(player);
    closeScanner();
  }

  /*
   * Method for the gameplay loop
   * @param player the player
   */
  public static void gameplayLoop(Player player){

  }
}