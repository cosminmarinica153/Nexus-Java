import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    private final int PORT = 2222;
    private ServerSocket serverSocket;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();


    public void start() throws IOException{
        serverSocket = new ServerSocket(PORT);
        System.out.println("The server started listening to port: " + PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from: " + socket.getInetAddress());
            clients.add(new ClientHandler(socket)); 
            
        }
    }
    
    public static class ClientHandler {
        private final Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) throws IOException {
            this.clientSocket = socket;
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            new Thread(()->{
                try{
                    while (true) {

                    }
                }catch(IOException e){
                    System.out.println("N a mers");
                }
                    
                
            }).start();
            
        }

        public String getMessage() throws IOException {
            
            return in.readLine();

        }

        public void sendMessage(Dispatcher disp) {
            out.println(disp);

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
            Player[] players = new Player[4]; 

            for(int i = 0; i < this.players.length;i++){
                if(this.players[i] != null){
                    players[i] = new Player("Player " + (i+1), new ArrayList<>(),100);
                }
            }

            BlackJack blackjack = new BlackJack(players,this);


        }

        public void endGame() {


        }
        public void broadcast(Dispatcher dips) {
            for(ClientHandler player : players){
                if (player == null) {
                    continue;
                }
                player.sendMessage(dips);
            }

        }

        public void dispatch(Dispatcher disp){
            disp.getDestiantion().sendMessage(disp);
        }

        public ClientHandler getDestiantion(int index){
            return this.players[index];
        }
        

        public void run(){

        }
        
    }



}

