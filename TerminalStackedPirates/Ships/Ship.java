//File: Ship.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-19-2023
package Ships;

import java.util.*;
import Items.Cards.Card;
import Items.Cards.ShipCard;

public abstract class Ship {
  int level;
  ArrayList<ShipCard> cards; 
  int toughness; 
  
  public int getLevel() {
    return level;
  }

  public ArrayList<ShipCard> getCards() {
    return cards;
  }

  public boolean addCard(ShipCard newCard) {
    if(cards.size() < level){
      cards.add(newCard);
      return true;
    } else {
      return false;
    }
  }

  public void removeCard(Card card) {
    cards.remove(card);
  }

  public void setToughness(int toughness) {
    this.toughness = toughness;
  }

  public int getToughness(){
    return toughness;
  }

  public void reduceToughness(int damage){
    toughness -= damage;
  }

  public void increaseToughness(int toughtnessGained){
    toughness += toughtnessGained;
  }
}
