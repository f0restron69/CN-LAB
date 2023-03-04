import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
 
public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(1234);
        System.out.println("Server online!");
        byte[] receive = new byte[65535];
        DatagramPacket DpReceive = null;
        String line = "";
        while (true) {
            DpReceive = new DatagramPacket(receive, receive.length);
            ds.receive(DpReceive);
            line = new String(receive);
            line=line.trim();
            System.out.println("Client:-" + line);
            if (line.equals("bye")) {
                System.out.println("Client sent bye.....EXITING");
                break;
            }
            receive = new byte[65535];
        }
    }
}
