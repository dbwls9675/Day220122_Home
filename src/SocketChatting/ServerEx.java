package SocketChatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// ������ �̿��� ����/Ŭ���̾�Ʈ ä�� ����
public class ServerEx {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner scan = new Scanner(System.in);

		try {
			listener = new ServerSocket(9999);
			System.out.println("������ ��޸��� �ֽ��ϴ�.");
			socket = listener.accept();
			System.out.println("������ �޾ҽ��ϴ�.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while (true) {
				String inputMessage = in.readLine();
				if (inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("Ŭ���̾�Ʈ���� bye�� ������ �������ϴ�.");
					break;
				}
				System.out.println("Ŭ���̾�Ʈ : " + inputMessage);
				System.out.print("������>> ");
				String outputMessage = scan.next();
				out.write(outputMessage + "\n");
				out.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scan.close();
				socket.close();
				listener.close();
			} catch (Exception e) {
				System.out.println("Ŭ���̾�Ʈ�� ä�� �� ���� �߻�");
			}
		}
	}

}
