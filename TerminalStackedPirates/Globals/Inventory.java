//File: Inventory.java
//Author: MrFuzzyPants
//Created: 04-08-2023
//Modified: 04-08-2023
package Globals;

import static Globals.Tools.*;
import static Globals.Constants.*;
import java.util.ArrayList;
import Humans.Player;
import Items.Item;
import Items.Packs.*;
import Items.Cards.*;

public abstract class Inventory {
  /* 
   * Prints the inventory CSV in a user viewable format (Inventory Screen)
   */
  public static void viewInventory(){
    Player player = new Player();
    while(true){
      lineBreaker("INVENTORY");
      ArrayList<Pack> packs = new ArrayList<Pack>();
      ArrayList<Card> cards = new ArrayList<Card>();
      int it = 0;
      Item currentItem = getFromInventory(it);
      while(currentItem != null){
        if(currentItem instanceof Pack){
          Pack newPack = (Pack)currentItem;
          if(!newPack.getOpened()){
            packs.add(newPack);
          }
        } else if(currentItem instanceof Card){
          cards.add((Card)currentItem);
        }
        it++;
        currentItem = getFromInventory(it);
      }

      lineBreaker("PACKS");
      int packNums = 0;
      while(packNums < packs.size()){
        pr((packNums + 1) + ". ");
        pr(packs.get(packNums).getRarity(), packs.get(packNums).getColour());
        prln(" " + packs.get(packNums).getName());
        packNums++;
      }

      lineBreaker("CARDS");
      int cardNums = packNums;
      for(int j = 0; j < cards.size(); j++){
        pr((cardNums + 1) + ". ");
        pr(cards.get(j).getRarity(), cards.get(j).getColour());
        prln(" " + cards.get(j).getName());
        cardNums++;
      }
      
      lineBreaker("GOLD");
      pr("You have ");
      pr(player.getGold() + " Gold", GOLDCOLOUR);
      prln(".");

      prln("What would you like to do?");
      prln("Enter a pack number to open it");
      prln("Enter a card number to view it");
      prln("Q. Close the Inventory");
      int input = askIn();
      if(input == Integer.MAX_VALUE){
        break;
      } else {
        input -= 1;
        if(input < packNums){
          openPack(packs.get(input));
        } else if(input < cardNums){
          //viewCard(cards.get(input - packs.size()));
        } else {
          invalOp();
        }
      }
    }
  }

  public static void openPack(Pack pack){
    ArrayList<Card> cards = pack.open();
    for(int i = 0; i < cards.size(); i++){
      addToInventory(cards.get(i));
    }
    removeFromInventory(pack);
    pr("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n<><><><><><><><><><><><><><>OPENING<><><><><><><><><><><><><><>\n<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
    for(int i = 0; i < cards.size(); i++){
      prln(cards.get(i).getRarity() + SPACE + cards.get(i).getName(), cards.get(i).getColour());
    }
    askIn();
  }

  // CSV METHODS | CSV METHODS | CSV METHODS
  // CSV METHODS | CSV METHODS | CSV METHODS
  // CSV METHODS | CSV METHODS | CSV METHODS

  /*
   * Saves an item into the inventory CSV file
   * @param item The item to save
   */
  public static void addToInventory(Item item){
    writeToCSV(INVENTORYCSV,"Inventory.java",true,INVENTORYHEADER,INVENTORYFORMAT,TRUE,item.getItemType(),item.getType(),item.getIndex());
  }

  /*
   * Removes an item from the inventory CSV file
   * @param item The item to remove
   */
  public static void removeFromInventory(Item item){
    writeToCSVValue(INVENTORYCSV,"Inventory.java",ITEMINDEX,toStr(item.getIndex()),ININVENTORY,FALSE);
  }

  /*
   * Gets an item from the inventory CSV file
   * @param index The index of the item to get
   * @return The item at the index
   * @return null if the index is not found
   */
  public static Item getFromInventory(int index){
    String[] itemData = getFromCSVRow(INVENTORYCSV,"Inventory.java",INDEX,toStr(index));
    if(itemData != null){
      if(toBool(itemData[1])){
        if(itemData[2].equals(PACK)){
          if(itemData[3].equals(CREW)){
            return new CrewPack(true,toInt(itemData[4]));
          } else if(itemData[3].equals(FOOD)){
            return new FoodPack(true,toInt(itemData[4]));
          } else if(itemData[3].equals(SHIP)){
            return new ShipPack(true,toInt(itemData[4]));
          }
        } else if(itemData[2].equals(CARD)){
          if(itemData[3].equals(CREW)){
            return new CrewCard(true,toInt(itemData[4]));
          } else if(itemData[3].equals(FOOD)){
            return new FoodCard(true,toInt(itemData[4]));
          } else if(itemData[3].equals(SHIP)){
            return new ShipCard(true,toInt(itemData[4]));
          }
        }
      }
    }
    return null;
  }
}
