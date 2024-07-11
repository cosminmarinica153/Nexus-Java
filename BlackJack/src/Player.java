import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private Hand hand;
    private boolean isAI;
    private boolean isReady;

    public Player(String name, boolean isAI) {

        this.name = name;
        this.hand = new Hand();
        this.isAI = isAI;


    }

    public boolean getReady(){
        return isReady;
    }

    public void setReady(boolean ready){
        isReady = ready;
    }

    public Player(String name) {

        this.name = name;
        this.hand = new Hand();
        this.isReady = false;

    }

    public String getName() {

        return name;

    }

    public Hand getHand() {

        return hand;

    }

    public void clearHand() {

        hand.clear();

    }

    public int getHandValue() {

        return hand.getValue();

    }

    public void addCardToHand(Card card) {

        hand.addCard(card);

    }

    public boolean isAI() {

        return isAI;

    }

    public String decideAction() {
        // Simplistic AI: hit if hand value < 17, otherwise stand
        if (getHandValue() < 17) {

            return "hit";

        } else {

            return "stand";

        }
    }

    public String toString(boolean showFirstCard) {

        if (isAI && !showFirstCard) {

            return name + "'s hand: [" + hand.getCards().get(0) + ", HIDDEN]";

        } else {

            return name + "'s hand: " + hand + " " + getHandValue();

        }
    }

    @Override
    public String toString() {

        return name ;

    }
}

