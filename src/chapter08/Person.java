package chapter08;

public class Person extends Client {
	int age;
	String name;
	String address;
	String phone;
	
	public Person() {
		this("이순신", "강남구", "010-1234-1234", 20);
	}
	public Person(String name, String address, String phone, int age) {
		//name, age 필드는 부모클래스에서 사용!!
		//부모 클래스의 생성자 호출 메소드 super()
//		super(name, age);		//부모 클래스 호출
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.age = age;
	}
	
	public void personRegister() {
		System.out.println("접수한다.");
	}
	
	@Override
	public void payment() {
	}
	
	@Override
	public void register() {
		System.out.println(name + " 고객이 접수를 한다.");
	}
	
	@Override
	public void printInfo() {		//부모가 가진 메소드를 똑같은 모습으로 가져옴 - 오버라이딩(Overriding)
		System.out.print("고객(Client)정보 --> " + name + ", ");
		System.out.print(age + ", ");
		System.out.print(address + ", ");
		System.out.print(phone + "\n");
	}
	
}
