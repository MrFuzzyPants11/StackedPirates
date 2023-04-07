//File: CrewPack.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Items.Packs;

import static Globals.Tools.*;
import java.util.ArrayList;

public class CrewPack extends Pack{
  /*
   * Constructor for a new CrewPack
   */
  public CrewPack(boolean reload, int rarityOrIndex){
    if(reload){
      String[] data = getFromCSVRow("allpacks", "CrewPack.java", "Index", "" + rarityOrIndex);
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
      generatePack(rarity,"CrewPack.java", "Crew");
      this.index = getFromCSVLastIndex("allpacks", "CrewPack.java");
    }
  }

  /*
   * Gets the name of the pack
   * @return the name of the pack
   */
  public String getName(){
    return "Crew Pack";
  }

  /*
   * Gets the type of the pack
   * @return the type of the pack
   */
  public String getType(){
    return "Crew";
  }
}
