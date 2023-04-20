//File: ShipCard.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 04-19-2023
package Items.Cards;

import static Globals.Tools.*;

import Items.Effects.ShipEffect;

import static Globals.Constants.*;

public class ShipCard extends Card{
  
  /*
   * Constructor for a new ShipCard
   */
  public ShipCard(boolean reload, int rarityOrIndex){
    if(reload){
      String[] data = getFromCSVRow(SHIPCARDSCSV, "ShipPack.java", INDEX, toStr(rarityOrIndex));
      index = toInt(data[0]);
      rarity = toInt(data[1]);
      name = data[2];
      effect = new ShipEffect(toInt(data[3]));
    } else {
      rarity = rarityOrIndex;
      name = "TEST SHIP";
      effect = new ShipEffect(rarityOrIndex);
      writeToCSV(SHIPCARDSCSV, "ShipCard.java", true, SHIPCARDSHEADER, SHIPCARDSFORMAT, rarity, name,rarity);
      index = getFromCSVLastIndex(SHIPCARDSCSV, "ShipCard.java");
    }
  }

  /*
   * Gets the type of the card
   * @return the type of the card
   */
  public String getType(){
    return SHIP;
  }
}
