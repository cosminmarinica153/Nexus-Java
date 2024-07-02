import java.util.ArrayList;
import java.util.List;

class Player {
    private final List<Card> hand;
    private int handValue;
//    private Chip[] chips;

    public Player(){
        this.hand = new ArrayList<>();
        this.handValue = 0;
    }

    public void addCardsToHand(Deck deck){
        Card card = deck.removeCard();
        hand.add(card);
        handValue += card.getValue();
        //to do
        if(handValue > 21){
            for(Card checkAce : hand){
                if(checkAce.getRank().equalsIgnoreCase("Ace") && handValue > 21)
                    handValue -= 10;
            }
        }
    }
    public int handValue(){
        return handValue;
    }

    public List<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "Cards:" +
                hand;
    }
}
