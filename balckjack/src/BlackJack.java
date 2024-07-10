import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BlackJack extends Deck {

    Scanner scanner = new Scanner(System.in);
    Deck deck = new Deck();
    private Player humanPLayer = new Player("Human");
    private Player dealPlayer = new Player("Deal");

    public BlackJack() {
        dealCards();
        tempShowPlayerInfo();
        choices();

    }

    public void dealCards() {
        humanPLayer.addCardsToHand(deck);
        humanPLayer.addCardsToHand(deck);
        dealPlayer.addCardsToHand(deck);
        dealPlayer.addCardsToHand(deck);
    }

    public void choices(){
        System.out.println("Human's turn");
        while(true){
            System.out.println("Do you want to hit or stand? ");
            String choice = scanner.nextLine();
            if(choice.equalsIgnoreCase("hit")){
                humanPLayer.addCardsToHand(deck);
                System.out.println(humanPLayer + "Value: " + humanPLayer.handValue());
                if(humanPLayer.handValue()>21) {
                    System.out.println("You busted. Dealer won");
                    return;
                }
            }else if(choice.equalsIgnoreCase("stand")){
                break;
            }
        }
        System.out.println("Dealer's turn");
        while(true){
            if(dealPlayer.handValue()<=17){
                dealPlayer.addCardsToHand(deck);
                System.out.println("Dealer cards: " + dealPlayer + "Value: " + dealPlayer.handValue());
            } else if (dealPlayer.handValue() > 21) {
                System.out.println("Dealer busted. You won!");
                return;
            }
        }
    }

    public void score(){
        System.out.println("Human score: " + humanPLayer.handValue() + " Dealer score: " + dealPlayer.handValue());
        if(humanPLayer.handValue() > dealPlayer.handValue()){
            System.out.println("Human wins!");
        } else if(humanPLayer.handValue() < dealPlayer.handValue()){
            System.out.println("Dealer wins!");
        } else if (humanPLayer.handValue() == dealPlayer.handValue()) {
            System.out.println("Draw");
        }
    }

    public void tempShowPlayerInfo() {
        System.out.println(humanPLayer);
        System.out.println("Your value is: " + humanPLayer.handValue());
        System.out.println("Dealer's one card is : " + dealPlayer.getHand().get(1));
    }

}