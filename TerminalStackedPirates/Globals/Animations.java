//File: Animations.java
//Author: MrFuzzyPants
//Created: 04-09-2023
//Modified: 04-19-2023
package Globals;

import static Globals.Constants.*;
import static Globals.Tools.*;
import static Globals.ASCIIArt.*;
import java.util.Random;
import Items.Cards.*;

public abstract class Animations {

  /*
   * Prints the opening animation for a pack
   */
  public static void openPackAnimation(int rarity){
    pr("\u001B[31m<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><>< \u001B[0mOPENING\u001B[31m <><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");

    sleep(ANIMATIONSPEED);

    pr("\033[3F\r\u001B[33m<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><>< \u001B[0mYOUR\u001B[33m ><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");

    sleep(ANIMATIONSPEED);

    pr("\033[3F\r\u001B[32m<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><>< \u001B[0mPACK\u001B[32m ><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");

    sleep(ANIMATIONSPEED);

    pr("\033[3F\r\u001B[36m<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><>< \u001B[0mYOU\u001B[36m <><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");

    sleep(ANIMATIONSPEED);

    pr("\033[3F\r\u001B[34m<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><>< \u001B[0mGOT\u001B[34m <><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");

    sleep(ANIMATIONSPEED);

    pr("\033[3F\r\u001B[35m<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><> \u001B[0mA\u001B[35m <><><><><><><><><><><><><><><><\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
      +"<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");

    sleep(ANIMATIONSPEED);

    if(rarity == COMMONNUM){
      pr("\033[3F\r");
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",COMMONCOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",COMMONCOLOUR);
      prln("<><><><><><><><><><><><><><> COMMON <><><><><><><><><><><><><><>",COMMONCOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",COMMONCOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",COMMONCOLOUR);

    } else if(rarity == UNCOMMONNUM){
      pr("\033[3F\r");
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",UNCOMMONCOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",UNCOMMONCOLOUR);
      prln("<><><><><><><><><><><><><>< UNCOMMON ><><><><><><><><><><><><><>",UNCOMMONCOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",UNCOMMONCOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",UNCOMMONCOLOUR);
    } else if(rarity == RARENUM){
      pr("\033[3F\r");
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",RARECOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",RARECOLOUR);
      prln("<><><><><><><><><><><><><><>< RARE ><><><><><><><><><><><><><><>",RARECOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",RARECOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",RARECOLOUR);
    } else if(rarity == EPICNUM){
      pr("\033[3F\r");
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",EPICCOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",EPICCOLOUR);
      prln("<><><><><><><><><><><><><><>< EPIC ><><><><><><><><><><><><><><>",EPICCOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",EPICCOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",EPICCOLOUR);
    } else {
      pr("\033[3F\r");
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",LEGENDARYCOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",LEGENDARYCOLOUR);
      prln("<><><><><><><><><><><><><>< LEGENDARY <><><><><><><><><><><><><>", LEGENDARYCOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",LEGENDARYCOLOUR);
      prln("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>",LEGENDARYCOLOUR);
    }
  }

  /*
   * Prints the animation for viewing a trading card
   * @param numCards the number of cards to be viewed
   * @param cards the cards to be viewed
   */
  public static void viewCardAnimation(int numCards, Card... cards){
    Random rand = new Random();
    String[][] allCardArts = new String[numCards][20];
    for (int i = 0; i < numCards; i++) {
      if(cards[i] instanceof FoodCard){
        int randomInt = rand.nextInt(4);
        if(randomInt == 0){
          addCardToArray(allCardArts[i],FOODPLATECARD,cards[i]);
        } else if(randomInt == 1){
          addCardToArray(allCardArts[i],FOODCHERRYCARD,cards[i]);
        } else if(randomInt == 2){
          addCardToArray(allCardArts[i],FOODCHOCOLATECARD,cards[i]);
        } else if(randomInt == 3){
          addCardToArray(allCardArts[i],FOODTEACARD,cards[i]);
        }
      } else if(cards[i] instanceof CrewCard){
        int randomInt = rand.nextInt(4);
        if(randomInt == 0){
          addCardToArray(allCardArts[i],CREWKNIFECARD,cards[i]);
        } else if(randomInt == 1){
          addCardToArray(allCardArts[i],CREWGUNCARD,cards[i]);
        } else if(randomInt == 2){
          addCardToArray(allCardArts[i],CREWTUNICCARD,cards[i]);
        } else if(randomInt == 3){
          addCardToArray(allCardArts[i],CREWBOOTSCARD,cards[i]);
        }

      } else if(cards[i] instanceof ShipCard){
        if(rand.nextBoolean()){
          addCardToArray(allCardArts[i],SHIPSHIPCARD, cards[i]);
        } else {
          addCardToArray(allCardArts[i],SHIPCANNONCARD,cards[i]);
        }
      }
    }

    for(int i = 0; i < 20; i++){
      for(int j = 0; j < numCards; j++){
        pr(allCardArts[j][i]);
      }
      prln(EMPTY);
    }
  }

  /*
   * Adds a cards art to the array of cardarts
   * @param allCardArts the array to store the art
   * @param cardArt the art of the card
   * @param card the card to be added
   */
  public static void addCardToArray(String[] allCardArts, String[] cardArt,Card card){
    int lengthAdded = 0;
    for(int i = 0; i < 20; i++){
      String temp = EMPTY;
      if(cardArt[i].equals(NAMEBAR)){
        lengthAdded = 0;
        int strLen = card.getName().length();
        if(strLen == 30){
          temp = "|" + everyFirstCap(card.getName()) + "|";
        } else if(strLen == 29){
          temp = "| " + everyFirstCap(card.getName()) + "|";
        } else if(strLen == 28){
          temp = "| " + everyFirstCap(card.getName()) + " |";
        } else if(strLen == 27){
          temp = "|  " + everyFirstCap(card.getName()) + " |";
        } else {
          int padding = 28 - card.getName().length();
          temp = "|  " + everyFirstCap(card.getName()) + " ".repeat(padding) + "|";
        }
        allCardArts[i] = temp;
      } else if(cardArt[i].equals(RARITYPLACEHOLDER)){
        lengthAdded = 0;
        if(card.getRarity() == LEGENDARYNUM){
          temp = "|  " + allCaps(card.getType()) + " CARD" + "       \u001B[31;3mL\u001B[33;3mE\u001B[32;3mG\u001B[36;3mE\u001B[34;3mN\u001B[35;3mD\u001B[31;3mA\u001B[33;3mR\u001B[32;3mY\u001B[0m   |";
        } else {
          temp = " ".repeat(13 - card.getRarityText().length());
          temp = "|  " + allCaps(card.getType()) + " CARD" + "   " + temp + "\u001B[" + card.getColour() + "m" +  allCaps(card.getRarityText()) + "\u001B[0m   |"; 
        }
        allCardArts[i] = temp;
      } else if(cardArt[i].equals(EFFECTPLACEHOLDER)){
        if(lengthAdded < card.getEffect().getDescription().length()){
          String sub = card.getEffect().getDescription().substring(lengthAdded);
          if(sub.charAt(0) == ' '){
            sub = sub.substring(1);
          }
          int len = Math.min(26, sub.length());
          String firstStr = sub.substring(0, len);
          if(len == 26){
            String secondStr = sub.substring(len - 1);
            if(secondStr.charAt(0) != ' '){
              while (firstStr.charAt(firstStr.length() - 1) != ' ') {
                firstStr = firstStr.substring(0, firstStr.length() - 1);
              }
            }
          }
          lengthAdded += firstStr.length();
          if (firstStr.length() < 26) {
            temp = "|  " + firstStr + " ".repeat(26 - firstStr.length()) + "  |";
          }
        } else {
          temp = "|                              |";
        }
        allCardArts[i] = temp;
      } else {
        allCardArts[i] = cardArt[i];
        lengthAdded = 0;
      }
    }
  }
}
