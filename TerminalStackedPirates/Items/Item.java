//File: Pack.java
//Author: MrFuzzyPants
//Created: 05-07-2023
//Modified: 05-07-2023
package Items;

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
  public String getRarity(){
    if(rarity == 0){
      return "Common";
    }
    
    if(rarity == 1){
      return "Uncommon";
    }
    
    if(rarity == 2){
      return "Rare";
    }
    
    if(rarity == 3){
      return "Epic";
    }
    return "legendary";
  }

  /*
   * Converts the rarity number of an item to an ANSI colour code
   * @return the rarity of the item as a ANSI colour code
   */
  public String getColour(){
    if(rarity == 0){
      return "";
    }
    if(rarity == 1){
      return "36";
    }

    if(rarity == 2){
      return "35";
    }

    if(rarity == 3){
      return "33";
    }
    return "RAINBOWBABY"; // If item is legendary return custom rainbow colour code
  }
}
