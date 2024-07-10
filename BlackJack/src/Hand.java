import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Hand implements Serializable {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }
    public List<Card> getCards() {
        return cards;
    }

    public int getValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank().equals("Ace")) {
                numAces++;
            }
        }

        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        return value;
    }

    public void clear() {
        cards.clear();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
