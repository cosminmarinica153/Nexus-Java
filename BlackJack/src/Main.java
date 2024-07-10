import java.util.Scanner;

public class Main {
    //Variabilele de care avem nevoie
    public Deck deck;
    public Player player1;
    private Player player2;
    private int player1Score;
    private int player2Score;
    private Deposit sold;
    private int bet_entry;
    private boolean showDealerFirstCard;


    public Main(int initialDeposit) {
        //Valori variabile
        player1 = new Player("Player 1", false);
        player2 = new Player("Player 2 (AI)", true);
        player1Score = 0;
        player2Score = 0;
        sold = new Deposit(initialDeposit);
        showDealerFirstCard = false;
    }

    private void resetGame() {
        //resetare joc
        deck = new Deck();
        player1.getHand().clear();
        player2.getHand().clear();
        showDealerFirstCard = false;
    }

    private void chooseBet() {
        //Alege miza si vezi daca ai destul in depozit
        Scanner scanner = new Scanner(System.in);
        boolean validBet = false;
        while (!validBet) {
            System.out.print("Choose a bet (5, 10, 25, 50 $): ");
            bet_entry = scanner.nextInt();
            if (bet_entry == 5 || bet_entry == 10 || bet_entry == 25 || bet_entry == 50) {
                if (sold.getBalance() >= bet_entry) {
                    validBet = true;
                } else {
                    System.out.println("You don't have enough funds to place this bet.");
                }
            } else {
                System.out.println("Invalid bet. Choose again.");
            }
        }
        sold.withdrawFunds(bet_entry);

        System.out.println("Deposit after bet: " + sold.getBalance() + " $");
    }

    private void playRound() {
        Scanner scanner = new Scanner(System.in);
        resetGame();

        if (sold.getBalance() < 5) {
            System.out.println("You don't have enough funds in your deposit to play.");
            return;
        }

        chooseBet();

        // Distribuirea inițială a cărților
        player1.addCardToHand(deck.drawCard());
        player2.addCardToHand(deck.drawCard());
        player1.addCardToHand(deck.drawCard());
        player2.addCardToHand(deck.drawCard());


        System.out.println(player1);
        System.out.println(player2.toString(showDealerFirstCard));

        if(player1.getHandValue() == 21){

            System.out.println(player2.getName() + " busted. " + player1.getName() + " wins!");
            player1Score++;
            sold.addFunds(bet_entry * 2 + bet_entry/2);
            System.out.println(player1.getName() + ": " + player1Score);
            System.out.println(player2.getName() + ": " + player2Score);
            System.out.println("Current deposit: " + sold.getBalance() + " $");
        }else{
            boolean doubled = DoubleIt.doubleBet(scanner , sold, bet_entry);
            if (doubled) {
                bet_entry *= 2;
                player1.addCardToHand(deck.drawCard());
                System.out.println(player1);

            }else{
                while (player1.getHandValue() < 21) {
                    System.out.print(player1.getName() + ", do you want to hit or stand? ");
                    String action = scanner.nextLine();

                    if (action.equalsIgnoreCase("hit")) {

                        player1.addCardToHand(deck.drawCard());
                        System.out.println(player1);
                    } else {
                        break;
                    }

                }
            }



            //Tura jucătorului 2 (AI)
            while (player2.getHandValue() < 21) {
                String action = player2.decideAction();
                System.out.println(player2.getName() + " decides to " + action + ".");
                if (action.equalsIgnoreCase("hit")) {
                    player2.addCardToHand(deck.drawCard());
                    System.out.println(player2.toString(showDealerFirstCard));
                } else {
                    break;
                }
            }

            //dealer hand
            showDealerFirstCard = true;
            System.out.println("\nDealer's hand:");
            System.out.println(player2);

            //Determinarea câștigătorului
            int player1Value = player1.getHandValue();
            int player2Value = player2.getHandValue();

            System.out.println("\nFinal hands:");
            System.out.println(player1);
            System.out.println(player2.toString(showDealerFirstCard));



            if (player1Value > 21 && player2Value > 21) {
                System.out.println("Both players busted. It's a draw!");
                sold.addFunds(bet_entry);
            } else if (player1Value > 21) {
                System.out.println(player1.getName() + " busted. " + player2.getName() + " wins!");
                player2Score++;
            } else if (player2Value > 21) {
                System.out.println(player2.getName() + " busted. " + player1.getName() + " wins!");
                player1Score++;
                sold.addFunds(bet_entry * 2);
            } else if (player1Value > player2Value) {
                System.out.println(player1.getName() + " wins!");
                player1Score++;
                sold.addFunds(bet_entry * 2);
            } else if (player2Value > player1Value) {
                System.out.println(player2.getName() + " wins!");
                player2Score++;
            } else {
                System.out.println("It's a draw!");
                sold.addFunds(bet_entry);
            }

            System.out.println("\nScores:");
            System.out.println(player1.getName() + ": " + player1Score);
            System.out.println(player2.getName() + ": " + player2Score);
            System.out.println("Current deposit: " + sold.getBalance() + " $");

            showDealerFirstCard = false;
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean continuePlaying = true;

        while (continuePlaying) {
            playRound();

            if (sold.getBalance() < 5) {
                System.out.println("You don't have enough funds in your deposit to continue playing.");
                break;
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                continuePlaying = false;
            }
        }

        System.out.println("Final scores: ");
        System.out.println(player1.getName() + ": " + player1Score);
        System.out.println(player2.getName() + ": " + player2Score);
        System.out.println("Final deposit: " + sold.getBalance() + " $");
    }

//    public static void main(String[] args) {
//
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the initial amount of money in the deposit: ");
//        int initialDeposit = scanner.nextInt();
//        Main game = new Main(initialDeposit);
//        game.play();
//
//
//    }
}