package chapter11;

import java.util.Scanner;

/**
 * Exception 객체 생성 > 다른 메소드에게 예외처리를 넘김
 */
public class ExceptionTest4 {
	//checkAge 메소드
	public static void checkAge(int age) throws Exception {		//메인 메소드는 static이라 static만 불러올수있음	//에러를 메소드를 호출한 곳으로 떠넘김
		if(age<0) {
			throw new Exception("나이는 0보다 커야 합니다");		//exception 발생
		} else {
			System.out.println("age : " + age);
		}
	}
	
	public static void main(String[] args) {	//메인에서 에러를 떠넘기면 빨간불이 보이지만 않을 뿐 런타임시 exception이 발생
		//키보드를 통해 나이를 입력 받아 체크함
		Scanner scan = new Scanner(System.in);
		System.out.print("나이 > ");
		int age = scan.nextInt();
		
		try {
			checkAge(age) ;
		} catch (Exception e) {
			System.out.println("Exception : age는 0보다 커야함");
		} finally {
			scan.close();
			System.out.println("-- 프로그램 종료 --");
		}
		
	}
}
