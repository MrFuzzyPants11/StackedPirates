//File: Player.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Humans;

import java.util.*;

import Items.Item;
import Items.Cards.*;
import static Globals.Tools.*;

public class Player extends Human{
  int gold;
  
  /*
   * Constructor to reload player data from CSV
   * Used for loading a saved game
   */
  public Player(){
    String[] playerData = getFromCSVRow("player", "Player.java", "Index", "0");
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
    this.level = 1;
    this.health = 20;
    this.cards = new ArrayList<CrewCard>();
    this.gold = 1500;

    writeToCSV("player","Player.java", false, "Fname,Lname,Level,Health,Gold,Cards","%s,%s,%d,%d,%d,%s", 
        this.fname, this.lname, this.level, this.health, this.gold, this.cards.toString());
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
    writeToCSVValue("player", "Player.java", "Index", "0", "Gold", toStr(this.gold));
  }
}
