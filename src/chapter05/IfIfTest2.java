package chapter05;

import java.util.Scanner;
/*
 * 중첩 if
 */
public class IfIfTest2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean math_pass = false, eng_pass = false;
		
		System.out.print("수학 점수 > ");
		math_pass = (input.nextInt() >= 60)? true : false;
		System.out.print("영어 점수 > ");
		eng_pass = (input.nextInt() >= 60)? true : false;		
		
		//1. 중첩 if
		if(math_pass) if(eng_pass) System.out.println("합격"); 	//블록이 없어서 아래 else가 뒤에 if의 else가 된 듯
		else System.out.println("불합격");

		
		//2. 논리연산자 &&를 이용하여 if ~ else
		if(math_pass && eng_pass) System.out.println("합격");
		else System.out.println("불합격");
		
		input.close();
	}

}
