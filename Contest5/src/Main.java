public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player();
        Player player1 = new Player();
        Player player2 = new Player();

        deck.checkCards();
        deck.shuffleDeck();
        player.getCards();

    }
}