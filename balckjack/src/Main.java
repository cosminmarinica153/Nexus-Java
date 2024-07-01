import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Deck deck = new Deck();
//        deck.initializeDeck();
    }
}

//Scopul în Blackjack este să ai o mână de cărți cu o valoare totală cât mai aproape de 21,
// fără a depăși această valoare, și să ai o valoare mai mare  decât dealerul.


//Valoarea Cărților
//Cărțile numerotate (2-10): Valoarea lor este egală cu numărul de pe carte.
//Cărțile de față (J, Q, K): Fiecare are valoarea 10.
//As: Poate valora fie 1, fie 11, în funcție de ce este mai avantajos pentru mână.

//Desfășurarea Jocului
//Pariul: Fiecare jucător plasează un pariu înainte de începerea mâinii.
//Împărțirea cărților: Dealerul împarte două cărți fiecărui jucător și două pentru sine.
// Una dintre cărțile dealerului este așezată cu fața în sus (cartea vizibilă), iar cealaltă cu fața în jos (cartea ascunsă).
//Deciziile jucătorului:
//Hit: Jucătorul solicită o altă carte.
//Stand: Jucătorul alege să nu mai ia cărți suplimentare.
//Double Down: Jucătorul își dublează pariul inițial și primește doar o singură carte suplimentară.
//Split: Dacă jucătorul are două cărți de aceeași valoare,
// poate să împartă mâna în două mâini separate și să plasezeun pariu suplimentar egal cu cel inițial.
//Surrender: Jucătorul poate renunța la mâna sa și pierde jumătate din pariu
// (aceasta nu este permisă în toate cazinourile).
//Regulile dealerului: Dealerul trebuie să tragă cărți până când ajunge la un total de 17
// sau mai mult. Dacă dealerul are un total de 17, acesta trebuie să stea (aceasta poate varia dacă dealerul are un soft 17 - un 17 care include un as).

class Card{
    private int value;
    private String suits;

    public Card(int value, String suits){
        this.value = value;
        this.suits = suits;
    }

    public int getValue(){
        return value;
    }
}

class Deck{
    protected List<Card> deck;

    protected void initializeDeck(){
        String[] suits = {"🔷", "♥️", "♣️", "🖤"};
        for(String suit : suits){
            for(int i = 2; i <= 14; i++){
                //System.out.println("cartea " + i + " suit " + suit);
                deck.add(new Card(i, suit));
            }
        }
    }
    protected void shuffleDeck(){
        Collections.shuffle(deck);
    }
}

class Player {
    private String name;
    private List<Card> hand;
    private int suma;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addCardsToHand(Card card){
        this.hand.add(card);
    }

    public int suma(){
        suma = this.hand.stream().mapToInt(Card::getValue).sum();
        return 0;
    }

}

class BlackJack extends Deck{
    private Player humanPLayer;
    private Player dealPlayer;

    private BlackJack(){
        this.deck = new ArrayList<>();
        humanPLayer = new Player("Tomi");
        dealPlayer = new Player("Robo");

        initializeDeck();
        shuffleDeck();
    }

    private void dealCards(){
        humanPLayer.addCardsToHand(deck.get(0));
        humanPLayer.addCardsToHand(deck.get(1));
        dealPlayer.addCardsToHand(deck.get(2));
        dealPlayer.addCardsToHand(deck.get(3));
        int suma = humanPLayer.suma();
        dealPlayer.suma();
        System.out.println("Dealing Cards: " + suma  );
    }
    public void play(){

    }

}
