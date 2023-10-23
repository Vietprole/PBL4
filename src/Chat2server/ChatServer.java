package Chat2server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(7000);
		System.out.print("server is started");
		Socket socket= server.accept();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		
		Scanner kb = new Scanner(System.in);
		while(true) {
			String st = din.readUTF();
			System.out.println(st);
			System.out.println("server: ");
			String msg= kb.nextLine();
			dos.writeUTF("server: "+msg);
			dos.flush();
			kb=kb.reset();
			
		}
	}

}
