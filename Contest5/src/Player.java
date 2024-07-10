import utils.Card;

import java.util.ArrayList;

public class Player {
    private final String type;
    private ArrayList<Card> cards;
    private int total;
    private int credits;
    private int bet;


    public Player(String type, ArrayList<Card> cards, int credits) {
        this.type = type;
        this.cards = new ArrayList<>(cards);
        this.total = 0;
        this.credits = credits;
    }
    public Player(String type,ArrayList<Card> cards){
        this.type = type;
        this.cards = new ArrayList<>(cards);
        this.total = 0;
    }

    public ArrayList<Card> getCards() {
        if (this.type.equals("Dealer")) {
            ArrayList<Card> dealerCards = new ArrayList<>(this.cards);
            return dealerCards;
        }
        return new ArrayList<>(this.cards);
    }

    public String getType() {
        return this.type;
    }
    public int getCredits(){
        return this.credits;
    }
    public void setCredits(int credits){
        this.credits += credits;
    }
    public int getBet(){return this.bet;}
    public void setBet(int bet) {this.bet = bet;}
    public void setCards(ArrayList<Card> cards){
        this.cards = cards;
    }

    public int checkTotal() {
        this.total = 0; // reset total to recalculate
        if (this.type != "Dealer") {
            for (Card card : this.cards) {
                this.total += card.getValue();
            }
            return this.total;
        }

        for (int i = 0; i < cards.size(); i++) {

            if (cards.get(i).getValue() > 11)
                this.total += 10;
            else
                this.total += cards.get(i).getValue();

        }
        return this.total;

    }

    public void addCards(Card card) {
        this.cards.add(card);
        checkTotal();
    }

    public void addCards(ArrayList<Card> cards) {
        this.cards.addAll(cards);
        checkTotal();
    } 

    public void checkForAces() {
        if (this.total > 21) {
            for (Card card : this.cards) {
                if (card.getValue() == 11) {
                    card = new Card(1, card.getSuit());
                    checkTotal();
                }
            }
        }
    }

    public Card putCardOnTable() {
        if (this.cards.isEmpty())
            return null;
        System.out.println(this.type + " puts down: " + this.cards.get(0));
        return this.cards.remove(0);
    }

    public boolean hasCards() {
        return !this.cards.isEmpty();
    }
}
