//File: CardPack.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023

package Cards.Packs;

import java.util.*;

import Cards.Cards.Card;

public abstract class Pack {
  int cost = 50;
  int rarity;
  ArrayList<Card> cards;

  protected abstract void generatePack(int rarity);
  
  public abstract String getName();

  public ArrayList<Card> openPack(){
    return cards;
  }

  public int getCost(){
    return cost;
  }

  public String getRarity(){
    if(rarity == 0){
      return "Common";
    } else if(rarity == 1){
      return "Uncommon";
    } else if(rarity == 2){
      return "Rare";
    } else if(rarity == 3){
      return "Epic";
    } else if(rarity == 4){
      return "Legendary";
    } else {
      return "ERROR";
    }
  }

  public String getColour(){
    if(rarity == 0){
      return "";
    }
    if(rarity == 1){
      return "36";
    } else if(rarity == 2){
      return "35";
    } else if(rarity == 3){
      return "33";
    }
    return "RAINBOWBABY";
  }
}