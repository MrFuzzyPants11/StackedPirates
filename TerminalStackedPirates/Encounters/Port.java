//File: Port.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Encounters;

import static Globals.Tools.*;
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
    String[] data = getFromCSVRow("ports","Ports.java","Index", toStr(index));
    this.index = toInt(data[0]);
    this.name = data[1];
    this.storeIndex = toInt(data[2]);
    this.tavernIndex = toInt(data[3]);
    this.dockIndex = toInt(data[4]);
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
  public Port(String name, Boolean full) {
    this.name = name;
    if(full){
      store = new SupplyStore(false,1);
      tavern = new Tavern(false,1);
      dock = new Dockyard(false,1);
      storeIndex = store.getIndex();
      tavernIndex = tavern.getIndex();
      dockIndex = dock.getIndex();
    } else {
      Random rand = new Random();
      while(true){
        if(generateSubEncounters(rand.nextInt(4) + 1,rand.nextInt(4) + 1,rand.nextInt(4) + 1)){
          break;
        }
      }
    }
    writeToCSV("ports","Port.java",true,"Name,SupplyStore,Tavern,Dockyard","%s,%d,%d,%d",name,storeIndex, tavernIndex, dockIndex);
  }

  /*
   * The Port Environment
   * @param player the player
   */
  public void enter(Player player){
    while(true){
      lineBreaker(" Port ");
      pr("You have entered The ");
      pr("Port","34");
      prln(" of " + name);

      pr("This port has a ");
      
      if(store != null){
        pr("Level " + store.getLevel(), "35");
        pr(" Supply Store", "34");
      }
      if(store != null && tavern != null && dock != null){
        pr(", ");
      }
      if(store != null && tavern != null && dock == null){
        pr(", and a ");
      }
      if(tavern != null){
        pr("Level " + tavern.getLevel(), "35");
        pr(" Tavern","34");
      }
      if((store != null || tavern != null) && dock != null){
        pr(", and a ");
      }
      if(dock != null){
        pr("Level " + dock.getLevel(), "35");
        pr(" Dockyard","34");
      }
  
      prln(".");
      prln("Where would you like to go?");
      this.printSubEncounters();
      int input = askIn();
      int choice = this.enterSubEncounter(player, input);
      if(choice == 0 || choice == Integer.MIN_VALUE){ //If entered menu or sub encounter reload Port interaction
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
      this.store = new SupplyStore(false,Slevel);
      storeIndex = store.getIndex();
    } else if(rand.nextBoolean()) {
      this.store = new SupplyStore(false,Slevel);
      storeIndex = store.getIndex();
    }

    if(rand.nextBoolean()) {
      this.tavern = new Tavern(false,Tlevel);
      tavernIndex = tavern.getIndex();
    } else if(rand.nextBoolean()) {
      this.tavern = new Tavern(false,Tlevel);
      tavernIndex = tavern.getIndex();
    }

    if(rand.nextBoolean()) {
      this.dock = new Dockyard(false,Dlevel);
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
      pr("Supply Store","34");
      prln(" (Buy Crew Packs, food packs, and sell goods)");
    }

    if(tavern != null){
      pr("2. ");
      pr("Tavern","34");
      prln(" (Hire Crew, and get into fights)");
    }

    if(dock != null){
      pr("3. ");
      pr("Dockyard","34");
      prln(" (Buy Ship Packs, Buy a new ship, upgrade your ship, or repair your ship)");
    }

    pr("4. Leave ");
    pr("Port","34");
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
        prln("There is no Supply Store here.");
        return this.enterSubEncounter(player,askIn());
      }
    } else if(input == 2){
      if(tavern != null){
        tavern.enter(player);
        return 0;
      } else {
        prln("There is no Tavern here.");
        return this.enterSubEncounter(player,askIn());
      }
    } else if(input == 3){
      if(dock != null){
        dock.enter(player);
        return 0;
      } else {
        prln("There is no Dockyard here.");
        return this.enterSubEncounter(player,askIn());
      }
    } else if(input == 4){
      prln("You leave the Port on your Ship.");
      return 1;
    } else if(input == Integer.MIN_VALUE){
      return input;
    } else {
      invalOp();
      return this.enterSubEncounter(player,askIn());
    }
  }
}
