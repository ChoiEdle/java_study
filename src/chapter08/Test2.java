package chapter08;

public class Test2 extends Test1 {
	
	public Test2(String name){
		super.name = name;
	}
	
	@Override
	public void plintInfo() {
		System.out.println(name);
	}
}
