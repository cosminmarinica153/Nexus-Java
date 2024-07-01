import java.util.*;


public class Player {
    protected String type;
    protected ArrayList<Card> hand;
    protected int balance;

    public Player(String type, ArrayList<Card> hand) {
        this.type = type;
        this.hand = hand;

    }

    public String getType() {
        return type;
    }
    public List<Card> getHand() {
        return hand;
    }
    public int getBalance() {
        return balance;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public ArrayList<Card> getCards(){
        return new ArrayList<>(this.hand);
    }

}
