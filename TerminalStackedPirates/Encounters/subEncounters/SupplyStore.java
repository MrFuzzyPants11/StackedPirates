//File: SupplyStore.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023
package Encounters.subEncounters;

import static Globals.Tools.*;
import java.util.*;
import Cards.Packs.*;
import Humans.*;

public class SupplyStore extends SubEncounter{
  ArrayList<Pack> packs;
  
  public SupplyStore(int level){
    packs = new ArrayList<Pack>();
    Random rand = new Random();
    for(int i = 0; i < 5; i++){
      packs.add(new CrewPack(rand.nextInt(level + 1)));
    }
    for(int i = 0; i < 5; i++){
      packs.add(new FoodPack(rand.nextInt(level + 1)));
    }
  }

  public void enter(){
    Player player = new Player();
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
            if(i < 9){
              pr("0");
            }
            pr((i + 1) + ". " + packs.get(i).getName() + " ");
            pr(packs.get(i).getRarity(), packs.get(i).getColour());
            prln(" - " + packs.get(i).getCost() + " gold");
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
                packs.remove(oldInput);
                continue;
              } else {
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
