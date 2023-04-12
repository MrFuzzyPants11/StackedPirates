//File: ShipCard.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-10-2023
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
      this.index = toInt(data[0]);
      this.rarity = toInt(data[1]);
      this.name = data[2];
      this.effect = new ShipEffect(toInt(data[3]));
    } else {
      this.rarity = rarityOrIndex;
      this.name = "TEST SHIP";
      this.effect = new ShipEffect(rarityOrIndex);
      writeToCSV(SHIPCARDSCSV, "ShipCard.java", true, SHIPCARDSHEADER, SHIPCARDSFORMAT, rarity, this.name,rarity);
      this.index = getFromCSVLastIndex(SHIPCARDSCSV, "ShipCard.java");
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
