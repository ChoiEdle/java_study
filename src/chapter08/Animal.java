package chapter08;

public class Animal extends Client {
	String name;
	int age;
	Person owner;
	
	public Animal() {
		this("예삐",3, null);
	}
	public Animal(String name, int age, Person owner) {
		this.name = name;
		this.age = age;
//		super(name, age);
		this.owner = owner;
	}
	
	//sound()
	public void sound() {
		System.out.println(name + " 짖는다");
	}
	
	public void animalRegister() {
		System.out.println("접수한다.");
	}
	
	@Override
	public void payment() {
	}
	
	@Override
	public void register() {
		System.out.println(owner.name + " 고객이 접수를 한다.");
	}
	
	@Override
	public void printInfo() {		//부모가 가진 메소드를 똑같은 모습으로 가져옴 - 오버라이딩(Overriding)
		System.out.print("고객(Client)정보 --> " + name + ", ");
		System.out.print(age + ", ");
		System.out.print(owner.name + ", ");
		System.out.print(owner.age + "\n");
	}
}
