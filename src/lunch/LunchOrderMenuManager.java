package lunch;

public class LunchOrderMenuManager {
	//Field
	LunchOrderSystemOOP system;
//	String[] lunchMenuNames;		//한두개 받아올때 방법
//	int[] lunchMenuPrice;
	
	//Constructor
	public LunchOrderMenuManager() {
	}
	
	public LunchOrderMenuManager(LunchOrderSystemOOP system) {
		this.system = system;
//		this.lunchMenuNames = lunchMenuNames;
//		this.lunchMenuPrice = lunchMenuPrice;
	}
	
	//method
	//런치메뉴 생성
	public void createLunchMenu() {
		for(int i=0; i<system.lunchMenuNames.length; i++) {
			LunchMenu menu = new LunchMenu();		//이게 for문 안에 있는게 중요, 밖에 있으면 lunchMenuList[] 모든 주소가 하나를 가르켜서 내부 값이 다 같아짐
			menu.no = i+1;
			menu.name = system.lunchMenuNames[i];
			menu.price = system.lunchMenuPrice[i];
			system.lunchMenuList[i] = menu;
 		}
	}
	
	//런치메뉴 출력
	public void showLunchMenu() {
		System.out.println("*******************************************");
		for(LunchMenu menu : system.lunchMenuList) {
			System.out.print(menu.no + ". ");
			System.out.print(menu.name + "\t");
			System.out.print(menu.price + "\n");
		}
		System.out.println("*******************************************");
		selectLunchMenu();
	}
	
	//런치메뉴 선택
	public void selectLunchMenu() {
		System.out.print("주문메뉴(숫자) > ");
		
		if(system.scan.hasNextInt()) {
			lunchMenuCheck(system.scan.nextInt());
		} else {
			System.out.println("=> 입력된 값이 바르지 않음. 다시 입력!!!");		
			system.scan.next();			//없으면 입력값이 계속 남아있어서 반복됨
			selectLunchMenu();
		}
		
	}
	
	//런치메뉴 체크
	public void lunchMenuCheck(int lunchMenu) {
		//lunchMenu : 1~4 => 주문가능, 다른번호 : 메뉴 준비중 => 다시 입력
		if(1<=lunchMenu && lunchMenu <= 4) {
			//주문 진행
			system.order(lunchMenu);
		} else {
			System.out.println("=> 런치 메뉴 준비중~");
			showLunchMenu();
		}
	}
	
	//메인 메뉴 출력
	public void showMainMenu() {
		System.out.println("*******************************************");
		System.out.println("\tWelcome to [" + system.title + "] Food Mart!!!");
		System.out.println("*******************************************");
		System.out.println("\t1. 음식 주문");		
		System.out.println("\t2. 주문 내역");		
		System.out.println("\t3. 음식 결제");		
		System.out.println("\t4. 결제 내역");		
		System.out.println("\t9. 프로그램 종료");		
		System.out.println("*******************************************");
		selectMainMenu();
	}//showMainMenu
	
	//메인메뉴 선택
	public void selectMainMenu() {
		System.out.print("메인메뉴(숫자) > ");
		
		if(system.scan.hasNextInt()) {
			mainMenuCheck(system.scan.nextInt());
		} else {
			System.out.println("=> 입력된 값이 바르지 않음. 다시 입력!!!");		
			system.scan.next();			//없으면 입력값이 계속 남아있어서 반복됨
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
				system.orderList();
				break;
			case 3:
				system.payment();
				break;
			case 4:
				system.paymentList();
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
}
