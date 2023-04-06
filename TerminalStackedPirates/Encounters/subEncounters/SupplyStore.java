package Encounters.subEncounters;

import static Globals.Tools.*;
import java.util.*;
import Cards.Cards.*;
import Cards.Packs.*;

public class SupplyStore extends SubEncounter{
  ArrayList<Pack> packs;
  
  public SupplyStore(int level){
    packs = new ArrayList<Pack>();
    Random rand = new Random();
    for(int i = 0; i < 5; i++){
      packs.add(new CrewPack((rand.nextInt(5))));//Should be level + 1 instead of 5
    }
    for(int i = 0; i < 5; i++){
      packs.add(new FoodPack((rand.nextInt(5))));//Should be level + 1 instead of 5
    }
  }

  public void enter(){
    lineBreaker();
    prln("You enter the supply store.");
    prln("You see a variety of packs.");
    while(true){
      pr("You have ");
      pr(getFromCSV("player", "SupplyStore.java", "Index", "0", "Gold") + " Gold", "33");
      prln(".");
      prln("What would you like to do?");
      prln("1. Buy a pack");
      prln("2. Leave the store");
      int input = askIn();
      if(input == 1){
        prln("Here are my packs");
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
          break;
        } else {
          input -= 1;
          if(packs.get(input).getCost() > toInt(getFromCSV("player", "SupplyStore.java", "Index", "0", "Gold"))){
            prln("You do not have enough gold to buy this pack.");
            continue;
          } else {
            pr("Are you sure you want to buy a ");
            pr(packs.get(input).getRarity(), packs.get(input).getColour());
            pr(" " + packs.get(input).getName() + " ");
            prln(" for " + packs.get(input).getCost() + " gold?");
            prln("1. Yes");
            prln("2. No");
            int oldInput = input;
            input = askIn();
            if(input == 1){
              writeToCSVValue("player", "SupplyStore.java", "Index", "0", "Gold", 
                toStr(toInt(getFromCSV("player", "SupplyStore.java", "Index", "0", "Gold")) - packs.get(oldInput).getCost()));
                lineBreaker();
                continue;
            } else {
              lineBreaker();
              continue;
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
