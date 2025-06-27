package chapter05;

import java.util.Scanner;

/*
 * 반복문 : for(초기값선언;조건식;증감연산식) {
 * 실행문;	//조건식이 true인 경우 실행
 * }
 * 조건식이 false가 되면 for 블록 종료
 * 초기값으로 선언된 변수는 for 블록 안에서만 사용
 */
public class ForTest {

	public static void main(String[] args) {
		//1~5까지 정수를 출력, 1~10으로 변경하게되면 for문은 조건식만 변경, 노가다는 전부 추가, 작성도 수정도 편하기 때문에 for문 사용
		//시작과 종료값은 실행시 외부에서 입력을 통해 진행함

		Scanner input = new Scanner(System.in);
		int start, end;
		int sum = 0;		//이게 for문 안에 있으면 반복될때마다 0으로 초기화 때문에 원하는 값이 출력 안됌

		System.out.print("시작값 > ");
		start = input.nextInt();
		System.out.print("종료값 > ");
		end = input.nextInt();
		
		for(int i=start; i<=end; i++) {		//1이상의 값을 누적합으로 대입 -> i+=값
			sum += i;
			System.out.println("i = " + i);
		}
//		System.out.println(i); 	//에러 : i의 범위는 for 블록, i는 for문 안에서만 존재
		System.out.println("sum = " + sum);
		System.out.println("-- for문 종료 --");
		
		/*System.out.println("1");	//이것도 틀린건 아님 ㅋㅋ
		System.out.println("2");	
		System.out.println("3");	
		System.out.println("4");	
		System.out.println("5");*/
		
		
		
		input.close();
	}

}
