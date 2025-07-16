package chapter12;

public class MathTest {

	public static void main(String[] args) {
		//모든 메소드가 static으로 정의되어 있음 : 클래스명.메소드명
		System.out.println(Math.abs(-100));			//절대값 출력
		System.out.println(Math.floor(1234.567));	//소수점 자리를 버림
		System.out.println(Math.max(100, 200));		//최대값 출력
		System.out.println(Math.min(100, 200));		//최소값 출력
		System.out.println(Math.random());			//random값 출력
		System.out.println((int)Math.floor(Math.random()*100));			//정수 2자리 랜덤 호출
		System.out.println(Math.round(123.567));	//소수점 자리 반올림
		
		
		
	}

}
