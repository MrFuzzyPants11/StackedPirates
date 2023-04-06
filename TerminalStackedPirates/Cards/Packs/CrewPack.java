package Cards.Packs;

import java.util.*;

import Cards.Cards.*;

public class CrewPack extends Pack{
  public CrewPack(int rarity){
    this.rarity = rarity;
    cards = new ArrayList<Card>();
    generatePack(rarity);
  }

  public String getName(){
    return "Crew Pack";
  }

  protected void generatePack(int rarity){
    Random rand = new Random();
    if(rarity == 0){
      for(int i = 0; i < 5; i++){
        cards.add(new CrewCard(0));
      }
    } else if(rarity == 1){
      cards.add(new CrewCard(1));
      if(rand.nextBoolean()){
        cards.add(new CrewCard(1));
      } else {
        cards.add(new CrewCard(0));
      }
      for(int i = 1; i <= 3; i++){
        cards.add(new CrewCard(0));
      }
    } else {
      cards.add(new CrewCard(rarity));
      if(rand.nextBoolean()){
        cards.add(new CrewCard(rarity));
      } else {
        cards.add(new CrewCard(rarity - 1));
      }
      for(int i = 1; i <= 3; i++){
        cards.add(new CrewCard(rand.nextInt(rarity)));
      }
    }
  }
}
