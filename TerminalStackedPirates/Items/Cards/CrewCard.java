//File: CrewCard.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023
package Items.Cards;

import static Globals.Tools.*;

import Items.Effects.CrewEffect;

import static Globals.Constants.*;


public class CrewCard extends Card {

  /*
   * Constructor for a new CrewCard
   */
  public CrewCard(boolean reload,int rarityOrIndex){
    if(reload){
      String[] data = getFromCSVRow(ALLCARDSCSV, "CrewPack.java", INDEX, toStr(rarityOrIndex));
      this.index = toInt(data[0]);
      this.rarity = toInt(data[2]);
      this.name = data[3];
      this.effect = new CrewEffect(toInt(data[4]));
    } else {
      this.name = "TEST CREW";
      this.rarity = rarityOrIndex;
      this.effect = new CrewEffect(rarityOrIndex);
      writeToCSV(ALLCARDSCSV, "CrewCard.java", true, ALLCARDSHEADER, ALLCARDSFORMAT, CREW,rarity, this.name,rarity);
      this.index = getFromCSVLastIndex(ALLCARDSCSV, "CrewCard.java");
    }
  }

  /*
   * Gets the type of the card
   * @return the type of the card
   */
  public String getType(){
    return CREW;
  }
}
