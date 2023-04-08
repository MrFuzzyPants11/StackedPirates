//File: Tools.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-07-2023
package Globals;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import Items.*;
import Items.Cards.*;
import Items.Packs.*;

public class Tools {

  // BASIC METHOD SHORTENING TOOLS | BASIC METHOD SHORTENING TOOLS | BASIC METHOD SHORTENING TOOLS
  // BASIC METHOD SHORTENING TOOLS | BASIC METHOD SHORTENING TOOLS | BASIC METHOD SHORTENING TOOLS
  // BASIC METHOD SHORTENING TOOLS | BASIC METHOD SHORTENING TOOLS | BASIC METHOD SHORTENING TOOLS

  /*
   * Converts int to string
   * @param num The number to convert
   */
  public static String toStr(int num){
    return Integer.toString(num);
  }

  /*
   * Converts string to int
   * @param str The string to convert
   */
  public static int toInt(String str){
    return Integer.parseInt(str);
  }

  /*
   * Converts string to boolean
   * @param str The string to convert
   */
  public static boolean toBool(String str){
    return Boolean.parseBoolean(str);
  }

  /*
   * Converts boolean to string
   * @param bool The boolean to convert
   */
  public static String toStr(boolean bool){
    return Boolean.toString(bool);
  }

  // GENERATION METHODS | GENERATION METHODS | GENERATION METHODS
  // GENERATION METHODS | GENERATION METHODS | GENERATION METHODS
  // GENERATION METHODS | GENERATION METHODS | GENERATION METHODS
  
  /*
   * Generates a random first name from either the English or Spanish list
   * @param english Whether to generate an English or Spanish name
   * @return The generated name
   */
  static ArrayList<String> enFirstNames = new ArrayList<String>();
  static ArrayList<String> esFirstNames = new ArrayList<String>();
  public static String generateFirstName(Boolean english) {
    Random rand = new Random();
    if(english){
      return enFirstNames.get(rand.nextInt(enFirstNames.size()));
    } else {
      return esFirstNames.get(rand.nextInt(esFirstNames.size()));
    }
  }

  /*
   * Generates a random last name from either the English or Spanish list
   * @param english Whether to generate an English or Spanish name
   * @return The generated name
   */
  static ArrayList<String> enLastNames = new ArrayList<String>();
  static ArrayList<String> esLastNames = new ArrayList<String>();
  public static String generateLastName(Boolean english) {
    Random rand = new Random();
    if(english){
      return enLastNames.get(rand.nextInt(enLastNames.size()));
    } else {
      return esLastNames.get(rand.nextInt(esLastNames.size()));
    }
  }

  // PRINT METHODS | PRINT METHODS | PRINT METHODS
  // PRINT METHODS | PRINT METHODS | PRINT METHODS
  // PRINT METHODS | PRINT METHODS | PRINT METHODS

  /*
   * Prints a string with a newline at the end
   * @param str The string to print
   */
  public static void prln(String str){
    System.out.print(str + "\n");
  }

  /*
   * Prints a string without a newline
   * @param str The string to print
   */
  public static void pr(String str){
    System.out.print(str);
  }

  /*
   * Prints a string with a newline at the beginning
   * @param str The string to print
   */
  public static void prnl(String str){
    System.out.print("\n" + str);
  }

  /*
   * Prints a coloured string with a newline at the end
   * @param str The string to print
   * @param col The ANSI colour code to print the text in
   */
  public static void prln(String str, String col){
    if(col.equals("RAINBOWBABY")){
      prln(rainbowIfier(str));
    } else if(col.equals("BROWNBOWBABY")) {
      prln(brownbowIfier(str));
    } else {
      prln("\u001B[" + col + "m" + str + "\u001B[0m");
    }
  }

  /*
   * Prints a coloured string without a newline
   * @param str The string to print
   * @param col The ANSI colour code to print the text in
   */
  public static void pr(String str, String col){
    if(col.equals("RAINBOWBABY")){
      pr(rainbowIfier(str));
    } else if(col.equals("BROWNBOWBABY")) {
      pr(brownbowIfier(str));
    } else {
      pr("\u001B[" + col + "m" + str + "\u001B[0m");
    }
  }

  /*
   * Prints a coloured string with a newline at the beginning
   * @param str The string to print
   * @param col The ANSI colour code to print the text in
   */
  public static void prnl(String str, String col){
    if(col.equals("RAINBOWBABY")){
      prnl(rainbowIfier(str));
    } else if(col.equals("BROWNBOWBABY")) {
      prnl(brownbowIfier(str));
    } else {
      prnl("\u001B[" + col + "m" + str + "\u001B[0m");
    }
  }

  /*
   * Used internally to print rainbow text
   * @param str The string to print in rainbow text
   */
  private static String rainbowIfier(String str){
    final String[] rainbowColours = {"\u001B[31;3m", "\u001B[33;3m", "\u001B[32;3m", "\u001B[36;3m", "\u001B[34;3m", "\u001B[35;3m"};
    String temp = "";
    for (int i = 0; i < str.length(); i++) {
      temp = temp + rainbowColours[i % rainbowColours.length] + str.charAt(i);
    }
    return (temp + "\u001B[0m");
  }

  /*
   * Used internally to print "brownbow" (black and white) text
   * @param str The string to print in brownbow text
   */
  private static String brownbowIfier(String str){
    final String[] brownbowColours = {"\u001B[30;1m","\u001B[30;1m","\u001B[37;1m","\u001B[37;1m"};
    String temp = "";
    for (int i = 0; i < str.length(); i++) {
      temp = temp + brownbowColours[i % brownbowColours.length] + str.charAt(i);
    }
    return (temp + "\u001B[0m");
  }
  
  /*
   * Sends an invalid option message to the user
   */
  public static void invalOp(){
    prln("That is not a valid option.", "31");
  }

  /*
   * Prints a line of text to separate sections of the terminal
   */
  public static void lineBreaker(String middle){
    int sidedPaddingLength = (64 - middle.length()) / 2;
    pr("<>".repeat(sidedPaddingLength / 2),"BROWNBOWBABY");
    pr(middle,"1;4");
    prln("<>".repeat(sidedPaddingLength / 2),"BROWNBOWBABY");
  }


  // INTERACTIVE USER METHODS | INTERACTIVE USER METHODS | INTERACTIVE USER METHODS
  // INTERACTIVE USER METHODS | INTERACTIVE USER METHODS | INTERACTIVE USER METHODS
  // INTERACTIVE USER METHODS | INTERACTIVE USER METHODS | INTERACTIVE USER METHODS
  
  static Scanner scanner;
  /*
   * Initializes the scanner
   */
  public static void initializeScanner(){
    scanner = new Scanner(System.in);
  }

  /*
   * Closes the scanner
   */
  public static void closeScanner(){
    scanner.close();
  }

  /*
   * Asks the user for input from the terminal and adds a breakline after input is received
   * This can also go to other menus if special characters are entered
   * @return The string the user entered as an int
   */
  public static int askIn(){
    pr("Enter Response: ");
    String userInput = scanner.nextLine();
    int input;
    if(userInput.equals("i")){
      viewInventory();
      input = Integer.MIN_VALUE;
    } else if(userInput.equals("s")){
      viewSettingsMenu();
      input = Integer.MIN_VALUE;
    } else {
      input = toInt(userInput);
    }
    lineBreaker("");
    return input;
  }

  /*
   * Prints out the settings menu
   */
  public static void viewSettingsMenu(){
    lineBreaker(" SETTINGS MENU");
    int input = askIn();
  }
  
  /* 
   * Prints the inventory CSV in a user viewable format (Inventory Screen)
   */
  public static void viewInventory(){
    lineBreaker("INVENTORY");
    ArrayList<Pack> packs = new ArrayList<Pack>();
    ArrayList<Card> cards = new ArrayList<Card>();
    int it = 0;
    Item currentItem = getFromInventory(it);
    while(currentItem != null){
      if(currentItem instanceof Pack){
        packs.add((Pack)currentItem);
      } else if(currentItem instanceof Card){
        cards.add((Card)currentItem);
      }
      it++;
      currentItem = getFromInventory(it);
    }

    lineBreaker("PACKS");
    int i = 0;
    while(i < packs.size()){
      pr((i + 1) + ". ");
      pr(packs.get(i).getRarity(), packs.get(i).getColour());
      prln(" " + packs.get(i).getName());
      i++;
    }

    lineBreaker("CARDS");
    for(int j = 0; j < cards.size(); j++){
      pr((i + 1) + ". ");
      pr(cards.get(j).getRarity(), cards.get(j).getColour());
      prln(" " + cards.get(j).getName());
      i++;
    }

    prln("What would you like to do?");
    int input = askIn();
  }

  // CSV METHODS | CSV METHODS | CSV METHODS
  // CSV METHODS | CSV METHODS | CSV METHODS
  // CSV METHODS | CSV METHODS | CSV METHODS

  /*
   * Refreshes all CSVs to delete their contents
   */
  public static void cleanCSVFiles(){
    refreshCSV("allcards","Type,Rarity,Name");
    refreshCSV("allpacks","Type,Sold,Rarity,Cost,Card1,Card2,Card3,Card4,Card5");
    refreshCSV("human","");
    refreshCSV("inventory","InInventory,Type,SubType,ItemIndex");
    refreshCSV("player","Fname,Lname,Level,Health,Gold,Cards");
    refreshCSV("playership","");
    refreshCSV("ports","Name,SupplyStore,Tavern,Dockyard");
    refreshCSV("supplystores","Level,Pack0,Pack1,Pack2,Pack3,Pack4,Pack5,Pack6,Pack7,Pack8,Pack9");
  }

  /*
   * Refreshes a CSV file to delete its contents
   * @param filename The name of the file to refresh
   * @param headerRow The header row to write to the file
   */
  private static void refreshCSV(String filename, String headerRow) {
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter("TerminalStackedPirates/Globals/SaveGameFiles/" + filename + ".csv"));
      writer.write("Index," + headerRow + "\n");

      writer.close();
    } catch (Exception e){
      prln("refreshCSV: Failed to write to CSV file.", "31");
    }
  }

  /*
   * Writes a row of data to a CSV file
   * @param filename The name of the file to write to
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @param append Whether to append to the file or overwrite it
   * @param headerRow The header row to write to the file
   * @param format The format of the data to write to the file
   * @param data The data to write to the file
   */
  public static void writeToCSV(String filename, String comingFrom, boolean append, String headerRow, String format, Object... data) {
    try{
      String filepath = "TerminalStackedPirates/Globals/SaveGameFiles/" + filename + ".csv";
      BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, append));

      // If the file is being overwritten, write the header row with index value
      if (!append) {
        writer.write("Index," + headerRow + "\n");
      }

      // Get the number of rows in the file (if overwritten will be 1)
      int numRows = 0;
      if (Files.exists(Paths.get(filepath))) {
        numRows = Files.lines(Paths.get(filepath)).skip(1).toArray().length; // Skip header row
      }

      // Use that number to add an index to all the rows
      int numCols = format.split(",").length;
      for (int i = 0; i < data.length; i += numCols) {
        writer.write(numRows + i/numCols + ",");
        for (int j = 0; j < numCols; j++) {
          writer.write(String.valueOf(data[i + j]));
          if (j < numCols - 1) {
            writer.write(",");
          }
        }
        writer.write("\n");
      }
        writer.close();
    } catch (Exception e){
      prln("writeToCSV: " + comingFrom + ": Failed to write to CSV file.", "31");
    }
  }

  /*
   * Writes a specific value to a CSV row
   * @param filename The name of the file to read from
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @param searchColumn The column to search for the search value
   * @param searchValue The value to search for in the search column
   * @param changeColumn The column to change the value in
   * @param newValue The new value to change the value in the change column to
   */
  public static void writeToCSVValue(String filename, String comingFrom, String searchColumn, String searchValue, String changeColumn, String newValue) {
    try{
      // Read the CSV file into a 2D array (data[][])
      List<String[]> lines = new ArrayList<>();
      BufferedReader reader = new BufferedReader(new FileReader("TerminalStackedPirates/Globals/SaveGameFiles/" + filename + ".csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] values = line.split(",");
        lines.add(values);
      }
      reader.close();
      String[][] data = lines.toArray(new String[0][]);

      // Find the column index of the header column
      int searchColumnIndex = -1;
      for (int i = 0; i < data[0].length; i++) {
        if (data[0][i].equals(searchColumn)) {
          searchColumnIndex = i;
          break;
        }
      }
      if (searchColumnIndex == -1) {
        prln("writeToCSVValue: " + comingFrom + ": " + searchColumn + "searchColumn not found in CSV file", "31");
      }

      // Find the row index of the value in that header column
      int rowIndex = -1;
      for (int i = 1; i < data.length; i++) {
        if (data[i][searchColumnIndex].equals(searchValue)) {
          rowIndex = i;
          break;
        }
      }
      if (rowIndex == -1) {
        prln("writeToCSVValue: " + comingFrom + ": " + searchValue + "searchValue not found in CSV file", "31");
      }

      // Find the column index of the column to change
      int changeColumnIndex = -1;
      for (int i = 0; i < data[0].length; i++) {
        if (data[0][i].equals(changeColumn)) {
          changeColumnIndex = i;
          break;
        }
      }
      if (changeColumnIndex == -1) {
        prln("writeToCSVValue: " + comingFrom + ": " + changeColumn + "changeColumn not found in CSV file", "31");
      }

      // Update the value in our array of the data
      data[rowIndex][changeColumnIndex] = newValue;

      // Write the updated array back to the CSV file
      BufferedWriter writer = new BufferedWriter(new FileWriter("TerminalStackedPirates/Globals/SaveGameFiles/" + filename + ".csv"));
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
          writer.write(data[i][j]);
          if (j < data[i].length - 1) {
            writer.write(",");
          }
        }
        writer.write("\n");
      }
      writer.close();
    } catch (Exception e){
      prln("writeToCSVValue: " + comingFrom + ": Failed to read from CSV file.", "31");
    }
  }

  /*
   * Gets a specific value from a CSV file
   * @param filename The name of the file to read from
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @param searchColumn The column to search for the search value
   * @param searchValue The value to search for in the search column
   * @param resultColumn The column to return the result from
   * @return The value in the result column of the row with the search value in the search column
   * @return null if the search value or either columns are not found
   */
  public static String getFromCSVValue(String filename, String comingFrom, String searchColumn, String searchValue, String resultColumn){
    try {
      BufferedReader reader = new BufferedReader(new FileReader("TerminalStackedPirates/Globals/SaveGameFiles/" + filename + ".csv"));

      // Get the index of the search column and result column
      String headerRow = reader.readLine();
      String[] columns = headerRow.split(",");
      int searchColumnIndex = -1;
      int resultColumnIndex = -1;
      for (int i = 0; i < columns.length; i++) {
        if (columns[i].equals(searchColumn)) {
            searchColumnIndex = i;
        }
        if (columns[i].equals(resultColumn)) {
            resultColumnIndex = i;
        }
      }
      if (searchColumnIndex == -1) {
        prln("getFromCSVValue: " +  comingFrom + ": " + searchColumn + "searchColumn not found in CSV file", "31");
        reader.close();
        return null;
      }
      if (resultColumnIndex == -1) {
        prln("getFromCSVValue: " + comingFrom + ": " + resultColumn + "resultColumn not found in CSV file", "31");
        reader.close();
        return null;
      }
  
      // Search for the search value in the search column then save that row in a string array
      String row;
      while ((row = reader.readLine()) != null) {
        String[] values = row.split(",");
        if (values[searchColumnIndex].equals(searchValue)) {
            reader.close();
            return values[resultColumnIndex]; //Return the value in the result column from that array
        }
      }
  
      reader.close();
      return null;
    } catch (Exception e){
      prln("getFromCSVValue: " + comingFrom + ": Failed to read from CSV file.", "31");
      return null;
    }
  }

  /*
   * Gets a specific row from a CSV file
   * @param filename The name of the file to read from
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @param columnName The name of the column to search for the value
   * @param value The value to search for in the column
   * @return The row with the value in the column as a String array
   * @return null if the value or column are not found
   */
  public static String[] getFromCSVRow(String filename, String comingFrom, String columnName, String value) {
    try{
      BufferedReader reader = new BufferedReader(new FileReader("TerminalStackedPirates/Globals/SaveGameFiles/" + filename + ".csv"));
      
      // Get the index of the column
      String header = reader.readLine();
      String[] columnNames = header.split(",");
      int columnIndex = -1;
      for (int i = 0; i < columnNames.length; i++) {
          if (columnNames[i].equals(columnName)) {
              columnIndex = i;
              break;
          }
      }
      if (columnIndex == -1) {
          reader.close();
          throw new IllegalArgumentException("Column name not found in CSV file");
      }

      // Search for the value in the column then save that row in a string array
      String line;
      while ((line = reader.readLine()) != null) {
          String[] row = line.split(",");
          if (row[columnIndex].equals(value)) {
              reader.close();
              return row; //Return that array
          }
      }
      reader.close();
      return null;
    } catch (Exception e){
      prln("getFromCSVRow: " + comingFrom + ": Failed to read from CSV file.", "31");
      return null;
    }
  }

  /*
   * Gets the entire contents of a CSV file as a 2D array
   * @param filename The name of the file to read from
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @return The contents of the CSV file as a 2D array
   */
  public static ArrayList<ArrayList<String>> getFromCSVFile(String filename, String comingFrom) {
    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    try {
        BufferedReader reader = new BufferedReader(new FileReader("TerminalStackedPirates/Globals/" + filename + ".csv"));

        // Read in rows and split into columns
        String row;
        reader.readLine(); // Skip header row
        while ((row = reader.readLine()) != null) {
            String[] columns = row.split(",");
            ArrayList<String> rowData = new ArrayList<String>(Arrays.asList(columns));
            data.add(rowData);
        }

        reader.close();
    } catch (Exception e) {
        prln("getFromCSVFile: " + comingFrom + ": Failed to read from CSV file.", "31");
    }
    return data;
  }
  /*
   * Gets the last index of a CSV file
   * @param filename The name of the file to read from
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @return The last index of the CSV file
   * @return Integer.MAX_VALUE if the file does not exist
   */
  public static int getFromCSVLastIndex(String filename, String comingFrom) {
    try{
      BufferedReader reader = new BufferedReader(new FileReader("TerminalStackedPirates/Globals/SaveGameFiles/" + filename + ".csv"));
      List<String> lines = new ArrayList<String>();
      String line = reader.readLine();
      while (line != null) {
          lines.add(line);
          line = reader.readLine();
      }
      reader.close();
      return lines.size() - 2;
    } catch (Exception e){
      prln("getFromCSVIndex: " + comingFrom + ": Failed to read from CSV file.", "31");
      return Integer.MAX_VALUE;
    }
  }
  // // INVENTORY SPECIFIC CSV METHODS | INVENTORY SPECIFIC CSV METHODS
  // // INVENTORY SPECIFIC CSV METHODS | INVENTORY SPECIFIC CSV METHODS
  // // INVENTORY SPECIFIC CSV METHODS | INVENTORY SPECIFIC CSV METHODS

  /*
   * Saves an item into the inventory CSV file
   * @param item The item to save
   */
  public static void addToInventory(Item item){
    writeToCSV("inventory","Tools.java",true,"InInventory,Type,SubType,ItemIndex","%s,%s,%s,%d","true",item.getItemType(),item.getType(),item.getIndex());
  }

  /*
   * Removes an item from the inventory CSV file
   * @param item The item to remove
   */
  public static void removeFromInventory(Item item){
    writeToCSVValue("inventory","Tools.java","Index",toStr(item.getIndex()),"InInventory","false");
  }

  /*
   * Gets an item from the inventory CSV file
   * @param index The index of the item to get
   * @return The item at the index
   * @return null if the index is not found
   */
  public static Item getFromInventory(int index){
    String[] itemData = getFromCSVRow("inventory","Tools.java","Index",toStr(index));
    if(itemData != null){
      if(toBool(itemData[1])){
        if(itemData[2].equals("pack")){
          if(itemData[3].equals("crew")){
            return new CrewPack(true,toInt(itemData[4]));
          } else if(itemData[3].equals("food")){
            return new FoodPack(true,toInt(itemData[4]));
          } else if(itemData[3].equals("ship")){
            return new ShipPack(true,toInt(itemData[4]));
          }
        } else if(itemData[2].equals("card")){
          if(itemData[3].equals("crew")){
            return new CrewCard(true,toInt(itemData[4]));
          } else if(itemData[3].equals("food")){
            return new FoodCard(true,toInt(itemData[4]));
          } else if(itemData[3].equals("ship")){
            return new ShipCard(true,toInt(itemData[4]));
          }
        }
      }
    }
    return null;
  }

  // OTHER FILE METHODS | OTHER FILE METHODS | OTHER FILE METHODS
  // OTHER FILE METHODS | OTHER FILE METHODS | OTHER FILE METHODS
  // OTHER FILE METHODS | OTHER FILE METHODS | OTHER FILE METHODS

  /*
   * Loads the name files into arrayLists to store them in memory instead of accessing the very
   * large text files every time a name is needed (Which will be often)
   */
  public static void LoadNameFiles(){
    getFromTXT(enFirstNames,"Smashew Names/enfirstnames");
    getFromTXT(esFirstNames,"Smashew Names/esfirstnames");
    getFromTXT(enLastNames,"Smashew Names/enlastnames");
    getFromTXT(esLastNames,"Smashew Names/esLastnames");
  }

  /*
   * Gets a txt file as an ArrayList
   * @param array the ArrayList to store the lines in
   * @param filename The name of the file to read from
   */
  private static void getFromTXT(ArrayList<String> array,String filename){
    try {

      // Open the file for reading
      BufferedReader reader = new BufferedReader(new FileReader("TerminalStackedPirates/Globals/"+ filename + ".txt"));

      // Read each line and add it to the list
      String line = reader.readLine();
      while (line != null) {
          array.add(line);
          line = reader.readLine();
      }

      // Close the reader
      reader.close();

    } catch (IOException e) {
      prln("getFromTXT: Failed to read from txt file.", "31");
    }
  }
}