//File: Human.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023

package Humans;

import java.util.*;
import Cards.*;

public abstract class Human {
  int level;
  int health;
  ArrayList<Card> cards;
  String fname;
  String lname;


  public boolean addCard(Card newCard) {
    if(cards.size() < level){
      if(newCard instanceof OneHandedTool){
        for(Card card : cards){
          if(card instanceof OneHandedTool){
            return false;
          }
        }
      } else if(newCard instanceof TwoHandedTool){
        for(Card card : cards){
          if(card instanceof TwoHandedTool){
            return false;
          }
        }
      }
      this.cards.add(newCard);
      return true;
    } else {
      return false;
    }
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

  public ArrayList<Card> getCards() {
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
