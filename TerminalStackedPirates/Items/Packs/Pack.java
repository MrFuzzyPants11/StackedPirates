//File: Pack.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 04-08-2023
package Items.Packs;

import java.util.*;
import Items.Item;
import Items.Cards.*;
import static Globals.Tools.*;
import static Globals.Constants.*;

public abstract class Pack extends Item{
  int cost;
  boolean sold = false;
  boolean opened = false;
  ArrayList<Integer> cRarities = new ArrayList<Integer>();

  /*
   * Gets the cost of the pack
   * @return the cost of the pack
   */
  public int getCost(){
    return cost;
  }

  /*
   * Gets whether the pack has been sold or not
   * @return the pack's sold value
   */
  public boolean getSold(){
    return sold;
  }

  /*
   * Sets the pack's sold value to true
   */
  public void sellPack(){
    sold = true;
    writeToCSVValue(ALLPACKSCSV, "Pack.java", INDEX, toStr(this.index), SOLD, TRUE);
  }


  /*
   * Gets that this is a pack type
   * @return "pack"
   */
  public String getItemType(){
    return PACK;
  }

  /*
   * Gets whether the pack has been opened or not
   * @return the pack's opened value
   */
  public boolean getOpened(){
    return opened;
  }

  /*
   * Sets the pack's opened value to true
   */
  public ArrayList<Card> open(){
    opened = true;
    writeToCSVValue(ALLPACKSCSV, "Pack.java", INDEX, toStr(this.index), OPENED, TRUE);
    ArrayList<Card> cards = new ArrayList<Card>();
    if(this.getType().equals(CREW)){
      for(int i = 0; i < 5; i++){
        cards.add(new CrewCard(false, cRarities.get(i)));
      }
    } else if(this.getType().equals(FOOD)){
      for(int i = 0; i < 5; i++){
        cards.add(new FoodCard(false, cRarities.get(i)));
      }
    } else if(this.getType().equals(SHIP)){
      for(int i = 0; i < 5; i++){
        cards.add(new ShipCard(false, cRarities.get(i)));
      }
    }
    return cards;
  }
  
  /*
   * Writes the pack to the CSV file
   */
  protected void writePack(String comingFrom, String type, ArrayList<Integer> cRarities){
    writeToCSV(ALLPACKSCSV,comingFrom, true, ALLPACKSHEADER, ALLPACKSFORMAT,
      type,sold,opened,rarity,cost, cRarities.get(0), cRarities.get(1), cRarities.get(2), cRarities.get(3), cRarities.get(4));
  }


  /*
   * Generates a pack and writes it to the CSV file
   * @param rarity the rarity of the pack
   * @param comingFrom the file that called this method
   * @param type the type of pack
   */
  protected void generatePack(int rarity,String comingFrom, String type){
    Random rand = new Random();
    int additionalCost = (rand.nextInt(101)/10) * 10;
    cost = 100 + (rarity * 100) + additionalCost;
    if(rarity == 0){ // From a common pack there is a:
      cRarities.add(0);
      cRarities.add(0);
      cRarities.add(0);
      cRarities.add(0); // 99.99% chance to get a common
      cRarities.add(1); // 100% chance to get uncommon
      if(rand.nextInt(11) == 9){// 9% chance to get rare
        cRarities.remove(0);
        cRarities.add(2);
      }
      if(rand.nextInt(33) == 7){// 3% chance to get epic
        cRarities.remove(0);
        cRarities.add(3);
      }
      if(rand.nextInt(100) == 69){// 1% chance to get legendary
        cRarities.remove(0);
        cRarities.add(4);
      }
    } else if(rarity == 1){// From an uncommon pack there is a:
      cRarities.add(0);
      cRarities.add(0); // 99.99% chance to get a common
      cRarities.add(1); // 100% chance to get 2 uncommons
      cRarities.add(1);
      cRarities.add(2); // 100% chance to get rare
      if(rand.nextInt(11) == 7){// 9% chance to get epic
        cRarities.remove(0);
        cRarities.add(3);
      }
      if(rand.nextInt(50) == 34){// 2% chance to get legendary
        cRarities.remove(0);
        cRarities.add(4);
      }
    } else if(rarity == 2){
      cRarities.add(0); // 92% chance to get a common
      if(rand.nextBoolean()){ // 48% chance to get another uncommon
        cRarities.add(0);
      } else {
        cRarities.add(1);
      }
      cRarities.add(1); // 100% chance to get uncommon
      cRarities.add(2); // 100% chance to get rare
      cRarities.add(3); // 100% chance to get epic
      if(rand.nextInt(25) == 20){// 4% chance to get legendary
        cRarities.remove(0);
        cRarities.add(4);
      }
    } else if(rarity == 3){
      if(rand.nextBoolean()){ // 45% chance to get another uncommon or a common
        cRarities.add(0);
      } else {
        cRarities.add(1);
      }
      cRarities.add(1); // 100% chance to get uncommon
      cRarities.add(2); // 100% chance to get rare
      cRarities.add(3);
      cRarities.add(3); // 100% chance to get 2 epics
      if(rand.nextInt(10) == 5){// 10% chance to get legendary
        cRarities.remove(0);
        cRarities.add(4);
      }
    } else {
      cRarities.add(1); // 50% chance to get uncommon
      cRarities.add(2);
      cRarities.add(2); // 100% chance to get 2 rares
      cRarities.add(3);
      cRarities.add(3); // 100% chance to get 2 epics
      if(rand.nextInt(2) == 1){// 50% chance to get legendary
        cRarities.remove(0);
        cRarities.add(4);
      }
    }
    writePack(comingFrom, type, cRarities);
  }
}