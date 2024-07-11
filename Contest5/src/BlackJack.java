
import utils.Card;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    // Players (4)
    private final Server.SessionHandler session;
    private final Player[] players = new Player[5];

    private Scanner scanner = new Scanner(System.in);

    // Cards
    private Deck deck;
    private ArrayList<Card> cards;

    public BlackJack(Player[] players, Server.SessionHandler session) {
        // Initialize the cards
        this.session = session;
        cards = new ArrayList<>();
        for(int i = 0 ;i < 4; i++){
            deck = new Deck(2, 14);
            cards.addAll(deck.getDeck());
        }

        // Initialize the Players
        for (int i = 0; i < players.length; i = i + 1) {
            this.players[i] = players[i];
        }
        this.players[4] = new Player("Dealer", new ArrayList<Card>());

        play();
    }
    public void initRound(){
        for(int i = 0; i < players.length-1;i++){
            if(players[i] == null){
                continue;
            }
            players[i].setCards(new ArrayList<>());
            players[i].setBet(0);
        }
        players[players.length-1].setCards(new ArrayList<>());

        if (cards.size() < 20) {
            for(int i = 4 ;i < 4; i++){
                deck = new Deck(2, 14);
                cards.addAll(deck.getDeck());
            }
        }
        

    }

    public void play() {
        while (true) {
            initRound();

            startBet();

            for(int j = 0; j<2;j++){
                for (int i = players.length - 1; i >= 0; i--) {
                    if (players[i].getBet() == 0 || players[i] == null) {
                        continue;
                    }
                    hit(players[i]);
                }
            }

            for(int i = 0; i < players.length-1; i++){
                if (players[i].getBet() == 0|| players[i] == null) {
                    continue;
                }
                playRound(players[i]);
            }
            dealerTurn(players[players.length-1]);

            for(int i = 0; i<players.length-1;i++){
                if (players[i].getBet() == 0|| players[i] == null) {
                    continue;
                }
                playerWin(players[i]);
            }

            for(int i = 0; i<players.length-1;i++){
                if (players[i].getBet() == 0|| players[i] == null) {
                    continue;
                }
                playAgain(players[i]);
            }


        }

    }

    public void playRound(Player player){
        int index = Integer.parseInt(player.getType().split(" ")[1])-1;
            while (true) {
                if (player.checkTotal() > 21) {
                session.dispatch(new Dispatcher("You busted! Out", session.getDestiantion(index)));
                    break;
                } else if (player.checkTotal() == 21) {
                session.dispatch(new Dispatcher("Ai BlackJack", session.getDestiantion(index)));
                    break;
                }
                session.dispatch(new Dispatcher("Make your choice: ", session.getDestiantion(index)));
                session.dispatch(new Dispatcher("(1) Hit", session.getDestiantion(index)));
                session.dispatch(new Dispatcher("(2) Stand", session.getDestiantion(index)));
                int choice = scanner.nextInt(); 

                if (choice == 1) {
                    hit(player);
                } else if (choice == 2) {
                    break;
                } else {
                session.dispatch(new Dispatcher("Invalid choice! Bye", session.getDestiantion(index)));
                }
            }
    }
    

    public void startBet() {
        for (int i = 0; i < players.length - 1; i = i + 1) {
            if (this.players[i] == null) {
                continue;
            }
            if (this.players[i].getCredits() < 10) {
                players[i].setBet(0);
                session.dispatch(new Dispatcher("You don't have enough credits", session.getDestiantion(i)));
                continue;
            }
            session.dispatch(new Dispatcher("You have " + players[i].getCredits() + " credits", session.getDestiantion(i)));
            session.dispatch(new Dispatcher("How many credits do you want to bet? Min bet is 10", session.getDestiantion(i)));
            session.dispatch(new Dispatcher("Bet 0 if you don't want to join", session.getDestiantion(i)));
            int creditsPlayed = scanner.nextInt();

            while (creditsPlayed < 10 && creditsPlayed != 0) {
            session.dispatch(new Dispatcher("Bet is insuficient", session.getDestiantion(i)));
                creditsPlayed = scanner.nextInt();
            }
            players[i].setBet(creditsPlayed);
            players[i].setCredits(-creditsPlayed);
        }
        
    }
    
    private void dealerTurn(Player currPlayer) {
        if (currPlayer.getCards().size() == 2) {
            session.broadcast(new Dispatcher(currPlayer.getType() + ": " + currPlayer.getCards() + "(" + currPlayer.checkTotal() + ")"));

        }
        while (currPlayer.checkTotal() <= 16) {
            hit(currPlayer);
        }
    }
    private void hit(Player playerToHit) {
        if (!this.cards.isEmpty()) {
            Card card = cards.removeLast();
            playerToHit.addCards(card);
        }
        if (this.cards.size() >= 2) {
            
            for (Player player : players) {
                showCards(player);
            }
        }
    }
    
    private void showCards(Player playerToHit) { //trb broadcast
        if (playerToHit.getType().equals("Dealer") && playerToHit.getCards().size() == 2) {
            System.out.println(playerToHit.getType() + ": [" + playerToHit.getCards().get(0) + " ?" + "]("
            + playerToHit.getCards().get(0).getValue() + ")");
        } else {
            System.out.println(
                playerToHit.getType() + ": " + playerToHit.getCards() + "(" + playerToHit.checkTotal() + ")");
            }
        }

    private void playerWin(Player player) {
        int index = Integer.parseInt(player.getType().split(" ")[1])-1;

        if (player.checkTotal() > 21) {
            session.dispatch(new Dispatcher("Bust !!!", session.getDestiantion(index)));
            return;
        }
        
        if (player.checkTotal() == 21) {
            player.setCredits(player.getBet() * 3);
            session.dispatch(new Dispatcher("BlackJack. You Won !!!", session.getDestiantion(index)));
            return;
        
        } else if (players[players.length-1].checkTotal() == 21) {
            session.dispatch(new Dispatcher("Dealer has BlackJack. You lost !!!", session.getDestiantion(index)));
            return;
        }
        
        if (players[players.length-1].checkTotal() < player.checkTotal() ||
            players[players.length-1].checkTotal() > 21) {
            player.setCredits(player.getBet() * 2);
            session.dispatch(new Dispatcher("You won !!!", session.getDestiantion(index)));
            return;
        }
        
        if (players[players.length-1].checkTotal() > player.checkTotal()) {
            session.dispatch(new Dispatcher("You lost !!!", session.getDestiantion(index)));
            return;
        }
        
        player.setCredits(player.getBet());
        session.dispatch(new Dispatcher("It's a draw !!!", session.getDestiantion(index)));
    }
    
    private void playAgain(Player player){

    }

}
    

