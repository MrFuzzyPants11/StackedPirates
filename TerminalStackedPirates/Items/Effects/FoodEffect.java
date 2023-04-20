//File: FoodEffect.java
//Author: MrFuzzyPants
//Created: 04-09-2023
//Modified: 04-10-2023
package Items.Effects;

import static Globals.Tools.*;
import static Globals.Constants.*;

public class FoodEffect extends Effect{
  private int healthRestored;

  public FoodEffect(int index){
    String[] data = getFromCSVRow(FOODEFFECTS, "FoodEffect.java", INDEX, toStr(index));
    index = toInt(data[0]);
    rarity = toInt(data[1]);
    description = data[2];
    healthRestored = toInt(data[3]);
  }

  public String getType(){
    return FOOD;
  }

  public String getName(){
    return "Food Effect";
  }

  public int getHealthRestored(){
    return healthRestored;
  }
}
