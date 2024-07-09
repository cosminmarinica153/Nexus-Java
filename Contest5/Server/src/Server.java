import java.io.*;
import java.net.*;

public class Server {
    private final int PORT = 2222;
    private ServerSocket serverSocket;

    public static class ClientHandler {
        private final Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void getMessage() {


        }

        public void sendMessage(String message) {


        }

        public void broadcastMessage(String message) {


        }
    }

    public static class SessionHandler extends Thread {
        //we have to host the game
        //the session is the BlackJack table
        private ClientHandler[] players;
        private BlackJack game;

        public SessionHandler() {
            this.players = new ClientHandler[4];
        }

        public void addPlayer(ClientHandler player) {
            for (int i=0;i<this.players.length;i=i+1){
                if (this.players[i] == null){
                    this.players[i]=player;
                    return;
                }
            }
            System.out.println("Table full");
        }

        public void removePlayer(ClientHandler player) {
            for (int i=0;i<this.players.length;i=i+1){
                if (this.players[i] == player){
                    this.players[i] = null;
                    return;
                }
            }
            System.out.println("Player isn't at the table");
        }

        public void startGame() {
//      BlackJack blackjack = new BlackJack();

        }

        public void endGame() {


        }

        public void run(){

        }
    }



}

