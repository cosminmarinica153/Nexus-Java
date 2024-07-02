import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Player {
    private List<Card> hand;
    private int handValue;
    private List<Chip> chips;

    public Player(){
        this.hand = new ArrayList<>();
        this.handValue = 0;
        this.chips = new ArrayList<>();
    }

    public void addCardsToHand(Deck deck){
        Card card = deck.removeCard();
        hand.add(card);
        handValue += card.getValue();
        //to do
        if(handValue > 21){
            for(Card checkAce : hand){
                if(checkAce.getRank().equalsIgnoreCase("Ace") && handValue > 21)
                    handValue -= 10;
            }
        }
    }

    public List<Chip> getChips() {
        return chips;
    }

    public String showChips(){
        String chipsString = "";
        int[] chipsCounter = new int[6];
        for(Chip chip : chips){
            if (chip.getColor().equals("white")) {
                chipsCounter[0]++;
            } else if (chip.getColor().equals("red")) {
                chipsCounter[1]++;
            } else if (chip.getColor().equals("blue")) {
                chipsCounter[2]++;
            } else if (chip.getColor().equals("green")) {
                chipsCounter[3]++;
            } else if (chip.getColor().equals("orange")) {
                chipsCounter[4]++;
            } else if (chip.getColor().equals("black")) {
                chipsCounter[5]++;
            }
        }

        chipsString += "Player Chips: \n";
        chipsString += chipsCounter[0] + " white chip(s)\n";
        chipsString += chipsCounter[1] + " red chip(s)\n";
        chipsString += chipsCounter[2] + " blue chip(s)\n";
        chipsString += chipsCounter[3] + " green chip(s)\n";
        chipsString += chipsCounter[4] + " orange chip(s)\n";
        chipsString += chipsCounter[5] + " black chip(s)\n";

        return chipsString;
    }

    public void addChipsToHand(Chip[] chips){
        this.chips.addAll(Arrays.asList(chips));
    }

    public int handValue(){
        return handValue;
    }

    public List<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "Cards:" +
                hand;
    }
}
