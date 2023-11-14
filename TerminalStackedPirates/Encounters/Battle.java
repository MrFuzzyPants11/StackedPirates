//File: Battle.java
//Author: MrFuzzyPants
//Created: 04-19-2023
//Modified: 04-19-2023
package Encounters;
import static Globals.Tools.*;
import java.util.ArrayList;
import static Globals.Constants.*;
import Ships.EnemyShip;
import Humans.*;


public class Battle extends Encounter{

  String type;
  EnemyShip ship;
  ArrayList<Enemy> enemies;
  /*
   * Constructor for the Battle Class
   */
  public Battle(boolean reload,int levelOrIndex){
    if(reload){
      String[] data = getFromCSVRow(BATTLECSV,"Battle.java",INDEX, toStr(levelOrIndex));
      index = levelOrIndex;
      level = toInt(data[1]);
      type = data[2];
      ship = new EnemyShip(toInt(data[3]));
      for(int i = 4; toInt(data[i]) != -1 && i < data.length; i++){
        enemies.add(new Enemy(true, toInt(data[i])));
      }
    } else {
      level = levelOrIndex;
      //int tempType = generateRand(4);
      int tempType = 0;
      if(tempType == 0){
        type = BRITISH;
        ship = new EnemyShip(level + 1, BRITISH);
      } else if(tempType == 1){
        type = SPANISH;
        ship = new EnemyShip(level + 1, SPANISH);
      } else if(tempType == 2){
        type = MERCHANT;
        ship = new EnemyShip(level, MERCHANT);
      } else {
        type = PIRATE;
        ship = new EnemyShip(level, PIRATE);
      }

      int enemyNum = MAXLEVEL; 
      if(level != MAXLEVEL){
        enemyNum = level + 1;
      }

      for(int i = 0; i <= enemyNum; i++ ){
        enemies.add(new Enemy(false, generateLevel(level)));
      }

      writeToCSV(BATTLECSV,"Battle.java",true,BATTLEHEADER,BATTLEFORMAT, level,type,ship.getIndex(),-1,-1,-1,-1,-1);
      index = getFromCSVLastIndex(BATTLECSV,"Battle.java");

      for(int i = 0; i < enemies.size() - 1; i++){
        writeToCSVValue(BATTLECSV,"Battle.java",INDEX,toStr(index), CREWINDEX + toStr(i), toStr(enemies.get(i).getIndex()));
      }
    }
  }

  public String getType(){
    return BATTLE;
  }

  public char getSymbol(){
    return BATTLESYMBOL;
  }

  public void enter(Player player){
    enterProgressUpdates("Battle.java",BATTLE,this.index);
  }

  /*
   * Sets the viewedness of an Encounter
   */
  public void viewEncounter(){
    writeToCSVValue(BATTLECSV,"Battle.java",INDEX,toStr(index),VIEWED,TRUE);
    viewed = true;
  }
}
