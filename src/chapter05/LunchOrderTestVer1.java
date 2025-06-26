package chapter05;

import java.util.Scanner;

public class LunchOrderTestVer1 {

	public static void main(String[] args) {
		//메뉴판
		System.out.println("*******************************************");
		System.out.println("\tWelcome to Food Mart!!!");
		System.out.println("*******************************************");
		System.out.println("\t1. 햄버거(🍔):100\t2. 피자(🍕):200");		
		System.out.println("\t3. 라멘(🍜):300\t4. 샐러드(🥗):400");		
		System.out.println("\t9. 나가기");		
		System.out.println("*******************************************");
		Scanner scan = new Scanner(System.in);
		int menuNo = -1;
		String menuName = " ";
		int menuPrice = 0;
		
		//1. 메뉴 선택
		System.out.print("메뉴 선택(숫자로) > ");
		if(scan.hasNextInt()){
			menuNo = scan.nextInt();
			
			switch(menuNo) {
				case 1:	menuName = "햄버거(🍔)"; 	menuPrice = 100;	break;
				case 2:	menuName = "피자(🍕)"; 	menuPrice = 200;	break;
				case 3:	menuName = "라멘(🍜)"; 	menuPrice = 300;	break;
				case 4:	menuName = "샐러드(🥗)";	menuPrice = 400;	break;
				case 9:
					System.out.println("- 프로그램을 종료합니다 -");
					System.exit(0);
					break;
				default : System.out.println("메뉴 준비중 입니다.");
			}//switch		
			/*
			if(menuNo == 1) {
				System.out.println("햄버거(🍔)");				
			} else if(menuNo == 2){
				System.out.println("피자(🍕)");
			} else if(menuNo == 3){
				System.out.println("라멘(🍜)");
			} else if(menuNo == 4){
				System.out.println("샐러드(🥗)");
			} else if(menuNo == 9){
				System.out.println("- 프로그램을 종료합니다 -");
				System.exit(0);		//JDK종료 명령어, ()안에 숫자는 0이 정상종료 1이 비정상종료
			} else {
				System.out.println("메뉴 준비중 입니다.");
			}*/ //if(menuNo ==1) 
		} else{
			System.out.println("올바르지 않은 입력값입니다.");
			}	//if(scan.hasNextInt())
		System.out.println("주문하신 메뉴는 " + menuName + ", 가격은 " + menuPrice + "원 입니다.");
		
		
		//2. 주문 결제
		
		
		//3. 주문 내역 출력 : 주문한 메뉴는 (햄버거), 결제금액(), 잔돈() 입니다.
		
		
		scan.close();
		}
		
		
		

	}




