import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ServerHost  {
    private ServerSocket serverSocket;
    private int PORT=2222;
    private ArrayList<Player>players = new ArrayList<>();
    private Deck deck =new Deck();
    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        while(true) {
            Socket clientSocket = serverSocket.accept();
            new ServerClient(clientSocket).start();
            System.out.println("new client connected");
        }

    }

    private class ServerClient extends Thread {
        private Player player;
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;
        public Main main = new Main( 1000);
        private ObjectInputStream ois;


        public ServerClient(Socket clientSocket) {
            this.clientSocket = clientSocket;


        }
//        Deck deck =new Deck();




        public void run() {
            try{
                ois = new ObjectInputStream(clientSocket.getInputStream());
                out = new PrintWriter(clientSocket.getOutputStream(),true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                player= (Player) ois.readObject();
                players.add(player);
                System.out.println(players);
                String input;

                while((input = in.readLine()) != null) {
                    switch(input) {
                        case "Start":
                            deck.deckSize();

                            break;
                        case "Hit" :

                            System.out.println(deck.deckSize());
                            System.out.println("player req a hit");
                            System.out.println(deck.toString());
                            out.println(deck.toString());
                            out.println("Hit");
                            break;
                        case "Stand":
                            System.out.println("player stand");
                            break;


                    }
                }
                in.close();
                out.close();
                clientSocket.close();
                players.remove(player);
            }

            catch(Exception e) {
                e.printStackTrace();
                players.remove(player);
            }
        }
    }



    public static void main(String[] args) throws IOException {
        ServerHost server = new ServerHost();
        server.start();

    }

}