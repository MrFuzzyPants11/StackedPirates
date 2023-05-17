//File: StackedPiratesTerminal.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 05-16-2023

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
    pr("Generating World.... ");
    int[][] world = new int[11][11];
    int[] remainingBosses = GENBOSSES;
    // These are all number remaining not number in the world
    int numPorts = NUMPORTS;
    int numBattles = NUMBATTLES;
    int numIslands = NUMISLANDS;

    world[6][6] = GENSTARTINGPORT;
    int x;
    int y;
    int encounter;
    int bossNum = 0;
    while(numPorts != 0 || numBattles != 0 || numIslands != 0 || bossNum < remainingBosses.length){
      x = generateRand(11);
      y = generateRand(11);
      if(world[y][x] == 0){
        encounter = generateRand(4) + 1;
        if(encounter == 1 && numPorts > 0){
          world[y][x] = 1;
          numPorts--;
        } else if(encounter == 2 && numBattles > 0){
          world[y][x] = 2;
          numBattles--;
        } else if(encounter == 3 && numIslands > 0){
          world[y][x] = 3;
          numIslands--;
        } else if(encounter == 4 && bossNum < remainingBosses.length){
          world[y][x] = remainingBosses[bossNum];
          bossNum++;
        }
      }
    }

    prln(" Done!",GREEN);
    //Load blank ship into CSV
    writeToCSV(PLAYERSHIPCSV, "StackedPiratesTerminal.java",false,PLAYERSHIPHEADER, PLAYERSHIPFORMAT,MINLEVEL,(MINLEVEL + 1) * 100,0,4,0,-1,-1,-1,-1,-1);
    
    return new Player("FuzzyPants");
  }

  // private static Player initializeLoadGame(){
  //   // Load name files into memory
  //   LoadNameFiles();

  //   // Load the scanner
  //   initializeScanner();

  //   return new Player();
  // }

  /*
   * Method for the gameplay loop
   * @param player the player
   */
  public static void gameplayLoop(Player player){

  }
}