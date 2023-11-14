//File: OpenOcean.java
//Author: MrFuzzyPants
//Created: 04-19-2023
//Modified: 11-13-2023
package Encounters;

import static Globals.Constants.*;
import static Globals.Tools.*;
import Humans.Player;

public class Ocean extends Encounter{
  public Ocean(Boolean reload, int levelOrIndex){
    if(reload){
      String[] data = getFromCSVRow(OCEANCSV,"Ocean.java",INDEX,toStr(levelOrIndex));
      index = levelOrIndex;
      viewed = toBool(data[1]);
    } else {
      writeToCSV(OCEANCSV,"Ocean.java",true,OCEANHEADER,OCEANFORMAT,FALSE);
      index = getFromCSVLastIndex(OCEANCSV, "Ocean.java");
    }
  }
  public String getType(){
    return OCEAN;
  }
  public char getSymbol(){
    return OCEANSYMBOL;
  }
  public void enter(Player player){
    enterProgressUpdates("Ocean.java",OCEAN,this.index);
  }

  /*
   * Sets the viewedness of an Encounter
   */
  public void viewEncounter(){
    writeToCSVValue(OCEANCSV,"Ocean.java",INDEX,toStr(index),VIEWED,TRUE);
    viewed = true;
  }
}
