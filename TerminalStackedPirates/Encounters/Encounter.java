//File: Encounter.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 06-07-2023
package Encounters;

import Humans.Player;

public abstract class Encounter {
  protected boolean viewed;
  protected int index;
  protected int level;
  /*
   * Method for moving the player into an encounter
   * @param player the player entering the encounter
   */
  public abstract void enter(Player player);
  /*
   * Method for getting the encounter type
   * @return the encounters type as a String
   */
  public abstract String getType();
  /*
   * Gets if the encounter has been viewed before
   * @return the Encounter's viewed boolean
   */
  public boolean getviewed(){
    return viewed;
  }

  /*
   * Gets the Encounter's index
   * @return the Encounter's index
   */
  public int getIndex(){
    return index;
  }

  /*
   * Gets Encounter's level for print purposes AKA level + 1
   * @return the Encounter's level + 1
   */
  public int getLevelText(){
    return level + 1;
  }

  /*
   * Gets the Encounter's actual level
   * @return the Encounter's level
   */
  public int getLevel(){
    return level;
  }
}
