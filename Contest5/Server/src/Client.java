import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public Client(String ip,int port) throws IOException{
        socket = new Socket(ip,port);
        out = new PrintWriter(socket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        new Thread(()->{
            try{
                while (true) {
                    System.out.println(in.readLine()); //TEMP
                }
            }catch(IOException e){
                System.out.println("N a mers");
            }
                
            
        }).start();
    }

    public void sendMsg(String msg){
        out.println(msg);
    }
    
}
