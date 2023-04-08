//File: ShipPack.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Items.Packs;

import static Globals.Tools.*;
import java.util.ArrayList;

public class ShipPack extends Pack{
  /*
   * Constructor for a new ShipPack
   */
  public ShipPack(boolean reload, int rarityOrIndex){
    if(reload){
      String[] data = getFromCSVRow("allpacks", "ShipPack.java", "Index", toStr(rarityOrIndex));
      this.index = toInt(data[0]);
      this.sold = toBool(data[2]);
      this.rarity = toInt(data[3]);
      this.cost = toInt(data[4]);
      cRarities = new ArrayList<Integer>();
      for(int i = 5; i < data.length; i++){
        cRarities.add(toInt(data[i]));
      }
    } else {
      this.rarity = rarityOrIndex;
      generatePack(rarity,"ShipPack.java", "ship");
      this.index = getFromCSVLastIndex("allpacks", "ShipPack.java");
    }
  }

  /*
   * Gets the name of the pack
   * @return the name of the pack
   */
  public String getName(){
    return "Ship Pack";
  }

  /*
   * Gets the type of the pack
   * @return the type of the pack
   */
  public String getType(){
    return "ship";
  }
}