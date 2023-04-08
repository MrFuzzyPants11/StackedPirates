//File: CrewCard.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Items.Cards;

import static Globals.Tools.*;

public class CrewCard extends Card {

  /*
   * Constructor for a new CrewCard
   */
  public CrewCard(boolean reload,int rarityOrIndex){
    rarity = rarityOrIndex;
    this.name = "TESTCREW";
    writeToCSV("allcards", "CrewCard.java", true, "Type,Rarity,Name", "%s,%d,%s", "Crew",rarity, this.name);
    this.index = getFromCSVLastIndex("allCards", "CrewCard.java");
  }

  /*
   * Gets the type of the card
   * @return the type of the card
   */
  public String getType(){
    return "crew";
  }
}
