import java.util.*;

public class Player {
    Chip[] chips;
    List<Card> hand;
    int balance;

    public Player(Chip[] chips, List<Card> hand, int balance ){
        this.chips = chips;
        this.hand = hand;
        this.balance = balance;
    }

    public void Hit(){
        Card card = BlackjackGame.deck.drawCard();
        hand.add(card);
        System.out.println("Player has drawn a " + card.getRank());
    }

    public void Stand(){
        System.out.println("Player has stood");
    }

}
