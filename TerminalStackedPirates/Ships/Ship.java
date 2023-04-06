//File: Ship.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023
package Ships;

import java.util.*;
import Cards.*;
import Cards.Cards.Card;
import Cards.Cards.ShipCard;

public abstract class Ship {
  int size;
  ArrayList<ShipCard> cards; 
  int repairs;
  int toughness; 
  
  public int getSize() {
    return this.size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public ArrayList<ShipCard> getCards() {
    return this.cards;
  }

  public boolean addCard(ShipCard newCard) {
    if(cards.size() < size){
      this.cards.add(newCard);
      return true;
    } else {
      return false;
    }
  }

  public void removeCard(Card card) {
    cards.remove(card);
  }

  public void setRepairs(int repairs) {
    this.repairs = repairs;
  }

  public int getRepairs(){
    return this.repairs;
  }

  public void reduceRepairs(int used){
    this.repairs -= used;
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
