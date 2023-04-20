//File: Player.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 04-19-2023
package Humans;

import static Globals.Tools.*;
import static Globals.Constants.*;
import Ships.PlayerShip;

public class Player extends Human{
  int gold;
  String name;
  PlayerShip ship;

  /*
   * Constructor to reload player data from CSV 
   * Used for loading a saved game
   */
  public Player(){
    String[] playerData = getFromCSVRow(PLAYERCSV, "Player.java",INDEX, "0");
    name = playerData[1];
    level = toInt(playerData[2]);
    health = toInt(playerData[3]);
    gold = toInt(playerData[4]);
    ship = new PlayerShip();
  }

  /*
   * Constructor to create a new player
   * @param name the player's name
   */
  public Player(String name){
    this.name = name;
    level = STARTINGLEVEL;
    health = STARTINGHEALTH;
    gold = STARTINGGOLD;
    ship = new PlayerShip();
    writeToCSV(PLAYERCSV,"Player.java", false, PLAYERHEADER,PLAYERFORMAT, 
        name, level, health, gold, -1,-1,-1,-1,-1);
  }

  /*
   * Gets the player's name
   * @return the player's name
   */
  public String getName() {
    return name;
  }

  /*
   * Gets the player's gold
   * @return the player's gold
   */
  public int getGold() {
    return gold;
  }

  /*
   * Removes gold from the amount of gold the player has
   * @param amount the amount of gold to be removed
   */
  public void spendGold(int amount){
    gold -= amount;
    writeToCSVValue(PLAYERCSV, "Player.java", INDEX, "0", GOLD, toStr(gold));
  }

  /*
   * Adds gold to the amount of gold the player has
   * @param amount the amount of gold to be added
   */
  public void earnGold(int amount){
    gold += amount;
    writeToCSVValue(PLAYERCSV, "Player.java", INDEX, "0", GOLD, toStr(gold));
  }

  /*
   * Gets this player's ship
   * @return the player's PlayerShip
   */
  public PlayerShip getShip(){
    return ship;
  }
}
