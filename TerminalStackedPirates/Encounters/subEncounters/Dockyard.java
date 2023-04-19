//File: Dockyard.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-19-2023
package Encounters.subEncounters;

import Humans.Player;
import static Globals.Tools.*;
import static Globals.Constants.*;
import static Globals.PlayerAttributes.Inventory.*;
import java.util.ArrayList;
import Items.Packs.ShipPack;
import Ships.PlayerShip;

public class Dockyard extends SubEncounter{
  private String name;
  private ArrayList<ShipPack> shipPacks;
  /*
   * Constructor for a new Dockyard
   * @param reload whether the encounter is being reloaded
   * @param levelOrIndex the level of the encounter or the index of the encounter if being reloaded
   */
  public Dockyard(boolean reload, int levelOrIndex){
    if(reload){

    } else {
      this.name = generateFirstName(generateRand());
      this.level = levelOrIndex;
      this.index = 0; 
      shipPacks = new ArrayList<ShipPack>();
      for(int i = 0; i < 5; i++){
        shipPacks.add(new ShipPack(false, generateLevel(levelOrIndex)));
      }
    }
  }

  /*
   * The Dockyard Environment
   * @param player the player
   */
  public void enter(Player player){
    lineBreaker("Dockyard");
    pr("You pull your ship over to " + name + "'s ");
    prln("Dockyard", ENCOUNTERCOLOUR);
    while(true){
      prln("What would you like to do?");
      prln("1. Buy Ship Packs");
      prln("2. Repair your ship");
      prln("3. Upgrade your Ship");
      prln("Q. Leave");
      int input = askIn();
      if(input == QUIT){
        break;
      } else if(input == 1){
        goBuyPacks(player);
        continue;
      } else if(input == 2){
        goRepairShip(player);
        continue;
      } else if(input == 3){
        goUpgradeShip(player);
        continue;
      } else {
        invalOp();
        continue;
      }
    }
  }
  
  private void goBuyPacks(Player player){
    prln("You walk into " + name + "'s Ship Supplies.");
    while(true){
      prln("Hey there scab, What can I do for ya?");
      for(int i = 0; i < shipPacks.size(); i++){
        if(!shipPacks.get(i).getSold()){
          pr((i + 1) + ". " + shipPacks.get(i).getName() + " ");
          pr(firstCap(shipPacks.get(i).getRarityText()), shipPacks.get(i).getColour());
          prln(" - " + shipPacks.get(i).getCost() + " gold");
        }
      }
      prln("Q. Leave the store");
      pr("You have ");
      pr(player.getGold() + " Gold", GOLDCOLOUR);
      prln(".");
      prln("Which pack would you like to buy?");
      int input = askIn();
      if(input == QUIT){
        prln("You leave and store and go back to your ship.");
        break;
      } else {
        if(input == MENUEXIT){
          continue;
        }
        input -= 1;
        if(shipPacks.get(input).getCost() > player.getGold()){
          prln("You do not have enough gold to buy this pack.",RED);
        } else if(shipPacks.get(input).getSold()){
          prln("A pack so good you'd buy it twice?\n\t\tyou can't though sorry.\n");
        } else {
          pr("Are you sure you want to buy a ");
          pr(firstCap(shipPacks.get(input).getRarityText()), shipPacks.get(input).getColour());
          pr(" " + shipPacks.get(input).getName() + " for ");
          prln(shipPacks.get(input).getCost() + " gold?", GOLDCOLOUR);
          prln(toStr(input + 1) + ". Yes");
          prln("Q. No");
          int oldInput = input;
          input = askIn();
          if(input == (oldInput + 1)){
            player.spendGold(shipPacks.get(oldInput).getCost());
            addToInventory(shipPacks.get(oldInput));
            shipPacks.get(oldInput).sellPack();
          }
        }
      }
    }
  }

  private void goRepairShip(Player player){
    PlayerShip ship = new PlayerShip();
    while(true){
      prln("You pull your ship into the repair slip.");
      prln("What would you like to do?");
      pr("1. Repair your ship for ");
      pr("50 Gold",GOLDCOLOUR);
      prln(".");
      pr("2. Purchase repair kits for ");
      pr("75 Gold",GOLDCOLOUR);
      prln(".");
      prln("Q. Leave");
      int input = askIn();
      if(input == QUIT){
        break;
      } else if(input == 1){
        prln("How many times would you like to repair your ship?");
        prln("Your ship has " + ship.getToughness() + "/" + ((ship.getSize() + 1) * 100) + " Toughness");
        pr("And you have ");
        pr(player.getGold() + " Gold", GOLDCOLOUR);
        prln(".");
        prln("Q. Leave");
        input = askIn();
        if(input == QUIT){
          continue;
        } else if(input > 0){
          if(player.getGold() < input * 50){
            prln("You do not have enough gold to buy that many repairs");
          } else if((input * REPAIRAMOUNT) + ship.getToughness() < ((ship.getSize() + 1) * 100)){ //If the repairs are less than the max ship size no prompt
            ship.increaseToughness(input * REPAIRAMOUNT);
            player.spendGold(input * 50);
          } else if(((input - 1) * REPAIRAMOUNT) + ship.getToughness() < ((ship.getSize() + 1) * 100)){ //Same is they are greater but not more than 1 repair kit more
            ship.increaseToughness(input * REPAIRAMOUNT);
            player.spendGold(input * 50);
          } else {
            prln("You are attempting to repair more than is possible");
            prln("Are you sure you want repair that much?");
            prln("1. Yes");
            prln("Q. No");
            int input2 = askIn();
            if(input2 != 1){
              continue;
            } else {
              ship.increaseToughness(input * REPAIRAMOUNT);
              player.spendGold(input * 50);
            }
          }
        } else {
          invalOp();
          continue;
        }
      } else if (input == 2){
        prln("How many times would you like to repair your ship?");
        prln("Your ship has " + ((ship.getSize() + 1) * 100) + " Maximum Toughness");
        pr("And you have ");
        pr(player.getGold() + " Gold", GOLDCOLOUR);
        prln(".");
        prln("Q. Leave");
        input = askIn();
        if(input == QUIT){
          continue;
        } else if(input > 0){
          if(player.getGold() < input * 75){
            prln("You do not have enough gold to buy that many repairs");
          } else {
            ship.addRepairs(input);
            player.spendGold(input * 75);
          } 
        } else {
          invalOp();
          continue;
        }
      } else {
        invalOp();
        continue;
      }
    }
  }

  private void goUpgradeShip(Player player){

  }
}
