import java.util.*;


public class Dealer {
    private List<Card> hand;

    public Dealer(List<Card> hand) {
        this.hand = hand;
    }



    public void addCard(Card card) {
        hand.add(card);
    }
}