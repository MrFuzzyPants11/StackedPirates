//File: Card.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Items.Cards;

import Items.Item;

public abstract class Card extends Item{
  String name;

  /*
   * Gets the name of the card
   * @return the name of the card
   */
  public String getName(){
    return name;
  }

  /*
   * Gets that this is a card type
   * @return "card"
   */
  public String getItemType(){
    return "card";
  }
}
