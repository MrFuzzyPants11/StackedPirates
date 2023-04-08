//File: ShipCard.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Items.Cards;

import static Globals.Tools.*;

public class ShipCard extends Card{
  
  /*
   * Constructor for a new ShipCard
   */
  public ShipCard(boolean reload, int rarityOrIndex){
    rarity = rarityOrIndex;
    this.name = "TESTSHIP";

    writeToCSV("allcards", "ShipCard.java", true, "Type,Rarity,Name", "%s,%d,%s", "Ship", rarity, name);
    this.index = getFromCSVLastIndex("allCards", "ShipCard.java");
  }

  /*
   * Gets the type of the card
   * @return the type of the card
   */
  public String getType(){
    return "ship";
  }
}
