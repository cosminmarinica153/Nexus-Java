import java.util.*;

public class Dealer {
    private List<Card> hand;

    public Dealer(List<Card> hand) {
        this.hand = hand;
    }

    public void draw() {
        Card card = BlackjackGame.deck.drawCard();
        hand.add(card);
        System.out.println("Dealer has drawn a " + card.getRank());
    }

    public void addCard(Card card) {
        hand.add(card);
    }
}