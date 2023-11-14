//File: Location.java
//Author: MrFuzzyPants
//Created: 06-10-2023
//Modified: 11-13-2023
package Globals.PlayerAttributes;

import static Globals.Tools.*;
import static Globals.Constants.*;

public abstract class Location {
  /*
   * Sets both y and x for the player
   * @param y the players y coordinate
   * @param x the players x coordinate
   */
  public static void setYX(int y, int x){
    writeToCSV(LOCATIONCSV,"Location.java",false,LOCATIONHEADER,LOCATIONFORMAT,y,x);
  }

  /*
   * Gets both y and x for the player
   * @return a pair of the Players y and x
   */
  public static Pair<Integer,Integer> getYX(){
    String[] data = getFromCSVRow(LOCATIONCSV,"Location.java",INDEX,ZERO);
    return new Pair<Integer,Integer>(toInt(data[1]),toInt(data[2]));
  }

  /*
   * Gets the players y coordinate 
   */
  public static int getY() {
    String data = getFromCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,YCORD);
    return toInt(data);
  }

  /*
   * Gets the players x coordinate 
   */
  public static int getX() {
    String data = getFromCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,XCORD);
    return toInt(data);
  }

  /*
   * Moves the player up
   */
  public static boolean moveUp() {
    int y = getY() - 1; //flipped sign because graph starts top left
    if(y < 0){
      return false;
    }

    writeToCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,YCORD,toStr(y));
    return true;
  }

  /*
   * Moves the player down
   */
  public static boolean moveDown() {
    int y = getY() + 1; //flipped sign because graph starts top left
    if(y > WORLDSIZE - 1){
      return false;
    }

    writeToCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,YCORD,toStr(y));
    return true;
  }

  /*
   * Moves the player right
   */
  public static boolean moveRight() {
    int x = getX() + 1;
    if(x > WORLDSIZE - 1){
      return false;
    }

    writeToCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,XCORD,toStr(x));
    return true;
  }

  /*
   * Moves the player left
   */
  public static boolean moveLeft() {
    int x = getX() - 1;
    if(x < 0){
      return false;
    }

    writeToCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,XCORD,toStr(x));
    return true;
  }
}
