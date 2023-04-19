//File: PlayerShip.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-19-2023
package Ships;

import static Globals.Tools.*;
import static Globals.Constants.*;
import java.util.*;
import Items.Cards.*;

public class PlayerShip extends Ship{
  int repairs;
  int travelUntilSink;
  int holeLevel;

  /*
   * Constructor for a new PlayerShip
   */
  public PlayerShip(){
    String[] data = getFromCSVRow(PLAYERSHIPCSV,"PlayerShip.java",INDEX, "0");
    this.size = toInt(data[1]);
    this.toughness = toInt(data[2]);
    this.repairs = toInt(data[3]);
    this.travelUntilSink = toInt(data[4]);
    this.holeLevel = toInt(data[5]);
    this.cards = new ArrayList<ShipCard>();
    for(int i = 6; i < data.length; i++){
      if(toInt(data[i]) != -1){
        cards.add(new ShipCard(true, toInt(data[i])));
      }
    }
  }
  /*
   * Gets the number of repairs the PlayerShip has
   * @Return the repairs
   */
  public int getRepairs(){
    return this.repairs;
  }

  /*
   * Adds one repair kit to the ship
   * @Param int the amount of repairs to add
   */
  public void addRepairs(int added){
    this.repairs += added;
  }

  /*
   * Reduces the number of Repairs by the amount used
   * @Param int the amount being used
   * @Return true if able to remove that many repairs
   * @Return false if unable to remove that many repairs
   */
  public boolean reduceRepairs(int used){
    if(this.repairs < used){
      return false;
    }
    this.repairs -= used;
    return true;
  }

  /*
   * Gets the hole level of the ship
   * @return the hole level of the ship
   */
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

  /*
   * Gets the amount of travel until the ship sinks
   * @return the amount of travel until the ship sinks
   */
  public int getTravelUntilSink(){
    return this.travelUntilSink;
  }

  /*
   * Checks if the ship can travel
   * @return true if the ship can travel
   */
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
