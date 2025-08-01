package chapter17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 멀티 채팅 서버 구현
 */
public class Server {
	
	public final static int PORT = 9000;
	public static ArrayList<ClientHandler> list = new ArrayList<ClientHandler>();

	public static void main(String[] args) {
		boolean flag = true;
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("서버 실행 중 : " + PORT);
			System.out.println("클라이언트 접속 대기 중~");
			
			while(flag) {
				Socket s = server.accept();		//클라이언트 접속 대기 중
				System.out.println("클라이언트 접속!!");
				
				//클라이언트 별로 접속하고 별도 종료 진행
				ClientHandler ch = new ClientHandler(s);
				list.add(ch);
				ch.start();
			}
			server.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}//main

}//Server

class ClientHandler extends Thread {
	Socket s;
	DataOutputStream output;
	DataInputStream input;
	
	public ClientHandler(Socket s) {
		try {
			this.s = s;
			this.output = new DataOutputStream(s.getOutputStream());	//전송
			this.input = new DataInputStream(s.getInputStream());	//수신
			String str = "[서버] 환영합니다~ ";
			output.writeUTF(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			boolean flag = true;
			while(flag) {
				String recievedMsg = input.readUTF();
				if(recievedMsg.equals("exit")) {
					//while문 빠져나가서 스레드 종료하기
					flag = false;
					//list에 추가됬던 스레드도 삭제
					Server.list.remove(this);	//이거 한줄이면 되는거였네 ㅋㅋㅋㅋㅋ 본인이 빠지면 되는 것
//					Iterator<ClientHandler> l = Server.list.iterator();		//개잘했네 ㅋㅋ 했는데 위에 한줄이면 되는거였음 ㅋㅋ...
//					while(l.hasNext()) {
//						if(l.next().equals(this)) {		//종료한다는건 본인이니깐 list에서 본인과 같은 object 찾기
//							l.remove();			//동일하면 list에서 제거
//							break;
//						}
//					}
//					for(int i=0; i<Server.list.size(); i++) {	//이거는 Iterator 안쓰고 그냥 remove 사용
//						if(this.equals(Server.list.get(i))) {	//종료하는건 본인이니 this
//							Server.list.remove(i);
//							break;
//						}
//					}
				} else {
//					output.writeUTF("[서버] " + recievedMsg);	//현재 접속한 클라이언트에게만 전송
					Server.list.forEach(ch -> {
						try {
							ch.output.writeUTF(recievedMsg);
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
				}//else
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
