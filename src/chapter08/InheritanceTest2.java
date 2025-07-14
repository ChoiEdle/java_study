package chapter08;

public class InheritanceTest2 {

	public static void main(String[] args) {
		Circle redC = new Circle("빨간색");
		Circle blueC = new Circle("파란색");
		Rectangle yelloR = new Rectangle("노란색");
		Triangle greenT= new Triangle("초록색");
		
		redC.draw();
		blueC.draw();
		yelloR.draw();
		greenT.draw();
	}

}
