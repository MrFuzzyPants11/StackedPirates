//File: Bartender.java
//Author: MrFuzzyPants
//Created: 05-11-2023
//Modified: 04-16-2023
package Humans;

import static Globals.Tools.*;
import static Globals.Constants.*;

public class Bartender extends NPC {
  private boolean blackMarket;
  
  public Bartender(boolean reload,int levelOrIndex){
    if(reload){
      String[] data = getFromCSVRow(BARTENDERSCSV, "Bartender.java",INDEX, toStr(levelOrIndex));
      this.index = levelOrIndex;
      this.fname = data[1];
      this.lname = data[2];
      this.level = toInt(data[3]);
      this.health = toInt(data[4]);
      this.blackMarket = toBool(data[5]);
    } else {
      boolean isEnglish = generateRand();
      this.fname = generateFirstName(isEnglish);
      this.lname = generateLastName(isEnglish);
      this.level = levelOrIndex;
      this.health = STARTINGHEALTH;
      if(levelOrIndex == MAXLEVEL){
        blackMarket = true;
      } else {
        blackMarket = false;
      }

      writeToCSV(BARTENDERSCSV,"Bartender.java", true, BARTENDERSHEADER,BARTENDERSFORMAT, 
          this.fname, this.lname, this.level, this.health, toStr(this.blackMarket));
      this.index = getFromCSVLastIndex(BARTENDERSCSV, "Bartender.java");
    }
  }

  public boolean getBlackMarket(){
    return blackMarket;
  }
}
