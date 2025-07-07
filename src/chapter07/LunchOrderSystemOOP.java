package chapter07;

import java.util.Scanner;

public class LunchOrderSystemOOP {
	//Field
	Scanner scan = new Scanner(System.in);
	LunchMenu[] lunchMenuList = new LunchMenu[4];		//주문할 메뉴 : LunchMenu

	
	//시스템 메뉴 : MainMenu
	
	
	//Constructor
	
	//Method
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
		System.out.print("메뉴 > ");
		
		if(scan.hasNextInt()) {
			mainMenuCheck(scan.nextInt());
		} else {
			System.out.println("입력된 값이 바르지 않음. 다시 입력!!!");		
			scan.next();			//없으면 입력값이 계속 남아있어서 반복됨
			showMainMenu();
		}
		
	}//showMainMenu
	
	//main menu check
	public void mainMenuCheck(int mainMenu) {
		
	}
	
	
	
}//class
