//File: Tavern.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023
package Encounters.subEncounters;

import Items.Cards.FoodCard;
import Items.Packs.FoodPack;
import static Globals.Constants.*;
import static Globals.Tools.*;
import java.util.ArrayList;
import Humans.*;

public class Tavern extends SubEncounter{
  ArrayList<Crew> TavernPatrons;
  String name;
  Bartender bartender;
  ArrayList<FoodPack> foodPacks;
  private final String[] tavernTypes = {"Pub","Bar","Tavern","Cantina","Saloon","Beach Club", "Ale House", "Lounge", "Canteen", "Tavern", "Speakeasy", "Beer Hole", "Brewery"};
  
  /*
   * Constructor for a new Tavern
   * @param reload whether the encounter is being reloaded
   * @param levelOrIndex the level of the encounter or the index of the encounter if being reloaded
   */
  public Tavern(boolean reload, int levelOrIndex){
    if(reload){
      String[] data = getFromCSVRow(TAVERNSCSV,"Tavern.java",INDEX, toStr(levelOrIndex));
      index = toInt(data[0]);
      name = data[1];
      level = toInt(data[2]);
      bartender = new Bartender(true, toInt(data[3]));
      foodPacks = new ArrayList<FoodPack>();
      for(int i = 4;  i < 9; i++){
        foodPacks.add(new FoodPack(true, toInt(data[i])));
      }

      TavernPatrons = new ArrayList<Crew>();
      for(int i = 9; toInt(data[i]) != -1 && i < data.length; i++){
        TavernPatrons.add(new Crew(true, toInt(data[i])));
      }
    } else {
      level = levelOrIndex;
      name = generateFirstName(generateRand()) + "'s " + tavernTypes[generateRand(13)];
      bartender = new Bartender(false, generateLevel(levelOrIndex));

      foodPacks = new ArrayList<FoodPack>();
      for(int i = 0; i < 5; i++){
        foodPacks.add(new FoodPack(false, generateLevel(levelOrIndex)));
      }

      TavernPatrons = new ArrayList<Crew>();
      int numPatrons = generateRand((levelOrIndex + 1) * 5);
      if(numPatrons > 15 || levelOrIndex == MAXLEVEL){
        numPatrons = 15;
      } else if(numPatrons < 5){
        numPatrons = 5;
      }

      for(int i = 0; i < numPatrons; i++){
        TavernPatrons.add(new Crew(false, generateLevel(levelOrIndex)));
      }

      writeToCSV(TAVERNSCSV,"Tavern.java",true,TAVERNSHEADER,TAVERNSFORMAT,name, level,bartender.getIndex(),foodPacks.get(0).getIndex(),foodPacks.get(1).getIndex(),foodPacks.get(2).getIndex(),
      foodPacks.get(3).getIndex(),foodPacks.get(4).getIndex(),-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1);
      this.index = getFromCSVLastIndex(TAVERNSCSV,"Tavern.java");

      for(int i = 0; i < TavernPatrons.size() - 1; i++){
        writeToCSVValue(TAVERNSCSV,"Tavern.java",INDEX,toStr(this.index), "crewindex" + i, toStr(TavernPatrons.get(i).getIndex()));
      }
    }
  }



  /*
   * The Tavern Environment
   * @param player the player
   */
  public void enter(Player player){
    lineBreaker("Tavern");
    pr("You enter ");
    pr(name, ENCOUNTERCOLOUR);
    prln(".");
    while(true){
      prln("Who would you like to talk to?");
      prln("1. Bartender");
      prln("2. Patrons");
      prln("Q. Leave");
      int input = askIn();
      if(input == QUIT){
        break;
      } else if(input == 1){
        talkToBartender(player);
        continue;
      } else if(input == 2){
        talkToPatrons(player);
        continue;
      } else {
        invalOp();
        continue;
      }
    }
  }

  /*
   * Talk to the bartender
   * @param player the player
   */
  public void talkToBartender(Player player){
    prln("Hey there Captain! What can I get you?");
  }

  /*
   * Talk to the patrons
   * @param player the player
   */
  public void talkToPatrons(Player player){
    prln("You look around the room and see: ");
    for(int i = 0; i < TavernPatrons.size(); i++){
      prln((i + 1) + ". " + TavernPatrons.get(i).getFname() + " " + TavernPatrons.get(i).getLname());
    }
  }
}
