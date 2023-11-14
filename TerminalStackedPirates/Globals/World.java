//File: World.java
//Author: MrFuzzyPants
//Created: 06-07-2023
//Modified: 11-13-2023
package Globals;

import static Globals.Tools.*;
import static Globals.Constants.*;
import static Globals.PlayerAttributes.Location.*;
import Encounters.*;
import Globals.Tools.Pair;

public class World {
  Encounter[][] world = new Encounter[WORLDSIZE][WORLDSIZE];
  
  /*
   * Constructor for the World object
   * @param boolean true if reloading a map false if generating a map.
   */
  public World(Boolean reload){
    String[] mapData = new String[2];
    if(reload){
      for(int y = 0; y < WORLDSIZE; y++){
        for(int x = 0; x < WORLDSIZE; x++){
          mapData = getFromCSVRow(WORLDCSV,"WorldMap.java",INDEX,toStr(y * WORLDSIZE + x));
          if(mapData[1].equals(PORT)){
            world[y][x] = new Port(toInt(mapData[2]));
          } else {
            world[y][x] = new Ocean(true,toInt(mapData[2]));
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
        world[y][x] = new Ocean(false,MINLEVEL);
      }
    }
    // These are all number remaining not number in the world
    int numPorts = NUMPORTS;
    int numBattles = NUMBATTLES;

    //Randomly picks one of the middle squares to be the starting square
    int randomSquare = generateRand(4);
    world[((WORLDSIZE / 2) - 1) + randomSquare / 2][((WORLDSIZE / 2) - 1) + randomSquare % 2] = new Port(true,MINLEVEL);
    setYX(((WORLDSIZE / 2) - 1) + randomSquare / 2,((WORLDSIZE / 2) - 1) + randomSquare % 2); //And sets the players location to that square
    
    int encounter;
    int x;
    int y;
    int level = MINLEVEL;
    while(numPorts > 1 || numBattles > 0){
      x = generateRand(WORLDSIZE);
      y = generateRand(WORLDSIZE);
      if(world[y][x].getType().equals(OCEAN)){
        encounter = generateRand(2) + 1;
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

        if(encounter == GENPORT && numPorts > 0){
          world[y][x] = new Port(false,level);
          numPorts--;
        } else if(encounter == GENBATTLE && numBattles > 0){
          world[y][x] = new Battle(false,level);
        }
      }
    }
    writeMapToCSV();

    // Set the views around the player
    updateViews();
  }

  /*
   * Internal World function used to more efficiently write the map to a CSV
   */
  private void writeMapToCSV(){
    refreshCSV(WORLDCSV,WORLDHEADER);
    for(int y = 0; y < WORLDSIZE; y++){
      for(int x = 0; x < WORLDSIZE; x++){
        writeToCSV(WORLDCSV, "WorldMap.java", true, WORLDHEADER, WORLDFORMAT,world[y][x].getType(),world[y][x].getIndex());
      }
    }
  }

  /*
   * Internal function to set Views around player as they move
   */
  private void updateViews(){
    Pair<Integer,Integer> YX = getYX();
    int yCord = YX.getFirst();
    int xCord = YX.getSecond();
    world[yCord][xCord].viewEncounter();
    boolean smallY = yCord == 0;
    boolean largeY = yCord == WORLDSIZE - 1;
    boolean smallX = xCord == 0;
    boolean largeX = xCord == WORLDSIZE - 1;
    
    if(!largeY){
      world[yCord + 1][xCord].viewEncounter();
      if(!largeX){
        world[yCord + 1][xCord + 1].viewEncounter();
      }
      if(!smallX){
        world[yCord + 1][xCord - 1].viewEncounter();
      }
    }

    if(!largeX){
      world[yCord][xCord + 1].viewEncounter();
    }

    if(!smallX){
      world[yCord][xCord - 1].viewEncounter();
    }

    if(!smallY){
      world[yCord - 1][xCord].viewEncounter();
      if(!largeX){
        world[yCord - 1][xCord + 1].viewEncounter();
      }

      if(!smallX){
        world[yCord - 1][xCord - 1].viewEncounter();
      }
    }
  }

  /*
   * prints the map
   */
  public void printMap(){
    updateViews();
    Pair<Integer,Integer> YX = getYX();
    int yCord = YX.getFirst();
    int xCord = YX.getSecond();

    for(int y = 0; y < WORLDSIZE; y++){
      for(int x = 0; x < WORLDSIZE; x++){
        if(y == yCord && x == xCord){
          pr(PLAYERSYMBOL + SPACE);
        } else if(world[y][x].getViewed()){
          pr(world[y][x].getSymbol() + SPACE);
        } else {
          pr(NOTVIEWEDSYMBOL + SPACE);
        }
      }
      pr(NEWLINE);
    }
  }

  /*
   * prints the map at a 5x5 scale around the player
   */
  public void printMapZoomed(){
    updateViews();
    Pair<Integer,Integer> YX = getYX();
    int yCord = YX.getFirst();
    int xCord = YX.getSecond();
    int minY = 2;
    int maxY = 2;
    int minX = 2;
    int maxX = 2;
    // Edge of map checks
    if(yCord == 1){
      minY = 1;
      maxY = 3;
    } else if(yCord == 0){
      minY = 0;
      maxY = 4;
    } else if(yCord == WORLDSIZE - 2){
      minY = 3;
      maxY = 1;
    } else if(yCord == WORLDSIZE - 1){
      minY = 4;
      maxY = 0;
    }

    if(xCord == 1){
      minX = 1;
      maxX = 3;
    } else if(xCord == 0){
      minX = 0;
      maxX = 4;
    } else if(xCord == WORLDSIZE - 2){
      minX = 3;
      maxX = 1;
    } else if(xCord == WORLDSIZE - 1){
      minX = 4;
      maxX = 0;
    }
    for(int y = yCord - minY; y <= yCord + maxY; y++){
      for(int x = xCord - minX; x <= xCord + maxX; x++){
        if(y == yCord && x == xCord){
          pr(PLAYERSYMBOL + SPACE);
        } else if(world[y][x].getViewed()){
          pr(world[y][x].getSymbol() + SPACE);
        } else {
          pr(NOTVIEWEDSYMBOL + SPACE);
        }
      }
      pr(NEWLINE);
    }
  }

  /*
   * Gets the encounter from coordinates on the map
   * @param y y-coordinate of Encounter
   * @param x x-coordinate of Encounter
   */
  public Encounter getMapEncounter(int y, int x){
    return world[y][x];
  }
}