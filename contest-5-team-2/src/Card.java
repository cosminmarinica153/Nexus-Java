
public class Card {
    
        
        private int value;
        private String rank;
                //{'2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9, '10': 10, 'J': 10, 'Q': 10, 'K': 10, 'A': 11}
        private String suit;    // "trefla","inima neagra",...
    
        public Card(int value, String rank, String suit){
            this.value = value;
            this.rank = rank;
            this.suit = suit;
        }
    
        public int getValue(){
            return this.value;
        }

        public String getRank(){
            return this.rank;
        }
    
        public String toString(){
            return "<<" + this.value + " " + this.suit + ">>";
        }
}

