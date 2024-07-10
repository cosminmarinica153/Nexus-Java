
import utils.Card;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackJack {
    // Players (4)

    private final Player[] players = new Player[5];

    private Scanner scanner = new Scanner(System.in);


    // Cards
    private Deck deck;
    private ArrayList<Card> cards;

    public BlackJack(Player[] players) {
        // Initialize the cards
        deck = new Deck(2, 14);
        cards = new ArrayList<>(deck.getDeck());
        // Initialize the Players
        for (int i = 0; i < players.length; i = i + 1) {
            this.players[i] = players[i];
        }
        this.players[4] = new Player("Dealer", new ArrayList<Card>());

        play();
    }

    public void play() {
        for (int i = 0; i < players.length - 1; i = i + 1) {
            if (this.players[i] == null) {
                continue;
            }
            if (this.players[i].getCredits() < 10) {
                players[i].setBet(0);
                System.out.println("You don't have enough credits");
                continue;
            }
            System.out.println("You have " + players[i].getCredits() + " credits");
            System.out.println("How many credits do you want to bet?\nMin bet is 10");
            System.out.println("Bet 0 if you don't want to join");
            int creditsPlayed = scanner.nextInt();

            while (creditsPlayed < 10 && creditsPlayed != 0){
                System.out.println("Bet is insuficient");
                creditsPlayed = scanner.nextInt();
            }
            players[i].setBet(creditsPlayed);
            if (this.players[i].getBet() == 0)
                continue;
            if
        }

    }


//                players.getFirst().setCredits(-creditsPlayed);
//                System.out.println("TEMP: ai" + players.getFirst().getCredits() + " credite");
//                for (int i = 0; i < 2; i++) {
//                    for (Player player : players) {
//                        hit(player);
//                    }
//                }
//
//                nextPlayer();
//
//                System.out.println(playerWin(creditsPlayed));
//                System.out.println(players.getFirst().getCredits());
//                if (players.getFirst().getCredits() < 10) {
//                    System.out.println("Nu ai destui bani sa joci la masa asta, SARACULE!");
//                    break;
//                }
//                System.out.println("Ai vrea sa mai joci o mana?\n1 pt da 2 pt nu");
//                playerChoice = scanner.nextInt();
//                if (playerChoice == 1) {
//                    newTurn();
//                    continue;
//                } else {
//                    System.out.println("Te mai asteptam pe la noi");
//                    break;
//                }
//
//            } else {
//                System.out.println("Nu ai pariat destul");
//            }
//        }
}

public void newTurn() {
    for (Player player : players) {
        player.setCards(new ArrayList<>());
    }
    this.deck = new Deck(2, 14);
    this.cards = new ArrayList<>(deck.getDeck());
}

//    private void nextPlayer() {
//        Scanner scanner = new Scanner(System.in);
//        ArrayList<Player> activePlayers = players;
//        for (Player currPlayer : activePlayers) {
//            if (!currPlayer.getType().equals("Player") && !currPlayer.getType().equals("Dealer")) {
//                if (currPlayer.checkTotal() < 17) {
//                    hit(currPlayer);
//                } else {
//                    continue;
//                }
//            } else if (currPlayer.getType().equals("Dealer")) {
////                dealerTurn(currPlayer);
//            } else if (currPlayer.getType().equals("Player")) {
//                while (true) {
//                    if (currPlayer.checkTotal() > 21) {
//                        System.out.println("You busted! Out");
//                        break;
//                    } else if (currPlayer.checkTotal() == 21) {
//                        System.out.println("Ai BlackJack");
//                        break;
//                    }
//                    System.out.println("\nMake your choice: ");
//                    System.out.println("(1) Hit");
//                    System.out.println("(2) Stand");
//                    int choice = scanner.nextInt();
//                    if (choice == 1) {
//                        hit(currPlayer);
//                    } else if (choice == 2) {
//                        break;
//                    } else {
//                        System.out.println("Invalid choice! Bye");
//                    }
//                }
//            }
//        }
//    }

private void hit(Player playerToHit) {
    if (!this.cards.isEmpty()) {
        Card card = cards.removeLast();
        playerToHit.addCards(card);
    }
    if (this.cards.size() >= 2) {
//            printTable();
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
}
//    private void dealerTurn(Player currPlayer) {
//        if (currPlayer.cards.size() == 2) {
//            System.out
//                    .println(currPlayer.getType() + ": " + currPlayer.getCards() + "(" + currPlayer.checkTotal() + ")");
//        }
//        while (currPlayer.checkTotal() <= 16) {
//            hit(currPlayer);
//        }
//    }
//
//    private void printTable() {
//        clearScreen();
//        for (Player player : players) {
//            ShowCards(player);
//        }
//    }
//
//    private void clearScreen() {
//        System.out.println("----------------------------");
//    }
//
//    /**
//     * Calculates wether the game ending scenario was reached
//     *
//     * @param creditsPlayed number of credits played by the player
//     * @return game scenario message
//     */
//    private String playerWin(int creditsPlayed) {
//        if (players.getFirst().checkTotal() > 21) {
//            return "Bust !!!";
//        }
//
//        if (players.getFirst().checkoTtal() == 21) {
//
//            players.getFirst().setCredits(creditsPlayed * 3);
//            return "BlackJack. You Won !!!";
//
//
//        } else if (players.getLast().checkTotal() == 21) {
//            return "Dealer has BlackJack. You lost !!!";
//        }
//
//        if (players.getLast().checkTotal() < players.getFirst().checkTotal() || players.getLast().checkTotal() > 21) {
//            players.getFirst().setCredits(creditsPlayed * 2);
//            return "You won !!!";
//        }
//
//        if (players.getLast().checkTotal() > players.getFirst().checkTotal()) {
//            return "You lost !!!";
//        }
//
//        players.getFirst().setCredits(creditsPlayed);
//        return "It's a draw !!!";
//    }
//}

