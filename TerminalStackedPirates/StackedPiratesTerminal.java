//File: StackedPiratesTerminal.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 11-13-2023

import Humans.*;
import static Globals.Tools.*;
import static Globals.Constants.*;
import Globals.World;
import Encounters.*;
import static Globals.PlayerAttributes.Location.*;

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
      
      Pair<World, Player> pair = initializeNewGame();
      //World map = pair.getFirst();
      Player player = pair.getSecond();
      prMap();
      prln("/////////////////////////////");
      prMapZoomed();
      if(player != null){
        pr("Welcome to Stacked Pirates");
        pr(" Captain " + player.getName() + "!\nYou are ");
        pr("Level " + player.getLevelText(),LEVELCOLOUR);
        pr(", have no cards, But do have ");
        prln(player.getGold() + " gold.", GOLDCOLOUR);
        //Port port = new Port(0);
        //port.enter(player);
        gameplayLoop(player);
        closeScanner();
      }
    }
  }

  /*
   * Method for generating game world and files
   */
  private static Pair<World,Player> initializeNewGame(){
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
    World map = new World(false);
    prln(" Done!",GREEN);

    //Load blank ship into CSV
    writeToCSV(PLAYERSHIPCSV, "StackedPiratesTerminal.java",false,PLAYERSHIPHEADER, PLAYERSHIPFORMAT,MINLEVEL,(MINLEVEL + 1) * 100,0,4,0,-1,-1,-1,-1,-1);
    
    return new Pair<World,Player>(map,new Player("FuzzyPants"));
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
    while(true){
      lineBreaker("MAP");
      prln("Where would you like to go?");
      prMapZoomed();
      prln("E. Enter this location");
      prln("W. Move Up");
      prln("A. Move Left");
      prln("S. Move Down");
      prln("D. Move Right");
      int input = askIn();
      if(input == E){
        Encounter enc = getMapEncounter(getY(),getX());
        if(enc instanceof Port){
          Port newEncounter = (Port) enc;
          newEncounter.enter(player);
        } else if(enc instanceof Ocean){
          Ocean newEncounter = (Ocean) enc;
          newEncounter.enter(player);
        }
      } else {
        if (input == W){
          if(!moveUp()){
            prln("You cannot go any further up!", RED);
          }
        } else if (input == A){
          if(!moveLeft()){
            prln("You cannot go any further left!", RED);
          }
        } else if (input == S){
          if(!moveDown()){
            prln("You cannot go any further down!", RED);
          }
        } else if (input == D){
          if(!moveRight()){
            prln("You cannot go any further right!", RED);
          }
        }
      }
    }
  }
}