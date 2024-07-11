import java.io.IOException;
import java.util.ArrayList;

public class StartServer {
    public static void main(String[] args) throws IOException{
        // new Server().start();

        Player[] players = new Player[5];
        players[0] = new Player("Player 1" , new ArrayList<>(),100);
        for(Player player : players){
            System.out.println(player.toString());
        }


    }
}
