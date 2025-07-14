package chapter08;

public class InheritanceTest2 {

	public static void main(String[] args) {
		Circle redC = new Circle("빨간색", 12);
		Circle blueC = new Circle("파란색", 6);
		Rectangle yellowR = new Rectangle("노란색", 10, 12);
		Triangle greenT= new Triangle("초록색", 4, 6);
		
		redC.draw();
		System.out.println("redC.getArea : " + redC.getArea());
		
		blueC.draw();
		System.out.println("blueC.getArea : " + blueC.getArea());
		
		yellowR.draw();
		System.out.println("yellowR.getArea : " + yellowR.getArea());

		greenT.draw();
		System.out.println("greenT.getArea : " + greenT.getArea());
		
	}

}
