import utils.Card;
import utils.Deck;
import utils.Player;

import java.util.*;

public class BlackjackGame {
    private List<Card> combinedDeck;
    private List<Player> players;
    private List<Player> remainingPlayers;
    private Player currentPlayer;
    private Player dealer;
    private Player human;
    private Player aIPlayer1;
    private Player aIPlayer2;
    private int currentBet;
    private boolean exitGame;

    public BlackjackGame() {
        this.combinedDeck = new ArrayList<>();
        this.exitGame = false;
        initializePlayers();
        initializeDecks();
        shuffleCombinedDeck();
        startGame();
    }

    private void startGame() {
        while (!exitGame && human.getBalance() > 200) {
            placeBet();
            dealFirst2Cards();
            playGame();
            displayAllHands();
            checkWinner();
            resetGame();
        }
        if (human.getBalance() <= 200) {
            System.out.println("You don't have enough to play! Go to the ATM!");
        }
        System.out.println("Thank you for playing!");
    }

    private void initializePlayers() {
        players = new ArrayList<>();
        remainingPlayers = new ArrayList<>();
        this.human = new Player("Human", new ArrayList<>(), 1000);
        initializeAi();

        players.add(human);
        players.add(this.aIPlayer1);
        players.add(this.aIPlayer2);
        players.add(this.dealer);
    }

    private void initializeAi() {
        this.aIPlayer1 = new Player("AIPlayer1", new ArrayList<>());
        this.aIPlayer2 = new Player("AIPlayer2", new ArrayList<>());
        this.dealer = new Player("Dealer", new ArrayList<>());
    }

    private void initializeDecks() {
        for (int i = 0; i < 4; i++) {
            Deck deck = new Deck();
            combinedDeck.addAll(deck.getDeck());
        }
    }

    private void shuffleCombinedDeck() {
        Collections.shuffle(combinedDeck);
        System.out.println("utils.Deck shuffled.");
    }

    private void placeBet() {
        this.currentBet = getBetAmount();

        while (this.currentBet < 200 || this.currentBet > 1000) {
            System.out.println("Bet must be between 200 and 1000.");
            this.currentBet = getBetAmount();
        }

        human.removeBalance(this.currentBet);
    }

    private int getBetAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Place your bets! (200-1000)");
        while (true) {
            try {
                int bet = scanner.nextInt();
                if (human.getBalance() >= bet) {
                    return bet;
                } else {
                    System.out.println("You don't have enough credits (" + bet + "), you have (" + human.getBalance() + ")");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private void dealFirst2Cards() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                hit(player);
            }
        }
        for (Player player : players) {
            System.out.println(player.getType() + " got the following cards " + player.getCards() + " (" + player.checkTotal() + ")");
        }
    }

    private void hit(Player playerToHit) {
        if (!combinedDeck.isEmpty()) {
            Card card = combinedDeck.remove(combinedDeck.size() - 1);
            playerToHit.addCard(card);
        }
        if (playerToHit.getHand().size() > 2) {
            System.out.println(playerToHit.getType() + " now has: " + playerToHit.getHand() + " (" + playerToHit.checkTotal() + ")");
        }
    }

    private void stand(Player playerToStand) {
        this.players.remove(playerToStand);
        this.remainingPlayers.add(playerToStand);
    }

    private void playGame() {
        while (!this.players.isEmpty() && !exitGame) {
            nextPlayer();
        }
    }

    private void nextPlayer() {
        if (this.players.isEmpty()) return;

        Scanner scanner = new Scanner(System.in);
        this.currentPlayer = players.get(0);
        if (this.currentPlayer.getType().equals("Human")) {
            boolean playerTurn = true;
            while (playerTurn && this.currentPlayer.checkTotal() <= 21) {
                System.out.println("Now you have a choice: ");
                System.out.println("(1) Hit");
                System.out.println("(2) Stand");
                System.out.println("(3) Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        hit(this.currentPlayer);
                        if (this.currentPlayer.checkTotal() > 21) {
                            System.out.println("You have busted!");
                            playerTurn = false;
                            players.remove(this.currentPlayer); // Remove the current player immediately if busted
                        }
                        break;
                    case 2:
                        stand(this.currentPlayer);
                        playerTurn = false;
                        break;
                    case 3:
                        exitGame = true;
                        playerTurn = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } else {
            while (this.currentPlayer.checkTotal() < 17) {
                hit(this.currentPlayer);
            }
            stand(this.currentPlayer);
        }
        if (!exitGame && !players.isEmpty() && players.get(0) == this.currentPlayer) {
            players.remove(0); // Remove the player after their turn if they haven't been removed already
        }
    }

    private void displayAllHands() {
        System.out.println("\nDisplaying all players' hands:");
        for (Player player : remainingPlayers) {
            System.out.println(player.getType() + " has: " + player.getHand() + " (" + player.checkTotal() + ")");
        }
        System.out.println(dealer.getType() + " has: " + dealer.getHand() + " (" + dealer.checkTotal() + ")\n");
    }

    private void checkWinner() {
        System.out.println("Checking winners...");
        if (dealer.checkTotal() <= 21) {
            for (Player remainingPlayer : remainingPlayers) {
                if (remainingPlayer.checkTotal() <= 21) {
                    if (dealer.checkTotal() > remainingPlayer.checkTotal()) {
                        System.out.println(remainingPlayer.getType() + " has lost!");
                    } else if (dealer.checkTotal() == remainingPlayer.checkTotal()) {
                        if (remainingPlayer != dealer) {
                            System.out.println("Draw between " + remainingPlayer.getType() + " and " + dealer.getType());
                            if (remainingPlayer == this.human) {
                                this.human.addBalance(this.currentBet);
                            }
                        }
                    } else {
                        System.out.println(remainingPlayer.getType() + " has won!");
                        if (remainingPlayer == this.human) {
                            this.human.addBalance(this.currentBet * 2);
                        }
                    }
                } else {
                    System.out.println(remainingPlayer.getType() + " has busted!");
                }
            }
        } else {
            for (Player remainingPlayer : remainingPlayers) {
                if (remainingPlayer.checkTotal() <= 21) {
                    System.out.println(remainingPlayer.getType() + " has won!");
                    if (remainingPlayer == this.human) {
                        this.human.addBalance(this.currentBet * 2);
                    }
                } else {
                    System.out.println(remainingPlayer.getType() + " has lost!");
                }
            }
        }
    }

    private void resetGame() {
        if (!exitGame && human.getBalance() > 200) {
            for (Player player : remainingPlayers) {
                player.resetHand();
            }
            this.players.clear();
            this.remainingPlayers.clear();
            initializePlayers();
        }
    }
}
