//File: Port.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 06-07-2023
package Encounters;

import static Globals.Tools.*;
import static Globals.Constants.*;
import java.util.*;
import Encounters.subEncounters.*;
import Humans.Player;

public class Port extends Encounter{
  String name;
  SupplyStore store;
  Tavern tavern;
  Dockyard dock;
  int storeIndex, tavernIndex, dockIndex = -1;

  /*
   * Constructor for a new Port
   * @param index the index of the port
   */
  public Port(int index){
    String[] data = getFromCSVRow(PORTSCSV,"Ports.java",INDEX, toStr(index));
    index = toInt(data[0]);
    name = data[1];
    storeIndex = toInt(data[2]);
    tavernIndex = toInt(data[3]);
    dockIndex = toInt(data[4]);
    viewed = toBool(data[5]);
    if(storeIndex != -1){
      store = new SupplyStore(true,storeIndex);
    }
    if(tavernIndex != -1){
      tavern = new Tavern(true,tavernIndex);
    }
    if(dockIndex != -1){
      dock = new Dockyard(true,dockIndex);
    }
  }

  /*
   * Constructor for a new Port
   * @param name the name of the port
   * @param full whether the port has all sub encounters
   */
  public Port(Boolean full, int level) {
    name = "Nassau";
    this.level = level;
    if(full){
      store = new SupplyStore(false,MINLEVEL);
      tavern = new Tavern(false,MINLEVEL);
      dock = new Dockyard(false,MINLEVEL);
      storeIndex = store.getIndex();
      tavernIndex = tavern.getIndex();
      dockIndex = dock.getIndex();
    } else {
      while(true){
        if(generateSubEncounters(generateLevel(level),generateLevel(level),generateLevel(level))){
          break;
        }
      }
    }
    viewed = false;
    writeToCSV(PORTSCSV,"Port.java",true,PORTSHEADER,PORTSFORMAT,name,level,storeIndex, tavernIndex, dockIndex,toStr(viewed));
  }

  /*
   * The Port Environment
   * @param player the player
   */
  public void enter(Player player){
    while(true){
      lineBreaker("Port");
      pr("You have entered The ");
      pr("Level " + getLevelText(), LEVELCOLOUR);
      pr(" Port",ENCOUNTERCOLOUR);
      prln(" of " + name);

      pr("This port has a ");
      
      if(store != null){
        pr("Level " + store.getLevelText(), LEVELCOLOUR);
        pr(" Supply Store", ENCOUNTERCOLOUR);
      }
      if(store != null && tavern != null && dock != null){
        pr(", ");
      }
      if(store != null && tavern != null && dock == null){
        pr(", and a ");
      }
      if(tavern != null){
        pr("Level " + tavern.getLevelText(), LEVELCOLOUR);
        pr(" Tavern",ENCOUNTERCOLOUR);
      }
      if((store != null || tavern != null) && dock != null){
        pr(", and a ");
      }
      if(dock != null){
        pr("Level " + dock.getLevelText(), LEVELCOLOUR);
        pr(" Dockyard",ENCOUNTERCOLOUR);
      }
  
      prln(".");
      prln("Where would you like to go?");
      printSubEncounters();
      int input = askIn();
      int choice = enterSubEncounter(player, input);
      if(choice == 0 || choice == MENUEXIT){ //If entered menu or sub encounter reload Port interaction
        continue;
      } else if(choice == 1){ //If left port leave it
        break;
      }
    }
  }

  /*
   * Generates the random sub encounters for the port
   * @param Slevel the level of the supply store
   * @param Tlevel the level of the tavern
   * @param Dlevel the level of the dockyard
   * @return whether the port has any sub encounters
   */
  public boolean generateSubEncounters(int Slevel, int Tlevel, int Dlevel){
    Random rand = new Random();
    
    //Calling the nextBoolean() method twice to get a greater change of generating
    //a port with more than one sub-encounter
    if(rand.nextBoolean()) {
      store = new SupplyStore(false,Slevel);
      storeIndex = store.getIndex();
    } else if(rand.nextBoolean()) {
      store = new SupplyStore(false,Slevel);
      storeIndex = store.getIndex();
    }

    if(rand.nextBoolean()) {
      tavern = new Tavern(false,Tlevel);
      tavernIndex = tavern.getIndex();
    } else if(rand.nextBoolean()) {
      tavern = new Tavern(false,Tlevel);
      tavernIndex = tavern.getIndex();
    }

    if(rand.nextBoolean()) {
      dock = new Dockyard(false,Dlevel);
      dockIndex = dock.getIndex();
    }

    if(store == null && tavern == null && dock == null){
      return false;
    } else {
      return true;
    }
  }

  /*
   * Prints the sub encounters of the port to be selected by the player
   */
  public void printSubEncounters(){
    if(store != null){
      pr("1. ");
      pr("Supply Store",ENCOUNTERCOLOUR);
      prln(" (Buy Crew Packs, food packs, and sell goods)");
    }

    if(tavern != null){
      pr("2. ");
      pr("Tavern",ENCOUNTERCOLOUR);
      prln(" (Hire Crew, and get into fights)");
    }

    if(dock != null){
      pr("3. ");
      pr("Dockyard",ENCOUNTERCOLOUR);
      prln(" (Buy Ship Packs, Buy a new ship, upgrade your ship, or repair your ship)");
    }

    pr("Q. Leave ");
    pr("Port",ENCOUNTERCOLOUR);
    prln(" on your Ship");
  }

  /*
   * Enters the sub encounter of the port
   * @param player the player
   * @param sub the sub encounter to enter
   * @return an int representing a sub encounter, leaving the port, or a menu action taken
   */
  public int enterSubEncounter(Player player,int input){ 
    if(input == 1){
      if(store != null){
        store.enter(player);
        return 0;
      } else {
        pr("There is no ");
        pr("Supply Store",ENCOUNTERCOLOUR); 
        prln("here.");
        return enterSubEncounter(player,askIn());
      }
    } else if(input == 2){
      if(tavern != null){
        tavern.enter(player);
        return 0;
      } else {
        pr("There is no ");
        pr("Tavern",ENCOUNTERCOLOUR); 
        prln(" here.");
        return enterSubEncounter(player,askIn());
      }
    } else if(input == 3){
      if(dock != null){
        dock.enter(player);
        return 0;
      } else {
        pr("There is no ");
        pr("Dockyard",ENCOUNTERCOLOUR); 
        prln(" here.");
        return enterSubEncounter(player,askIn());
      }
    } else if(input == QUIT){
      prln("You leave the Port on your Ship.");
      return 1;
    } else if(input == MENUEXIT){
      return input;
    } else {
      invalOp();
      return enterSubEncounter(player,askIn());
    }
  }

  public String getType(){
    return PORT;
  }
}
