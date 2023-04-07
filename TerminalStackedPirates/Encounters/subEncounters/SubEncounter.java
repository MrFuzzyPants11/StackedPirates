//File: SubEncounter.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Encounters.subEncounters;

import Encounters.Encounter;

public abstract class SubEncounter extends Encounter{
  int level;

  /*
   * Gets the level of the sub encounter
   */
  public int getLevel(){
    return level;
  }
}
