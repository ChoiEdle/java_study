package chapter08;

public class InheritanceTest {

	public static void main(String[] args) {
		Client c1 = new Client();
		Person p1 = new Person();
		Person p2 = new Person("김유신", "종로구", "010-9876-9876", 12);
		Animal dog = new Animal("명수", 5 , p1);
		Animal cat = new Animal("야옹이", 6 , p2);
		
//		c1.name = "홍길동";
//		p1.name = "홍길동";		//부모인 Client의 name 변수 사용???
//		p1.Client.name = "홍길동?"; 		//이거 안되더라 ㅋㅋ 	//부모와 자식이 같은 이름의 변수가 있으면 자식의 변수만 사용(부모 변수는 사용 불가)
//		a1.name = "예삐";		//Animal클래스의 name을 주석 처리 했는데도 오류 없이 잘 됨(부모의 변수를 사용해서)
//		System.out.println("c1. name ==> " + c1.name);
//		System.out.println("p1. name ==> " + p1.name);
//		System.out.println("a1. name ==> " + a1.name);
//		System.out.println("p2. name ==> " + p2.name);

//		c1.printInfo();
		p1.printInfo();
		p2.printInfo();
		dog.printInfo();
		cat.printInfo();
		
		dog.sound();
		cat.sound();
	}

}
