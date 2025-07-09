package vending_machine_ver2;

import commons.Menu;

public class VendingMachine {
	//Field
	Menu[] orderMenuList;
	Menu[] ableMenuList;
	Menu orderMenu;
	int ableCount = 0;
	String[] menuList = {"우   유", "유 자 차", "율 무 차", "핫 초 코", "밀크커피"};
	int[] priceList = {200, 300, 300, 300, 400};
	User user = new User();
	int totalCoin = 0;
	int change = 0;
	
	public static final int EXIT = 9;
	
	
	//Constructor
	public VendingMachine() {
		playSystem();
	}
	
	//Method
	//실행 순서 메소드
	public void playSystem() {
		createMenu();
		showMenuList();
		coinCheck();
		selectMenu();
		payment();
		finalCheck();
	}
	
	//메뉴 생성
	public void createMenu() {
		orderMenuList = new Menu[menuList.length];
		for(int i=0; i<menuList.length; i++) {
			int no = i+1;
			int price = priceList[i];
			String name = menuList[i];
			Menu menu = new Menu(no, name, price);
			orderMenuList[i] = menu;
		}
	}
	
	//메뉴 출력
	public void showMenuList() {
		for(Menu menu : orderMenuList) {
			System.out.print(menu.getNo() + ". \t");
			System.out.print(menu.getName() + "\t\t");
			System.out.print(menu.getPrice() + "원\n");
		}
	}
	//코인 체크
	public void coinCheck() {
		System.out.println("동전을 투입하세요.(100원, 500원만 가능)");
		if(user.getScan().hasNextInt()) {
			int insultCoin = user.getScan().nextInt();
			if(insultCoin == 100 || insultCoin == 500) {
				totalCoin += insultCoin;
				System.out.println("투입 금액 : " + totalCoin);
				menuCoinCheck();
			} else {
				System.out.println("100원 또는 500원이 아닙니다.");
				coinCheck();
			}
		} else {
			System.out.println("잘못 입력 하셨습니다.");
			user.getScan().next();
			coinCheck();
		}
	}
	
	//메뉴 or 동전 체크
	public void menuCoinCheck() {
		if(totalCoin >= lowPrice()) {
			System.out.println("=> 메뉴선택(n), 동전투입계속(아무키) > ");
			String input = user.getScan().next();
			if(input.equals("n")) {
				ableMenuList();
			} else {
				coinCheck();
			}
		} else {
			System.out.println("금액이 부족합니다.");
			coinCheck();
		}
	}
	
	//가능한 메뉴 리스트
	public void ableMenuList() {
		ableMenuList = new Menu[orderMenuList.length];
		for(Menu menu : orderMenuList) {
			if(menu.getPrice()<=totalCoin) {
				ableMenuList[ableCount] = menu;
				System.out.print(menu.getNo() + ". \t");
				System.out.print(menu.getName() + "\t\t");
				System.out.print(menu.getPrice() + "원\n");
				ableCount++;
			}
		}
	}
	
	//주문 가능 메뉴 번호를 골랐는지 확인 메소드
	public boolean selectMenuCheck(int menuNo) {
		boolean result = false;
		for(Menu menu : ableMenuList) {
			if(menu == null) {
				break;
			} else {
				if(menu.getNo() == menuNo) {
					result = true;
				}
			}
		}
		return result;
	}
	
	
	//메뉴 선택
	public void selectMenu() {
		System.out.println("음료를 선택하세요.(취소는 ["+ EXIT +"]를 입력해주세요)");
		if(user.getScan().hasNextInt()) {
			int menuNo = user.getScan().nextInt();
			if(menuNo == 9) {
				System.out.println("잔돈 : " + totalCoin + "원을 반환합니다.");
				System.out.println("이용해주셔서 감사합니다.");
				System.exit(0);
			} else {
				if(selectMenuCheck(menuNo)) {
					order(menuNo);
				} else {
					System.out.println("해당 메뉴 선택 할 수 없습니다.");
					selectMenu();
				}
			}
		} else {
			System.out.println("잘못 입력 하셨습니다.");
			user.getScan().next();
			selectMenu();
		}
	}
	
	//주문
	public void order(int menuNo) {
		for(Menu menu : ableMenuList) {
			if(menu == null) {
				break;
			} else {
				if(menu.getNo() == menuNo) {
					orderMenu = menu;
					break;
				} 
			}
		}
	}
	
	//결제
	public void payment() {
		change = totalCoin-orderMenu.getPrice();
		System.out.print("주문하신 메뉴 : " + orderMenu.getName() + "\t");
		System.out.print("결제 금액 : " + orderMenu.getPrice() + "\t");
		System.out.println("잔돈 : " + change);
	}
	
	//파이널 체크
	public void finalCheck() {
		if(change >= lowPrice()) {
			bigChange();
		} else {
			System.out.println("잔돈 : " + change + "원을 반환합니다.");
			System.out.println("이용해주셔서 감사합니다.");
			System.exit(0);
		}
	}
	
	//메뉴중에 가장 싼 메뉴의 가격을 리턴해주는 메소드
	public int lowPrice() {
		int low = priceList[0];
		for(int i=0; i<priceList.length; i++) {
			if(low>priceList[i]) {
				low = priceList[i];
			}
		}
		return low;
	}
	
	//초기화 메소드
	public void reset() {
		ableMenuList = null;
		orderMenu = null;
		ableCount = 0;
	}
	
	//잔돈이 많을 때 반복하는 메소드
	public void bigChange() {
		totalCoin = change;
		reset();
		
		ableMenuList();
		selectMenu();
		payment();
		finalCheck();
	}
}
