package chapter07;

public class Animal2 {	//파일명과 클래스명은 동일
	//Field : 전역변수
	String name;		//전역변수는 초기값을 JVM이 줌
	int age;			//초기값을 따로 주지 않는 이유는 누구나 사용할 수 있게 하기 위해
	
	
	//Constructor : 생성자는 오버로딩이 가능함!!
	public Animal2() {	//기본 생성자
		System.out.println("객체를 생성한다.");
	}	
	
	public Animal2(String name) {	//Field의 name만 초기화	//전역변수와 지역변수가 이름이 같아도 사용이 가능
		this.name = name;		//this heap에 생성된 나의 전역변수	//초기화는 값의 확장
		System.out.println("객체를 생성한다.");
	}
	
	public Animal2(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("객체를 생성한다.");
	}	
	
	//Method
	public void sleep(){	//[접근제어자] [반환타입=리턴타입] [메소드명]()
		String date = "20250703";
		System.out.println(date + name + " -> 잠을 잔다.");
	}
	
	//메인 메소드
//	public static void main(String[] args) {	//실행을 위한 메인 메소드
//		Animal giraffe = new Animal();
//		Animal elephant = new Animal();
//		
//		giraffe.name = "기린이";
//		elephant.name = "코순이";
//		
//		System.out.println("giraffe.name = " + giraffe.name);
//		System.out.println("elephant.name = " + elephant.name);
//	}
	
}


//메인 메소드가 없기 때문에 실행 x

