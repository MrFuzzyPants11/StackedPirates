//File: Map.java
//Author: MrFuzzyPants
//Created: 06-07-2023
//Modified: 06-10-2023
package Globals;

import static Globals.Tools.*;
import static Globals.Constants.*;
import Encounters.*;

public class WorldMap {
  Encounter[][] world = new Encounter[WORLDSIZE][WORLDSIZE];
  
  /*
   * Constructor for reloading the map
   * @param boolean true if reloading a map false if generating a map.
   */
  public WorldMap(Boolean reload){
    String[] mapData = new String[2];
    if(reload){
      for(int y = 0; y < WORLDSIZE; y++){
        for(int x = 0; x < WORLDSIZE; x++){
          mapData = getFromCSVRow(WORLDMAPCSV,"WorldMap.java",INDEX,toStr(y * 11 + x));
          if(mapData[1].equals(PORT)){
            world[y][x] = new Port(toInt(mapData[2]));
          } else {
            world[y][x] = new Basic();
          }
        }
      }
    } else {
      createMap();
    }
  }

  /*
   * Creates The map and saves it to the CSV
   */
  private void createMap(){
    for(int y = 0; y < WORLDSIZE; y++){
      for(int x = 0; x < WORLDSIZE; x++){
        world[y][x] = new Basic();
      }
    }
    // These are all number remaining not number in the world
    int numPorts = NUMPORTS;

    //Randomly picks one of the middle squares to be the starting square;
    int randomSquare = generateRand(4);
    world[((WORLDSIZE / 2) - 1) + randomSquare / 2][((WORLDSIZE / 2) - 1) + randomSquare % 2] = new Port(true,MINLEVEL);
    
    int encounter;
    int x;
    int y;
    int level = MINLEVEL;
    while(numPorts != 0){
      x = generateRand(WORLDSIZE);
      y = generateRand(WORLDSIZE);
      if(world[y][x].getType().equals(BASIC)){
        encounter = generateRand(1);
        // Determines the ring selected and sets the level
        if (y == 0 || y == 1 || y == 18 || y == 19 || x == 0 || x == 1 || x == 18 || x == 19) {
          level = MAXLEVEL;
        } else if (y == 2 || y == 3 || y == 16 || y == 17 || x == 2 || x == 3 || x == 16 || x == 17) {
          level = MAXLEVEL - 1;
        } else if (y == 4 || y == 5 || y == 14 || y == 15 || x == 4 || x == 5 || x == 14 || x == 15) {
          level = MAXLEVEL - 2;
        } else if (y == 6 || y == 7 || y == 12 || y == 13 || x == 6 || x == 7 || x == 12 || x == 13) {
          level = MINLEVEL + 1;
        } else {
          level = MINLEVEL;
        }

        if(encounter == 0 && numPorts > 0){
          world[y][x] = new Port(false,level);
          numPorts--;
        }
      }
    }
    writeMapToCSV();
  }

  /*
   * Internal WorldMap function used to more efficiently write the map to a CSV
   */
  private void writeMapToCSV(){
    writeToCSV(WORLDMAPCSV, "WorldMap.java", false, WORLDMAPHEADER, WORLDMAPFORMAT); //Resets map CSV if it already exists
    for(int y = 0; y < WORLDSIZE; y++){
      for(int x = 0; x < WORLDSIZE; x++){
        writeToCSV(WORLDMAPCSV, "WorldMap.java", true, WORLDMAPHEADER, WORLDMAPFORMAT,world[y][x].getType(),world[y][x].getIndex());
      }
    }
  }

  /*
   * prints the map
   */
  public void printMap(){
    for(int y = 0; y < WORLDSIZE; y++){
      for(int x = 0; x < WORLDSIZE; x++){
        pr(toStr(world[y][x].getSymbol()) + SPACE);
      }
      pr(NEWLINE);
    }
  }
  /*
   * prints the map at a 5x5 scale around the player
   */
  public void printMapZoomed(){}
}