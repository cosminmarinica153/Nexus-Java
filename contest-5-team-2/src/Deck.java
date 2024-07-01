import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Deck {
    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    private void initializeDeck() {
        String[] suits = {"♥️", "♠️", "♦️", "♣️"};
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                this.deck.add(new Card(i, suit));
                System.out.println(new Card(i, suit));
            }
        }
        System.out.println(deck.size());
    }

    public List<Card> getDeck(){
        return this.deck;
    }

    private void shuffleDeck() {
        Collections.shuffle(this.deck);
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
