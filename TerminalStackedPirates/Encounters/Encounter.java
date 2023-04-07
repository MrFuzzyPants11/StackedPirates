//File: Encounter.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Encounters;

import Humans.Player;

public abstract class Encounter {
  protected int index;

  /*
   * Method for moving the player into an encounter
   * @param player the player entering the encounter
   */
  public abstract void enter(Player player);
  
  /*
   * Gets the index of the encounter
   * @return the index of the encounter
   */
  public int getIndex(){
    return index;
  }
}
