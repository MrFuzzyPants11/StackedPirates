//File: CrewCard.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-10-2023
package Items.Cards;

import static Globals.Tools.*;

import Items.Effects.CrewEffect;

import static Globals.Constants.*;


public class CrewCard extends Card {
  private String crewType;
  /*
   * Constructor for a new CrewCard
   */
  public CrewCard(boolean reload,int rarityOrIndex){
    if(reload){
      String[] data = getFromCSVRow(CREWCARDSCSV, "CrewPack.java", INDEX, toStr(rarityOrIndex));
      index = toInt(data[0]);
      rarity = toInt(data[1]);
      name = data[2];
      crewType = data[3]; 
      effect = new CrewEffect(toInt(data[4]));
    } else {
      name = "TEST CREW";
      rarity = rarityOrIndex;
      effect = new CrewEffect(rarityOrIndex);
      int temptype = generateRand(5);
      if(temptype == 0){
        crewType = ONEHANDEDWEAPON;
      } else if(temptype == 1){
        crewType = TWOHANDEDWEAPON;
      } else if(temptype == 2){
        crewType = HAT;
      } else if(temptype == 3){
        crewType = TUNIC;
      } else if(temptype == 4){
        crewType = PANTS;
      }
      writeToCSV(CREWCARDSCSV, "CrewCard.java", true, CREWCARDSHEADER, CREWCARDSFORMAT, rarity, name,crewType,rarity);
      index = getFromCSVLastIndex(CREWCARDSCSV, "CrewCard.java");
    }
  }

  /*
   * Gets the type of the card
   * @return the type of the card
   */
  public String getType(){
    return CREW;
  }

  /*
   * Gets the crew type of the card
   * @return the crew type of the card
   */
  public String getCrewType(){
    return crewType;
  }
  
}
