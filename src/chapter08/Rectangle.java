package chapter08;

public class Rectangle extends Shape implements ShapeInterface {
//	String color;
	int width, height;
	
	public Rectangle(String color, int width, int height) {
		super(color);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println(color + " 사각형을 그린다.");
	}
	
	@Override
	public double getArea() {	//자동 형변환
		double result = 0;
		result = width*height;
		
		return result;
	}
}
