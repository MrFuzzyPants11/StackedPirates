//File: Tavern.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 06-10-2023
package Encounters.subEncounters;

import Items.Packs.FoodPack;
import static Globals.Constants.*;
import static Globals.PlayerAttributes.Inventory.*;
import static Globals.PlayerAttributes.CrewList.*;
import static Globals.Tools.*;
import java.util.ArrayList;
import Humans.*;
import Encounters.Encounter;

public class Tavern extends Encounter{
  ArrayList<Crew> tavernPatrons;
  String name;
  Bartender bartender;
  ArrayList<FoodPack> foodPacks;
  
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

      tavernPatrons = new ArrayList<Crew>();
      for(int i = 9; toInt(data[i]) != -1 && i < data.length; i++){
        tavernPatrons.add(new Crew(true, toInt(data[i])));
      }
    } else {
      level = levelOrIndex;
      name = generateFirstName(generateRand()) + "'s " + TAVERNTYPES[generateRand(TAVERNTYPES.length)];
      bartender = new Bartender(false, generateLevel(levelOrIndex));

      foodPacks = new ArrayList<FoodPack>();
      for(int i = 0; i < 5; i++){
        foodPacks.add(new FoodPack(false, generateLevel(levelOrIndex)));
      }

      tavernPatrons = new ArrayList<Crew>();
      int numPatrons = generateRand((levelOrIndex + 1) * 5);
      if(numPatrons > 15 || levelOrIndex == MAXLEVEL){
        numPatrons = 15;
      } else if(numPatrons < 5){
        numPatrons = 5;
      }

      for(int i = 0; i < numPatrons; i++){
        tavernPatrons.add(new Crew(false, generateLevel(levelOrIndex)));
      }

      writeToCSV(TAVERNSCSV,"Tavern.java",true,TAVERNSHEADER,TAVERNSFORMAT,name, level,bartender.getIndex(),foodPacks.get(0).getIndex(),foodPacks.get(1).getIndex(),foodPacks.get(2).getIndex(),
      foodPacks.get(3).getIndex(),foodPacks.get(4).getIndex(),-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1);
      index = getFromCSVLastIndex(TAVERNSCSV,"Tavern.java");

      for(int i = 0; i < tavernPatrons.size() - 1; i++){
        writeToCSVValue(TAVERNSCSV,"Tavern.java",INDEX,toStr(index), "crewindex" + i, toStr(tavernPatrons.get(i).getIndex()));
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
    prln("You approach the bar.");
    while(true){
      prln("Hey there Captain! What can I get you?");
      for(int i = 0; i < foodPacks.size(); i++){
        if(!foodPacks.get(i).getSold()){
          pr((i + 1) + ". " + foodPacks.get(i).getName() + " ");
          pr(firstCap(foodPacks.get(i).getRarityText()), foodPacks.get(i).getColour());
          prln(" - " + foodPacks.get(i).getCost() + " gold");
        }
      }
      // if(bartender.getBlackMarket()){
      //   prln("B. See what I have around back"); // To be implemented later
      // }
      prln("Q. Leave the bar");
      pr("You have ");
      pr(player.getGold() + " Gold", GOLDCOLOUR);
      prln(".");
      prln("Which pack would you like to buy?");
      int input = askIn();
      if(input == QUIT){
        prln("You walk away from the bar.");
        break;
      } else {
        if(input == MENUEXIT){
          continue;
        }
        input -= 1;
        if(foodPacks.get(input).getCost() > player.getGold()){
          prln("You do not have enough gold to buy this pack.",RED);
        } else if(foodPacks.get(input).getSold()){
          prln("A pack so good you'd buy it twice?\n\t\tyou can't though sorry.\n");
        } else {
          pr("Are you sure you want to buy a ");
          pr(firstCap(foodPacks.get(input).getRarityText()), foodPacks.get(input).getColour());
          pr(" " + foodPacks.get(input).getName() + " for ");
          prln(foodPacks.get(input).getCost() + " gold?", GOLDCOLOUR);
          prln(toStr(input + 1) + ". Yes");
          prln("Q. No");
          int oldInput = input;
          input = askIn();
          if(input == (oldInput + 1)){
            player.spendGold(foodPacks.get(oldInput).getCost());
            addToInventory(foodPacks.get(oldInput));
            foodPacks.get(oldInput).sellPack();
          }
        }
      }
    }
  }

  /*
   * Talk to the patrons
   * @param player the player
   */
  public void talkToPatrons(Player player){
    while(true){
      prln("You look around the room and see: ");
      for(int i = 0; i < tavernPatrons.size(); i++){
        if(tavernPatrons.get(i).getInTavern()){
          pr((i + 1) + ". " + tavernPatrons.get(i).getFname() + " " + tavernPatrons.get(i).getLname() + " - ");
          pr(tavernPatrons.get(i).getCost() + " Gold", GOLDCOLOUR);
          prln(" per travel.");
        }
      }
      prln("Q. no one.");
      prln("Who would you like to ask to join your crew?");
      int input = askIn();
      if(input == QUIT){
        break;
      } else if(input == MENUEXIT){
        continue;
      } else if(input > tavernPatrons.size()){
        invalOp();
        continue;
      }
      input -= 1;
      prln("You walk over to " + tavernPatrons.get(input).getFname() + " " + tavernPatrons.get(input).getLname() + "and ask them to join your crew.");
      prln("\"" + JOINCREW[generateRand(JOINCREW.length)] + "\" They reply.");
      boolean added = addCrew(tavernPatrons.get(input));
      if(added){
        prln("They agree to join your crew, but they will leave if you can't pay them!");
        tavernPatrons.get(input).setInTavern(false);
        sleep(1000);
      } else {
        while(true){
          prln("They agree to join your crew, but you don't have enough room on your ship for them!");
          prln("Would you like to remove a crew member to add them?");
          ArrayList<Crew> curCrew = getCrew();
          for(int i = 0; i < curCrew.size(); i++){
            pr((i + 1) + ". " + curCrew.get(i).getFname() + " " + curCrew.get(i).getLname() + " - ");
            pr(curCrew.get(i).getCost() + " Gold", GOLDCOLOUR);
            prln(" per travel.");
          }
          prln("Q. Revoke your offer to " + tavernPatrons.get(input).getFname() + " " + tavernPatrons.get(input).getLname() + ".");
          prln("Who would you like to remove from your crew?");
          int input2 = askIn();
          if(input2 == QUIT){
            prln("You revoke your offer to " + tavernPatrons.get(input).getFname() + " " + tavernPatrons.get(input).getLname() + ".");
            break;
          } else if(input2 > tavernPatrons.size()){
            invalOp();
            continue;
          } else {
            input2 -= 1;
            prln("Are you sure you want to remove " + curCrew.get(input2).getFname() + " " + curCrew.get(input2).getLname() + " from your crew?");
            prln("1. Yes");
            prln("Q. No");
            int input3 = askIn();
            if(input3 == 1){removeCrew(input2);
              tavernPatrons.get(input).setInTavern(false);
              prln("You remove " + curCrew.get(input2).getFname() + " " + curCrew.get(input2).getLname() + " from your crew.");
              addCrew(tavernPatrons.get(input));
              sleep(1000);
              prln("You add " + tavernPatrons.get(input).getFname() + " " + tavernPatrons.get(input).getLname() + " to your crew.");
              sleep(1000);
            }
            break;
          }
        }
      }
    }
  }
  /*
   * gets the TAVERN type
   * @return String TAVERn
   */
  public String getType(){
    return TAVERN;
  }

  /*
   * gets the Tavern Symbol
   * @return char TAVERN
   */
  public char getSymbol(){
    return TAVERNSYMBOL;
  }

  /*
   * Sets the viewedness of an Encounter
   */
  public void viewEncounter(){
    viewed = true;
  }
}
