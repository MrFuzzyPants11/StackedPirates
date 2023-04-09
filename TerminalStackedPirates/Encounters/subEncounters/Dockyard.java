//File: Dockyard.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023
package Encounters.subEncounters;

import Humans.Player;

public class Dockyard extends SubEncounter{
  /*
   * Constructor for a new Dockyard
   * @param reload whether the encounter is being reloaded
   * @param levelOrIndex the level of the encounter or the index of the encounter if being reloaded
   */
  public Dockyard(boolean reload, int levelOrIndex){
    this.level = levelOrIndex;
    this.index = 0; 
  }

  /*
   * The Dockyard Environment
   * @param player the player
   */
  public void enter(Player player){
  }
}
