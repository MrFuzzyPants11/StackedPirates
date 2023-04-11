//File: Animations.java
//Author: MrFuzzyPants
//Created: 04-08-2023
//Modified: 04-08-2023
package Globals;

public abstract class Constants {
  // Common Strings
  public static final String CREW = "crew";
  public static final String FOOD = "food";
  public static final String SHIP = "ship";
  public static final String CARD = "card";
  public static final String PACK = "pack";
  public static final String EFFECT = "effect";

  // Header Columns
  public static final String INDEX = "index";
  public static final String TYPE = "type";
  public static final String RARITY = "rarity";
  public static final String NAME = "name";
  public static final String SOLD = "sold";
  public static final String OPENED = "opened";
  public static final String COST = "cost";
  public static final String CARD1 = "card1";
  public static final String CARD2 = "card2";
  public static final String CARD3 = "card3";
  public static final String CARD4 = "card4";
  public static final String CARD5 = "card5";
  public static final String ININVENTORY = "ininventory";
  public static final String SUBTYPE = "subtype";
  public static final String ITEMINDEX = "itemindex";
  public static final String FNAME = "fname";
  public static final String LNAME = "lname";
  public static final String LEVEL = "level";
  public static final String HEALTH = "health";
  public static final String GOLD = "gold";
  public static final String SUPPLYSTORE = "supplystore";
  public static final String TAVERN = "tavern";
  public static final String DOCKYARD = "dockyard";
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
  public static final String HEALTHRESTORED = "healthrestored";
  public static final String DESCRIPTION = "description";
  public static final String EFFECTINDEX = "effectindex";

  // RARITIES
  public static final String COMMON = "common";
  public static final String UNCOMMON = "uncommon";
  public static final String RARE = "rare";
  public static final String EPIC = "epic";
  public static final String LEGENDARY = "legendary";

  // COLOURS
  public static final String RESET = "0";
  public static final String COMMONCOLOUR = RESET;
  public static final String BLACK = "30";
  public static final String RED = "31";
  public static final String GREEN = "32";
  public static final String YELLOW = "33";
  public static final String GOLDCOLOUR = YELLOW;
  public static final String EPICCOLOUR = YELLOW;
  public static final String BLUE = "34";
  public static final String ENCOUNTERCOLOUR = BLUE;
  public static final String MAGENTA = "35";
  public static final String LEVELCOLOUR = MAGENTA;
  public static final String RARECOLOUR = MAGENTA;
  public static final String CYAN = "36";
  public static final String UNCOMMONCOLOUR = CYAN;
  public static final String WHITE = "37";
  public static final String RAINBOW = "RAINBOW";
  public static final String LEGENDARYCOLOUR = RAINBOW;
  public static final String BROWNBOW = "BROWNBOW";

  // FILE NAMES
  public static final String ALLCARDSCSV = "allcards";
  public static final String ALLPACKSCSV = "allpacks";
  public static final String HUMANCSV = "human";
  public static final String INVENTORYCSV = "inventory";
  public static final String PLAYERCSV = "player";
  public static final String PLAYERSHIPCSV = "playership";
  public static final String PORTSCSV = "ports";
  public static final String SUPPLYSTORESCSV = "supplystores";
  public static final String NAMESFOLDER = "SmashewNames";
  public static final String ENFIRSTNAMES = NAMESFOLDER + "/enfirstnames";
  public static final String ESFIRSTNAMES = NAMESFOLDER + "/esfirstnames";
  public static final String ENLASTNAMES = NAMESFOLDER + "/enlastnames";
  public static final String ESLASTNAMES = NAMESFOLDER + "/eslastnames";
  public static final String FOODEFFECTCSV = "foodeffects";
  public static final String CREWEFFECTCSV = "creweffects";
  public static final String SHIPEFFECTCSV = "shipeffects";

  // Headers and formats
  public static final String ALLCARDSHEADER = TYPE + "," + RARITY + "," + NAME + "," + EFFECTINDEX;
  public static final String ALLCARDSFORMAT = "%s,%d,%s,%d";
  public static final String ALLPACKSHEADER = TYPE + "," + SOLD + "," + OPENED + "," + RARITY + "," + COST + "," + CARD1 + "," + CARD2 + "," + CARD3 + "," + CARD4 + "," + CARD5;
  public static final String ALLPACKSFORMAT = "%s,%s,%s,%d,%d,%d,%d,%d,%d,%d";
  public static final String CREWEFFECTHEADER = RARITY + "," + DESCRIPTION;
  public static final String CREWEFFECTFORMAT = "%d,%s";
  public static final String FOODEFFECTHEADER = RARITY + "," + DESCRIPTION + "," + HEALTHRESTORED;
  public static final String FOODEFFECTFORMAT = "%d,%s,%d";
  public static final String HUMANHEADER = "";
  public static final String INVENTORYHEADER = ININVENTORY + "," + TYPE + "," + SUBTYPE + "," + ITEMINDEX;
  public static final String INVENTORYFORMAT = "%s,%s,%s,%d";
  public static final String PLAYERHEADER = FNAME + "," + LNAME + "," + LEVEL + "," + HEALTH + "," + GOLD + "," + CARD1 + "," + CARD2 + "," + CARD3 + "," + CARD4 + "," + CARD5;
  public static final String PLAYERFORMAT = "%s,%s,%d,%d,%d,%d,%d,%d,%d,%d";
  public static final String PLAYERSHIPHEADER = "";
  public static final String PLAYERSHIPFORMAT = "";
  public static final String PORTSHEADER = NAME + "," + LEVEL + "," + SUPPLYSTORE + "," + TAVERN + "," + DOCKYARD;
  public static final String PORTSFORMAT = "%s,%d,%d,%d,%d";
  public static final String SHIPEFFECTHEADER = RARITY + "," + DESCRIPTION;
  public static final String SHIPEFFECTFORMAT = "%d,%s";
  public static final String SUPPLYSTORESHEADER = LEVEL + "," + PACK0 + "," + PACK1 + "," + PACK2 + "," + PACK3 + "," + PACK4 + "," + PACK5 + "," + PACK6 + "," + PACK7 + "," + PACK8 + "," + PACK9;
  public static final String SUPPLYSTORESFORMAT = "%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d";

  // NUMBERS
  public static final int COMMONNUM = 0;
  public static final int UNCOMMONNUM = 1;
  public static final int RARENUM = 2;
  public static final int EPICNUM = 3;
  public static final int LEGENDARYNUM = 4;
  public static final int MINVALUE = Integer.MIN_VALUE;
  public static final int MENUEXIT = MINVALUE;
  public static final int MAXVALUE = Integer.MAX_VALUE;
  public static final int QUIT = MAXVALUE;
  public static final int MINRARITY = 0;
  public static final int MAXRARITY = 4;
  public static final int MINLEVEL = 0;
  public static final int MAXLEVEL = 4;
  public static final int ANIMATIONSPEED = 1000;

  // Initial Values
  public static final int STARTINGLEVEL = 0;
  public static final int STARTINGHEALTH = 50;
  public static final int STARTINGGOLD = 696969;

  // OTHER
  public static final String TRUE = "true";
  public static final String FALSE = "false";
  public static final String EMPTY = "";
  public static final String SPACE = " ";
}
