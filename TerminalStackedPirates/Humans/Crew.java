//File: Crew.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-11-2023
package Humans;

import static Globals.Tools.*;
import static Globals.Constants.*;
import Items.Cards.CrewCard;

public class Crew extends NPC {
  private int cost;
  private boolean inTavern;

  public Crew(boolean reload, int levelOrIndex){
    if(reload){
      String[] data = getFromCSVRow(CREWSCSV, "Crew.java",INDEX, toStr(levelOrIndex));
      index = levelOrIndex;
      fname = data[1];
      lname = data[2];
      level = toInt(data[4]);
      health = toInt(data[5]);
      cost = toInt(data[6]);
      inTavern = toBool(data[7]);

      for(int i = 8; toInt(data[i]) != -1 && i < data.length; i++){
        equipCard(new CrewCard(true, toInt(data[i])));
      }

    } else {
      boolean isEnglish = generateRand();
      fname = generateFirstName(isEnglish);
      lname = generateLastName(isEnglish);
      level = levelOrIndex;
      health = STARTINGHEALTH;
      cost = 10 + generateRand(11);
      inTavern = true;

      writeToCSV(CREWSCSV,"Crew.java", true, ALLCREWSHEADER,ALLCREWSFORMAT, 
          fname, lname, FALSE, level, health,cost,inTavern,-1,-1,-1,-1,-1);
      index = getFromCSVLastIndex(CREWSCSV, "Crew.java");
    }
  }

  /*
   * Gets the Crew Member's cost
   * @return the Crew Member's cost
   */
  public int getCost(){
    return cost;
  }

  /*
   * Sets the Crew Member's cost
   * @param cost the Crew Member's cost
   */
  public void setCost(int cost){
    this.cost = cost;
  }

  /*
   * Gets the Crew Member's inTavern stat
   * @return the Crew Member's inTavern
   */
  public boolean getInTavern(){
    return inTavern;
  }

  /*
   * Sets the Crew Member's inTavern stat
   * @param inTavern the Crew Member's inTavern
   */
  public void setInTavern(boolean inTavern){
    this.inTavern = inTavern;
  }
}
