package chapter08;

public class Circle extends Shape implements ShapeInterface{
//	String color;
	double redius;
	public static final double PI = 3.14;
	
	public Circle(String color, double redius) {
		super(color);
		this.redius = redius;
	}
	
	@Override
	public void draw() {
		System.out.println(color + " 원을 그린다.");
	}
	
	@Override
	public double getArea() {
		double result = 0;
		result = redius*redius*PI;
		return result;
	}
	
}
