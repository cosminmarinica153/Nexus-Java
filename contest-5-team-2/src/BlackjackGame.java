import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BlackjackGame {
    private List<Card> combinedDeck;
    private List<Player> players;
    private Player currentPlayer;

    public BlackjackGame() {
        this.combinedDeck = new ArrayList<>();
        initializeDecks();
        initializePlayers();
        shuffleCombinedDeck();
        dealFirst2Cards();
        playGame();

    }

    private void initializePlayers() {
        players = new ArrayList<>();
        Player human = new Player("Human", new ArrayList<>());
        Player aIPlayer1 = new Player("AIPlayer1", new ArrayList<>());
        Player aIPlayer2 = new Player("AIPlayer2", new ArrayList<>());
        Player dealer = new Player("Dealer", new ArrayList<>());
        players.add(human);
        players.add(aIPlayer1);
        players.add(aIPlayer2);
        players.add(dealer);
    }

    private void initializeDecks() {
        for (int i = 0; i < 4; i++) {
            Deck deck = new Deck();
            combinedDeck.addAll(deck.getDeck());
        }
        System.out.println("Decks initialized with total cards: " + combinedDeck.size());
    }

    private void shuffleCombinedDeck() {
        Collections.shuffle(combinedDeck);
        System.out.println("Deck shuffled.");
    }

    public Card drawCard() {
        return combinedDeck.remove(combinedDeck.size() - 1);
    }

    public void showCombinedDeck() {
        for (Card card : combinedDeck) {
            System.out.println("Card: " + card);
        }
        System.out.println("Size of Combined Deck: " + combinedDeck.size());
    }

    private void hit(Player playerToHit) {
        if (!combinedDeck.isEmpty()) {
            Card card = combinedDeck.remove(combinedDeck.size() - 1);
            playerToHit.addCard(card);
        }
        if(playerToHit.getHand().size() > 2)
            System.out.println(playerToHit.getType() + " now has: " + playerToHit.getHand() + "( " + playerToHit.checkTotal() + ")");
    }

    private void stand(Player playerToStand) {
        this.players.remove(playerToStand);
    }

    public void dealFirst2Cards() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                hit(player);
            }
        }
        for (Player player : players) {
            System.out.println(player.getType() + " got the following cards" + player.getCards() + "( " + player.checkTotal() + ")");
        }

    }

    private void playGame()
    {
        while(!this.players.isEmpty()) {
            nextPlayer();
        }
    }

    private void nextPlayer(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> activePlayers = new ArrayList<>(players);
        this.currentPlayer = activePlayers.getFirst();
        activePlayers.remove(activePlayers.getFirst());
        if(this.currentPlayer.getType().equals("Human"))
        {
            System.out.println("Now you have a choice: ");
            System.out.println("(1) Hit");
            System.out.println("(2) Stand");
            int choice = scanner.nextInt();
            if(choice == 1)
                hit(this.currentPlayer);
            else if(choice == 2)
                stand(this.currentPlayer);
            else
                System.out.println("Invalid choice");
        } else {
            if(this.currentPlayer.checkTotal() < 17)
                hit(this.currentPlayer);
            else
                stand(this.currentPlayer);
        }

    }
}


//
/*
 * Ne trebuie 4 deck-uri de carti cu 52 de carti
 * Se impart cate 2 carti la fiecare jucator si la dealer
 * Cartile jucatorilor se pot vedea amandoua, pe cand una din cartile dealerului trebuie sa fie ascunsa
 * Fiecare jucator isi verifica cartile si decide daca sa mai ceara una sau nu
 * Valorile cartilor sunt de la 1 la 11, 1-9 valori normale, J, Q, K = 10, A = 11/1
 * Daca un jucator mai cere carti iar suma cartilor trece de 21, jucatorul pierde
 * Daca toti jucatorii nu mai cer carti, dealer-ul arata cartea ascunsa si se verifica suma cartilor lui
 * Daca suma cartilor DEALER-ULUI este mai mica decat 17, dealer-ul mai ceara carti
 * Daca suma cartilor DEALER-ULUI este 21, dealer-ul are un blackjack
 * Daca suma cartilor DEALER-ULUI este mai mare decat 21, dealer-ul pierde
 * Se compara suma cartilor jucatorilor cu suma cartilor dealerului
 * Daca Dealer-ul are blackjack (suma cartilor 21) iar jucatorii au suma cartilor < 21, jucatorii pierd
 * Daca Dealer-ul are blackjack (suma cartilor 21) iar jucatorii/unul din jucator are si el blackjack,
 * jucatorul isi ia banii inapoi
 * Daca Dealer-ul NU are blackjack si jucatorii au suma cartilor mai mare decat a dealer-ului dar sub 21,
 * jucatorii/jucatorul castiga
 *
 *
 *
 */

//TODO: Player
//TODO: Deck
//TODO: Card