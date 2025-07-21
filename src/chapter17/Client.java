package chapter17;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			final String HOST = "localhost";
			final int PORT = 9000;
			Frame f = new Frame();
			Button button1 = new Button("종료");
			
			Socket s = new Socket(HOST, PORT);	//localhost, 127.0.0.1, 192.168.50.57	
			System.out.println("클라이언트 접속 ~");
			
			f.add(button1);
			f.setSize(200, 300);
			f.setVisible(true);
			
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("-- 클라이언트 종료 --");
					System.exit(0);
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
