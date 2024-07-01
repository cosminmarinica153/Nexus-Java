import utils.Card;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> deck;

    public Deck(int min, int max) {
        this.deck = new ArrayList<>();
        initializeDeck(min, max);
    }

    private void initializeDeck(int min, int max) {
        String[] suits = {"♥️", "♠️", "♦️", "♣️"};
        for (String suit : suits) {
            for (int i = min; i <= max; i++) {
                this.deck.add(new Card(i, suit));
            }
        }
        Collections.shuffle(this.deck);
    }

    public ArrayList<Card> getDeck() {
        return this.deck; }
}
