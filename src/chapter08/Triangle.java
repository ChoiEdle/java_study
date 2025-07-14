package chapter08;

public class Triangle extends Shape {
	String color;
	
	public Triangle() {
		
	}
	public Triangle(String color) {
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println(color + " 삼각형을 그린다.");
	}
}
