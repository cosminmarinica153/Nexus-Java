import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Server {
    private final int PORT = 2222;
    private ServerSocket serverSocket;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static HashMap<String, SessionHandler> allSessions = new HashMap<>(); 


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
        private BlockingQueue<String> messageQueue;

        public ClientHandler(Socket socket) throws IOException {
            this.clientSocket = socket;
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            messageQueue = new LinkedBlockingQueue<>();
            new Thread(()->{
                try{
                    String message;
                    while ((message = in.readLine()) != null) {
                        if (message.charAt(0) == '/') {
                            commands(message.split("/")[1]);
                        }
                        messageQueue.put(message);
                    }
                }catch(IOException e){
                    System.out.println("N a mers");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                    
                
            }).start();
            
        }

        public void commands(String command){

        }

        public String getNextMessage() {
            
            try {
                return messageQueue.take();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                return null;
            }

        }

        public void sendMessage(Dispatcher disp) {
            out.println(disp);

        }

        public void createSession(){
            allSessions.put(getNextMessage(), new SessionHandler());
        }
        public void connectSession(){

        }
        public void disconnectSession(){

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

            game = new BlackJack(players,this);


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
        

        public String getInput(int index) {
            return this.players[index].getNextMessage();
        }

        public void isReady(){
            broadcast(new Dispatcher("All players type ready to start the game"));
            int[] count = new int[4];
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                for(int i =0; i < players.length; i++){
                    if(players[i].getNextMessage() == null) continue;
                    if (players[i].getNextMessage().toLowerCase() == "ready") {
                        count[i] = 1;
                    }
                }
                boolean ready = true;
                for(int i = 0; i < count.length ; i++){
                    if (count[i] == 0) {
                        ready = false;
                        break;
                    }
                                // p1 p2 null p4 // p1 null null p4
                }
                if(ready) return;
            }
        }

        public void run(){
            // isReady();

            // startGame();

            // while (true) {
            //     game.play();
                
            // }
            System.out.println("Session is running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        
    }



}

