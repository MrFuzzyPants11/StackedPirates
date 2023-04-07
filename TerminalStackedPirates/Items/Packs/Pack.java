//File: Pack.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Items.Packs;

import java.util.*;
import Items.Item;
import static Globals.Tools.*;

public abstract class Pack extends Item{
  int cost;
  boolean sold = false;
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
   * Gets that this is a pack type
   * @return "pack"
   */
  public String getItemType(){
    return "pack";
  }

  /*
   * Sets the pack's sold value to true
   */
  public void sellPack(){
    sold = true;
    writeToCSVValue("allpacks", "Pack.java", "Index", "" + this.index, "Sold", "true");
  }

  /*
   * Writes the pack to the CSV file
   */
  protected void writePack(String comingFrom, String type, ArrayList<Integer> cRarities){
    writeToCSV("allpacks",comingFrom, true, "Type,Sold,Rarity,Cost,Card1,Card2,Card3,Card4,Card5", "%s,%s,%d,%d,%d,%d,%d,%d,%d",
      type,sold,rarity,cost, cRarities.get(0), cRarities.get(1), cRarities.get(2), cRarities.get(3), cRarities.get(4));
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
    if(rarity == 0){
      for(int i = 0; i < 5; i++){
        cRarities.add(0);
      }
    } else if(rarity == 1){
      cRarities.add(1);
      if(rand.nextBoolean()){
        cRarities.add(1);
      } else {
        cRarities.add(0);
      }
      for(int i = 1; i <= 3; i++){
        cRarities.add(0);
      }
    } else {
      cRarities.add(rarity);
      if(rand.nextBoolean()){
        cRarities.add(rarity);
      } else {
        cRarities.add(rarity - 1);
      }
      for(int i = 1; i <= 3; i++){
        cRarities.add(rand.nextInt(rarity));
      }
    }
    writePack(comingFrom, type, cRarities);
  }
}