package chapter04;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		int hight = input.nextInt();
		boolean parent = input.nextBoolean();
		boolean hearchDease = input.nextBoolean();
		
		System.out.print("점수 > ");
		
		//6세 미만이면 안되고 키 120미만이면 안되고 심장관련 질환자면 안됨
		String result = ((age < 6 && parent == false) || hight < 120 || hearchDease == true)? "불가능" : "가능";
		System.out.println("result : " + result);
	
		
	}

}
