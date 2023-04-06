//File: Player.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023

package Humans;

import java.util.*;
import Cards.*;
import Cards.Cards.CrewCard;
import static Globals.Tools.*;

public class Player extends Human{
  int gold;
  
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

  public int getGold() {
    return this.gold;
  }

  public void spendGold(int amount){
    this.gold -= amount;
  }
}
