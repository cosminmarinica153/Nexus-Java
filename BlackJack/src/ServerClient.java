import java.net.*;
import java.io.*;


public class ServerClient  {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private Thread receiverThread;
    private ObjectOutputStream oos;

    public void startConection(String host, int port) throws IOException {
        clientSocket =new Socket("localhost",port);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(),true);
        oos = new ObjectOutputStream(clientSocket.getOutputStream());
        receiverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    String response;
                    while((response = in.readLine())!=null){
                        System.out.println(response);
                        if(response.equals("exit")){
                            clientSocket.close();
                        }
                        if(response.equals("Hit")){
                            System.out.println("suntem aici");
                        }
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        receiverThread.start();
    }

    public void sendMessage(String msg){
        out.println(msg);
        out.flush();

    }

    public void sendObject(Player player){
        try {
            oos.writeObject(player);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}
