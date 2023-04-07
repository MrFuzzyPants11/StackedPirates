//File: Tavern.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Encounters.subEncounters;

import Humans.Player;

public class Tavern extends SubEncounter{
  /*
   * Constructor for a new Tavern
   * @param reload whether the encounter is being reloaded
   * @param levelOrIndex the level of the encounter or the index of the encounter if being reloaded
   */
  public Tavern(boolean reload, int levelOrIndex){
    this.level = levelOrIndex;
    this.index = 0;
  }

  /*
   * The Tavern Environment
   * @param player the player
   */
  public void enter(Player player){
  }
}
