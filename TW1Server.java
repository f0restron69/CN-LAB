import java.net.*;
import java.io.*;
 
public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
 
    public Server(int port) throws Exception {
 
        server = new ServerSocket(port);
        System.out.println("Server started\n Waiting for a client ...");
        socket = server.accept();
        System.out.println("Client accepted");
        in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
        String line = "";
        while (!line.equals("Over")) {
            line = in.readUTF();
            System.out.println(line);
 
        }
        System.out.println("Closing connection");
        socket.close();
        in.close();
 
    }
 
    public static void main(String args[]) throws Exception {
        Server server = new Server(5000);
    }
}

