import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ServerHost  {
    private ServerSocket serverSocket;
    private int PORT=2222;
    private ArrayList<Player>players = new ArrayList<>();
    private Deck deck =new Deck();
    private Player dealer= new Player("dealer",true);
    private static HashMap <String, ClientHandler> clientHandlerHashMap =new HashMap<>();
    private boolean showDealerFirstCard;
    private boolean getStart = true;
    private int currentPlayer = 0;




    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);

        while(true) {
            Socket clientSocket = serverSocket.accept();
            new ClientHandler(clientSocket).start();
            System.out.println("new client connected");
        }

    }
    private void broadcast(String message) {
        for (ClientHandler handler : clientHandlerHashMap.values()) {
            handler.sendMessage(message);
        }
    }

    private void dealFirstCards(){
        for(int i =0; i<players.size(); i++){
            players.get(i).addCardToHand(deck.drawCard());
            players.get(i).addCardToHand(deck.drawCard());
            broadcast(players.get(i).getName() + "'s hand: " + players.get(i).getHand());
        }
        dealer.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());
        broadcast("Dealer's hand: " + dealer.toString(showDealerFirstCard));

    }

    private void checkWinner(Player player) {
        if (player.getHandValue() == 21) {
            System.out.println(player.getName() + " Blackjack....You win");
        } else if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() <= 21) {
            System.out.println(player.getName() + " win with " + player.getHandValue() + "!");
        } else if (player.getHandValue() > 21) {
            System.out.println(player.getName() + " You lose");
        }
    }

    private void determineWinners() {
        showDealerFirstCard = true;
        broadcast("Dealer's final hand: " + dealer.toString(showDealerFirstCard));
        for (Player player : players) {
            if (player.getHandValue() <= 21 && (player.getHandValue() > dealer.getHandValue() || dealer.getHandValue() > 21)) {
                broadcast(player.getName() + " wins with " + player.getHandValue() + "!");
            } else {
                broadcast(player.getName() + " loses");
            }
        }
        // Reset for next round
        resetGame();
    }

    private void resetGame() {
        deck = new Deck();
        for (Player player : players) {
            player.clearHand();
        }
        dealer.clearHand();
        currentPlayer = 0;
        dealFirstCards();
        showDealerFirstCard = false;
        getStart = true;
        broadcast("New round starting. Get ready!");
    }



    public static void sendMessageToClient(String clientName, String message){
        ClientHandler handler = clientHandlerHashMap.get(clientName);
        if(handler != null)
            handler.sendMessage(message);
    }

    private class ClientHandler extends Thread {
        private Player player;
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;
        public Main main = new Main( 1000);
        private ObjectInputStream ois;

        public void sendMessage(String msg){
            if(out != null);
            out.println(msg);
        }



        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;

        }





        public void run() {
            try{
                ois = new ObjectInputStream(clientSocket.getInputStream());
                out = new PrintWriter(clientSocket.getOutputStream(),true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                player = (Player) ois.readObject();
                players.add(player);
                System.out.println(players);
                String input;
                clientHandlerHashMap.put(player.getName(), this);

                while((input = in.readLine()) != null) {
                    switch(input) {
                        case "Start":
                            System.out.println("Start case");
                            if(getStart){
                                deck.deckSize();
                                int allReady = 0;
                                for(int i =0; i<players.size(); i++){
                                    if (players.get(i).getReady()) {
                                        allReady++;
                                    }
                                }
                                if (allReady == players.size()) {
                                    dealFirstCards();
                                    getStart = false;
                                }
                            }

                            break;

                        case "Ready":
                            player.setReady(true);
                            System.out.println("Ready");
                            System.out.println(player.getName());
                            sendMessageToClient(players.get(0).getName(), "Hello user1");
                            sendMessageToClient(players.get(1).getName(), "Hello user2");
                            sendMessageToClient(player.getName(), "hoadfjawuefd");
                            break;

                        case "Double" :
                            System.out.println("Double it");
                            break;


                        case "Hit":
                            if (players.get(currentPlayer).equals(player) && player.getHandValue() <= 21) {
                                player.addCardToHand(deck.drawCard());
                                String handUpdate = player.getName() + "'s hand: " + player.getHand() + " (" + player.getHandValue() + ")";
                                System.out.println(handUpdate);
                                broadcast(handUpdate);
                                checkWinner(player);
                                if (player.getHandValue() > 21) {
                                    broadcast(player.getName() + " busts!");
                                    currentPlayer = (currentPlayer + 1) % players.size();
                                    if (currentPlayer == 0) {
                                        determineWinners();
                                    } else {
                                        broadcast("It's " + players.get(currentPlayer).getName() + "'s turn.");
                                    }
                                }
                            } else {
                                sendMessage("It's not your turn or you've already busted.");
                            }
                            break;
                        case "Stand":
                            if (players.get(currentPlayer).equals(player) && player.getHandValue() <= 21) {
                                broadcast(player.getName() + " chooses to Stand");
                                currentPlayer = (currentPlayer + 1) % players.size();
                                if (currentPlayer == 0) {
                                    showDealerFirstCard = true;
                                    broadcast("Dealer's hand: " + dealer.toString(showDealerFirstCard));
                                    determineWinners();
                                } else {
                                    broadcast("It's " + players.get(currentPlayer).getName() + "'s turn");
                                }
                            } else {
                                sendMessage("It's not your turn or you've already busted.");
                            }
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