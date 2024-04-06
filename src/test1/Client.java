package test1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		try {
			Socket socket = new Socket("localhost", 5500);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			// String time = dis.readUTF();
			// System.out.println(time);
			//Scanner scanner = new Scanner(System.in);
			Scanner scanner = new Scanner(new File("D:/tai xuong/input.txt"));
			// String inputString = scanner.nextLine();
			//StringBuilder sb = new StringBuilder();
			// System.out.println("Nhap so nut: ");
			int so_nut = 6;// scanner.nextInt();
			int so_duong = so_nut + 1;
			String text = scanner.nextLine();

//            for (int i = 0; i < so_duong; i++) {
//                System.out.println("Nhap ten 2 nut va khoang cach giua chung: ");
//                String temp = scanner.nextLine();
//                sb.append(" "+temp);
//            }
//            System.out.println(sb);
//            dos.writeUTF(sb.toString());
			dos.writeUTF(text);
			socket.close();
		} catch (UnknownHostException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
