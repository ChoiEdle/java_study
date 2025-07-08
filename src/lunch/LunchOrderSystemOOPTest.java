package lunch;

public class LunchOrderSystemOOPTest {

	public static void main(String[] args) {
		LunchOrderSystemOOP system = new LunchOrderSystemOOP();		//system이라는 객체를 만들어서 앞으로 사용하려고 선언하는건데
		system.title = "더조은";										//생성자에서 자동으로 실행해주면 아래처럼 객체 선언을 할 필요가 없음 
		system.menuManager.showMainMenu();
		
		//생성자를 객체 초기화 후 실행 메소드를 호출하는 경우
		new LunchOrderSystemOOP("HAPPY");							//이게 아래
	}

}
