//File: SupplyStore.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 06-08-2023
package Encounters.subEncounters;

import static Globals.Tools.*;
import static Globals.Constants.*;
import static Globals.PlayerAttributes.Inventory.*;
import java.util.*;
import Humans.*;
import Items.Packs.*;
import Encounters.Encounter;

public class SupplyStore extends Encounter{
  ArrayList<Pack> packs;

  /*
   * Constructor for a new supply store
   * @param reload whether the supply store is being reloaded from a save file
   * @param levelOrIndex the level of the supply store or the index of the supply store if being reloaded
   */
  public SupplyStore(boolean reload, int levelOrIndex){
    if(reload){
      String[] data = getFromCSVRow(SUPPLYSTORESCSV,"SupplyStore.java",INDEX, toStr(levelOrIndex));
      index = levelOrIndex;
      level = toInt(data[1]);
      packs = new ArrayList<Pack>();
      for(int i = 2; i < data.length; i++){
        if(Integer.parseInt(data[i]) < 100){
          packs.add(new CrewPack(true, toInt(data[i])));
        } else {
          packs.add(new FoodPack(true, toInt(data[i])));
        }
      }
    } else {
      packs = new ArrayList<Pack>();
      level = levelOrIndex;
      for(int i = 0; i < 5; i++){
        packs.add(new CrewPack(false,generateLevel(level)));
      }
      for(int i = 0; i < 5; i++){
        packs.add(new FoodPack(false,generateLevel(level)));
      }
      writeToCSV(SUPPLYSTORESCSV,"SupplyStore.java",true,SUPPLYSTORESHEADER,SUPPLYSTORESFORMAT,level, packs.get(0).getIndex(), 
        packs.get(1).getIndex(), packs.get(2).getIndex(), packs.get(3).getIndex(), packs.get(4).getIndex(), 
        packs.get(5).getIndex(), packs.get(6).getIndex(), packs.get(7).getIndex(), packs.get(8).getIndex(), packs.get(9).getIndex());
      index = getFromCSVLastIndex(SUPPLYSTORESCSV,"SupplyStore.java");
    }
  }

  /*
   * The Store environment
   * @param player the player
   */
  public void enter(Player player){
    lineBreaker("Supply Store");
    pr("You enter Hannigan's ");
    pr("Supply Store", ENCOUNTERCOLOUR);
    prln(".");
    prln("You see a variety of packs.");
    boolean leave = false;
    while(!leave){
      pr("You have ");
      pr(player.getGold() + " Gold", GOLDCOLOUR);
      prln(".");
      prln("What would you like to do?");
      prln("1. Buy a pack");
      prln("Q. Leave the store");
      int input = askIn();
      if(input == 1){
        prln("Here are my packs:");
        while(true){
          for(int i = 0; i < packs.size(); i++){
            if(!packs.get(i).getSold()){
              pr((i + 1) + ". " + packs.get(i).getName() + " ");
              pr(firstCap(packs.get(i).getRarityText()), packs.get(i).getColour());
              prln(" - " + packs.get(i).getCost() + " gold");
            }
          }
          prln("Q. Leave the store");
          pr("You have ");
          pr(player.getGold() + " Gold", GOLDCOLOUR);
          prln(".");
          prln("Which pack would you like to buy?");
          input = askIn();
          if(input == QUIT){
            prln("You leave the store.");
            leave = true;
            break;
          } else {
            if(input == MENUEXIT){
              continue;
            }
            input -= 1;
            if(packs.get(input).getCost() > player.getGold()){
              prln("You do not have enough gold to buy this pack.",RED);
            } else if(packs.get(input).getSold()){
              prln("A pack so good you'd buy it twice?\n\t\tyou can't though sorry.");
            } else {
              pr("Are you sure you want to buy a ");
              pr(firstCap(packs.get(input).getRarityText()), packs.get(input).getColour());
              pr(" " + packs.get(input).getName() + " for ");
              prln(packs.get(input).getCost() + " gold?", GOLDCOLOUR);
              prln(toStr(input + 1) + ". Yes");
              prln("Q. No");
              int oldInput = input;
              input = askIn();
              if(input == (oldInput + 1)){
                player.spendGold(packs.get(oldInput).getCost());
                addToInventory(packs.get(oldInput));
                packs.get(oldInput).sellPack();
              }
            }
          }
        }
        
      } else if(input == QUIT){
        prln("You leave the store.");
        break;
      } else if(input != MENUEXIT){
        invalOp();
      }
    }
  }

  /*
   * gets the SUPPLYSTORE type
   * @return String SUPPLYSTORE
   */
  public String getType(){
    return SUPPLYSTORE;
  }

  /*
   * gets the Supplystore Symbol
   * @return char SUPPLYSTORE
   */
  public char getSymbol(){
    return 'S';
  }
}
