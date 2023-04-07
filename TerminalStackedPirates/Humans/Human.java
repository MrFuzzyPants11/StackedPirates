//File: Human.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Humans;

import java.util.*;

import Items.Cards.Card;
import Items.Cards.CrewCard;

public abstract class Human {
  int level;
  int health;
  ArrayList<CrewCard> cards;
  String fname;
  String lname;


  /*
   * Adds a card to the humans's deck
   * @param newCard the card to be added
   */
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

  /*
   * Removes a card from the human's deck
   * @param oldCard the card to be removed
   */
  public void removeCard(CrewCard oldCard) {
    this.cards.remove(oldCard);
  }

  /*
   * Gets the human's level
   * @return the human's level
   */
  public int getLevel() {
    return this.level;
  }

  /*
   * Gets the human's health
   * @return the human's health
   */
  public int getHealth() {
    return this.health;
  }

  /*
   * Reduces the human's health
   * @param damage the amount of damage to be taken
   */
  public void reduceHealth(int damage){
    this.health -= damage;
  }

  /*
   * Gets the human's deck
   * @return the human's deck
   */
  public ArrayList<CrewCard> getCards() {
    return this.cards;
  }

  /*
   * Gets the human's first name
   * @return the human's first name
   */
  public String getFname() {
    return this.fname;
  }

  /*
   * Gets the human's last name
   * @return the human's last name
   */
  public String getLname() {
    return this.lname;
  }
}
