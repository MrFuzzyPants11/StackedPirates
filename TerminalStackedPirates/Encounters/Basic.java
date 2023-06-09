//File: Basic.java
//Author: MrFuzzyPants
//Created: 06-08-2023
//Modified: 06-08-2023
package Encounters;

import static Globals.Constants.BASIC;
import Humans.Player;

public class Basic extends Encounter {
  public Basic(){}
  public String getType(){
    return BASIC;
  }
  public char getSymbol(){
    return 'B';
  }
  public void enter(Player player){}
}
