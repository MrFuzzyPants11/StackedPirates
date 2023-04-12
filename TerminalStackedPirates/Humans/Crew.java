//File: Crew.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-11-2023
package Humans;

import static Globals.Tools.*;
import static Globals.Constants.*;
import Items.Cards.CrewCard;

public class Crew extends NPC {
  public Crew(boolean reload, int levelOrIndex){
    if(reload){
      String[] data = getFromCSVRow(ALLCREWSCSV, "Crew.java",INDEX, toStr(levelOrIndex));
      this.index = levelOrIndex;
      this.fname = data[1];
      this.lname = data[2];
      this.level = toInt(data[4]);
      this.health = toInt(data[5]);

      for(int i = 6; toInt(data[i]) != -1 && i < data.length; i++){
        equipCard(new CrewCard(true, toInt(data[i])));
      }

    } else {
      boolean isEnglish = generateRand();
      this.fname = generateFirstName(isEnglish);
      this.lname = generateLastName(isEnglish);
      this.level = levelOrIndex;
      this.health = STARTINGHEALTH;

      writeToCSV(ALLCREWSCSV,"Crew.java", true, ALLCREWSHEADER,ALLCREWSFORMAT, 
          this.fname, this.lname, FALSE, this.level, this.health,-1,-1,-1,-1,-1);
      this.index = getFromCSVLastIndex(ALLCREWSCSV, "Crew.java");
    }
  }
}
