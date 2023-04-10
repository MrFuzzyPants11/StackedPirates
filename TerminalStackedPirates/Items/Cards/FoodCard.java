//File: FoodCard.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023
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
      String[] data = getFromCSVRow(ALLCARDSCSV, "FoodPack.java", INDEX, toStr(rarityOrIndex));
      this.index = toInt(data[0]);
      this.rarity = toInt(data[2]);
      this.name = data[3];
      this.effect = new FoodEffect(toInt(data[4]));
    } else {
      this.rarity = rarityOrIndex;
      this.name = "TEST FOOD";
      this.effect = new FoodEffect(rarityOrIndex);
      writeToCSV(ALLCARDSCSV, "FoodCard.java", true, ALLCARDSHEADER, ALLCARDSFORMAT, FOOD, rarity, this.name,rarity);
      this.index = getFromCSVLastIndex(ALLCARDSCSV, "FoodCard.java");
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
