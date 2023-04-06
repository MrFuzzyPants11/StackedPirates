//File: Pack.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023
package Cards.Packs;

import java.util.*;

public abstract class Pack {
  int cost;
  int rarity;
  int index;
  ArrayList<Integer> cRarities = new ArrayList<Integer>();
  
  public abstract String getName();

  // public ArrayList<Card> openPack(){
  //   return cards;
  // }

  public int getCost(){
    return cost;
  }

  public int getIndex(){
    return index;
  }

  public String getRarity(){
    if(rarity == 0){
      return "Common";
    }
    
    if(rarity == 1){
      return "Uncommon";
    }
    
    if(rarity == 2){
      return "Rare";
    }
    
    if(rarity == 3){
      return "Epic";
    }
    return "legendary";
  }

  public String getColour(){
    if(rarity == 0){
      return "";
    }
    if(rarity == 1){
      return "36";
    }

    if(rarity == 2){
      return "35";
    }

    if(rarity == 3){
      return "33";
    }
    return "RAINBOWBABY";
  }

  protected void generatePack(int rarity){
    Random rand = new Random();
    int additionalCost = (rand.nextInt(101)/10) * 10;
    cost = 100 + (rarity * 100) + additionalCost;
    if(rarity == 0){
      for(int i = 0; i < 5; i++){
        cRarities.add(0);
      }
    } else if(rarity == 1){
      cRarities.add(1);
      if(rand.nextBoolean()){
        cRarities.add(1);
      } else {
        cRarities.add(0);
      }
      for(int i = 1; i <= 3; i++){
        cRarities.add(0);
      }
    } else {
      cRarities.add(rarity);
      if(rand.nextBoolean()){
        cRarities.add(rarity);
      } else {
        cRarities.add(rarity - 1);
      }
      for(int i = 1; i <= 3; i++){
        cRarities.add(rand.nextInt(rarity));
      }
    }
  }
}