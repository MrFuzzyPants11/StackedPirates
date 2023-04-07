//File: FoodCard.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Items.Cards;

import static Globals.Tools.*;

public class FoodCard extends Card{
  /*
   * Constructor for a new FoodCard
   */
  public FoodCard(int rarity){
    this.rarity = rarity;
    this.name = "TESTFOOD";

    writeToCSV("allcards", "FoodCard.java", true, "Type,Rarity,Name", "%s,%d,%s", "Food", this.rarity, this.name);
    this.index = getFromCSVLastIndex("allCards", "FoodCard.java");
  }

  /*
   * Gets the type of the card
   * @return the type of the card
   */
  public String getType(){
    return "Food";
  }
}
