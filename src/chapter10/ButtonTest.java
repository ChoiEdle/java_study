package chapter10;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest {

	public static void main(String[] args) {
		Frame f = new Frame();
		Panel p = new Panel();
		Button btnClick = new Button("클릭해주세요!!");
		p.add(btnClick);
		f.setLayout(new BorderLayout());
		f.add(p, BorderLayout.NORTH);
		f.setTitle("버튼 테스트");
		f.setSize(300, 400);
		f.setVisible(true);
		
		
		
		//버튼의 이벤트 처리1 - 내부 클래스를 생성하여 액션 이벤트 처리
//		ButtonTest.ButtonActionListener action = new ButtonTest.ButtonActionListener();
		btnClick.addActionListener(new ButtonTest.ButtonActionListener());
		
		//버튼의 이벤트 처리2 - Anonymous(익명) 클래스를 생성하여 액션 이벤트 처리
		
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