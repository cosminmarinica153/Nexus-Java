import java.io.IOException;
import java.util.Scanner;

public class StartClient2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String ip = "192.168.1.130";
        int port = 2222;
        Client client = new Client(ip, port);
        while (true) {
            client.sendMsg(scanner.nextLine());
        }
    }
}
