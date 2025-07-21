package chapter17;

public class ThreadExtends extends Thread {
	//Field
	
	//Constructor
	public ThreadExtends() {
		super("스레드1");
	}
	
	//Method
	@Override
	public void run() {
		//1~10 출력
		for(int i=1; i<=10; i++) {
			try {
				sleep(1000);	//1초 sleep
				System.out.println(getName() + " -----> " + i);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
