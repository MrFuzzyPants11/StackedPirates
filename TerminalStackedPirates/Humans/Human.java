//File: Human.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023
package Humans;

import java.util.*;
import Cards.*;
import Cards.Cards.Card;
import Cards.Cards.CrewCard;

public abstract class Human {
  int level;
  int health;
  ArrayList<CrewCard> cards;
  String fname;
  String lname;


  public int addCard(CrewCard newCard) {
    if(cards.size() < level){
      for(Card card : cards){
        if(card.getClass().isInstance(newCard)){
          return 1;
        }
      }
      this.cards.add(newCard);
      return 0;
    }
    return 2;
  }

  public void removeCard(CrewCard oldCard) {
    this.cards.remove(oldCard);
  }

  public int getLevel() {
    return this.level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getHealth() {
    return this.health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void reduceHealth(int damage){
    this.health -= damage;
  }

  public ArrayList<CrewCard> getCards() {
    return this.cards;
  }

  public String getFname() {
    return this.fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return this.lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

}
