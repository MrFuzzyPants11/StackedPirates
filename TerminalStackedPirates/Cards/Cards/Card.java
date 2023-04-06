//File: Card.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023
package Cards.Cards;

public abstract class Card {
  int rarity;
  String name;
  int index;


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
  
  public String getName(){
    return name;
  }

  public String getEffect(){
    return effect;
  }

  public int getIndex(){
    return index;
  }
}
