//File: ShipEffect.java
//Author: MrFuzzyPants
//Created: 04-09-2023
//Modified: 04-19-2023
package Items.Effects;

import static Globals.Tools.*;
import static Globals.Constants.*;

public class ShipEffect extends Effect{

  public ShipEffect(int index){
    String[] data = getFromCSVRow(SHIPEFFECTS, "ShipEffect.java", INDEX, toStr(index));
    index = toInt(data[0]);
    rarity = toInt(data[1]);
    description = data[2];
  }

  public String getType(){
    return SHIP;
  }

  public String getName(){
    return "Ship Effect";
  }
}
