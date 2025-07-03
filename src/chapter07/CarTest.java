package chapter07;

public class CarTest {

	public static void main(String[] args) {
		//1. 객체 생성
		Car avante = new Car();		//같은 패키지 안에 있어서 그냥 불러와짐(사실 public이면 다 불러와짐 ㅋㅋ), 같은 패키지가 아니면 import해야 함
		Car ev6 = new Car();
		
		//2. 객체 데이터 할당
		avante.name = "아반테";
		avante.company = "현대자동차";
		avante.price = 1000;
		
		ev6.name = "EV6";
		ev6.company = "기아자동차";
		ev6.price = 2000;
		
		//3. 메소드 호출
		System.out.println("***********************************");
		System.out.println("\tCar Information");
		System.out.println("***********************************");
		//각 메소드 호출 종료 시 main으로 돌아가는 복귀주소(리턴주소)를 갖는다.
		avante.showInfo();
		ev6.showInfo();
		System.out.println("***********************************");
		System.out.println("-- main 메소드 종료 --");
		
	}

}
