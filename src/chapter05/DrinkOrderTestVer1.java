package chapter05;

import java.util.Scanner;

public class DrinkOrderTestVer1 {

	public static void main(String[] args) {
		//지역 변수 선언
		Scanner scan = new Scanner(System.in);	//여러번 선언하지 않도록 주의
		int menuNo = 0;
		int menuPrice = 0;
		int money = 0;
		int charge = 0;
		boolean menuFlag = true;
		boolean moneyFlag = true;
		String menuName = "";
		String menuPO = "";
		
		//step 1 : 메뉴판 출력
		System.out.println("[시작]");
		System.out.println("-------------------------------");
		System.out.println("☕🍵🥤 Mega Coffee Menu");
		System.out.println("-------------------------------");
		System.out.println("1. ☕ 아메리카노 - 2,800원");
		System.out.println("2. 🍵 바닐라 라떼 - 3,500원");
		System.out.println("3. 🥤 딸기 쉐이크 - 4,000원");
		System.out.println("-------------------------------");
		
		//step 2 : 주문 기능
		while(menuFlag) {
			System.out.print("주문할 메뉴 번호 입력>");			
			if(scan.hasNextInt()) {
				//선택 메뉴번호를 체크하여 메뉴명, 메뉴가격을 별도의 변수에 저장
				menuFlag = false;
				menuNo = scan.nextInt();
				switch(menuNo) {
				case 1 : menuName = "☕ 아메리카노"; 	menuPrice = 2800; break;
				case 2 : menuName = "🍵 바닐라 라떼";	menuPrice = 3500; break;
				case 3 : menuName = "🥤 딸기 쉐이크"; 	menuPrice = 4000; break;
				default : 
					System.out.println("=> 준비중 입니다. "); 
					menuFlag = true;
				}//switch
				menuPO = String.format("%,d", new Object[] {Integer.valueOf(menuPrice)});
			}else {
				System.out.println("올바르지 않은 입력값 입니다. 다시 입력해주세요");
				scan.next();
			}//else			
		}//while
		System.out.println("=> 주문 메뉴 : " + menuName + ", 결제 예정 금액 : " + menuPO + "원\n");
		
		
		//step 3 : 메뉴 결제 기능
		while(moneyFlag) {
			System.out.print("결제할 금액 입력> ");
			if(scan.hasNextInt()) {
				money += scan.nextInt();
				System.out.println("총 입금 금액> " + money + "원");
				if(money>menuPrice) {
					moneyFlag = false;
					charge = money-menuPrice;					
				}else {
					System.out.println("=> 금액이 부족합니다. 다시 입력해주세요.");					
				}
			}else {
				System.out.println("올바르지 않은 입력값 입니다. 다시 입력해주세요");		
			}
		}//while
		System.out.println("=> 결제 완료! 잔돈: " + charge + "원");				
		System.out.println("[종료]");
		System.out.println("이용해주셔서 감사합니다.");
	}//main

}//class
