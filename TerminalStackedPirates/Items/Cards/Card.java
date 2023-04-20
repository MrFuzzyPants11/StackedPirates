//File: Card.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 04-19-2023
package Items.Cards;

import Items.Item;
import Items.Effects.*;

import static Globals.Constants.*;

public abstract class Card extends Item{
  String name;
  Effect effect;
  
  /*
   * Gets the name of the card
   * @return the name of the card
   */
  public String getName(){
    return name;
  }

  /*
   * Gets the effect of the card
   * @return the effect of the card
   */
  public Effect getEffect(){
    return effect;
  }

  /*
   * Gets that this is a card type
   * @return "card"
   */
  public String getItemType(){
    return CARD;
  }
}
