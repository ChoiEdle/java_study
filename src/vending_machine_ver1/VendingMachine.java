package vending_machine_ver1;

import commons.Menu;

public class VendingMachine {
	//Field
	String[] nameList = {"☕ 밀크커피", "☕ 아메리카노", "🍋 유 자 차", "🥛  우   유"};
	int[] priceList = {300, 400, 300, 200};
	Menu[] menuList;
	String title;
	User user;
	int totalCoin;
	
	//Constructor
	public VendingMachine(User user) {
		this("막심", user);
	}
	public VendingMachine(String title, User user) {
		this.title = title;
		this.user = user;
		createMenuList();
		showMenuList();
		checkInsertCoin();
	}
	
	//Method
//	public boolean coinCheck(int coin) {
//		boolean result = false;
//		if(coin == 100 || coin == 500) {
//			result = true;
//		}
//		return result;
//	}
	
	//입력되는 동전 체크
	public void checkInsertCoin() {
		System.out.println("=> 동전을 투입해 주세요");
		int coin = user.insertCoin();
		if (coin == 100 || coin ==500) {		//사용가능 동전 체크
			totalCoin += coin;
			System.out.println("총 투입금액 : " + totalCoin);
			if(totalCoin>=200) {			//메뉴 선택 최소 금액 체크
				System.out.print("=> 메뉴선택(n), 동전투입계속(아무키) > ");
				if(user.scan.next().equals("n")) {
					selectMenu();
				} else {
					checkInsertCoin();
				}
			} else {
				System.out.println("=>최소 금액 부족!!");
				checkInsertCoin();
			}
		} else {
			System.out.println("=> 동전은 100원, 500원만 사용 가능합니다. 동전 반환!!");
			checkInsertCoin();
		}
	}
	
	//메뉴 선택
	public void selectMenu() {
		System.out.println("=> 메뉴를 선택해 주세요.");
		user.selectMenu();
	}
	
	//메뉴 출력
	public void showMenuList() {
		System.out.println("---------------------------------");
		System.out.println("   ☕🍵🥤 "+ title +" Coffee Menu");
		System.out.println("---------------------------------");
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() + ".\t");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%,d", menu.getPrice())+ "원\n");
		}
		System.out.println("---------------------------------");
	}
	
	//메뉴 리스트 생성
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		for(int i=0; i<nameList.length; i++) {
			int no = i+1;
			String name = nameList[i];
			int price = priceList[i];
			
			Menu menu = new Menu(no, name, price);
			menuList[i] = menu;
		}
	}
	
	
}
