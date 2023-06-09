//File: Map.java
//Author: MrFuzzyPants
//Created: 06-07-2023
//Modified: 06-07-2023
package Globals;

import static Globals.Tools.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import static Globals.Constants.*;
import Encounters.*;

public class WorldMap {
  Encounter[][] world = new Encounter[WORLDSIZE][WORLDSIZE];
  
  /*
   * Constructor for reloading the map
   * @param boolean true if reloading a map false if generating a map.
   */
  public WorldMap(Boolean reload){
    if(reload){
      String[] mapData = getFromFirstCSVRow(WORLDMAPCSV, "Map.java");
      for(int y = 0; y < WORLDSIZE; y++){
        for(int x = 0; x < WORLDSIZE*2; x = x + 2){ //Skips indexes to only look at encounter types
          if(mapData[(y * WORLDSIZE) + x].equals(PORT)){ //Checks data for the place at [y][x] but linearily
            world[y][x/2] = new Port(toInt(mapData[(y * WORLDSIZE) + x + 1])); // Saves the port at the index as saved for x;
          } else if(mapData[(y * WORLDSIZE) + x].equals(BASIC)){
            world[y][x/2] = new Basic();
          }
        }
      }
    } else {
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
  }

  /*
   * Internal WorldMap function used to more efficiently write the map to a CSv
   */
  private void writeMapToCSV(){
    // Write the CSV content to a file using BufferedWriter
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(WORLDMAPCSV))) {

      // Iterate over the world map to add it to file
      for(int y = 0; y < WORLDSIZE; y++){
          for(int x = 0; x < WORLDSIZE; x++){
            writer.write(world[y][x].getType() + COMMA + world[y][x].getIndex());
            if(y != WORLDSIZE -1 && x != WORLDSIZE - 1){
              writer.write(COMMA);
            }
          }
        }

        writer.close();
    } catch (Exception e) {
      prln("writeMapToCSV: Failed to write to CSV file.", RED);
    }
  }

  /*
   * prints the map
   */
  public void printMap(){
    for(int y = 0; y < WORLDSIZE; y++){
      for(int x = 0; x < WORLDSIZE; x++){
        pr(toStr(world[y][x].getSymbol()));
      }
      pr(NEWLINE);
    }
  }
  /*
   * prints the map at a 5x5 scale around the player
   */
  public void printMapZoomed(){}
}