import java.net.*;
import java.io.*;
 
public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
 
    public Client(String address, int port) throws Exception {
        socket = new Socket(address, port);
        System.out.println("Connected");
        input = new DataInputStream(System.in);
        out = new DataOutputStream(socket.getOutputStream());
        String line = "";
        while (!line.equals("Over")) {
            line = input.readLine();
            out.writeUTF(line);
        }
        input.close();
        out.close();
        socket.close();
 
    }
 
    public static void main(String args[]) throws Exception {
        Client client = new Client("127.0.0.1", 5000);
    }
}
