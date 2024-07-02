import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Deck {
    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"♥️", "♠️", "♦️", "♣️"};
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                this.deck.add(new Card(i, suit));
            }
        }
        Collections.shuffle(this.deck);
    }

    public List<Card> getDeck(){
        return this.deck;
    }

    public Card drawCard() {
        return deck.remove(deck.size() - 1);
    }

    public void showDeck()
    {
        for(Card card : deck)
        {
            System.out.println("Card: " + card);

        }
        System.out.println("Size of Deck: " + deck.size());
    }

}
