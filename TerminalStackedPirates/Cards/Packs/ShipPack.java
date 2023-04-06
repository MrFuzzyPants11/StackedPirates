package Cards.Packs;

import java.util.*;

import Cards.Cards.*;

public class ShipPack extends Pack{
  public ShipPack(int rarity){
    this.rarity = rarity;
    cards = new ArrayList<Card>();
    generatePack(rarity);
  }

  public String getName(){
    return "Ship Pack";
  }
  
  protected void generatePack(int rarity){
    Random rand = new Random();
    if(rarity == 0){
      for(int i = 0; i < 5; i++){
        cards.add(new ShipCard(0));
      }
    } else if(rarity == 1){
      cards.add(new ShipCard(1));
      if(rand.nextBoolean()){
        cards.add(new ShipCard(1));
      } else {
        cards.add(new ShipCard(0));
      }
      for(int i = 1; i <= 3; i++){
        cards.add(new ShipCard(0));
      }
    } else {
      cards.add(new ShipCard(rarity));
      if(rand.nextBoolean()){
        cards.add(new ShipCard(rarity));
      } else {
        cards.add(new ShipCard(rarity - 1));
      }
      for(int i = 1; i <= 3; i++){
        cards.add(new ShipCard(rand.nextInt(rarity)));
      }
    }
  }
}
