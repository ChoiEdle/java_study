package chapter08;

public class Triangle extends Shape {
	String color;
	double width, height;
	
	public Triangle() {
		
	}
	public Triangle(String color, double width, double height) {
		this.color = color;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println(color + " 삼각형을 그린다.");
	}
	
	@Override
	public double getArea() {
		double result = 0;
		result = width*height*0.5;
		
		return result;
	}
}
