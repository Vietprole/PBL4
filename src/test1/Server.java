package test1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.Date;

public class Server {
    public static void main(String[] args) throws Exception{
        try (ServerSocket server = new ServerSocket(5500)) {
            System.out.println("Server is started");
            //while(true){
                Socket socket = server.accept();
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String input = dis.readUTF();
                dos.writeUTF("Server da nhan duoc");
                System.out.println(input);
                //String time = new Date().toString();
                //dos.writeUTF("Server tra lai ngay gio"+time);
                socket.close();
            //}
        }
    }
}
