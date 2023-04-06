//File: ShipPack.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023
package Cards.Packs;

import static Globals.Tools.*;

public class ShipPack extends Pack{
  public ShipPack(int rarity){
    this.rarity = rarity;
    generatePack(rarity);
    writeToCSV("allpacks", "ShipCard.java", true, "Type,Rarity,Cost,Card1,Card2,Card3,Card4,Card5", "%s,%d,%d,%d,%d,%d,%d,%d", "Ship",this.rarity,this.cost,
    cRarities.get(0), cRarities.get(1), cRarities.get(2), cRarities.get(3), cRarities.get(4));
    this.index = getFromCSVLastIndex("allpacks", "ShipPack.java");
  }

  public String getName(){
    return "Ship Pack";
  }
}
