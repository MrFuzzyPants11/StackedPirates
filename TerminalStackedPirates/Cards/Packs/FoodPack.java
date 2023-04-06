package Cards.Packs;
import java.util.*;

import Cards.Cards.*;

public class FoodPack extends Pack{
  public FoodPack(int rarity){
    this.rarity = rarity;
    cards = new ArrayList<Card>();
    generatePack(rarity);
  }

  public String getName(){
    return "Food Pack";
  }
  
  protected void generatePack(int rarity){
    Random rand = new Random();
    if(rarity == 0){
      for(int i = 0; i < 5; i++){
        cards.add(new FoodCard(0));
      }
    } else if(rarity == 1){
      cards.add(new FoodCard(1));
      if(rand.nextBoolean()){
        cards.add(new FoodCard(1));
      } else {
        cards.add(new FoodCard(0));
      }
      for(int i = 1; i <= 3; i++){
        cards.add(new FoodCard(0));
      }
    } else {
      cards.add(new FoodCard(rarity));
      if(rand.nextBoolean()){
        cards.add(new FoodCard(rarity));
      } else {
        cards.add(new FoodCard(rarity - 1));
      }
      for(int i = 1; i <= 3; i++){
        cards.add(new FoodCard(rand.nextInt(rarity)));
      }
    }
  }
}