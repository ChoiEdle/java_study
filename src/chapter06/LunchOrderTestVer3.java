package chapter06;

import java.util.Scanner;

/* 
 * 음식 주문/결제 프로그램(콘솔)
 * - 음식을 주문(1), 결제(2), 프로그램 종료(9)하는 메뉴로 구성된다.
 * - 프로그램 종료를 제외하고 나머지 메뉴는 반복 선택 가능하다.
 * - 메뉴 선택 시 체크하는 기능은 switch~case를 이용하여 구연한다.
 * 
 * <추가 사항>
 * (1) 예외사항 처리 : 메뉴 선택, 결제금액 입력 시 정수형 타입이 아닌 경우 메세지 출력 후 재입력을 유도함
 * (2) 입력값이 정확할 때까지 재입력을 유도하여 진행, flag 변수를 이용하여 반복
 * (3) 결제 금액이 부족한 경우 재입력을 통해 금액을 누적으로 계산하여 저장 후 결제
 */
public class LunchOrderTestVer3 {

	public static void main(String[] args) {
		System.out.println("*******************************************");
		System.out.println("\tWelcome to Food Mart!!!");
		System.out.println("*******************************************");
		System.out.println("\t1. 음식 주문");		
		System.out.println("\t2. 음식 결제");		
		System.out.println("\t9. 프로그램 종료");		
		System.out.println("*******************************************");
		
		Scanner scan = new Scanner(System.in);
		boolean menuFlag = true;
		int menuNo = -1;
		while(menuFlag) {
			menuNo = scan.nextInt();
			switch(menuNo) {
			case 1 : 
				System.out.println("1번입니다.");
				break;
			case 2 : 
				System.out.println("2번입니다.");
				break;
			case 9 : 
				System.out.println("프로그램을 종료합니다.");
				menuFlag = false;
				break;
			default : ;	
			}
		}
		
		
		
	}

}
