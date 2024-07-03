
import utils.Card;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    // Players (4)
    private final Player human;
    private final Player dealer;
    private final Player aiPlayer1;
    private final Player aiPlayer2;
    //private Player currPlayer;

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
        this.aiPlayer2 = new Player("Ai2", emptyHand);

        players = new ArrayList<>();

        players.add(human);
        players.add(aiPlayer1);
        players.add(aiPlayer2);
        players.add(dealer);

        play();
    }

    public void play() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                hit(player);
            }
        }
        // while (!this.players.isEmpty()){
        nextPlayer();
        // }
    }

    private void nextPlayer() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> activePlayers = new ArrayList<>(players);
        // ArrayList<Player> copyOfPlayers = activePlayers;
        // this.currPlayer = activePlayers.getFirst();
        for (Player currPlayer : activePlayers) {
            //activePlayers.remove(activePlayers.getFirst());
            if (!currPlayer.getType().equals("Player") && !currPlayer.getType().equals("Dealer")) {
                if (currPlayer.checkTotal() < 17) {
                    hit(currPlayer);
                } else {
                    //stand(currPlayer);
                    continue;
                }
            } else if (currPlayer.getType().equals("Dealer")) {
                dealerTurn(currPlayer);
            } else if (currPlayer.getType().equals("Player")) {
                while (true) {
                    if (currPlayer.checkTotal() > 21) {
                        System.out.println("You busted! Out");
                        //stand(this.currPlayer);
                        break;
                    } else if (currPlayer.checkTotal() == 21) {
                        System.out.println("Ai BlackJack");
                        // stand(this.currPlayer);
                        break;
                    }
                    System.out.println("Make your choice: ");
                    System.out.println("(1) Hit");
                    System.out.println("(2) Stand");
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        hit(currPlayer);
                    } else if (choice == 2) {
                        //stand(this.currPlayer);
                        break;
                    } else {
                        System.out.println("Invalid choice! Bye");
                    }
                }
                
            }
        }
    }

    private void stand(Player playerToStand) {
        this.players.remove(playerToStand);
    }

    private void hit(Player playerToHit) {

        if (!this.cards.isEmpty()) {
            Card card = cards.removeLast();
            playerToHit.addCards(card);
        }
        if (this.cards.size() >= 2) {

            ShowCards(playerToHit);

        }
    }

    private void ShowCards(Player playerToHit) {
        if (playerToHit.getType().equals("Dealer") && playerToHit.cards.size() == 2) {
            System.out.println(playerToHit.getType() + ": [" + playerToHit.getCards().get(0) + " ?" + "]("
                    + playerToHit.getCards().get(0).getValue() + ")");
        } else {
            System.out.println(
                    playerToHit.getType() + ": " + playerToHit.getCards() + "(" + playerToHit.checkTotal() + ")");
        }

    }

    private void printTable() {

    }

    private void dealerTurn(Player currPlayer) {
        if (currPlayer.cards.size() == 2) {
            System.out .println(currPlayer.getType() + ": " + currPlayer.getCards() + "(" + currPlayer.checkTotal() + ")");

        }
        if (currPlayer.checkTotal() <= 16) {
            hit(currPlayer);
        } 
        //stand(this.currPlayer);
        
    }

}
