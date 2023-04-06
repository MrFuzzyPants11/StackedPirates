package Globals;

import java.io.*;
import java.util.*;

public class Tools {
  static Scanner scanner;
  static String[] rainbowColours = {"\u001B[31;3m", "\u001B[33;3m", "\u001B[32;3m", "\u001B[36;3m", "\u001B[34;3m", "\u001B[35;3m"};

  public static void prln(String str){
    System.out.print(str + "\n");
  }

  public static void prln(String str, String col){
    if(col.equals("RAINBOWBABY")){
      prln(rainbowIfier(str));
    } else {
      prln("\u001B[" + col + "m" + str + "\u001B[0m");
    }
  }
  
  public static void pr(String str){
    System.out.print(str);
  }

  public static void pr(String str, String col){
    if(col.equals("RAINBOWBABY")){
      pr(rainbowIfier(str));
    } else {
      pr("\u001B[" + col + "m" + str + "\u001B[0m");
    }
  }
  
  public static void prnl(String str){
    System.out.print("\n" + str);
  }

  public static void prnl(String str, String col){
    if(col.equals("RAINBOWBABY")){
      prnl(rainbowIfier(str));
    } else {
      prnl("\u001B[" + col + "m" + str + "\u001B[0m");
    }
  }

  private static String rainbowIfier(String str){
    String temp = "";
    for (int i = 0; i < str.length(); i++) {
      temp = temp + rainbowColours[i % rainbowColours.length] + str.charAt(i);
    }
    return (temp + "\u001B[0m");
  }

  public static void invalOp(){
    prln("That is not a valid option.");
  }

  public static void initializeScanner(){
    scanner = new Scanner(System.in);
  }

  public static void closeScanner(){
    scanner.close();
  }

  public static int askIn(){
    pr("Enter Response: ");
    int input = scanner.nextInt();
    return input;
  }

  public static String toStr(int num){
    return Integer.toString(num);
  }

  public static int toInt(String str){
    return Integer.parseInt(str);
  }

  public static void lineBreaker(){
    prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
  }

  public static void writeToCSV(String filename, String comingFrom, boolean append, String headerRow, String format, Object... data) {
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter("TerminalStackedPirates/Globals/" + filename + ".csv", append));

      if (!append) {
        writer.write("Index," + headerRow + "\n");
      }

      // Get the number of rows already in the file
      BufferedReader reader = new BufferedReader(new FileReader("TerminalStackedPirates/Globals/" + filename + ".csv"));
      int numRows = reader.lines().skip(1).toArray().length; // Skip header row
      reader.close();

      // Write the data rows with index
      for (int i = 0; i < data.length; i += format.split(",").length) {
        writer.write(numRows + i/format.split(",").length + ",");
        writer.write(String.format(format, Arrays.copyOfRange(data, i, i + format.split(",").length)) + "\n");
      }

      writer.close();
    } catch (Exception e){
      prln("writeToCSV: " + comingFrom + ": Failed to write to CSV file.", "31");
    }
  }

  public static String getFromCSV(String filename, String comingFrom, String searchColumn, String searchValue, String resultColumn){
    try {
      BufferedReader reader = new BufferedReader(new FileReader("TerminalStackedPirates/Globals/" + filename + ".csv"));

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
        prln("getFromCSV: " +  comingFrom + ": " + searchColumn + "searchColumn not found in CSV file", "31");
        reader.close();
        return null;
      }

      if (resultColumnIndex == -1) {
        prln("getFromCSV: " + comingFrom + ": " + resultColumn + "resultColumn not found in CSV file", "31");
        reader.close();
        return null;
      }
  
      String row;
      while ((row = reader.readLine()) != null) {
        String[] values = row.split(",");
        if (values[searchColumnIndex].equals(searchValue)) {
            reader.close();
            return values[resultColumnIndex];
        }
      }
  
      reader.close();
      return null;
    } catch (Exception e){
      prln("getFromCSV: " + comingFrom + ": Failed to read from CSV file.", "31");
      return null;
    }
  }

  public static void writeToCSVValue(String filename, String comingFrom, String searchColumn, String searchValue, String changeColumn, String newValue) {
    try{
      // Read the CSV file into a 2D array
      List<String[]> lines = new ArrayList<>();
      BufferedReader reader = new BufferedReader(new FileReader("TerminalStackedPirates/Globals/" + filename + ".csv"));
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

      // Find the row index of the value
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

      // Find the column index of the second column
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

      // Update the value in the array
      data[rowIndex][changeColumnIndex] = newValue;

      // Write the updated array back to the CSV file
      BufferedWriter writer = new BufferedWriter(new FileWriter("TerminalStackedPirates/Globals/" + filename + ".csv"));
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
}