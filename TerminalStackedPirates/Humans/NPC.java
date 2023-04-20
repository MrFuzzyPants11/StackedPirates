//File: NPC.java
//Author: MrFuzzyPants
//Created: 04-11-2023
//Modified: 04-11-2023
package Humans;

public abstract class NPC extends Human{
  String fname;
  String lname;
  int index;
  /*
   * Gets the NPC's first name
   * @return the NPC's first name
   */
  public String getFname() {
    return fname;
  }

  /*
   * Gets the NPC's last name
   * @return the NPC's last name
   */
  public String getLname() {
    return lname;
  }

  /*
   * Gets the NPC's index
   * @return the NPC's index
   */
  public int getIndex() {
    return index;
  }
}
