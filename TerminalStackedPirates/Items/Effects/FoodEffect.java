//File: Tools.java
//Author: MrFuzzyPants
//Created: 04-09-2023
//Modified: 04-09-2023
package Items.Effects;

import static Globals.Tools.*;
import static Globals.Constants.*;

public class FoodEffect extends Effect{
  private int healthRestored;

  public FoodEffect(int index){
    String[] data = getFromCSVRow(FOODEFFECTCSV, "FoodEffect.java", INDEX, toStr(index));
    this.index = toInt(data[0]);
    this.rarity = toInt(data[1]);
    this.description = data[2];
    this.healthRestored = toInt(data[3]);
  }

  public String getType(){
    return FOOD;
  }

  public String getName(){
    return "Food Effect";
  }

  public int getHealthRestored(){
    return this.healthRestored;
  }
}
