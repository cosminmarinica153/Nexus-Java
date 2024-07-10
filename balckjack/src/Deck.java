import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    protected ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        String[] suits = {"♥️","🔷", "♣️", "🖤"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "Ace"};
        int[] value = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
        for (String suit : suits) {
            for (int i = 0; i < value.length; i++) {
                deck.add(new Card(value[i], suit, ranks[i]));
            }
        }
        shuffleDeck();
    }


    protected void shuffleDeck() {
        Collections.shuffle(deck);
    }
    public Card removeCard() {
        return deck.removeLast();
    }
}
