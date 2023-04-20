//File: Bartender.java
//Author: MrFuzzyPants
//Created: 04-11-2023
//Modified: 04-19-2023
package Humans;

import static Globals.Tools.*;
import static Globals.Constants.*;

public class Bartender extends NPC {
  private boolean blackMarket;
  
  public Bartender(boolean reload,int levelOrIndex){
    if(reload){
      String[] data = getFromCSVRow(BARTENDERSCSV, "Bartender.java",INDEX, toStr(levelOrIndex));
      index = levelOrIndex;
      fname = data[1];
      lname = data[2];
      level = toInt(data[3]);
      health = toInt(data[4]);
      blackMarket = toBool(data[5]);
    } else {
      boolean isEnglish = generateRand();
      fname = generateFirstName(isEnglish);
      lname = generateLastName(isEnglish);
      level = levelOrIndex;
      health = STARTINGHEALTH;
      if(levelOrIndex == MAXLEVEL){
        blackMarket = true;
      } else {
        blackMarket = false;
      }

      writeToCSV(BARTENDERSCSV,"Bartender.java", true, BARTENDERSHEADER,BARTENDERSFORMAT, 
          fname, lname, level, health, toStr(blackMarket));
      index = getFromCSVLastIndex(BARTENDERSCSV, "Bartender.java");
    }
  }

  public boolean getBlackMarket(){
    return blackMarket;
  }
}
