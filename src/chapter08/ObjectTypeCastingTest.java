package chapter08;

public class ObjectTypeCastingTest {

	public static void main(String[] args) {
		Circle yellowC = new Circle("노랑", 1);
		Rectangle blueR = new Rectangle("파랑", 1, 2);
	
		Shape s = new Circle("초록색", 2);	//자동(묵시적) 형변환		//Shape이 Circle의 부모기 때문에 에러가 안남
		Circle cs = (Circle)s;		//강제(명시적) 형변환 O, 있는데 안보이는것
//		Rectangle r = (Rectangle)s;		//강제(명시적) 형변환 X, 무조건 상속 관계에만 형변환 가능
		
		Shape s2 = new Shape("빨강");
//		Circle cs2 = (Circle)s2;	//강제(명시적) 형변환 X, 없는것
		
		//인터페이스를 통해 자식의 모습으로 객체를 구현하는 것을 권장함!!!
		ShapeInterface si = new Circle("코랄", 1);
		si.draw();		//자식인 Circle의 draw() 호출됨
		System.out.println(si.getArea());
		System.out.println();
		Circle cs3 = (Circle)si;
		cs3.draw();
		System.out.println(cs3.getArea());

		cs.draw();
//		cs2.draw();
		
		yellowC.draw();
		blueR.draw();
//		s.draw();		//Shape 클래스는 draw() 메소드를 정의하지 않음
		System.out.println(s.color);
		
		//상속받은 인터페이스 통한 객체 생성
		ShapeInterface siR = new Rectangle("하양", 1, 5);
		ShapeInterface siT = new Triangle("검정", 2, 3);
//		(추상메소드) --다형성 구현-- (상속받아 오버 라이딩)
		
		siR.draw();
		System.out.println(siR.getArea());
		siT.draw();
		System.out.println(siT.getArea());
	}

}
