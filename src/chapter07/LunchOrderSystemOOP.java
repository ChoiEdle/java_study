package chapter07;

import java.util.Scanner;

public class LunchOrderSystemOOP {
	//Field
	Scanner scan = new Scanner(System.in);
	String[] lunchMenuNames = {"햄버거(🍔)", "피  자(🍕)", "라  멘(🍜)", "샐러드(🥗)"};
	int[] lunchMenuPrice = {100, 200, 300, 400};
	LunchMenu[] lunchMenuList = new LunchMenu[4];		//주문할 메뉴 : LunchMenu

	
	//시스템 메뉴 : MainMenu
	
	
	//Constructor
	
	//Method
	//런치메뉴 생성
	public void createLunchMenu() {
		for(int i=0; i<lunchMenuNames.length; i++) {
			LunchMenu menu = new LunchMenu();		//이게 for문 안에 있는게 중요, 밖에 있으면 lunchMenuList[] 모든 주소가 하나를 가르켜서 내부 값이 다 같아짐
			menu.no = i+1;
			menu.name = lunchMenuNames[i];
			menu.price = lunchMenuPrice[i];
			lunchMenuList[i] = menu;
 		}
	}
	
	//런치메뉴 출력
	public void showLunchMenu() {
		System.out.println("*******************************************");
		for(LunchMenu menu : lunchMenuList) {
			System.out.print(menu.no + ". ");
			System.out.print(menu.name + "\t");
			System.out.print(menu.price + "\n");
		}
		System.out.println("*******************************************");
	}
	
	//런치메뉴 선택
	public void selectLunchMenu() {
		System.out.print("주문메뉴(숫자) > ");
		
		if(scan.hasNextInt()) {
			lunchMenuCheck(scan.nextInt());
		} else {
			System.out.println("=> 입력된 값이 바르지 않음. 다시 입력!!!");		
			scan.next();			//없으면 입력값이 계속 남아있어서 반복됨
			selectLunchMenu();
		}
		
	}
	
	//런치메뉴 체크
	public void lunchMenuCheck(int lunchMenu) {
		//lunchMenu : 1~4 => 주문가능, 다른번호 : 메뉴 준비중 => 다시 입력
		if(1<=lunchMenu && lunchMenu <= 4) {
			//주문 진행
			order(lunchMenu);
			
		} else {
			System.out.println("=> 런치 메뉴 준비중~");
			showLunchMenu();
		}
	}
	
	//메인 메뉴 출력
	public void showMainMenu() {
		System.out.println("*******************************************");
		System.out.println("\tWelcome to Food Mart!!!");
		System.out.println("*******************************************");
		System.out.println("\t1. 음식 주문");		
		System.out.println("\t2. 주문 내역");		
		System.out.println("\t3. 음식 결제");		
		System.out.println("\t4. 결제 내역");		
		System.out.println("\t9. 프로그램 종료");		
		System.out.println("*******************************************");
		createLunchMenu();		//이거 없으면 런치메뉴가 생성이 안되서 오류남(나중에 생성자로 뺀다고 하셨음)
		selectMainMenu();
	}//showMainMenu
	
	//메인메뉴 선택
	public void selectMainMenu() {
		System.out.print("메인메뉴(숫자) > ");
		
		if(scan.hasNextInt()) {
			mainMenuCheck(scan.nextInt());
		} else {
			System.out.println("=> 입력된 값이 바르지 않음. 다시 입력!!!");		
			scan.next();			//없으면 입력값이 계속 남아있어서 반복됨
			selectMainMenu();
		}
		
	}
	
	//메인메뉴 체크
	public void mainMenuCheck(int mainMenu) {
		switch(mainMenu) {
			case 1:
				showLunchMenu();
				break;
			case 2:
				orderList();
				break;
			case 3:
				payment();
				break;
			case 4:
				paymentList();
				break;
			case 9:
				System.out.println("=> 음식 주문 시스템을 종료합니다");
				System.exit(0);
				break;
			default :
				System.out.println("=> 메뉴 준비중~");
				showMainMenu();
		}
	}
	
	//주문 : order()
	public void order(int lunchMenu) {
		
	}
	
	//주문 내역 : orderList()
	public void orderList() {
		
	}
	
	//결제 : payment()
	public void payment() {
		
	}
	
	//결제 내역 : paymentList()
	public void paymentList() {
		
	}
	
	
	
}//class
