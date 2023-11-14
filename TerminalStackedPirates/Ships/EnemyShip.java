//File: EnemyShip.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 04-04-2023
package Ships;

public class EnemyShip extends Ship{
  int index = 0;
  public EnemyShip(int level, String type){}
  public EnemyShip(int index){}


  public int getIndex(){
    return index;
  }
}
