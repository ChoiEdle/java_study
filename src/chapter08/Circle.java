package chapter08;

public class Circle extends Shape{
	String color;
	
	public Circle() {
		
	}
	public Circle(String color) {
		this.color = color;
	}
	
	@Override
	public void draw() {
		System.out.println(color + " 원을 그린다.");
	}
}
