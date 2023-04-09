//File: Player.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023
package Humans;

import static Globals.Tools.*;
import static Globals.Constants.*;

public class Player extends Human{
  int gold;
  
  /*
   * Constructor to reload player data from CSV
   * Used for loading a saved game
   */
  public Player(){
    String[] playerData = getFromCSVRow(PLAYERCSV, "Player.java",INDEX, "0");
    this.fname = playerData[1];
    this.lname = playerData[2];
    this.level = toInt(playerData[3]);
    this.health = toInt(playerData[4]);
    this.gold = toInt(playerData[5]);
  }

  /*
   * Constructor to create a new player
   * @param fname the player's first name
   * @param lname the player's last name
   */
  public Player(String fname, String lname){
    this.fname = fname;
    this.lname = lname;
    this.level = STARTINGLEVEL;
    this.health = STARTINGHEALTH;
    this.gold = STARTINGGOLD;

    writeToCSV(PLAYERCSV,"Player.java", false, PLAYERHEADER,PLAYERFORMAT, 
        this.fname, this.lname, this.level, this.health, this.gold, 0,0,0,0,0);
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
