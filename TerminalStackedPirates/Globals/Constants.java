//File: Constants.java
//Author: MrFuzzyPants
//Created: 04-08-2023
//Modified: 11-13-2023
package Globals;

import Globals.Tools.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Constants {
  // General Words
  public static final String CARD = "card";
  public static final String COMMA = ",";
  public static final String CREW = "crew";
  public static final String EFFECT = "effect";
  public static final String EMPTY = "";
  public static final String FOOD = "food";
  public static final String PACK = "pack";
  public static final String SHIP = "ship";
  public static final String SPACE = " ";
  public static final String NEWLINE = "\n";
  public static final String PORT = "port";
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
  public static final String INTAVERN = "intavern";
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
  public static final String SOLD = "sold";
  public static final String SUBTYPE = "subtype";
  public static final String SUPPLYSTORE = "supplystore";
  public static final String TAVERN = "tavern";
  public static final String TOUGHNESS = "toughness";
  public static final String TRAVELUNTILSINK = "traveluntilsink";
  public static final String TUNIC = "tunic";
  public static final String TWOHANDEDWEAPON = "twohandedweapon";
  public static final String TYPE = "type";
  public static final String VIEWED = "viewed";
  public static final String ENCOUNTER = "encounter";
  public static final String ENCOUNTERINDEX = "encounterindex";
  public static final String OCEAN = "ocean";
  public static final String YCORD = "ycord";
  public static final String XCORD = "xcord"; 
  public static final String ZERO = "0";


  // Rarities
  public static final String COMMON = "common";
  public static final String UNCOMMON = "uncommon";
  public static final String RARE = "rare";
  public static final String EPIC = "epic";
  public static final String LEGENDARY = "legendary";

  // Colours
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
  public static final String ROUTINGLOCATION = "";//"TerminalStackedPirates/"; // Sometimes needs to be terminalStackPirates sometimes not. Weird.
  public static final String FILELOCATION = ROUTINGLOCATION + "Globals/";
  public static final String SAVEGAMELOCATION = FILELOCATION + "SaveGameFiles/";
  public static final String TEMPFILELOCATION = SAVEGAMELOCATION + "Temp/";
  public static final String IMMUTABLEFILELOCATION = FILELOCATION + "ImmutableFiles/";
  public static final String NAMESFOLDER = IMMUTABLEFILELOCATION + "SmashewNames/";
  public static final String EFFECTSFOLDER = IMMUTABLEFILELOCATION + "Effects/";

  // File paths
    // SAVE GAME
  public static final String BARTENDERSCSV = TEMPFILELOCATION + "bartenders.csv";
  public static final String BARTENDERSCSVPERM = SAVEGAMELOCATION + "bartenders.csv";
  public static final String CREWCARDSCSV = TEMPFILELOCATION + "crewcards.csv";
  public static final String CREWCARDSCSVPERM = SAVEGAMELOCATION + "crewcards.csv";
  public static final String CREWLISTCSV = TEMPFILELOCATION + "crewlist.csv";
  public static final String CREWLISTCSVPERM = SAVEGAMELOCATION + "crewlist.csv";
  public static final String CREWSCSV = TEMPFILELOCATION + "crews.csv";
  public static final String CREWSCSVPERM = SAVEGAMELOCATION + "crews.csv";
  public static final String DOCKYARDSCSV = TEMPFILELOCATION + "dockyards.csv";
  public static final String DOCKYARDSCSVPERM = SAVEGAMELOCATION + "dockyards.csv";
  public static final String FOODCARDSCSV = TEMPFILELOCATION + "foodcards.csv";
  public static final String FOODCARDSCSVPERM = SAVEGAMELOCATION + "foodcards.csv";
  public static final String GAMEPROGRESSCSV = SAVEGAMELOCATION + "progress.csv";
  public static final String INVENTORYCSV = TEMPFILELOCATION + "inventory.csv";
  public static final String INVENTORYCSVPERM = SAVEGAMELOCATION + "inventory.csv";
  public static final String LOCATIONCSV = TEMPFILELOCATION + "location.csv";
  public static final String LOCATIONCSVPERM = SAVEGAMELOCATION + "location.csv";
  public static final String OCEANCSV = TEMPFILELOCATION + "ocean.csv";
  public static final String OCEANCSVPERM = SAVEGAMELOCATION + "ocean.csv";
  public static final String PACKSCSV = TEMPFILELOCATION + "packs.csv";
  public static final String PACKSCSVPERM = SAVEGAMELOCATION + "packs.csv";
  public static final String PLAYERCSV = TEMPFILELOCATION + "player.csv";
  public static final String PLAYERCSVPERM = SAVEGAMELOCATION + "player.csv";
  public static final String PLAYERSHIPCSV = TEMPFILELOCATION + "playership.csv";
  public static final String PLAYERSHIPCSVPERM = SAVEGAMELOCATION + "playership.csv";
  public static final String PORTSCSV = TEMPFILELOCATION + "ports.csv";
  public static final String PORTSCSVPERM = SAVEGAMELOCATION + "ports.csv";
  public static final String SHIPCARDSCSV = TEMPFILELOCATION + "shipcards.csv";
  public static final String SHIPCARDSCSVPERM = SAVEGAMELOCATION + "shipcards.csv";
  public static final String SUPPLYSTORESCSV = TEMPFILELOCATION + "supplystores.csv";
  public static final String SUPPLYSTORESCSVPERM = SAVEGAMELOCATION + "supplystores.csv";
  public static final String TAVERNSCSV = TEMPFILELOCATION + "taverns.csv"; 
  public static final String TAVERNSCSVPERM = SAVEGAMELOCATION + "taverns.csv"; 
  public static final String WORLDCSV = SAVEGAMELOCATION + "world.csv";
  public static final List<Pair<String, String>> allfileHeaderPairs = Collections.unmodifiableList(
    new ArrayList<Pair<String, String>>() {{
      add(new Pair<>(BARTENDERSCSV,BARTENDERSHEADER));
      add(new Pair<>(BARTENDERSCSVPERM,BARTENDERSHEADER));
      add(new Pair<>(CREWCARDSCSV,CREWCARDSHEADER));
      add(new Pair<>(CREWCARDSCSVPERM,CREWCARDSHEADER));
      add(new Pair<>(CREWLISTCSV,CREWLISTHEADER));
      add(new Pair<>(CREWLISTCSVPERM,CREWLISTHEADER));
      add(new Pair<>(CREWSCSV,ALLCREWSHEADER));
      add(new Pair<>(CREWSCSVPERM,ALLCREWSHEADER));
      add(new Pair<>(DOCKYARDSCSV,DOCKYARDHEADER));
      add(new Pair<>(DOCKYARDSCSVPERM,DOCKYARDHEADER));
      add(new Pair<>(FOODCARDSCSV,FOODCARDSHEADER));
      add(new Pair<>(FOODCARDSCSVPERM,FOODCARDSHEADER));
      add(new Pair<>(GAMEPROGRESSCSV, GAMEPROGRESSHEADER));
      add(new Pair<>(INVENTORYCSV,INVENTORYHEADER));
      add(new Pair<>(INVENTORYCSVPERM,INVENTORYHEADER));
      add(new Pair<>(OCEANCSV,OCEANHEADER));
      add(new Pair<>(OCEANCSVPERM,OCEANHEADER));
      add(new Pair<>(PACKSCSV,ALLPACKSHEADER));
      add(new Pair<>(PACKSCSVPERM,ALLPACKSHEADER));
      add(new Pair<>(PLAYERCSV,PLAYERHEADER));
      add(new Pair<>(PLAYERCSVPERM,PLAYERHEADER));
      add(new Pair<>(PLAYERSHIPCSV,PLAYERSHIPHEADER));
      add(new Pair<>(PLAYERSHIPCSVPERM,PLAYERSHIPHEADER));
      add(new Pair<>(PORTSCSV,PORTSHEADER));
      add(new Pair<>(PORTSCSVPERM,PORTSHEADER));
      add(new Pair<>(SHIPCARDSCSV,SHIPCARDSHEADER));
      add(new Pair<>(SHIPCARDSCSVPERM,SHIPCARDSHEADER));
      add(new Pair<>(SUPPLYSTORESCSV,SUPPLYSTORESHEADER));
      add(new Pair<>(SUPPLYSTORESCSVPERM,SUPPLYSTORESHEADER));
      add(new Pair<>(TAVERNSCSV,TAVERNSHEADER));
      add(new Pair<>(TAVERNSCSVPERM,TAVERNSHEADER));
      add(new Pair<>(WORLDCSV,WORLDHEADER));
      add(new Pair<>(LOCATIONCSV,LOCATIONHEADER));
      add(new Pair<>(LOCATIONCSVPERM,LOCATIONHEADER));
    }}
  );

  public static final List<Pair<String, String>> allTempPermPairs = Collections.unmodifiableList(
    new ArrayList<Pair<String, String>>() {{
      add(new Pair<>(BARTENDERSCSV,BARTENDERSCSVPERM));
      add(new Pair<>(CREWCARDSCSV,CREWCARDSCSVPERM));
      add(new Pair<>(CREWLISTCSV,CREWLISTCSVPERM));
      add(new Pair<>(CREWSCSV,CREWSCSVPERM));
      add(new Pair<>(DOCKYARDSCSV,DOCKYARDSCSVPERM));
      add(new Pair<>(FOODCARDSCSV,FOODCARDSCSVPERM));
      add(new Pair<>(INVENTORYCSV,INVENTORYCSVPERM));
      add(new Pair<>(OCEANCSV,OCEANCSVPERM));
      add(new Pair<>(PACKSCSV,PACKSCSVPERM));
      add(new Pair<>(PLAYERCSV,PLAYERCSVPERM));
      add(new Pair<>(PLAYERSHIPCSV,PLAYERSHIPCSVPERM));
      add(new Pair<>(PORTSCSV,PORTSCSVPERM));
      add(new Pair<>(SHIPCARDSCSV,SHIPCARDSCSVPERM));
      add(new Pair<>(SUPPLYSTORESCSV,SUPPLYSTORESCSVPERM));
      add(new Pair<>(TAVERNSCSV,TAVERNSCSVPERM));
      add(new Pair<>(LOCATIONCSV,LOCATIONCSVPERM));
    }}
  );

    // IMMUTABLE
  public static final String ENFIRSTNAMES = NAMESFOLDER + "enfirstnames.txt";
  public static final String ENLASTNAMES = NAMESFOLDER + "enlastnames.txt";
  public static final String ESFIRSTNAMES = NAMESFOLDER + "esfirstnames.txt";
  public static final String ESLASTNAMES = NAMESFOLDER + "eslastnames.txt";
  public static final String CREWEFFECTS = EFFECTSFOLDER + "creweffects.csv";
  public static final String FOODEFFECTS = EFFECTSFOLDER + "foodeffects.csv";
  public static final String SHIPEFFECTS = EFFECTSFOLDER + "shipeffects.csv";

  // Headers and formats
  public static final String ALLCREWSFORMAT = "%s,%s,%s,%d,%d,%d,%s,%d,%d,%d,%d,%d";
  public static final String ALLCREWSHEADER = FNAME + COMMA + LNAME + COMMA + INCREW + COMMA + LEVEL + COMMA + HEALTH + COMMA + COST + COMMA + INTAVERN +COMMA+ CARD0 + COMMA + CARD1 + COMMA + CARD2 + COMMA + CARD3 + COMMA + CARD4;
  public static final String ALLPACKSFORMAT = "%s,%s,%s,%d,%d,%d,%d,%d,%d,%d";
  public static final String ALLPACKSHEADER = TYPE + COMMA + SOLD + COMMA + OPENED + COMMA + RARITY + COMMA + COST + COMMA + CARD0 + COMMA + CARD1 + COMMA + CARD2 + COMMA + CARD3 + COMMA + CARD4;
  public static final String BARTENDERSFORMAT = "%s,%s,%d,%d,%s";
  public static final String BARTENDERSHEADER = FNAME + COMMA + LNAME + COMMA + LEVEL + COMMA + HEALTH + COMMA + BLACKMARKETDEALER;
  public static final String CREWCARDSFORMAT = "%d,%s,%s,%d";
  public static final String CREWCARDSHEADER = RARITY + COMMA + NAME + COMMA + CREWCARDTYPE + COMMA + EFFECTINDEX;
  public static final String CREWEFFECTFORMAT = "%d,%s";
  public static final String CREWEFFECTHEADER = RARITY + COMMA + DESCRIPTION;
  public static final String CREWLISTFORMAT = "%d,%d,%d,%d,%d";
  public static final String CREWLISTHEADER = CREW0 + COMMA + CREW1 + COMMA + CREW2 + COMMA + CREW3 + COMMA + CREW4;
  public static final String DOCKYARDFORMAT = "%s,%d,%d,%d,%d,%d,%d";
  public static final String DOCKYARDHEADER = NAME + COMMA + LEVEL + COMMA + PACK0 + COMMA + PACK1 + COMMA + PACK2 + COMMA + PACK3 + COMMA + PACK4;
  public static final String FOODCARDSFORMAT = "%d,%s,%d";
  public static final String FOODCARDSHEADER = RARITY + COMMA + NAME + COMMA + EFFECTINDEX;
  public static final String FOODEFFECTFORMAT = "%d,%s,%d";
  public static final String FOODEFFECTHEADER = RARITY + COMMA + DESCRIPTION + COMMA + HEALTHRESTORED;
  public static final String INVENTORYFORMAT = "%s,%s,%s,%d";
  public static final String INVENTORYHEADER = ININVENTORY + COMMA + TYPE + COMMA + SUBTYPE + COMMA + ITEMINDEX;
  public static final String LOCATIONFORMAT = "%d,%d";
  public static final String LOCATIONHEADER = YCORD + COMMA + XCORD;
  public static final String OCEANFORMAT = "%s";
  public static final String OCEANHEADER = VIEWED;
  public static final String PLAYERFORMAT = "%s,%d,%d,%d,%d,%d,%d,%d,%d";
  public static final String PLAYERHEADER = NAME + COMMA + LEVEL + COMMA + HEALTH + COMMA + GOLD + COMMA + CARD0 + COMMA + CARD1 + COMMA + CARD2 + COMMA + CARD3 + COMMA + CARD4;
  public static final String PLAYERSHIPFORMAT = "%d,%d,%d,%d,%d,%d,%d,%d,%d,%d";
  public static final String PLAYERSHIPHEADER = LEVEL + COMMA + TOUGHNESS + COMMA + REPAIRS + COMMA + TRAVELUNTILSINK + COMMA + HOLELEVEL + COMMA + CARD0 + COMMA + CARD1 + COMMA + CARD2 + COMMA + CARD3 + COMMA + CARD4;
  public static final String PORTSFORMAT = "%s,%d,%d,%d,%d,%s";
  public static final String PORTSHEADER = NAME + COMMA + LEVEL + COMMA + SUPPLYSTORE + COMMA + TAVERN + COMMA + DOCKYARD + COMMA + VIEWED;
  public static final String SHIPCARDSFORMAT = "%d,%s,%d";
  public static final String SHIPCARDSHEADER = RARITY + COMMA + NAME + COMMA + EFFECTINDEX;
  public static final String SHIPEFFECTFORMAT = "%d,%s";
  public static final String SHIPEFFECTHEADER = RARITY + COMMA + DESCRIPTION;
  public static final String SUPPLYSTORESFORMAT = "%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d";
  public static final String SUPPLYSTORESHEADER = LEVEL + COMMA + PACK0 + COMMA + PACK1 + COMMA + PACK2 + COMMA + PACK3 + COMMA + PACK4 + COMMA + PACK5 + COMMA + PACK6 + COMMA + PACK7 + COMMA + PACK8 + COMMA + PACK9;
  public static final String TAVERNSFORMAT = "%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d";
  public static final String TAVERNSHEADER = NAME + COMMA + LEVEL + COMMA + BARTENDERINDEX + COMMA + PACK0 + COMMA + PACK1 + COMMA + PACK2 + COMMA + PACK3 + COMMA + PACK4 + COMMA + CREWINDEX0 + COMMA + CREWINDEX1 + COMMA + CREWINDEX2 + COMMA + CREWINDEX3 + COMMA + CREWINDEX4 + COMMA + CREWINDEX5 + COMMA + CREWINDEX6 + COMMA + CREWINDEX7 + COMMA + CREWINDEX8 + COMMA + CREWINDEX9+ COMMA + CREWINDEX10 + COMMA + CREWINDEX11 + COMMA + CREWINDEX12 + COMMA + CREWINDEX13 + COMMA + CREWINDEX14;
  public static final String WORLDFORMAT = "%s,%d";
  public static final String WORLDHEADER = ENCOUNTER + COMMA + ENCOUNTERINDEX;
  public static final String GAMEPROGRESSHEADER = ENCOUNTER + COMMA + ENCOUNTERINDEX;
  public static final String GAMEPROGRESSFORMAT = "%s,%d";
  
  // Numbers
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
  public static final int REPAIRAMOUNT = 75;
  public static final int UPGRADECOST = 1000;
  public static final int WORLDSIZE = 20;


  // Initial Values
  public static final int STARTINGGOLD = 696969;
  public static final int STARTINGHEALTH = 50;
  public static final int STARTINGLEVEL = 0;

  // Single Letter Translation codes
  public static final int A = -1;
  public static final int B = -2;
  public static final int C = -3;
  public static final int D = -4;
  public static final int E = -5;
  public static final int F = -6;
  public static final int G = -7;
  public static final int H = -8;
  public static final int I = -9;
  public static final int J = -10;
  public static final int K = -11;
  public static final int L = -12;
  public static final int M = -13;
  public static final int N = -14;
  public static final int O = -15;
  public static final int P = -16;
  public static final int Q = -17;
  public static final int R = -18;
  public static final int S = -19;
  public static final int T = -20;
  public static final int U = -21;
  public static final int V = -22;
  public static final int W = -23;
  public static final int X = -24;
  public static final int Y = -25;
  public static final int Z = -26;

  // World Generation Amounts
  public static final int NUMPORTS = 40;
  public static final int NUMBATTLES = 40;
  public static final int NUMISLANDS = 30;

  // World Encounter Identifiers
  public static final int GENPORT = 1;
  public static final int GENSTARTINGPORT = 9;
  public static final int GENBATTLE = 2;
  public static final int GENISLAND = 3;
  public static final int GENBOSS = 4;
    // Sub encounter specifiers
    // Battles
  public static final int GENBRITISH = 11;
  public static final int GENSPANISH = 12;
  public static final int GENPIRATE = 13;
  public static final int GENMERCHANT = 14;

    // Bosses
  public static final int GENLEVIATHON = 20;
  public static final int GENKRAKEN = 21;
  public static final int GENKAPPA = 22;
  public static final int GENSCYLLA = 23;
  public static final int GENUMIBOZU = 24;
  public static final int GENCHARYDBIS = 25;
  public static final int GENJENGU = 26;
  public static final int GENSIREN = 27;
  public static final int GENMAMI = 28;
  public static final int GENCUSTOM = 29;
  public static final int[] GENBOSSES = {GENLEVIATHON,GENKRAKEN,GENKAPPA,GENSCYLLA,GENUMIBOZU,GENCHARYDBIS,GENJENGU,GENSIREN,GENMAMI,GENCUSTOM};

  // Map Symbols
  public static final char OCEANSYMBOL = 'O';
  public static final char PORTSYMBOL = 'P';
  public static final char TAVERNSYMBOL = 'T';
  public static final char SUPPLYSTORESYMBOL = 'S';
  public static final char DOCKYARDSYMBOL = 'D';
  public static final char NOTVIEWED = 'N';
  public static final char PLAYERICON = 'Y';

  // Other
  public static final String FALSE = "false";
  public static final String TRUE = "true";
  public static final String[] TAVERNTYPES = {"Pub","Bar","Tavern", "Tavern","Cantina","Saloon","Beach Club", "Ale House", "Lounge", "Canteen", "Speakeasy", "Beer Hole", "Brewery"};
  public static final String[] JOINCREW = {"Yeah I'll join your crew!", "Sure.","Better than sitting around here.", "I hope you offer dental.", "Good time to confront my Thalassophobia.", 
                                            "Thank god my mother-in-law was driving me insane."};
}
