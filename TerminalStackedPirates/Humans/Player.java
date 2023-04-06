//File: Player.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023
package Humans;

import java.util.*;
import Cards.Packs.*;
import Cards.Cards.*;
import static Globals.Tools.*;

public class Player extends Human{
  int gold;
  

  public Player(){
    String[] playerData = getFromCSVRow("player", "Player.java", "Index", "0");
    this.fname = playerData[1];
    this.lname = playerData[2];
    this.level = toInt(playerData[3]);
    this.health = toInt(playerData[4]);
    this.gold = toInt(playerData[5]);
    this.cards = new ArrayList<CrewCard>();
    String[] cardNames = playerData[6].split(",");
    for(int i = 0; i < cardNames.length; i++){
      this.cards.add(new CrewCard(0));
    }
  }

  public Player(String fname, String lname){
    this.fname = fname;
    this.lname = lname;
    this.level = 1;
    this.health = 20;
    this.cards = new ArrayList<CrewCard>();
    this.gold = 500;

    writeToCSV("player","Player.java", false, "Fname,Lname,Level,Health,Gold,Cards","%s,%s,%d,%d,%d,%s", 
        this.fname, this.lname, this.level, this.health, this.gold, this.cards.toString());
  }

  public void addToInventory(Pack pack){
    writeToCSV("player","Player.java", true, "Pack,Card,IndexOfItem","%d,%d,%d", 
        1,0,pack.getIndex());
  }

  public void addToInventory(Card card){
    writeToCSV("player","Player.java", true, "Pack,Card,IndexOfItem","%d,%d,%d", 
        0,1,card.getIndex());
  }

  public int getGold() {
    return this.gold;
  }

  public void spendGold(int amount){
    this.gold -= amount;
    writeToCSVValue("player", "Player.java", "Index", "0", "Gold", toStr(this.gold));
  }
}
