//File: Constants.java
//Author: MrFuzzyPants
//Created: 04-08-2023
//Modified: 06-07-2023
package Globals;

public abstract class Constants {
  // Common Strings
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
  public static final String PORT = "port";

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
  public static final String ROUTINGLOCATION = "TerminalStackedPirates/"; // This should be set to EMPTY when running outside of VSC
  public static final String FILELOCATION = ROUTINGLOCATION + "Globals/";
  public static final String SAVEGAMELOCATION = FILELOCATION + "SaveGameFiles/";
  public static final String IMMUTABLEFILELOCATION = FILELOCATION + "ImmutableFiles/";
  public static final String NAMESFOLDER = IMMUTABLEFILELOCATION + "SmashewNames/";
  public static final String EFFECTSFOLDER = IMMUTABLEFILELOCATION + "Effects/";

  // File paths
  public static final String CREWSCSV = SAVEGAMELOCATION + "crews.csv";
  public static final String PACKSCSV = SAVEGAMELOCATION + "packs.csv";
  public static final String BARTENDERSCSV = SAVEGAMELOCATION + "bartenders.csv";
  public static final String CREWCARDSCSV = SAVEGAMELOCATION + "crewcards.csv";
  public static final String CREWEFFECTS = EFFECTSFOLDER + "creweffects.csv";
  public static final String CREWLISTCSV = SAVEGAMELOCATION + "crewlist.csv";
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
  public static final String DOCKYARDSCSV = SAVEGAMELOCATION + "dockyards.csv";
  public static final String WORLDMAPCSV = SAVEGAMELOCATION + "map.csv";

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
  public static final String FOODCARDSFORMAT = "%d,%s,%d";
  public static final String FOODCARDSHEADER = RARITY + COMMA + NAME + COMMA + EFFECTINDEX;
  public static final String FOODEFFECTFORMAT = "%d,%s,%d";
  public static final String FOODEFFECTHEADER = RARITY + COMMA + DESCRIPTION + COMMA + HEALTHRESTORED;
  public static final String INVENTORYFORMAT = "%s,%s,%s,%d";
  public static final String INVENTORYHEADER = ININVENTORY + COMMA + TYPE + COMMA + SUBTYPE + COMMA + ITEMINDEX;
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
  public static final String DOCKYARDFORMAT = "%s,%d,%d,%d,%d,%d,%d";
  public static final String DOCKYARDHEADER = NAME + COMMA + LEVEL + COMMA + PACK0 + COMMA + PACK1 + COMMA + PACK2 + COMMA + PACK3 + COMMA + PACK4;
  public static final String WORLDMAPFORMAT = "%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d,%s,%d";
  public static final String WORLDMAPHEADER = "ENCOUNTER0,INDEX0,ENCOUNTER1,INDEX1,ENCOUNTER2,INDEX2,ENCOUNTER3,INDEX3,ENCOUNTER4,INDEX4,ENCOUNTER5,INDEX5,ENCOUNTER6,INDEX6,ENCOUNTER7,INDEX7,ENCOUNTER8,INDEX8,ENCOUNTER9,INDEX9,ENCOUNTER10,INDEX10,ENCOUNTER11,INDEX11,ENCOUNTER12,INDEX12,ENCOUNTER13,INDEX13,ENCOUNTER14,INDEX14,ENCOUNTER15,INDEX15,ENCOUNTER16,INDEX16,ENCOUNTER17,INDEX17,ENCOUNTER18,INDEX18,ENCOUNTER19,INDEX19,ENCOUNTER20,INDEX20,ENCOUNTER21,INDEX21,ENCOUNTER22,INDEX22,ENCOUNTER23,INDEX23,ENCOUNTER24,INDEX24,ENCOUNTER25,INDEX25,ENCOUNTER26,INDEX26,ENCOUNTER27,INDEX27,ENCOUNTER28,INDEX28,ENCOUNTER29,INDEX29,ENCOUNTER30,INDEX30,ENCOUNTER31,INDEX31,ENCOUNTER32,INDEX32,ENCOUNTER33,INDEX33,ENCOUNTER34,INDEX34,ENCOUNTER35,INDEX35,ENCOUNTER36,INDEX36,ENCOUNTER37,INDEX37,ENCOUNTER38,INDEX38,ENCOUNTER39,INDEX39,ENCOUNTER40,INDEX40,ENCOUNTER41,INDEX41,ENCOUNTER42,INDEX42,ENCOUNTER43,INDEX43,ENCOUNTER44,INDEX44,ENCOUNTER45,INDEX45,ENCOUNTER46,INDEX46,ENCOUNTER47,INDEX47,ENCOUNTER48,INDEX48,ENCOUNTER49,INDEX49,ENCOUNTER50,INDEX50,ENCOUNTER51,INDEX51,ENCOUNTER52,INDEX52,ENCOUNTER53,INDEX53,ENCOUNTER54,INDEX54,ENCOUNTER55,INDEX55,ENCOUNTER56,INDEX56,ENCOUNTER57,INDEX57,ENCOUNTER58,INDEX58,ENCOUNTER59,INDEX59,ENCOUNTER60,INDEX60,ENCOUNTER61,INDEX61,ENCOUNTER62,INDEX62,ENCOUNTER63,INDEX63,ENCOUNTER64,INDEX64,ENCOUNTER65,INDEX65,ENCOUNTER66,INDEX66,ENCOUNTER67,INDEX67,ENCOUNTER68,INDEX68,ENCOUNTER69,INDEX69,ENCOUNTER70,INDEX70,ENCOUNTER71,INDEX71,ENCOUNTER72,INDEX72,ENCOUNTER73,INDEX73,ENCOUNTER74,INDEX74,ENCOUNTER75,INDEX75,ENCOUNTER76,INDEX76,ENCOUNTER77,INDEX77,ENCOUNTER78,INDEX78,ENCOUNTER79,INDEX79,ENCOUNTER80,INDEX80,ENCOUNTER81,INDEX81,ENCOUNTER82,INDEX82,ENCOUNTER83,INDEX83,ENCOUNTER84,INDEX84,ENCOUNTER85,INDEX85,ENCOUNTER86,INDEX86,ENCOUNTER87,INDEX87,ENCOUNTER88,INDEX88,ENCOUNTER89,INDEX89,ENCOUNTER90,INDEX90,ENCOUNTER91,INDEX91,ENCOUNTER92,INDEX92,ENCOUNTER93,INDEX93,ENCOUNTER94,INDEX94,ENCOUNTER95,INDEX95,ENCOUNTER96,INDEX96,ENCOUNTER97,INDEX97,ENCOUNTER98,INDEX98,ENCOUNTER99,INDEX99,ENCOUNTER100,INDEX100,ENCOUNTER101,INDEX101,ENCOUNTER102,INDEX102,ENCOUNTER103,INDEX103,ENCOUNTER104,INDEX104,ENCOUNTER105,INDEX105,ENCOUNTER106,INDEX106,ENCOUNTER107,INDEX107,ENCOUNTER108,INDEX108,ENCOUNTER109,INDEX109,ENCOUNTER110,INDEX110,ENCOUNTER111,INDEX111,ENCOUNTER112,INDEX112,ENCOUNTER113,INDEX113,ENCOUNTER114,INDEX114,ENCOUNTER115,INDEX115,ENCOUNTER116,INDEX116,ENCOUNTER117,INDEX117,ENCOUNTER118,INDEX118,ENCOUNTER119,INDEX119,ENCOUNTER120,INDEX120";

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
  public static final int NUMPORTS = 10;
  public static final int NUMBATTLES = 10;
  public static final int NUMISLANDS = 10;


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

  // WORLD ENCOUNTER IDENTIFIERS
  public static final int GENOCEAN = 0;
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

  // OTHER
  public static final String FALSE = "false";
  public static final String TRUE = "true";
  public static final String[] TAVERNTYPES = {"Pub","Bar","Tavern","Cantina","Saloon","Beach Club", "Ale House", "Lounge", "Canteen", "Tavern", "Speakeasy", "Beer Hole", "Brewery"};
  public static final String[] JOINCREW = {"Yeah I'll join your crew!", "Sure.","Better than sitting around here.", "I hope you offer dental.", "Good time to confront my Thalassophobia.", 
                                            "Thank god my mother-in-law was driving me insane."};
}
