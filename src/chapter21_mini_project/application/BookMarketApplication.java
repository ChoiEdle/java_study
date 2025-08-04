package chapter21_mini_project.application;

import java.util.Scanner;

import chapter21_mini_project.service.BookMarketService;

public class BookMarketApplication {
	//Field
	public static final int INFO= 1;
	public static final int SHOWCART = 2;
	public static final int DELETEALL = 3;
	public static final int ADD = 4;
	public static final int UPDOWN = 5;
	public static final int DELETE = 6;
	public static final int RECEIPT = 7;
	public static final int EXIT = 8;
	public Scanner scan;
	private String userName;
	private String userPhone;
	BookMarketService service;
	
	//Constructor
	public BookMarketApplication() {
		scan = new Scanner(System.in);
		service = new BookMarketService(this);
		login();
		cycle();
	}
	
	//Method
	public void cycle() {
		showMenu();
		selectMenu();
	}
	
	public void login() {
		System.out.print("당신의 이름을 입력하세요 : ");
		userName = scan.next();
		System.out.print("연락처를 입력하세요 : ");
		userPhone = scan.next();
		cycle();
	}
	
	public void showMenu() {
		System.out.println("*************************************************");
		System.out.println("\tWelcome to Shopping Mall");
		System.out.println("\tWelcome to Book Market!");
		System.out.println("*************************************************");
		System.out.println("1. 고객 정보 확인하기\t4. 바구니에 항목 추가하기");
		System.out.println("2. 장바구니 상품 목록 보기\t5. 장바구니의 항목 수량 변경");
		System.out.println("3. 장바구니 비우기\t\t6. 장바구니의 항목 삭제하기");
		System.out.println("7. 영수증 표시하기\t\t8. 종료");
		System.out.println("*************************************************");
		
	}
	
	public void selectMenu() {
		System.out.println("*************************************************");
		System.out.print("메뉴 번호를 선택해주세요 ");
		switch(scan.nextInt()) {
			case INFO :
				service.menuGuestInfo();
				break;
			case SHOWCART :
				service.menuCartItemList();
				break;
			case DELETEALL :
				service.menuCartClear();
				break;
			case ADD :
				service.menuCartAddItem();
				break;
			case UPDOWN :
				service.menuCartRemoveItemCount();
				break;
			case DELETE :
				service.menuCartRemoveItem();
				break;
			case RECEIPT :
				service.menuCartBill();
				break;
			case EXIT :
				service.menuExit();
				System.exit(0);
				break;
			default :
				
		}
		cycle();
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

}
