//File: StackedPiratesTerminal.java
//Author: MrFuzzyPants
//Created: 05-04-2023
//Modified: 05-04-2023

package Globals;

import static Globals.Tools.*;
import java.util.*;
import Humans.*;
import Ships.*;
import Cards.*;
import Encounters.*;
import Encounters.subEncounters.*;

public class StackedPiratesTerminal{
  public static void main(String args[]){
    initializeScanner();
    prln("Welcome to Stacked Pirates!");
    Player player = new Player("Fuzzy", "Pants");
    prln("You are " + player.getFname() + " " + player.getLname() + ".");
    prln("You are Level " + player.getLevel() + ", have no cards, But do have " + player.getGold() + " gold.");
    Port port = new Port(true);
    port.enter();
  }
}