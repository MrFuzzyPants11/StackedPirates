//File: Constants.java
//Author: MrFuzzyPants
//Created: 04-08-2023
//Modified: 04-18-2023
package Globals;

public abstract class Constants {
  // Common Strings
  public static final String CARD = "card";
  public static final String CREW = "crew";
  public static final String EFFECT = "effect";
  public static final String FOOD = "food";
  public static final String PACK = "pack";
  public static final String SHIP = "ship";

  // Header Columns
  public static final String BARTENDERINDEX = "bartenderindex";
  public static final String BLACKMARKETDEALER = "blackmarketdealer";
  public static final String CARD0 = "card0";
  public static final String CARD1 = "card1";
  public static final String CARD2 = "card2";
  public static final String CARD3 = "card3";
  public static final String CARD4 = "card4";
  public static final String COST = "cost";
  public static final String CREW0 = "crew0";
  public static final String CREW1 = "crew1";
  public static final String CREW2 = "crew2";
  public static final String CREW3 = "crew3";
  public static final String CREW4 = "crew4";
  public static final String CREWCARDTYPE = "crewcardtype";
  public static final String CREWINDEX0 = "crewindex0";
  public static final String CREWINDEX1 = "crewindex1";
  public static final String CREWINDEX10 = "crewindex10";
  public static final String CREWINDEX11 = "crewindex11";
  public static final String CREWINDEX12 = "crewindex12";
  public static final String CREWINDEX13 = "crewindex13";
  public static final String CREWINDEX14 = "crewindex14";
  public static final String CREWINDEX2 = "crewindex2";
  public static final String CREWINDEX3 = "crewindex3";
  public static final String CREWINDEX4 = "crewindex4";
  public static final String CREWINDEX5 = "crewindex5";
  public static final String CREWINDEX6 = "crewindex6";
  public static final String CREWINDEX7 = "crewindex7";
  public static final String CREWINDEX8 = "crewindex8";
  public static final String CREWINDEX9 = "crewindex9";
  public static final String DESCRIPTION = "description";
  public static final String DOCKYARD = "dockyard";
  public static final String EFFECTINDEX = "effectindex";
  public static final String FNAME = "fname";
  public static final String GOLD = "gold";
  public static final String HAT = "hat";
  public static final String HEALTH = "health";
  public static final String HEALTHRESTORED = "healthrestored";
  public static final String HOLELEVEL = "holelevel";
  public static final String INCREW = "increw";
  public static final String INDEX = "index";
  public static final String ININVENTORY = "ininventory";
  public static final String ITEMINDEX = "itemindex";
  public static final String LEVEL = "level";
  public static final String LNAME = "lname";
  public static final String NAME = "name";
  public static final String ONEHANDEDWEAPON = "onehandedweapon";
  public static final String OPENED = "opened";
  public static final String PACK0 = "pack0";
  public static final String PACK1 = "pack1";
  public static final String PACK2 = "pack2";
  public static final String PACK3 = "pack3";
  public static final String PACK4 = "pack4";
  public static final String PACK5 = "pack5";
  public static final String PACK6 = "pack6";
  public static final String PACK7 = "pack7";
  public static final String PACK8 = "pack8";
  public static final String PACK9 = "pack9";
  public static final String PANTS = "pants";
  public static final String RARITY = "rarity";
  public static final String REPAIRS = "repairs";
  public static final String SIZE = "size";  
  public static final String SOLD = "sold";
  public static final String SUBTYPE = "subtype";
  public static final String SUPPLYSTORE = "supplystore";
  public static final String TAVERN = "tavern";
  public static final String TOUGHNESS = "toughness";
  public static final String TRAVELUNTILSINK = "traveluntilsink";
  public static final String TUNIC = "tunic";
  public static final String TWOHANDEDWEAPON = "twohandedweapon";
  public static final String TYPE = "type";
  public static final String INTAVERN = "intavern";


  // RARITIES
  public static final String COMMON = "common";
  public static final String UNCOMMON = "uncommon";
  public static final String RARE = "rare";
  public static final String EPIC = "epic";
  public static final String LEGENDARY = "legendary";

  // COLOURS
  public static final String RESET = "0";
  public static final String BLACK = "30";
  public static final String RED = "31";
  public static final String GREEN = "32";
  public static final String YELLOW = "33";
  public static final String BLUE = "34";
  public static final String MAGENTA = "35";
  public static final String CYAN = "36";
  public static final String WHITE = "37";
  public static final String RAINBOW = "RAINBOW";
  public static final String BROWNBOW = "BROWNBOW";
  public static final String COMMONCOLOUR = RESET;
  public static final String ENCOUNTERCOLOUR = BLUE;
  public static final String EPICCOLOUR = YELLOW;
  public static final String GOLDCOLOUR = YELLOW;
  public static final String LEGENDARYCOLOUR = RAINBOW;
  public static final String LEVELCOLOUR = MAGENTA;
  public static final String RARECOLOUR = MAGENTA;
  public static final String UNCOMMONCOLOUR = CYAN;

  // Folder names
  public static final String ROUTINGLOCATION = "TerminalStackedPirates/"; // This should be set to "" when running outside of VSC
  public static final String FILELOCATION = ROUTINGLOCATION + "Globals/";
  public static final String SAVEGAMELOCATION = FILELOCATION + "SaveGameFiles/";
  public static final String IMMUTABLEFILELOCATION = FILELOCATION + "ImmutableFiles/";
  public static final String NAMESFOLDER = IMMUTABLEFILELOCATION + "SmashewNames/";
  public static final String EFFECTSFOLDER = IMMUTABLEFILELOCATION + "Effects/";

  // File paths
  public static final String ALLCREWSCSV = SAVEGAMELOCATION + "allcrews.csv";
  public static final String ALLPACKSCSV = SAVEGAMELOCATION + "allpacks.csv";
  public static final String BARTENDERSCSV = SAVEGAMELOCATION + "bartenders.csv";
  public static final String CREWCARDSCSV = SAVEGAMELOCATION + "crewcards.csv";
  public static final String CREWEFFECTS = EFFECTSFOLDER + "creweffects.csv";
  public static final String ENFIRSTNAMES = NAMESFOLDER + "enfirstnames.txt";
  public static final String ENLASTNAMES = NAMESFOLDER + "enlastnames.txt";
  public static final String ESFIRSTNAMES = NAMESFOLDER + "esfirstnames.txt";
  public static final String ESLASTNAMES = NAMESFOLDER + "eslastnames.txt";
  public static final String FOODCARDSCSV = SAVEGAMELOCATION + "foodcards.csv";
  public static final String FOODEFFECTS = EFFECTSFOLDER + "foodeffects.csv";
  public static final String INVENTORYCSV = SAVEGAMELOCATION + "inventory.csv";
  public static final String PLAYERCSV = SAVEGAMELOCATION + "player.csv";
  public static final String PLAYERSHIPCSV = SAVEGAMELOCATION + "playership.csv";
  public static final String PORTSCSV = SAVEGAMELOCATION + "ports.csv";
  public static final String SHIPCARDSCSV = SAVEGAMELOCATION + "shipcards.csv";
  public static final String SHIPEFFECTS = EFFECTSFOLDER + "shipeffects.csv";
  public static final String SUPPLYSTORESCSV = SAVEGAMELOCATION + "supplystores.csv";
  public static final String TAVERNSCSV = SAVEGAMELOCATION + "taverns.csv"; 
  public static final String CREWLISTCSV = SAVEGAMELOCATION + "crewlist.csv";


  // Headers and formats
  public static final String FOODCARDSFORMAT = "%d,%s,%d";
  public static final String FOODCARDSHEADER = RARITY + "," + NAME + "," + EFFECTINDEX;
  public static final String SHIPCARDSFORMAT = "%d,%s,%d";
  public static final String SHIPCARDSHEADER = RARITY + "," + NAME + "," + EFFECTINDEX;
  public static final String CREWCARDSFORMAT = "%d,%s,%s,%d";
  public static final String CREWCARDSHEADER = RARITY + "," + NAME + "," + CREWCARDTYPE + "," + EFFECTINDEX;
  public static final String ALLCREWSFORMAT = "%s,%s,%s,%d,%d,%d,%s,%d,%d,%d,%d,%d";
  public static final String ALLCREWSHEADER = FNAME + "," + LNAME + "," + INCREW + "," + LEVEL + "," + HEALTH + "," + COST + "," + INTAVERN +","+ CARD0 + "," + CARD1 + "," + CARD2 + "," + CARD3 + "," + CARD4;
  public static final String ALLPACKSFORMAT = "%s,%s,%s,%d,%d,%d,%d,%d,%d,%d";
  public static final String ALLPACKSHEADER = TYPE + "," + SOLD + "," + OPENED + "," + RARITY + "," + COST + "," + CARD0 + "," + CARD1 + "," + CARD2 + "," + CARD3 + "," + CARD4;
  public static final String BARTENDERSFORMAT = "%s,%s,%d,%d,%s";
  public static final String BARTENDERSHEADER = FNAME + "," + LNAME + "," + LEVEL + "," + HEALTH + "," + BLACKMARKETDEALER;
  public static final String CREWEFFECTFORMAT = "%d,%s";
  public static final String CREWEFFECTHEADER = RARITY + "," + DESCRIPTION;
  public static final String CREWLISTFORMAT = "%d,%d,%d,%d,%d";
  public static final String CREWLISTHEADER = CREW0 + "," + CREW1 + "," + CREW2 + "," + CREW3 + "," + CREW4;
  public static final String FOODEFFECTFORMAT = "%d,%s,%d";
  public static final String FOODEFFECTHEADER = RARITY + "," + DESCRIPTION + "," + HEALTHRESTORED;
  public static final String INVENTORYFORMAT = "%s,%s,%s,%d";
  public static final String INVENTORYHEADER = ININVENTORY + "," + TYPE + "," + SUBTYPE + "," + ITEMINDEX;
  public static final String PLAYERFORMAT = "%s,%d,%d,%d,%d,%d,%d,%d,%d";
  public static final String PLAYERHEADER = NAME + "," + LEVEL + "," + HEALTH + "," + GOLD + "," + CARD0 + "," + CARD1 + "," + CARD2 + "," + CARD3 + "," + CARD4;
  public static final String PLAYERSHIPFORMAT = "%d,%d,%d,%d,%d,%d,%d,%d,%d,%d";
  public static final String PLAYERSHIPHEADER = SIZE + "," + TOUGHNESS + "," + REPAIRS + "," + TRAVELUNTILSINK + "," + HOLELEVEL + "," + CARD0 + "," + CARD1 + "," + CARD2 + "," + CARD3 + "," + CARD4;
  public static final String PORTSFORMAT = "%s,%d,%d,%d,%d";
  public static final String PORTSHEADER = NAME + "," + LEVEL + "," + SUPPLYSTORE + "," + TAVERN + "," + DOCKYARD;
  public static final String SHIPEFFECTFORMAT = "%d,%s";
  public static final String SHIPEFFECTHEADER = RARITY + "," + DESCRIPTION;
  public static final String SUPPLYSTORESFORMAT = "%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d";
  public static final String SUPPLYSTORESHEADER = LEVEL + "," + PACK0 + "," + PACK1 + "," + PACK2 + "," + PACK3 + "," + PACK4 + "," + PACK5 + "," + PACK6 + "," + PACK7 + "," + PACK8 + "," + PACK9;
  public static final String TAVERNSFORMAT = "%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d";
  public static final String TAVERNSHEADER = NAME + "," + LEVEL + "," + BARTENDERINDEX + "," + PACK0 + "," + PACK1 + "," + PACK2 + "," + PACK3 + "," + PACK4 + "," + CREWINDEX0 + "," + CREWINDEX1 + "," + CREWINDEX2 + "," + CREWINDEX3 + "," + CREWINDEX4 + "," + CREWINDEX5 + "," + CREWINDEX6 + "," + CREWINDEX7 + "," + CREWINDEX8 + "," + CREWINDEX9+ "," + CREWINDEX10 + "," + CREWINDEX11 + "," + CREWINDEX12 + "," + CREWINDEX13 + "," + CREWINDEX14;


  // NUMBERS
  public static final int ANIMATIONSPEED = 1000;
  public static final int COMMONNUM = 0;
  public static final int EPICNUM = 3;
  public static final int LEGENDARYNUM = 4;
  public static final int MAXLEVEL = 4;
  public static final int MAXRARITY = 4;
  public static final int MAXVALUE = Integer.MAX_VALUE;
  public static final int MINVALUE = Integer.MIN_VALUE;
  public static final int MENUEXIT = MINVALUE;
  public static final int MINLEVEL = 0;
  public static final int MINRARITY = 0;
  public static final int QUIT = MAXVALUE;
  public static final int RARENUM = 2;
  public static final int UNCOMMONNUM = 1;

  // Initial Values
  public static final int STARTINGGOLD = 696969;
  public static final int STARTINGHEALTH = 50;
  public static final int STARTINGLEVEL = 0;

  // OTHER
  public static final String EMPTY = "";
  public static final String FALSE = "false";
  public static final String SPACE = " ";
  public static final String TRUE = "true";
  public static final String[] TAVERNTYPES = {"Pub","Bar","Tavern","Cantina","Saloon","Beach Club", "Ale House", "Lounge", "Canteen", "Tavern", "Speakeasy", "Beer Hole", "Brewery"};
  public static final String[] JOINCREW = {"Yeah I'll join your crew!", "Sure.","Better than sitting around here.", "I hope you offer dental.", "Good time to confront my Thalassophobia.", 
                                            "Thank god my mother-in-law was driving me insane."};
}
