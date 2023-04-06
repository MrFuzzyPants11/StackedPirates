//File: ShipCard.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023
package Cards.Cards;

import static Globals.Tools.*;

public class ShipCard extends Card{
  public ShipCard(int rarity){
    this.rarity = rarity;
    this.name = "TESTSHIP";

    writeToCSV("allcards", "ShipCard.java", true, "Type,Rarity,Name", "%s,%d,%s", "Ship", this.rarity, this.name);
    this.index = getFromCSVLastIndex("allCards", "ShipCard.java");
  }
}
