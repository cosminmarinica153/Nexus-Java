
import utils.Card;
import java.io.IOException;
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
        nextPlayer();
        playerWin();
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
                    System.out.println("\nMake your choice: ");
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


    private void hit(Player playerToHit) {
        if (!this.cards.isEmpty()) {
            Card card = cards.removeLast();
            playerToHit.addCards(card);
        }
        if (this.cards.size() >= 2) {
            printTable();
        }
//        clearScreen();
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

    private void dealerTurn(Player currPlayer) {
        if (currPlayer.cards.size() == 2) {
            System.out.println(currPlayer.getType() + ": " + currPlayer.getCards() + "(" + currPlayer.checkTotal() + ")");
        }
        while (currPlayer.checkTotal() <= 16) {
            hit(currPlayer);
        }
    }

    private void printTable() {
        clearScreen();
        for (Player player : players) {
            ShowCards(player);
        }
    }

    private void clearScreen() {
        System.out.println("----------------------------");
    }

    private void playerWin() {
        if (players.getFirst().checkTotal() == 21) {
            System.out.println("BlackJack. You Won !!!");
        } else
            if (players.getLast().checkTotal() == 21) {
            System.out.println("Dealer has BlackJack. You lost !!!");
        }
        if (players.getLast().checkTotal() == 21 && players.getFirst().checkTotal() == 21) {
            System.out.println("BlackJack Tie !!!");
            }
        if (players.getFirst().checkTotal() < 21) {
            if (players.getLast().checkTotal() < players.getFirst().checkTotal() || players.getLast().checkTotal() > 21) {
                System.out.println("You won !!!");
            }
        }
        if (players.getLast().checkTotal() < 21 && players.getLast().checkTotal() > players.getFirst().checkTotal()) {
            System.out.println("You lost !!!");
        }
        if (players.getFirst().checkTotal() > 21) {
            System.out.println("Bust !!!");
        }
        if (players.getFirst().checkTotal() == players.getLast().checkTotal()) {
            System.out.println("It's a draw !!!");
        }
    }
}


// in if daca playerul are sub 21 iar daca dealer si player au egal afiseaza tie
// la dealer turn, trebuie while pt cat are 16


//daca playerul nu are bust
    //daca dealerul are carti mai mici decat player
        //afiseaza mesaj ''ai castigat''
            //else afiseaza mesaj ''looser''





