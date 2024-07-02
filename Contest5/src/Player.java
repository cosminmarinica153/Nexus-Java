import utils.Card;

import java.util.ArrayList;

public class Player {
    protected final String type;
    protected ArrayList<Card> cards;
    protected int total;

    public Player(String type, ArrayList<Card> cards){
        this.type = type;
        this.cards = new ArrayList<>(cards);
        this.total = 0;
    }

    public void addCards(Card card) {
        this.cards.add(card);
        checkTotal();
    }
    public void addCards(ArrayList<Card> cards) {
        this.cards.addAll(cards);
        checkTotal();
    }

    public int checkTotal() {
        this.total = 0; // reset total to recalculate
        for(Card card : this.cards) {
            if (card.getValue() > 11)
                this.total += 10;
            else
                this.total += card.getValue();
        }
        for(Card card : this.cards) {
        if(card.getValue() == 11 && this.total >21)
            this.total -= 10;
        }
        return this.total;
    }

    public String getType() { return this.type; }

    public ArrayList<Card> getCards() {
        if (this.type.equals("Dealer")) {
            ArrayList<Card> dealerCards = new ArrayList<>(this.cards);
            if (!dealerCards.isEmpty()) {
                dealerCards.set(dealerCards.size() - 1, new Card("?"));
            }
            return dealerCards;
        }
        return new ArrayList<>(this.cards);
    }

//    public boolean checkForAces() {
//        if (this.total > 21) {
//            for (Card card : this.cards) {
//                if (card.getValue() == 11) {
//                    card = new Card(1, card.getSuit());
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public Card putCardOnTable() {
        if (this.cards.isEmpty())
            return null;
        System.out.println(this.type + " puts down: " + this.cards.get(0));
        return this.cards.remove(0);
    }

    public boolean hasCards() { return !this.cards.isEmpty(); }
}
