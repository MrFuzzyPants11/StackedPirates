//File: Tools.java
//Author: MrFuzzyPants
//Created: 04-04-2023
//Modified: 06-07-2023
package Globals;

import static Globals.Constants.*;
import static Globals.PlayerAttributes.Inventory.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import Items.Packs.*;
import Items.Cards.*;
import static Globals.Encyclopedia.*;

public abstract class Tools {

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
   * Converts char to string
   * @param num The number to convert
   */
  public static String toStr(char c){
    return "" + c;
  }

  /*
   * Converts boolean to string
   * @param bool The boolean to convert
   */
  public static String toStr(boolean bool){
    return Boolean.toString(bool);
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
   * Waits a certain amount of time
   * @param time The time to wait in milliseconds
   */
  public static void sleep(int time){
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      // Do nothing, if it can't wait that wont break anything
    }
  }

  /*
   * Returns the string with the first letter capitalized and the rest lowercase
   * @param str The string to convert
   * @return The converted string
   */
  public static String firstCap(String str){
    return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
  }

  /*
   * Returns the string with the first letter of each word is capialized and the rest lowercase
   * @param str The string to convert
   * @return The converted string
   */
  public static String everyFirstCap(String str){
    String[] words = str.split("\\s+");
    StringBuilder output = new StringBuilder();
    for (String word : words) {
        output.append(word.substring(0, 1).toUpperCase());
        output.append(word.substring(1));
        output.append(" ");
    }
    return output.toString().trim();
  }

  /*
   * Returns the string with all letters capitalized
   * @param str The string to convert
   * @return The converted string
   */
  public static String allCaps(String str){
    return str.toUpperCase();
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
    if(english){
      return enFirstNames.get(generateRand(enFirstNames.size()));
    } else {
      return esFirstNames.get(generateRand(esFirstNames.size()));
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
    if(english){
      return enLastNames.get(generateRand(enLastNames.size()));
    } else {
      return esLastNames.get(generateRand(esLastNames.size()));
    }
  }

  /*
   * Generates a random level to be used based on the inputed level
   * @param val The level to generate from
   * @return The generated level
   */
  public static int generateLevel(int val) {
    if(val == MINLEVEL){
      if (generateRand(3) < 2) { // 66% chance of MINLEVEL IF VAL IS MINLEVEL
        return MINLEVEL;
      } else {
        return MINLEVEL + 1;
      }
    }
    if (val == MAXLEVEL) {
      if (generateRand(3) < 2) { // 66% chance of MAXLEVEL IF VAL IS MAXLEVEL
        return MAXLEVEL;
      } else {
        return MAXLEVEL - 1;
      }
    }
    return generateRand(3) + val - 1; // val-1 or val or val + 1
  }

  /*
   * Generates a random number between 0 and max - 1
   * @param maxPlusOne The max number to generate (-1)
   * @return The generated number
   */
  public static int generateRand(int maxPlusOne) {
    Random rand = new Random();
    return rand.nextInt(maxPlusOne);
  }

  /*
   * Generates a random boolean
   */
  public static boolean generateRand() {
    Random rand = new Random();
    return rand.nextBoolean();
  }

  // MISC METHODS | MISC METHODS | MISC METHODS
  // MISC METHODS | MISC METHODS | MISC METHODS
  // MISC METHODS | MISC METHODS | MISC METHODS

  /*
   * Sorts a Pack ArrayList by rarity
   * @param ArrayList of Packs
   */
  public static ArrayList<Pack> sortPacksByRarity(ArrayList<Pack> packs){
    ArrayList<Pack> sortedList = new ArrayList<Pack>();
    for(int i = 0; i < packs.size();i++){
      if(packs.get(i).getRarity() == COMMONNUM){
        sortedList.add(packs.get(i));
      }
    }

    for(int i = 0; i < packs.size();i++){
      if(packs.get(i).getRarity() == UNCOMMONNUM){
        sortedList.add(packs.get(i));
      }
    }

    for(int i = 0; i < packs.size();i++){
      if(packs.get(i).getRarity() == RARENUM){
        sortedList.add(packs.get(i));
      }
    }

    for(int i = 0; i < packs.size();i++){
      if(packs.get(i).getRarity() == EPICNUM){
        sortedList.add(packs.get(i));
      }
    }

    for(int i = 0; i < packs.size();i++){
      if(packs.get(i).getRarity() == LEGENDARYNUM){
        sortedList.add(packs.get(i));
      }
    }

    return sortedList;
  }

  /*
   * Sorts a Card ArrayList by rarity
   * @param ArrayList of Cards
   */
  public static ArrayList<Card> sortCardsByRarity(ArrayList<Card> cards){
    ArrayList<Card> sortedList = new ArrayList<Card>();
    for(int i = 0; i < cards.size();i++){
      if(cards.get(i).getRarity() == COMMONNUM){
        sortedList.add(cards.get(i));
      }
    }

    for(int i = 0; i < cards.size();i++){
      if(cards.get(i).getRarity() == UNCOMMONNUM){
        sortedList.add(cards.get(i));
      }
    }

    for(int i = 0; i < cards.size();i++){
      if(cards.get(i).getRarity() == RARENUM){
        sortedList.add(cards.get(i));
      }
    }

    for(int i = 0; i < cards.size();i++){
      if(cards.get(i).getRarity() == EPICNUM){
        sortedList.add(cards.get(i));
      }
    }

    for(int i = 0; i < cards.size();i++){
      if(cards.get(i).getRarity() == LEGENDARYNUM){
        sortedList.add(cards.get(i));
      }
    }

    return sortedList;
  }

  // PRINT METHODS | PRINT METHODS | PRINT METHODS
  // PRINT METHODS | PRINT METHODS | PRINT METHODS
  // PRINT METHODS | PRINT METHODS | PRINT METHODS

  /*
   * Prints a string with a newline at the end
   * @param str The string to print
   */
  public static void prln(String str){
    System.out.print(str + NEWLINE);
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
    System.out.print(NEWLINE + str);
  }

  /*
   * Prints a coloured string with a newline at the end
   * @param str The string to print
   * @param col The ANSI colour code to print the text in
   */
  public static void prln(String str, String col){
    if(col.equals(RAINBOW)){
      prln(rainbowIfier(str));
    } else if(col.equals(BROWNBOW)) {
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
    if(col.equals(RAINBOW)){
      pr(rainbowIfier(str));
    } else if(col.equals(BROWNBOW)) {
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
    if(col.equals(RAINBOW)){
      prnl(rainbowIfier(str));
    } else if(col.equals(BROWNBOW)) {
      prnl(brownbowIfier(str));
    } else {
      prnl("\u001B[" + col + "m" + str + "\u001B[0m");
    }
  }

  /*
   * Used internally to print rainbow text
   * @param str The string to print in rainbow text
   */
  private static short rainbowMegaTracker = 0; // This makes the rainbow transition universally, if one string ends on green the next will start on cyan
                                                // So rainbow isn't always red first. It's a bit of a hack but it works.
  private static String rainbowIfier(String str){
    final String[] rainbowColours = {"\u001B[31;3m", "\u001B[33;3m", "\u001B[32;3m", "\u001B[36;3m", "\u001B[34;3m", "\u001B[35;3m"};
    String temp = EMPTY;
    for (int i = 0; i < str.length(); i++) {
      temp = temp + rainbowColours[rainbowMegaTracker] + str.charAt(i);
      if(rainbowMegaTracker >= 5){
        rainbowMegaTracker = 0;
      } else {
        rainbowMegaTracker++;
      }
    }
    return (temp + "\u001B[0m");
  }

  /*
   * Used internally to print "brownbow" (black and white) text
   * @param str The string to print in brownbow text
   */
  private static short brownbowMegaTracker = 0;
  private static String brownbowIfier(String str){
    final String[] brownbowColours = {"\u001B[30;1m","\u001B[30;1m","\u001B[37;1m","\u001B[37;1m"};
    String temp = EMPTY;
    for (int i = 0; i < str.length(); i++) {
      temp = temp + brownbowColours[brownbowMegaTracker] + str.charAt(i);
      if(brownbowMegaTracker >= 3){
        brownbowMegaTracker = 0;
      } else {
        brownbowMegaTracker++;
      }
    }
    return (temp + "\u001B[0m");
  }
  
  /*
   * Sends an invalid option message to the user
   */
  public static void invalOp(){
    prln("That is not a valid option.", RED);
  }

  /*
   * Prints a line of text to separate sections of the terminal
   * @param middle The text to print in the middle of the line
   */
  public static void lineBreaker(String middle){
    int sidedPaddingLength = (64 - middle.length()) / 2;
    pr("<>".repeat(sidedPaddingLength / 2),BROWNBOW);
    pr(middle,"1;4");
    prln("<>".repeat(sidedPaddingLength / 2),BROWNBOW);
  }

  /*
   * Prints a line of text to separate sections of the terminal
   * @param middle The text to print in the middle of the line
   * @param col The ANSI colour code to print the text in
   */
  public static void lineBreaker(String middle, String col){
    int sidedPaddingLength = (64 - middle.length()) / 2;
    pr("<>".repeat(sidedPaddingLength / 2),col);
    if(col.equals(RAINBOW)){
      pr(rainbowIfierForLineBreaker(middle));
    } else if(col.equals(BROWNBOW)) {
      pr(middle,BROWNBOW);
    } else {
      pr(middle,col + ";1;4");
    }
    prln("<>".repeat(sidedPaddingLength / 2),col);
  }

  /*
   * Used internally to print rainbow text in the lineBreaker text format
   * @param str The string to print in rainbow text
   */
  private static String rainbowIfierForLineBreaker(String str){
    final String[] rainbowColours = {"\u001B[31;1;4m", "\u001B[33;1;4m", "\u001B[32;1;4m", "\u001B[36;1;4m", "\u001B[34;1;4m", "\u001B[35;1;4m"};
    String temp = EMPTY;
    for (int i = 0; i < str.length(); i++) {
      if(rainbowMegaTracker >= 5){
        rainbowMegaTracker = 0;
      } else {
        rainbowMegaTracker++;
      }
      temp = temp + rainbowColours[rainbowMegaTracker] + str.charAt(i);
    }
    return (temp + "\u001B[0m");
  }

  /*
   * Prints the world map
   */
  public static void prMap(){
    (new World(true)).printMap();
  }

  /*
   * Prints the world map zoomed to the 5x5 around the player
   */
  public static void prMapZoomed(){
    (new World(true)).printMapZoomed();
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
  public static final Map<Character,Integer> charMap = Map.ofEntries(Map.entry('A', A),Map.entry('a', A),Map.entry('B', B),Map.entry('b', B),Map.entry('C', C),Map.entry('c', C),Map.entry('D', D),Map.entry('d', D),Map.entry('E', E),Map.entry('e', E),Map.entry('F', F),Map.entry('f', F),Map.entry('G', G),Map.entry('g', G),Map.entry('H', H),Map.entry('h', H),Map.entry('I', I),Map.entry('i', I),Map.entry('J', J),Map.entry('j', J),Map.entry('K', K),Map.entry('k', K),Map.entry('L', L),Map.entry('l', L),Map.entry('M', M),Map.entry('m', M),Map.entry('N', N),Map.entry('n', N),Map.entry('O', O),Map.entry('o', O),Map.entry('P', P),Map.entry('p', P),Map.entry('Q', Q),Map.entry('q', Q),Map.entry('R', R),Map.entry('r', R),Map.entry('S', S),Map.entry('s', S),Map.entry('T', T),Map.entry('t', T),Map.entry('U', U),Map.entry('u', U),Map.entry('V', V),Map.entry('v', V),Map.entry('W', W),Map.entry('w', -23),Map.entry('X', X),Map.entry('x', X),Map.entry('Y', Y),Map.entry('y', Y),Map.entry('Z', Z),Map.entry('z', Z ));
  public static int askIn(){
    pr("Enter Response: ");
    String userInput = scanner.nextLine();
    int input = -6969;
    // I have to use Integer.parseInt() because I can't throw an error from toInt() without having to handle it everywhere
    try {
      input = Integer.parseInt(userInput);
    } catch (NumberFormatException e) {
      if(charMap.containsKey(userInput.charAt(0))){
        input = charMap.get(userInput.charAt(0));
      }
    }

    if(input == I){ // If the user enters 'i' or 'I'
      viewInventory();
      input = MENUEXIT;
    } else if(input == P){ // If the user enters 'p' or 'P'
      viewPauseMenu();
      input = MENUEXIT;
    } else if(input == Q){ // If the user enters 'q' or 'Q'
      input = QUIT;
    } else if(input == -6969){ // If they didn't enter an int or a char
      invalOp();
      input = askIn();
    }

    lineBreaker(EMPTY);
    return input;
  }

  public static String askStr(){
    pr("Enter Response: ");
    String userInput = scanner.nextLine();
    lineBreaker(EMPTY);
    return userInput;
  }

  /*
   * Prints out the PAUSE menu
   */
  public static void viewPauseMenu(){
    lineBreaker("PAUSE MENU");
    while(true){
      prln("1. Settings");
      prln("2. SP Encyclopedia");
      prln("Q. Close Menu");
      int input = askIn();
      if(input == 1){
        //Open Settings
      } else if(input == 2){
        viewEncyclopedia();
      } else if(input == QUIT){
        break;
      } else if(input == MENUEXIT){ 
        continue;
      } else {
        invalOp();
        continue;
      }
    }
  }

  // CSV METHODS | CSV METHODS | CSV METHODS
  // CSV METHODS | CSV METHODS | CSV METHODS
  // CSV METHODS | CSV METHODS | CSV METHODS

  /*
   * Refreshes all CSVs to delete their contents
   */
  public static void cleanCSVFiles(){
    refreshCSV(BARTENDERSCSV,BARTENDERSHEADER);
    refreshCSV(CREWCARDSCSV,CREWCARDSHEADER);
    refreshCSV(CREWLISTCSV,CREWLISTHEADER);
    refreshCSV(CREWSCSV,ALLCREWSHEADER);
    refreshCSV(DOCKYARDSCSV,DOCKYARDHEADER);
    refreshCSV(FOODCARDSCSV,FOODCARDSHEADER);
    refreshCSV(INVENTORYCSV,INVENTORYHEADER);
    refreshCSV(LOCATIONCSV,LOCATIONHEADER);
    refreshCSV(OCEANCSV,OCEANHEADER);
    refreshCSV(PACKSCSV,ALLPACKSHEADER);
    refreshCSV(PLAYERCSV,PLAYERHEADER);
    refreshCSV(PLAYERSHIPCSV,PLAYERSHIPHEADER);
    refreshCSV(PORTSCSV,PORTSHEADER);
    refreshCSV(SHIPCARDSCSV,SHIPCARDSHEADER);
    refreshCSV(SUPPLYSTORESCSV,SUPPLYSTORESHEADER);
    refreshCSV(TAVERNSCSV,TAVERNSHEADER);
    refreshCSV(WORLDCSV,WORLDHEADER);
  }

  /*
   * Refreshes a CSV file to delete its contents
   * @param filepath The name of the file to refresh
   * @param headerRow The header row to write to the file
   */
  public static void refreshCSV(String filepath, String headerRow) {
    try{
      //Check if file exists and create it if not
      if (!Files.exists(Paths.get(filepath))) {
        Files.createFile(Paths.get(filepath));
      }
      BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
      writer.write(INDEX + COMMA + headerRow + NEWLINE);

      writer.close();
    } catch (Exception e){
      prln("refreshCSV: Failed to write to CSV file.", RED);
    }
  }

  /*
   * Writes a row of data to a CSV file
   * @param filepath The name of the file to write to
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @param append Whether to append to the file or overwrite it
   * @param headerRow The header row to write to the file
   * @param format The format of the data to write to the file
   * @param data The data to write to the file
   */
  public static void writeToCSV(String filepath, String comingFrom, boolean append, String headerRow, String format, Object... data) {
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, append));

      // If the file is being overwritten, write the header row with index value
      if (!append) {
        writer.write(INDEX + COMMA + headerRow + NEWLINE);
      }

      // Get the number of rows in the file (if overwritten will be 1)
      int numRows = 0;
      if (Files.exists(Paths.get(filepath))) {
        numRows = Files.lines(Paths.get(filepath)).skip(1).toArray().length; // Skip header row
      }

      // Use that number to add an index to all the rows
      int numCols = format.split(COMMA).length;
      for (int i = 0; i < data.length; i += numCols) {
        writer.write(numRows + i/numCols + COMMA);
        for (int j = 0; j < numCols; j++) {
          writer.write(String.valueOf(data[i + j]));
          if (j < numCols - 1) {
            writer.write(COMMA);
          }
        }
        writer.write(NEWLINE);
      }
        writer.close();
    } catch (Exception e){
      prln("writeToCSV: " + comingFrom + ": Failed to write to CSV file.", RED);
    }
  }

  /*
   * Writes a specific value to a CSV row
   * @param filepath The name of the file to read from
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @param searchColumn The column to search for the search value
   * @param searchValue The value to search for in the search column
   * @param changeColumn The column to change the value in
   * @param newValue The new value to change the value in the change column to
   */
  public static void writeToCSVValue(String filepath, String comingFrom, String searchColumn, String searchValue, String changeColumn, String newValue) {
    try{
      // Read the CSV file into a 2D array (data[][])
      List<String[]> lines = new ArrayList<>();
      BufferedReader reader = new BufferedReader(new FileReader(filepath));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] values = line.split(COMMA);
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
        prln("writeToCSVValue: " + comingFrom + ": " + searchColumn + " searchColumn not found in CSV file", RED);
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
        prln("writeToCSVValue: " + comingFrom + ": " + searchValue + " searchValue not found in CSV file", RED);
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
        prln("writeToCSVValue: " + comingFrom + ": " + changeColumn + " changeColumn not found in CSV file", RED);
      }

      // Update the value in our array of the data
      data[rowIndex][changeColumnIndex] = newValue;

      // Write the updated array back to the CSV file
      BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
          writer.write(data[i][j]);
          if (j < data[i].length - 1) {
            writer.write(COMMA);
          }
        }
        writer.write(NEWLINE);
      }
      writer.close();
    } catch (Exception e){
      prln("writeToCSVValue: " + comingFrom + ": Failed to read from CSV file.", RED);
    }
  }

  /*
   * Gets a specific value from a CSV file
   * @param filepath The name of the file to read from
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @param searchColumn The column to search for the search value
   * @param searchValue The value to search for in the search column
   * @param resultColumn The column to return the result from
   * @return The value in the result column of the row with the search value in the search column
   * @return null if the search value or either columns are not found
   */
  public static String getFromCSVValue(String filepath, String comingFrom, String searchColumn, String searchValue, String resultColumn){
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filepath));

      // Get the index of the search column and result column
      String headerRow = reader.readLine();
      String[] columns = headerRow.split(COMMA);
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
        prln("getFromCSVValue: " +  comingFrom + ": " + searchColumn + "searchColumn not found in CSV file", RED);
        reader.close();
        return null;
      }
      if (resultColumnIndex == -1) {
        prln("getFromCSVValue: " + comingFrom + ": " + resultColumn + "resultColumn not found in CSV file", RED);
        reader.close();
        return null;
      }
  
      // Search for the search value in the search column then save that row in a string array
      String row;
      while ((row = reader.readLine()) != null) {
        String[] values = row.split(COMMA);
        if (values[searchColumnIndex].equals(searchValue)) {
            reader.close();
            return values[resultColumnIndex]; //Return the value in the result column from that array
        }
      }
  
      reader.close();
      return null;
    } catch (Exception e){
      prln("getFromCSVValue: " + comingFrom + ": Failed to read from CSV file.", RED);
      return null;
    }
  }

  /*
   * Gets a specific row from a CSV file
   * @param filepath The name of the file to read from
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @param columnName The name of the column to search for the value
   * @param value The value to search for in the column
   * @return The row with the value in the column as a String array
   * @return null if the value or column are not found
   */
  public static String[] getFromCSVRow(String filepath, String comingFrom, String columnName, String value) {
    try{
      BufferedReader reader = new BufferedReader(new FileReader(filepath));
      
      // Get the index of the column
      String header = reader.readLine();
      String[] columnNames = header.split(COMMA);
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
          String[] row = line.split(COMMA);
          if (row[columnIndex].equals(value)) {
              reader.close();
              return row; //Return that array
          }
      }
      reader.close();
      return null;
    } catch (Exception e){
      prln("getFromCSVRow: " + comingFrom + ": Failed to read from CSV file.", RED);
      return null;
    }
  }
  /*
   * Gets a specific row from a CSV file
   * @param filepath The name of the file to read from
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @return The row with the value in the column as a String array
   * @return null if the value or column are not found
   */
  public static String[] getFromFirstCSVRow(String filepath, String comingFrom) {
    try{
      BufferedReader reader = new BufferedReader(new FileReader(filepath));
      
      String[] row = reader.readLine().split(COMMA);
      reader.close();
      return row;

    } catch (Exception e){
      prln("getFromCSVRow: " + comingFrom + ": Failed to read from CSV file.", RED);
      return null;
    }
  }

  /*
   * Gets the entire contents of a CSV file as a 2D array
   * @param filepath The name of the file to read from
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @return The contents of the CSV file as a 2D array
   */
  public static ArrayList<ArrayList<String>> getFromCSVFile(String filepath, String comingFrom) {
    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));

        // Read in rows and split into columns
        String row;
        reader.readLine(); // Skip header row
        while ((row = reader.readLine()) != null) {
            String[] columns = row.split(COMMA);
            ArrayList<String> rowData = new ArrayList<String>(Arrays.asList(columns));
            data.add(rowData);
        }

        reader.close();
    } catch (Exception e) {
        prln("getFromCSVFile: " + comingFrom + ": Failed to read from CSV file.", RED);
    }
    return data;
  }
  /*
   * Gets the last index of a CSV file
   * @param filepath The name of the file to read from
   * @param comingFrom The name of the class that called this method (For error reporting)
   * @return The last index of the CSV file
   * @return Integer.MAX_VALUE if the file does not exist
   */
  public static int getFromCSVLastIndex(String filepath, String comingFrom) {
    try{
      BufferedReader reader = new BufferedReader(new FileReader(filepath));
      List<String> lines = new ArrayList<String>();
      String line = reader.readLine();
      while (line != null) {
          lines.add(line);
          line = reader.readLine();
      }
      reader.close();
      return lines.size() - 2;
    } catch (Exception e){
      prln("getFromCSVIndex: " + comingFrom + ": Failed to read from CSV file.", RED);
      return MAXVALUE;
    }
  }

  // OTHER FILE METHODS | OTHER FILE METHODS | OTHER FILE METHODS
  // OTHER FILE METHODS | OTHER FILE METHODS | OTHER FILE METHODS
  // OTHER FILE METHODS | OTHER FILE METHODS | OTHER FILE METHODS

  /*
   * Loads the name files into arrayLists to store them in memory instead of accessing the very
   * large text files every time a name is needed (Which will be often)
   */
  public static void LoadNameFiles(){
    enFirstNames = getFromTXT(ENFIRSTNAMES);
    esFirstNames = getFromTXT(ESFIRSTNAMES);
    enLastNames = getFromTXT(ENLASTNAMES);
    esLastNames = getFromTXT(ESLASTNAMES);
  }

  /*
   * Gets a txt file as an ArrayList
   * @param array the ArrayList to store the lines in
   * @param filepath The name of the file to read from
   */
  private static ArrayList<String> getFromTXT(String filepath){
    try {
      ArrayList<String> array = new ArrayList<String>();
      // Open the file for reading
      BufferedReader reader = new BufferedReader(new FileReader(filepath));

      // Read each line and add it to the list
      String line = reader.readLine();
      while (line != null) {
          array.add(line);
          line = reader.readLine();
      }

      // Close the reader
      reader.close();
      return array;
    } catch (IOException e) {
      prln("getFromTXT: Failed to read from txt file.", RED);
      return null;
    }
  }


  // PAIR CLASS | PAIR CLASS | PAIR CLASS
  // PAIR CLASS | PAIR CLASS | PAIR CLASS
  // PAIR CLASS | PAIR CLASS | PAIR CLASS

  /*
   * A class to store two values of any type
   */
  public static class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
      this.first = first;
      this.second = second;
    }

    /*
     * Gets the first value
     * @return The first value
     */
    public T getFirst() {
      return first;
    }

    /*
     * Gets the second value
     * @return The second value
     */
    public U getSecond() {
      return second;
    }

    /*
     * Sets the first value
     * @param first The new first value
     */
    public void setFirst(T first) {
      this.first = first;
    }

    /*
     * Sets the second value
     * @param second The new second value
     */
    public void setSecond(U second) {
      this.second = second;
    }
  }
}