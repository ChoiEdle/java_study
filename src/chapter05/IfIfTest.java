package chapter05;

import java.util.Scanner;
/*
 * 중첩 if
 */
public class IfIfTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int math=0, eng=0;
		
		System.out.print("수학 점수 > ");
		math = input.nextInt();
		System.out.print("영어 점수 > ");
		eng = input.nextInt();
		
		
		//1. 중첩 if
		if(math >= 60) {
			if(eng >= 60) {
				System.out.println("합격");
			} /*else {
				System.out.println("불합격");		//여기까진 이번엔 안해도 됬나봄		
			}*/
		} else {
			System.out.println("불합격");
		}
		
		//2. 논리연산자 &&를 이용하여 if ~ else
		if((math >= 60) && (eng >= 60)) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		input.close();
	}

}
