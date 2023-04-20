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
    return this.level;
  }

  public ArrayList<ShipCard> getCards() {
    return this.cards;
  }

  public boolean addCard(ShipCard newCard) {
    if(cards.size() < level){
      this.cards.add(newCard);
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
    return this.toughness;
  }

  public void reduceToughness(int damage){
    this.toughness -= damage;
  }

  public void increaseToughness(int toughtnessGained){
    this.toughness += toughtnessGained;
  }
}
