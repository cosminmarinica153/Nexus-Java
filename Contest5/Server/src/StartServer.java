import java.io.IOException;

public class StartServer {
    public static void main(String[] args) throws IOException{
        new Server().start();

        // Player[] players = new Player[5];
        // players[0] = new Player("Player 1" , new ArrayList<>(),100);
        // for(Player player : players){
        //     System.out.println(player.toString());
        // }
        // ArrayList<Card> card = new ArrayList<>();
        // card.add(new Card(4,"🖤"));

        // Player player = new Player("Player 1", card);
        // ObjectMapper obj = new ObjectMapper();

        // String playersString = obj.writeValueAsString(player);

        // System.out.println(playersString);

        // Player player2 = obj.readValue(playersString, Player.class);

        // System.out.println(player2.getType());

    }
}
