package chapter07;

import java.util.Scanner;

public class OrderSystem {
	//Field
	Scanner scan = new Scanner(System.in);
	Order order = new Order();
	Menu[] menu = new Menu[3];
	String[] menuNameList = {"☕ 아메리카노", "🍵 바닐라 라떼", "🥤 딸기 쉐이크"};
	int[] menuPriceList = {2800, 3500, 4000};
	int amount = 0;
	//Constructor

	//Method
	//메뉴 출력
	public void showMainMenu() {
		System.out.println("=== 메뉴판 ===");
		for(int i=0; i<menuNameList.length; i++) {
			Menu drinkMenu = new Menu();
			drinkMenu.name = menuNameList[i];
			drinkMenu.price = menuPriceList[i];
			menu[i] = drinkMenu;
			System.out.println((i+1) + ". " + menu[i].name + " - " + menu[i].price + "원");
		}
		System.out.println();
		selectMenu();
	}
	
	//메뉴 선택
	public void selectMenu() {
		System.out.print("주문할 메뉴 번호 입력 > ");
		if(scan.hasNextInt()) {
			menuCheck(scan.nextInt());
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			scan.next();			//없으면 입력값이 계속 남아있어서 반복됨
			selectMenu();
		}
	}
	
	//메뉴 체크
	public void menuCheck(int menuNo) {
		if(1<=menuNo && menuNo <= 3) {
			order(menuNo);
		} else {
			System.out.println("=> 런치 메뉴 준비중~");
			showMainMenu();
		}
	}
	
	//주문
	public void order(int menuNo) {
		order.selectMenu = menu[menuNo-1].name;
		order.totalPayment = menu[menuNo-1].price;
		System.out.println("=> 주문 메뉴 : " + order.selectMenu + ", 결제 예정 금액 : " + order.totalPayment + "원\n");
		payment();
	}
	
	//결제
	public void payment() {
		int total = order.totalPayment;
		int change = 0;
		System.out.println("=> 결제 예정 금액 : " + total);
		System.out.print("결제할 금액 입력 > ");
		if(scan.hasNextInt()) {
			amount += scan.nextInt();
			System.out.println("총 입력 금액 : " + amount);
			if(amount >= total) {
				change = amount - total;
				System.out.println("=> 결제 완료! 잔돈: " + change);
				System.out.println("[종료]\n" + "이용해주셔서 감사합니다.");
			}else {
				System.out.println("금액이 부족합니다. 다시 입력해주세요.");
				payment();
			}
		} else {
			System.out.println("올바르지 않은 입력값입니다. 다시 입력해주세요");
			scan.next();
		}	//if(scan.hasNextInt())	
		
	}
	
}


