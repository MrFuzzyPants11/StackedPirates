//File: Location.java
//Author: MrFuzzyPants
//Created: 06-10-2023
//Modified: 06-10-2023
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
  public int getY() {
    String data = getFromCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,YCORD);
    return toInt(data);
  }

  /*
   * Gets the players x coordinate 
   */
  public int getX() {
    String data = getFromCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,XCORD);
    return toInt(data);
  }

  /*
   * Sets the players y coordindate
   * @param the players y coordinate
   */
  public void moveUp(int y) {
    String data = getFromCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,XCORD);
    int x = toInt(data);
    writeToCSV(LOCATIONCSV,"Location.java",false,LOCATIONHEADER,LOCATIONFORMAT,y,x);
  }

  /*
   * Moves the player up
   */
  public void moveUp() {
    int y = getY();
    writeToCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,YCORD,toStr(y + 1));
  }

  /*
   * Moves the player down
   */
  public void moveDown() {
    int y = getY();
    writeToCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,YCORD,toStr(y - 1));
  }

  /*
   * Moves the player right
   */
  public void moveRight() {
    int x = getX();
    writeToCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,XCORD,toStr(x + 1));
  }

  /*
   * Moves the player left
   */
  public void moveLeft() {
    int x = getX();
    writeToCSVValue(LOCATIONCSV,"Location.java",INDEX,ZERO,XCORD,toStr(x - 1));
  }
}
