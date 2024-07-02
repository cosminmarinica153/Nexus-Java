import java.util.*;
import java.util.Scanner;

public class BlackJack {
    Scanner scanner = new Scanner(System.in);

    private final Deck deck;
    private ChipPool chipPool;
    private final Player humanPlayer;
    private final Player dealPlayer;

    public BlackJack() {
        deck = new Deck();
        chipPool = new ChipPool();

        humanPlayer = new Player();
        dealPlayer = new Player();

        startGame();
//        dealCards();
//        showPlayerInfo();
//        choices();
    }

    // we need to redo the whole choice selection to adapt the usage of chips
    // we need to add bet amount before we can be dealt cards
    // we should also add a way for the player to play however much he likes,
    // and give him the option to leave table,
    // maybe we could give him some stats at the end ~~~ Cosmin
    public void startGame() {
        humanPlayer.addChipsToHand(chipPool.startChips());

        List<Chip> test = humanPlayer.getChips();


        System.out.println(humanPlayer.showChips());

        // this is broken
        humanPlayer.addChipsToHand(chipPool.buyChips(192));

        System.out.println(humanPlayer.showChips());

    }





    public void dealCards() {
        humanPlayer.addCardsToHand(deck);
        dealPlayer.addCardsToHand(deck);
        humanPlayer.addCardsToHand(deck);
        dealPlayer.addCardsToHand(deck);
    }

    public void choices() {
        System.out.println("Human's turn");
        while (true) {
            System.out.println("Do you want to hit or stand? ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("hit")) {
                humanPlayer.addCardsToHand(deck);
                System.out.println(humanPlayer + "Value: " + humanPlayer.handValue());
                if (humanPlayer.handValue() > 21) {
                    System.out.println("You busted. Dealer won");
                    return;
                }
            } else if (choice.equalsIgnoreCase("stand")) {
                break;
            }
        }
        System.out.println("Dealer's turn");
        while (true) {
            if (dealPlayer.handValue() <= 17) {
                dealPlayer.addCardsToHand(deck);
                System.out.println("Dealer cards: " + dealPlayer + "Value: " + dealPlayer.handValue());
            } else if (dealPlayer.handValue() > 21) {
                System.out.println("Dealer busted. You won!");
                return;
            } else {
                System.out.println("Dealer final cards: " + dealPlayer + "Value: " + dealPlayer.handValue());
                if(dealPlayer.handValue() >= humanPlayer.handValue())
                    System.out.println("Dealer player won!");
                else System.out.println("Human player won!");
                return;
            }
        }
    }

    public void showPlayerInfo() {
        System.out.println(humanPlayer);
        System.out.println("Your value is: " + humanPlayer.handValue());
        System.out.println("Dealer's one card is : " + dealPlayer.getHand().get(1));
}
}