//File: FoodCard.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 04-19-2023
package Items.Cards;

import static Globals.Tools.*;

import Items.Effects.FoodEffect;

import static Globals.Constants.*;

public class FoodCard extends Card{
  /*
   * Constructor for a new FoodCard
   */
  public FoodCard(boolean reload, int rarityOrIndex){
    if(reload){
      String[] data = getFromCSVRow(FOODCARDSCSV, "FoodCard.java", INDEX, toStr(rarityOrIndex));
      index = toInt(data[0]);
      rarity = toInt(data[1]);
      name = data[2];
      effect = new FoodEffect(toInt(data[3]));
    } else {
      rarity = rarityOrIndex;
      name = "TEST FOOD";
      effect = new FoodEffect(rarityOrIndex);
      writeToCSV(FOODCARDSCSV, "FoodCard.java", true, FOODCARDSHEADER, FOODCARDSFORMAT, rarity, name,rarity);
      index = getFromCSVLastIndex(FOODCARDSCSV, "FoodCard.java");
    }
  }

  /*
   * Gets the type of the card
   * @return the type of the card
   */
  public String getType(){
    return FOOD;
  }
}
