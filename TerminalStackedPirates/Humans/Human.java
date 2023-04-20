//File: Human.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023
package Humans;

import java.util.ArrayList;
import Items.Cards.CrewCard;

public abstract class Human {
  int level;
  int health;
  ArrayList<CrewCard> equippedCards = new ArrayList<CrewCard>();

  /*
   * Gets the human's level for print purposes, AKA level + 1
   * @return the human's level + 1
   */
  public int getLevelText() {
    return level + 1;
  }

  /*
   * Gets the human's actual level
   * @return the human's level
   */
  public int getLevel() {
    return level;
  }

  /*
   * Gets the human's health
   * @return the human's health
   */
  public int getHealth() {
    return health;
  }

  /*
   * Reduces the human's health
   * @param damage the amount of damage to be taken
   */
  public void reduceHealth(int damage){
    health -= damage;
  }

  /*
   * Saves the inputted crew card to the human's equipped cards
   * @param card the crew card to be saved
   * @return true if the card was saved, false if the card was not saved
   */
  public boolean equipCard(CrewCard card){
    for(int i = 0; i < equippedCards.size(); i++){
      if(card.getCrewType().equals(equippedCards.get(i).getCrewType())){
        return false;
      }
    }
    equippedCards.add(card);
    return true;
  }

  /*
   * Removes the inputted crew card from the human's equipped cards
   * @param card the crew card to be removed
   */
  public void unequipCard(CrewCard card){
    equippedCards.remove(card);
  }

  /*
   * Gets the human's equipped cards
   * @return the human's equipped cards
   */
  public ArrayList<CrewCard> getEquippedCards(){
    return equippedCards;
  }
}
