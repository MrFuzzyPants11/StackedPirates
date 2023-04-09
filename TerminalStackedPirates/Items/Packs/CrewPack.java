//File: CrewPack.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023
package Items.Packs;

import static Globals.Tools.*;
import java.util.ArrayList;
import static Globals.Constants.*;

public class CrewPack extends Pack{
  /*
   * Constructor for a new CrewPack
   */
  public CrewPack(boolean reload, int rarityOrIndex){
    if(reload){
      String[] data = getFromCSVRow(ALLPACKSCSV, "CrewPack.java", INDEX, toStr(rarityOrIndex));
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
      generatePack(rarity,"CrewPack.java", CREW);
      this.index = getFromCSVLastIndex(ALLPACKSCSV, "CrewPack.java");
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
    return CREW;
  }
}
