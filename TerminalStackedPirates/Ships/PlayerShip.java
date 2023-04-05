//File: PlayerShip.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023

package Ships;

import java.util.*;

public class PlayerShip extends Ship{
  int travelUntilSink;
  int holeLevel;

  public PlayerShip(int size){
    this.size = size;
    this.cards = new ArrayList<Card>();
    this.repairs = 0;
    this.toughness = size * 100;
    this.travelUntilSink = 4;
    this.holeLevel = 0;
  }
  
  public int getHoleLevel(){
    return this.holeLevel;
  }

  /*
   * Checks if the ship has enough health to not have holes
   * @return true if the ship has enough health to not have holes
   * @return false if the ship has enough damage to have holes
   */
  public boolean hasHoles(){
    if(this.toughness <= ((size * 100) * 0.25)){
      travelUntilSink = 1;
      holeLevel = 3;
      return false;
    }

    if(this.toughness <= ((size * 100) * 0.5)){
      travelUntilSink = 2;
      holeLevel = 2;
      return false;
    }

    if(this.toughness <= ((size * 100) * 0.75)){
      travelUntilSink = 3;
      holeLevel = 1;
      return false;
    } else {
      travelUntilSink = 4;
      holeLevel = 0;
      return true;
    }
  }

  public int getTravelUntilSink(){
    return this.travelUntilSink;
  }

  public boolean canTravel(){
    if(holeLevel > 0){
      if(travelUntilSink <= 0){
        return false;
      } else {
        travelUntilSink--;
        return true;
      }
    } else {
      return true;
    }
  }
}
