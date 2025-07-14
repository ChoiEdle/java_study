package chapter08;

public class Rectangle extends Shape {
	String color;
	
	public Rectangle() {
		
	}
	public Rectangle(String color) {
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println(color + " 사각형을 그린다.");
	}
	
}
