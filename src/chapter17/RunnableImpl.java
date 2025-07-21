package chapter17;

public class RunnableImpl implements Runnable {
	//Field
	
	//Constructor
	public RunnableImpl() {
		
	}
	
	//Method
	@Override
	public void run() {
		//1~10 출력
		for(int i=1; i<=10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Runnable ------> " + i);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
