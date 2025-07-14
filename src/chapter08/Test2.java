package chapter08;

public class Test2 extends Test1 {
	
	public Test2(String name){
		System.out.println("Test2 생성");
		super.name = name;
	}
	
	@Override
	public void plintInfo() {
		System.out.println(name);
	}
}
