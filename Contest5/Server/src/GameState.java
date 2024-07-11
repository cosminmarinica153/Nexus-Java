import java.util.ArrayList;

public class GameState {
    private Player[] players = new Player[5];

    public GameState(Player[] players){
        for(Player player : players){
            this.players = player;
        }
    }
}
