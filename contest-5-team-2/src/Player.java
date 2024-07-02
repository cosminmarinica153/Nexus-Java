import java.util.*;


public class Player {
    protected String type;
    protected ArrayList<Card> hand;
    protected int balance;
    protected int total;

    public Player(String type, ArrayList<Card> hand, int balance) {
        this.type = type;
        this.hand = hand;
        this.balance = balance;
    }
    public Player(String type, ArrayList<Card> hand) {
        this.type = type;
        this.hand = hand;
        this.balance = 1000;
    }

    public int checkTotal(){
        this.total = 0;
        int aceCount = 0;
        for(Card card : hand){
            if(card.getValue() == 11)
            {
                aceCount++;
                this.total += card.getValue();
            }
            else if(card.getValue() > 11)
                this.total += 10;
            else
                this.total += card.getValue();
        }
        while(this.total > 21 && aceCount > 0)
        {
            this.total -= 10;
            aceCount--;
        }
        return this.total;
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
    public void addBalance(int sum) {
        this.balance += sum;
    }
    public void removeBalance(int sum) {
        this.balance -= sum;
    }

    public void addCard(Card card) {
        hand.add(card);
    }
    public ArrayList<Card> getCards(){
        return new ArrayList<>(this.hand);
    }
    protected void resetHand() {
        this.hand = new ArrayList<>();
    }

}
