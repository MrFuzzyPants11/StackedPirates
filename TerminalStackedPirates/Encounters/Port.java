//File: Port.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023
package Encounters;

import static Globals.Tools.*;
import java.util.*;
import Encounters.subEncounters.*;

public class Port extends Encounter{
  SupplyStore store;
  Tavern tavern;
  Dockyard dock;

  public Port(Boolean full) {
    if(full){
      store = new SupplyStore(1);
      tavern = new Tavern();
      dock = new Dockyard();
    } else {
      while(true){
        if(generateSubEncounters(1,1,1)){
          break;
        }
      }
    }
  }

  public Port(Boolean full, int Slevel, int Tlevel, int Dlevel) {
    if(full){
      store = new SupplyStore(Slevel);
      tavern = new Tavern();
      dock = new Dockyard();
    } else {
      while(true){
        if(generateSubEncounters(Slevel,Tlevel,Dlevel)){
          break;
        }
      }
    }
  }

  public void enter(){
    while(true){
      lineBreaker();
      prln("You have entered a port.");
      pr("This port has a ");
      
      if(store != null){
        pr("Supply Store");
      }
      if(store != null && (tavern != null || dock != null)){
        pr(", ");
      }
      if(store != null && tavern != null && dock == null){
        pr(", and a ");
      }
      if(tavern != null){
        pr("Tavern");
      }
      if((store != null || tavern != null) && dock != null){
        pr(", and a ");
      }
      if(dock != null){
        pr("Dockyard");
      }
  
      prln(".");
      prln("Where would you like to go?");
      this.printSubEncounters();
      int input = askIn();
      if(input == 4){
        break;
      } else {
        this.enterSubEncounter(input);
      }
    }
  }

  public boolean generateSubEncounters(int Slevel, int Tlevel, int Dlevel){
    Random rand = new Random();
    int subs = 0;
    if(rand.nextBoolean()) {
      store = new SupplyStore(Slevel);
      subs++;
    }

    if(rand.nextBoolean()) {
      tavern = new Tavern();
      subs++;
    }

    if(rand.nextBoolean()) {
      dock = new Dockyard();
      subs++;
    }

    return subs > 0;
  }

  public void printSubEncounters(){
    if(store != null){
      prln("1. Supply Store (Buy Crew Packs, food packs, and sell goods)");
    }

    if(tavern != null){
      prln("2. Tavern (Hire Crew, and get into fights)");
    }

    if(dock != null){
      prln("3. Dockyard (Buy Ship Packs, Buy a new ship, upgrade your ship, or repair your ship)");
    }

    prln("4. Leave Port on your Ship");
  }

  public void enterSubEncounter(int sub){ 
    if(sub == 1){
      if(store != null){
        prln("You enter the Supply Store.");
        store.enter();
      } else {
        prln("There is no Supply Store here.");
        this.enterSubEncounter(askIn());
      }
    } else if(sub == 2){
      if(tavern != null){
        prln("You enter the Tavern.");
        tavern.enter();
      } else {
        prln("There is no Tavern here.");
        this.enterSubEncounter(askIn());
      }
    } else if(sub == 3){
      if(dock != null){
        prln("You enter the Dockyard.");
        dock.enter();
      } else {
        prln("There is no Dockyard here.");
        this.enterSubEncounter(askIn());
      }
    } else {
      invalOp();
      this.enterSubEncounter(askIn());
    }
  }
}
