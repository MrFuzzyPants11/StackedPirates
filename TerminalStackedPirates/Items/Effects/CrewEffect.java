//File: CrewEffect.java
//Author: MrFuzzyPants
//Created: 04-09-2023
//Modified: 04-10-2023
package Items.Effects;

import static Globals.Tools.*;
import static Globals.Constants.*;

public class CrewEffect extends Effect{
  public CrewEffect(int index){
    String[] data = getFromCSVRow(CREWEFFECTS, "CrewEffect.java", INDEX, toStr(index));
    index = toInt(data[0]);
    rarity = toInt(data[1]);
    description = data[2];
  }

  public String getType(){
    return CREW;
  }

  public String getName(){
    return "Crew Effect";
  }
}
