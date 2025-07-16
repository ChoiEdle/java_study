package chapter11;

import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("num1 > ");
		int num1 = scan.nextInt();
		
		System.out.print("num2 > ");
		int num2 = scan.nextInt();
		
		try {
			int result = num1/num2;
			System.out.println("result : " + result);
			int[] numbers = {1, 2, 3};
			System.out.println(numbers[0]);
//			System.out.println(numbers[5]);
			
		} catch(Exception e) {		//모든 예외(exception)의 부모 클래스
			System.out.println("예외 발생!!");
			e.printStackTrace();		//근대 이거 쓸꺼면 그냥 예외처리를 안하는게...?
		} finally {
			scan.close();
			System.out.println("-- 프로그램 종료 --");
		}
		
	}

}
