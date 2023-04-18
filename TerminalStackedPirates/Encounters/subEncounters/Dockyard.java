//File: Dockyard.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-18-2023
package Encounters.subEncounters;

import Humans.Player;

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
          prln("You do not have enough gold to buy this pack.","31");
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

  }
  private void goUpgradeShip(Player player){

  }
}
