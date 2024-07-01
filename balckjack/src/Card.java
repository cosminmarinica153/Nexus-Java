public class Card{
    private int value;
    private String suits;
    private String rank;

    public Card(int value, String suits, String rank){
        this.value = value;
        this.suits = suits;
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return  rank + " of " + suits;
    }
}