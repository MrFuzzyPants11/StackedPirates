//File: CrewList.java
//Author: MrFuzzyPants
//Created: 04-18-2023
//Modified: 04-18-2023
package Globals.PlayerAttributes;

import static Globals.Tools.*;
import static Globals.Constants.*;
import Humans.Crew;
import java.util.ArrayList;

public abstract class CrewList {
  /*
   * Gets the crew of the player
   * @return the crew of the player
   */
  public static ArrayList<Crew> getCrew(){
    ArrayList<Crew> crew = new ArrayList<Crew>();
    String[] data = getFromCSVRow(CREWLISTCSV,"CrewList.java",INDEX, "0");
    if(data == null){
      writeToCSV(CREWLISTCSV,"CrewList.java",false,CREWLISTHEADER,CREWLISTFORMAT,-1,-1,-1,-1,-1);
      return crew;
    }

    for(int i = 1; i < data.length; i++){
      int temp = toInt(data[i]);
      if(temp != -1){
        crew.add(new Crew(true,temp));
      }
    }
    return crew;
  }

  /*
   * Adds a crew member to the ship
   * @param crew the crew member to add
   */
  public static Boolean addCrew(Crew crewMember){
    ArrayList<Crew> crew = getCrew();
    if(crew.size() < 5){
      crew.add(crewMember);
      for(int i = 0; i < crew.size(); i++){
        writeToCSVValue(CREWLISTCSV, "CrewList.java", INDEX, "0", "crew" + i, toStr(crew.get(i).getIndex()));
      }
      return true;
    }
    return false;
  }

  /*
   * Removes a crew member from the ship
   * @param index the index of the crew member to remove
   */
  public static Boolean removeCrew(int index){
    ArrayList<Crew> crew = getCrew();
    if(index < crew.size()){
      crew.remove(index);
      for(int i = 0; i < 5; i++){
        if(crew.size() <= i){
          writeToCSVValue(CREWLISTCSV, "PlayerShip.java", INDEX, "0", "crew" + i, toStr(-1));
        } else {
          writeToCSVValue(CREWLISTCSV, "PlayerShip.java", INDEX, "0", "crew" + i, toStr(crew.get(i).getIndex()));
        }
      }
      return true;
    }
    return false;
  }
}
