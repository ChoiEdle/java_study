package chapter07;

public class Animal {	//파일명과 클래스명은 동일
	//Field : 전역변수
	String name;		//전역변수는 초기값을 JVM이 줌
	int age;			//초기값을 따로 주지 않는 이유는 누구나 사용할 수 있게 하기 위해
	
	//Constructor
	public Animal() {	//기본 생성자, 생성자는 무조건 public, 생성자명은 클래스명과 동일
		//생성자 호출시 실행되는 내용 => new Animal() 코드 실행 시 실행됨!!
		System.out.println("객체를 생성한다.");
	}
	
	//Method
	public void sleep(){	//[접근제어자] [반환타입=리턴타입] [메소드명]()
		String date = "20250703";
		System.out.println(date + name + " -> 잠을 잔다.");
	}
}


//메인 메소드가 없기 때문에 실행 x

