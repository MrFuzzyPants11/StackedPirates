//File: PlayerShip.java
//Author: MrFuzzyPants
//Created: 04-04-2023
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
    level = toInt(data[1]);
    toughness = toInt(data[2]);
    repairs = toInt(data[3]);
    travelUntilSink = toInt(data[4]);
    holeLevel = toInt(data[5]);
    cards = new ArrayList<ShipCard>();
    for(int i = 6; i < data.length; i++){
      if(toInt(data[i]) != -1){
        cards.add(new ShipCard(true, toInt(data[i])));
      }
    }
  }
  /*
   * Gets the number of repairs the PlayerShip has
   * @return the repairs
   */
  public int getRepairs(){
    return repairs;
  }

  /*
   * Adds one repair kit to the ship
   * @param int the amount of repairs to add
   */
  public void addRepairs(int added){
    repairs += added;
    writeToCSVValue(PLAYERSHIPCSV,"PlayerShip.java",INDEX,"0",REPAIRS,toStr(repairs));
  }

  /*
   * Reduces the number of Repairs by the amount used
   * @param int the amount being used
   * @return true if able to remove that many repairs
   * @return false if unable to remove that many repairs
   */
  public boolean reduceRepairs(int used){
    if(repairs < used){
      writeToCSVValue(PLAYERSHIPCSV,"PlayerShip.java",INDEX,"0",REPAIRS,toStr(repairs));
      return false;
    }
    repairs -= used;
    return true;
  }

  /*
   * Gets the hole level of the ship
   * @return the hole level of the ship
   */
  public int getHoleLevel(){
    return holeLevel;
  }

  /*
   * Checks if the ship has enough health to not have holes
   * @return true if the ship has enough health to not have holes
   * @return false if the ship has enough damage to have holes
   */
  public boolean hasHoles(){
    boolean hasHoles = false;
    if(toughness <= ((level * 100) * 0.25)){
      travelUntilSink = 1;
      holeLevel = 3;
      hasHoles = true;
    }

    if(toughness <= ((level * 100) * 0.5)){
      travelUntilSink = 2;
      holeLevel = 2;
      hasHoles = true;
    }

    if(toughness <= ((level * 100) * 0.75)){
      travelUntilSink = 3;
      holeLevel = 1;
      hasHoles = true;
    } else {
      travelUntilSink = 4;
      holeLevel = 0;
      hasHoles = false;
    }
    writeToCSVValue(PLAYERSHIPCSV,"PlayerShip.java",INDEX,"0",TRAVELUNTILSINK,toStr(travelUntilSink));
    writeToCSVValue(PLAYERSHIPCSV,"PlayerShip.java",INDEX,"0",HOLELEVEL,toStr(holeLevel));
    return hasHoles;
  }

  /*
   * Gets the amount of travel until the ship sinks
   * @return the amount of travel until the ship sinks
   */
  public int getTravelUntilSink(){
    return travelUntilSink;
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

  /*
   * Upgrades the ship's level and adds in new toughness
   */
  public void upgrade(){
    level += 1;
    toughness += 100;
    writeToCSVValue(PLAYERSHIPCSV,"PlayerShip.java",INDEX,"0",LEVEL,toStr(level));
    writeToCSVValue(PLAYERSHIPCSV,"PlayerShip.java",INDEX,"0",TOUGHNESS,toStr(toughness));
  }
}
