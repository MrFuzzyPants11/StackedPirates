//File: SupplyStore.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Encounters.subEncounters;

import static Globals.Tools.*;
import java.util.*;

import Humans.*;
import Items.Packs.*;

public class SupplyStore extends SubEncounter{
  ArrayList<Pack> packs;
  ArrayList<String> packIndexes = new ArrayList<String>(Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10"));

  /*
   * Constructor for a new supply store
   * @param reload whether the supply store is being reloaded from a save file
   * @param levelOrIndex the level of the supply store or the index of the supply store if being reloaded
   */
  public SupplyStore(boolean reload, int levelOrIndex){
    if(reload){
      String[] data = getFromCSVRow("supplystores","SupplyStore.java","Index", "" + levelOrIndex);
      this.index = toInt(data[0]);
      level = toInt(data[1]);
      this.packs = new ArrayList<Pack>();
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
      Random rand = new Random();
      for(int i = 0; i < 5; i++){
        packs.add(new CrewPack(false,rand.nextInt(level + 1)));
      }
      for(int i = 0; i < 5; i++){
        packs.add(new FoodPack(false,rand.nextInt(level + 1)));
      }
      writeToCSV("supplystores","SupplyStore.java",true,"level,pack0,pack1,pack2,pack3,pack4,pack5,pack6,pack7,pack8,pack9",
        "%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d",level, packs.get(0).getIndex(), packs.get(1).getIndex(), packs.get(2).getIndex(), packs.get(3).getIndex(), 
        packs.get(4).getIndex(), packs.get(5).getIndex(), packs.get(6).getIndex(), packs.get(7).getIndex(), packs.get(8).getIndex(), packs.get(9).getIndex());
      this.index = getFromCSVLastIndex("supplystores","SupplyStore.java");
    }
  }

  /*
   * The Store environment
   * @param player the player
   */
  public void enter(Player player){
    lineBreaker();
    prln("You enter the supply store.");
    prln("You see a variety of packs.");
    boolean leave = false;
    while(!leave){
      pr("You have ");
      pr(player.getGold() + " Gold", "33");
      prln(".");
      prln("What would you like to do?");
      prln("1. Buy a pack");
      prln("2. Leave the store");
      int input = askIn();
      if(input == 1){
        prln("Here are my packs:");
        while(true){
          for(int i = 0; i < packs.size(); i++){
            if(!packs.get(i).getSold()){
              pr(packIndexes.get(i) + ". " + packs.get(i).getName() + " ");
              pr(packs.get(i).getRarity(), packs.get(i).getColour());
              prln(" - " + packs.get(i).getCost() + " gold");
            }
          }
          prln("11. Leave the store");
          prln("Which pack would you like to buy?");
          input = askIn();
          if(input == 11){
            prln("You leave the store.");
            leave = true;
            break;
          } else {
            input -= 1;
            if(input > packs.size() - 1){
              invalOp();
              continue;
            } else if(packs.get(input).getCost() > player.getGold()){
              prln("You do not have enough gold to buy this pack.");
              continue;
            } else {
              pr("Are you sure you want to buy a ");
              pr(packs.get(input).getRarity(), packs.get(input).getColour());
              pr(" " + packs.get(input).getName() + " for ");
              prln(packs.get(input).getCost() + " gold?", "33");
              prln("1. Yes");
              prln("2. No");
              int oldInput = input;
              input = askIn();
              if(input == 1){
                player.spendGold(packs.get(oldInput).getCost());
                player.addToInventory(packs.get(oldInput));
                packs.remove(oldInput).sellPack();
                packIndexes.remove(oldInput);
                continue;
              }
            }
          }
        }
        
      } else if(input == 2){
        prln("You leave the store.");
        break;
      } else {
        invalOp();
      }
    }
  }
}
