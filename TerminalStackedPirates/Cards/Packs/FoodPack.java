//File: FoodPack.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023
package Cards.Packs;

import static Globals.Tools.*;

public class FoodPack extends Pack{
  public FoodPack(int rarity){
    this.rarity = rarity;
    generatePack(rarity);
    writeToCSV("allpacks", "FoodCard.java", true, "Type,Rarity,Cost,CRarity0,CRarity1,CRarity2,CRarity3,CRarity4", "%s,%d,%d,%d,%d,%d,%d,%d", "Food",this.rarity,this.cost,
    cRarities.get(0), cRarities.get(1), cRarities.get(2), cRarities.get(3), cRarities.get(4));
    this.index = getFromCSVLastIndex("allpacks", "FoodPack.java");
  }

  public String getName(){
    return "Food Pack";
  }
}