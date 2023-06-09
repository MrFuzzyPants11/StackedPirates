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
  Encounter[][] world = new Encounter[11][11];
  
  /*
   * Constructor for reloading the map
   */
  public WorldMap(){
    //TODO FIX THIS MATH and function
    String[] mapData = getFromCSVRow(WORLDMAPCSV, "Map.java","ENCOUNTER0", "0");
    for(int y = 0; y < 11; y++){
        for(int x = 0; x < 22; x++){
          if(mapData[(y * 11) + x].equals(PORT)){
            
          }
        }
      }
  }
  /*
   * Constructor for building map from array
   * @param newWorld the array to copy
   */
  public WorldMap(Encounter[][] newWorld){
    world = newWorld;
    writeMapToCSV();
  }

  /*
   * Internal WorldMap function used to more efficiently write the map to a CSv
   */
  private void writeMapToCSV(){
    // Write the CSV content to a file using BufferedWriter
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(WORLDMAPCSV))) {
      // Add header row
      writer.write(WORLDMAPHEADER);
      writer.newLine();

      // Iterate over the world map to add it to file
      for(int y = 0; y < 11; y++){
          for(int x = 0; x < 11; x++){
            writer.write(world[y][x].getType() + COMMA + world[y][x].getIndex());
            if(y * x != 100){
              writer.write(COMMA);
            }
          }
        }

        writer.close();
    } catch (Exception e) {
      prln("writeMapToCSV: Failed to write to CSV file.", RED);
    }
  }
}