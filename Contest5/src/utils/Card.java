package utils;

public class Card {
    private int value; // 2 - 14
    private String suit; // Trefla, Inima etc

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public Card(String suit) {
        this.suit = suit;
    }

    public Card(int value) {
        this.value = value;
    }

    public int getValue() { return this.value; }

    public String getSuit() { return this.suit; }

    public String toString() { return this.value + " " + this.suit; }
}
