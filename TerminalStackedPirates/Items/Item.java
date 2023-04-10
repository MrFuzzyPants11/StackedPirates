//File: Pack.java
//Author: MrFuzzyPants
//Created: 05-07-2023
//Modified: 04-08-2023
package Items;

import static Globals.Constants.*;
import static Globals.Tools.*;

public abstract class Item {
  protected int rarity;
  protected int index;

  /*
   * Gets the index of the item
   * @return the index of the item
   */
  public int getIndex(){
    return index;
  }

  /*
   * Gets the name of the item
   * @return the name of the item
   */
  public abstract String getName();

  /*
   * Gets the type of the item
   * @return the type of the item
   */
  public abstract String getType();

  /*
   * Gets the item type of the item (pack or card)
   * @return the item type of the item
   */
  public abstract String getItemType();

  /*
   * Converts the rarity number of an item to a string
   * @return the rarity of the item as a string
   */
  public String getRarityText(){
    if(rarity == COMMONNUM){
      return firstCap(COMMON);
    }
    
    if(rarity == UNCOMMONNUM){
      return firstCap(UNCOMMON);
    }
    
    if(rarity == RARENUM){
      return firstCap(RARE);
    }
    
    if(rarity == EPICNUM){
      return firstCap(EPIC);
    }
    return firstCap(LEGENDARY);
  }

  /*
   * Converts the rarity number of an item to a string
   * @return the rarity of the item as a string
   */
  public String getRarity(){
    if(rarity == COMMONNUM){
      return COMMON;
    }
    
    if(rarity == UNCOMMONNUM){
      return UNCOMMON;
    }
    
    if(rarity == RARENUM){
      return RARE;
    }
    
    if(rarity == EPICNUM){
      return EPIC;
    }
    return LEGENDARY;
  }

  /*
   * Converts the rarity number of an item to an ANSI colour code
   * @return the rarity of the item as a ANSI colour code
   */
  public String getColour(){
    if(rarity == 0){
      return COMMONCOLOUR;
    }
    if(rarity == 1){
      return UNCOMMONCOLOUR;
    }

    if(rarity == 2){
      return RARECOLOUR;
    }

    if(rarity == 3){
      return EPICCOLOUR;
    }
    return LEGENDARYCOLOUR;
  }
}
