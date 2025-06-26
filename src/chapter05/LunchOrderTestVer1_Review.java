package chapter05;

import java.util.Scanner;

public class LunchOrderTestVer1_Review {

	public static void main(String[] args) {
		//메뉴판
		System.out.println("*******************************************");
		System.out.println("\tWelcome to Food Mart!!!");
		System.out.println("*******************************************");
		System.out.println("\t1. 햄버거(🍔):100\t2. 피자(🍕):200");		
		System.out.println("\t3. 라멘(🍜):300\t4. 샐러드(🥗):400");		
		System.out.println("\t9. 나가기");		
		System.out.println("*******************************************");
		//1. 메뉴 선택
		int menuNo = -1;
		String menuName = " ";
		int menuPrice = 0;
		
		Scanner scan = new Scanner(System.in);
		if(scan.hasNextInt()) {
			switch(menuNo = scan.nextInt()){
			case 1 : menuName = "햄버거(🍔)"; menuPrice = 100; break;
			case 2 : menuName = "피자(🍕)"; menuPrice = 200; break;
			case 3 : menuName = "라멘(🍜)"; menuPrice = 300; break;
			case 4 : menuName = "샐러드(🥗)"; menuPrice = 400; break;
			case 9 : System.out.println("나가기"); break;
			default : System.out.println("메뉴를 준비중 입니다.");
				
			}
		}else {
			System.out.println("잘못 입력 하셨습니다.");
		}
		//2. 주문 결제
		//3. 주문 내역 출력 : 주문한 메뉴는 (햄버거), 결제금액(), 잔돈() 입니다.
		}
		
		
		

	}




