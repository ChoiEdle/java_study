package chapter10;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ButtonTest {

	public static void main(String[] args) {
		Frame f = new Frame();
		Panel p = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Button btnClick = new Button("버튼1");
		Button btnClick2 = new Button("버튼2");
		Button btnClick3 = new Button("버튼3");
		p.add(btnClick);
		p2.add(btnClick2);
		p3.add(btnClick3);
		f.setLayout(new BorderLayout());
		f.add(p, BorderLayout.NORTH);
		f.add(p2, BorderLayout.CENTER);
		f.add(p3, BorderLayout.SOUTH);
		f.setTitle("버튼 테스트");
		f.setSize(300, 400);
		f.setVisible(true);
		
		
		
		//버튼의 이벤트 처리1 - 내부 클래스를 생성하여 액션 이벤트 처리
//		ButtonTest.ButtonActionListener action = new ButtonTest.ButtonActionListener();
		btnClick.addActionListener(new ButtonTest.ButtonActionListener());
		
		//버튼의 이벤트 처리2 - Anonymous(익명) 클래스를 생성하여 액션 이벤트 처리
		btnClick2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click");
			}
		});
		
		//버튼의 이벤트 처리3 - 람다식(자바 버전 8이상) 처리방식을 이용한 이벤트 처리
//		btnClick3.addActionListener((ActionEvent e) -> {
//			System.out.println("버튼 3");
//		});
//		
//		btnClick3.addActionListener(e -> {	//파라미터(매개변수)가 하나인 경우 () 생략 가능, 타입도 생략 가능
//			System.out.println("버튼 3");
//		});
		
		btnClick3.addActionListener(e -> System.out.println("버튼 3"));	//메소드 내용이 한줄이면 {}도 생략가능, 생략 하게되면 ;도 생략
		
		//Frame의 종료 이벤트
		f.addWindowListener(new WindowListener() {
			public void windowActivated(WindowEvent e) {
				
			}
			public void windowClosed(WindowEvent e) {
				
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("- 프로그램 종료 -");
				System.exit(0);
			}
			public void windowDeactivated(WindowEvent e) {
				
			}
			public void windowDeiconified(WindowEvent e) {
				
			}
			public void windowIconified(WindowEvent e) {
				
			}
			public void windowOpened(WindowEvent e) {
				
			}
		});//f.addWindowListener()
		
		
	}
	
	/**
	 * 버튼의 이벤트 처리 클래스
	 */
	public static class ButtonActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("클릭");
		}
	}
	
}
//이건 즈언통의 방법