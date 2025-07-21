package chapter17;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 멀티 채팅 서버 구현
 */
public class Server {
	
	public final static int PORT = 9000;

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("서버 실행 중 : " + PORT);
			System.out.println("클라이언트 접속 대기 중~");
			
			while(true) {
				Socket s = server.accept();		//클라이언트 접속 대기 중
				System.out.println("클라이언트 접속!!");
				
				//클라이언트 별로 접속하고 별도 종료 진행
				new ClientHandler(s).start();;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}//main

}//Server

class ClientHandler extends Thread {
	Socket s;
	OutputStream output;
	InputStream input;
	
	public ClientHandler(Socket s) {
		try {
			this.s = s;
			this.output = s.getOutputStream();
			this.input = s.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			String str = "안녕하세요~";
			output.write(str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
