package chapter03;
//import java.lang.String;

public class Variable {
	public static void main(String[] args) {
		// 기본 자료형 변수 정의
		int age = 10;
		double aged = 10.0;
		boolean flag = true;	//true(1), false(0)
		char name = '홍';
		char name2 = '길';
		char name3 = '동';
		String sname = "김길동";					//기본형(Stack에 저장됨)
		
		// 참조 자료 변수 정의
		String sname2 = new String("고길동");		//참조형(Heap에 저장됨, Stack에는 Heap의 주소만 저장됨)	
		// ** String 클래스는 기본형과 참조형으로 모두 사용 가능!!
				
		//출력
		System.out.println(age);
		System.out.println(aged);
		System.out.println(flag);
		System.out.print(name);
		System.out.print(name2);
		System.out.println(name3);
		System.out.println(sname);
		System.out.println(sname2);
		System.out.println(""+ name + name2 + name3);	//"" 빼면 값이 아스키코드 값의 합이 나옴
	}

}
