//File: Effect.java
//Author: MrFuzzyPants
//Created: 04-09-2023
//Modified: 04-10-2023
package Items.Effects;

import Items.Item;
import static Globals.Constants.*;

public abstract class Effect extends Item{
  String description;

  public String getDescription(){
    return description;
  }

  public String getItemType(){
    return EFFECT;
  }
}
