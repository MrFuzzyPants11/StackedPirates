//File: Encyclopedia.java
//Author: MrFuzzyPants
//Created: 04-19-2023
//Modified: 04-19-2023
package Globals;

import static Globals.Tools.*;
import static Globals.Constants.*;

public abstract class Encyclopedia {
  public static void viewEncyclopedia(){
    while(true){
      lineBreaker("ENCYCLOPEDIA");
      prln("What would you like learn about");
      prln("1. Basic mechanics");
      prln("2. Encounters");
      prln("3. Humans (include the player)");
      prln("4. Items");
      prln("5. Ships");
      prln("Q. Go Back");
      int input = askIn();
      if(input == QUIT){
        break;
      } else if(input == MENUEXIT){
        continue;
      } else if(input == 1){
        basicMechanicsEncyclopedia();
      } else if(input == 2){
        encountersEncyclopedia();
      } else if(input == 3){
        humansEncyclopedia();
      } else if(input == 4){
        itemsEncyclopedia();
      } else if(input == 5){
        shipsEncyclopedia();
      } else {
        invalOp();
        continue;
      }
    }
  }
  private static void basicMechanicsEncyclopedia() {
    lineBreaker("BASIC MECHANIC ENCYCLOPEDIA");
  }

  private static void encountersEncyclopedia() {
    lineBreaker("ENCOUNTER ENCYCLOPEDIA");
  }

  private static void humansEncyclopedia() {
    lineBreaker("HUMAN ENCYCLOPEDIA");
  }

  private static void itemsEncyclopedia() {
    lineBreaker("ITEM ENCYCLOPEDIA");
  }

  private static void shipsEncyclopedia() {
    lineBreaker("SHIP ENCYCLOPEDIA");
  }
}
