

import utils.Card;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    // Players (4)
    private final Player human;
    private final Player dealer;
    private final Player aiPlayer1;
    private final Player aiPlayer2;
    private Player currPlayer;

    private final ArrayList<Player> players;

    // Cards
    private Deck deck;
    private ArrayList<Card> cards;

    public BlackJack() {
        // Initialize the cards
        deck = new Deck(2, 14);
        ArrayList<Card> emptyHand = new ArrayList<>();
        cards = new ArrayList<>(deck.getDeck());
        // Initialize the Players
        this.human = new Player("Player", emptyHand);
        this.dealer = new Player("Dealer", emptyHand);
        this.aiPlayer1 = new Player("Ai", emptyHand);
        this.aiPlayer2 = new Player("Ai", emptyHand);

        players = new ArrayList<>();

        players.add(dealer);
        players.add(human);
        players.add(aiPlayer1);
        players.add(aiPlayer2);

        play();
    }

    public void play() {
        for(int i = 0; i < 2; i ++) {
            for(Player player : players) {
                hit(player);
            }
        }
        while (!this.players.isEmpty()){
            nextPlayer();
        }
    }

    private void nextPlayer() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> activePlayers = new ArrayList<>(players);
        this.currPlayer = activePlayers.getFirst();
        activePlayers.remove(activePlayers.getFirst());
        if(!this.currPlayer.getType().equals("Player")) {
            if(this.currPlayer.checkTotal() < 17) {
                hit(this.currPlayer);
            } else {
                stand(this.currPlayer);
            }
        } else {
            System.out.println("Make your choice: ");
            System.out.println("(1) Hit");
            System.out.println("(2) Stand");
            int choice = scanner.nextInt();
            if (choice == 1) {
                hit(this.currPlayer);
            } else if (choice == 2) {
                stand(this.currPlayer);
            } else {
                System.out.println("Invalid choice! Bye");
            }
        }
    }

    private void stand(Player playerToStand) {
        this.players.remove(playerToStand);
    }

    private void hit(Player playerToHit) {
        if (!this.cards.isEmpty()) {
            Card card = cards.remove(cards.size() - 1);
            playerToHit.addCards(card);
        }
        if (this.cards.size() >= 2) {
            System.out.println(playerToHit.getType() + ": " + playerToHit.getCards() + " (" + playerToHit.checkTotal() + ")");
        }
    }
}
