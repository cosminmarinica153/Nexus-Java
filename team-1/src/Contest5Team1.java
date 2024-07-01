//initializam deck-ul de 52 carti
// dam shuffle

// player seteaza miza
//playerul primeste 2 carti cunoscute
// dealerul tot 2 dar numai una e vizibila
//daca suma cartilor jucatorului este sub 21, are optiunea sa dea hit sau stand
//daca jucatorul are suma cartilor 21, castiga automat
//daca jucatorul are in primele 2 carti, aceeasi carte, poate sa ceara split
//daca jucatorul are suma primelor 2 carti 9, 10, 11 fara AS poate cere double down si
////primeste o singura carte de la dealer

import java.util.*;
public class Contest5Team1 {
    public static void main(String[] args) {
        Blackjack blackjackGame = new Blackjack();
        Card carteaMea = new Card(5, "trefla");
        System.out.println("cartea mea este " + carteaMea);
    }
}
class Blackjack {

}
class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }
    public int getValue() {
        if (this.value > 11) return 10;
        return this.value;
    }
    public String toString(){
        return "-" + this.suit + "-" + this.value;
    }

}
class CardGame{
    protected List<Card> deck;
    protected void initializeDeck() {
        // initializare/pregatire date
        String[] suits = {"🔷", "♥️", "♣️", "🖤"};
        // actiuni
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                System.out.println("cartea " + suit + i);
                deck.add(new Card(i, suit));
            }
        }
    }
}
class Player {
    protected String name;
    protected List<Card> hand;
    protected int credits;

    public Player(String name, int credits){
        this.name = name;
        this.hand = new ArrayList<>();
        this.credits = credits;
    }
}

