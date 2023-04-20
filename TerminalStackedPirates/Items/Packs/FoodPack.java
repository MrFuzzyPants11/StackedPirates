//File: FoodPack.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023
package Items.Packs;

import static Globals.Tools.*;
import java.util.ArrayList;
import static Globals.Constants.*;

public class FoodPack extends Pack{
  /*
   * Constructor for a new FoodPack
   */
  public FoodPack(boolean reload, int rarityOrIndex){
    if(reload){
      String[] data = getFromCSVRow(PACKSCSV, "FoodPack.java", INDEX, toStr(rarityOrIndex));
      this.index = toInt(data[0]);
      this.sold = toBool(data[2]);
      this.opened = toBool(data[3]);
      this.rarity = toInt(data[4]);
      this.cost = toInt(data[5]);
      cRarities = new ArrayList<Integer>();
      for(int i = 6; i < data.length; i++){
        cRarities.add(toInt(data[i]));
      }
    } else {
      this.rarity = rarityOrIndex;
      generatePack(rarity,"FoodPack.java", FOOD);
      cost -= 100;
      this.index = getFromCSVLastIndex(PACKSCSV, "FoodPack.java");
    }
  }

  /*
   * Gets the name of the pack
   * @return the name of the pack
   */
  public String getName(){
    return "Food Pack";
  }

  /*
   * Gets the type of the pack
   * @return the type of the pack
   */
  public String getType(){
    return FOOD;
  }
}