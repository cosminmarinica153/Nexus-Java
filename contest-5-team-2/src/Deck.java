import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    private void initializeDeck() {
        String[] suits = {"", "inima neagra", "inima rosie", "romb"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
        List<String> ranksList = Arrays.asList(ranks);
        
        for(int i = 0; i < 4; i++){
            for (String suit : suits) {
                for (String rank : ranks) {
                    cards.add(new Card(values[ranksList.indexOf(rank)], rank, suit));
                }
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    public Card drawCard(){
        return cards.remove(cards.size() - 1);
    }

}
