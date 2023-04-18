//File: Player.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023
package Humans;

import static Globals.Tools.*;
import static Globals.Constants.*;

public class Player extends Human{
  int gold;
  String name;

  /*
   * Constructor to reload player data from CSV
   * Used for loading a saved game
   */
  public Player(){
    String[] playerData = getFromCSVRow(PLAYERCSV, "Player.java",INDEX, "0");
    this.name = playerData[1];
    this.level = toInt(playerData[2]);
    this.health = toInt(playerData[3]);
    this.gold = toInt(playerData[4]);
  }

  /*
   * Constructor to create a new player
   * @param name the player's name
   */
  public Player(String name){
    this.name = name;
    this.level = STARTINGLEVEL;
    this.health = STARTINGHEALTH;
    this.gold = STARTINGGOLD;
    writeToCSV(PLAYERCSV,"Player.java", false, PLAYERHEADER,PLAYERFORMAT, 
        this.name, this.level, this.health, this.gold, -1,-1,-1,-1,-1);
  }

  /*
   * Gets the player's name
   * @return the player's name
   */
  public String getName() {
    return this.name;
  }

  /*
   * Gets the player's gold
   * @return the player's gold
   */
  public int getGold() {
    return this.gold;
  }

  /*
   * Removes gold from the amount of gold the player has
   * @param amount the amount of gold to be removed
   */
  public void spendGold(int amount){
    this.gold -= amount;
    writeToCSVValue(PLAYERCSV, "Player.java", INDEX, "0", GOLD, toStr(this.gold));
  }
}
