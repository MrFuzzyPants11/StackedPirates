//File: Card.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023
package Items.Cards;

import Items.Item;
import static Globals.Constants.*;

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
    return CARD;
  }
}
