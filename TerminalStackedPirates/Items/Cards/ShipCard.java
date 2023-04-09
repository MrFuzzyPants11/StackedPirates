//File: ShipCard.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023
package Items.Cards;

import static Globals.Tools.*;
import static Globals.Constants.*;

public class ShipCard extends Card{
  
  /*
   * Constructor for a new ShipCard
   */
  public ShipCard(boolean reload, int rarityOrIndex){
    if(reload){
      String[] data = getFromCSVRow(ALLCARDSCSV, "CrewPack.java", INDEX, toStr(rarityOrIndex));
      this.index = toInt(data[0]);
      this.rarity = toInt(data[2]);
      this.name = data[3];
    } else {
      this.rarity = rarityOrIndex;
      this.name = "TESTSHIP";
      writeToCSV(ALLCARDSCSV, "ShipCard.java", true, ALLCARDSHEADER, ALLCARDSFORMAT, SHIP, rarity, this.name);
      this.index = getFromCSVLastIndex(ALLCARDSCSV, "ShipCard.java");
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
