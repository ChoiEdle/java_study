package lunch;

import java.util.Scanner;

public class LunchOrderSystemOOP {
	//Field
	Scanner scan;
	LunchOrderMenuManager menuManager;
	String[] lunchMenuNames = {"햄버거(🍔)", "피  자(🍕)", "라  멘(🍜)", "샐러드(🥗)"}; 	//선언+할당이 동시에
	int[] lunchMenuPrice = {100, 200, 300, 400};
	LunchMenu[] lunchMenuList;			//주문할 메뉴 : LunchMenu	//크기만 선언
	LunchOrderItem[] orderItemList; 	//나중에는 리스트라는걸 쓰면 숫자 제한이 없다고함
	LunchPaymentItem paymentItem;
	int orderCount = 0;
	int amount = 0;		//사용자 입력 결제 금액
	int change = 0;		//잔돈
	String title;

	
	//시스템 메뉴 : MainMenu
	
	
	//Constructor
	public LunchOrderSystemOOP() {
		scan = new Scanner(System.in);
		menuManager = new LunchOrderMenuManager(this);	//자기자신을 넘길땐 this만 적음
		lunchMenuList = new LunchMenu[4];
		orderItemList = new LunchOrderItem[4];
		
		menuManager.createLunchMenu();		//이거 없으면 런치메뉴가 생성이 안되서 오류남(나중에 생성자로 뺀다고 하셨음)	//생성자에서 위치도 중요함
	}
	
	public LunchOrderSystemOOP(String title) {
		this.title = title;
		scan = new Scanner(System.in);
		menuManager = new LunchOrderMenuManager(this);
		lunchMenuList = new LunchMenu[4];
		orderItemList = new LunchOrderItem[4];
		
		menuManager.createLunchMenu();		//이거 없으면 런치메뉴가 생성이 안되서 오류남(나중에 생성자로 뺀다고 하셨음)	//생성자에서 위치도 중요함
		
		menuManager.showMainMenu();
	}
	
	
	//Method

	
	//주문아이템의 인덱스 검색
	public int searchOrderItemIdx(int lunchMenu) {
		int idx = -1;
		for(int i=0; i<orderCount; i++) {
			LunchOrderItem orderItem = orderItemList[i];
			if(orderItem.no == lunchMenu) idx = i;
		}
		return idx;
	}
	
	//주문리스트 초기화
		public void orderItemListInit() {
			orderItemList = new LunchOrderItem[4];
			
//			for(LunchOrderItem orderItem : orderItemList) {
//				if(orderItem != null) orderItem = null;
//			}
			
			orderCount = 0;
			amount = 0;
		}
	
	//주문 : order()
	public void order(int lunchMenu) {
		
		System.out.println(lunchMenu + " 주문!");
		//lunchMenuList의 메뉴 번호 확인
		for(LunchMenu menu : lunchMenuList) {							//여기가 가장 어려웠다
			if(menu.no == lunchMenu) {
				int idx = searchOrderItemIdx(lunchMenu);
				if(idx == -1) {
					orderItemList[orderCount] = new LunchOrderItem();	//for문 밖에 있을 땐 order 메소드로 오면 바로 생성이라 주소값을 가져서 null이 나옴
					
					orderItemList[orderCount].no = menu.no;
					orderItemList[orderCount].name = menu.name;
					orderItemList[orderCount].price = menu.price;
					orderItemList[orderCount].qty = 1;
					orderCount++;
				} else {
					orderItemList[idx].qty += 1;
				}
//				orderItemList[orderCount].no = menu.no;
//				orderItemList[orderCount].name = menu.name;
//				orderItemList[orderCount].price = menu.price;
//				orderItemList[orderCount].qty += 1;
				break;
			}
		}
		System.out.println("=> 주문 완료!!!");
		menuManager.showMainMenu();
	}
	
	//주문 내역 : orderList()
	public void orderList() {
		if(orderCount == 0) {
			System.out.println("=> 주문내역 존재X, 주문 먼저 해주세요");
		} else {
			System.out.println("----------------------------------------------");
			System.out.println("번호\t메뉴명\t\t가격\t수량");
			System.out.println("----------------------------------------------");
			for(LunchOrderItem orderItem : orderItemList) {
				if(orderItem != null) {
					System.out.print(orderItem.no + "\t");
					System.out.print(orderItem.name + "\t");
					System.out.print(orderItem.price + "\t");
					System.out.print(orderItem.qty + "\n");
				}
			}
			System.out.println("----------------------------------------------");
		}
		menuManager.showMainMenu();
	}
	
	//결제 예정금액 산출
	public int totalPayment() {
		int sum = 0;
		for(LunchOrderItem orderItem : orderItemList) {
			if(orderItem != null) {
				sum += orderItem.price * orderItem.qty;
			}
		}
		return sum;
	}
	
	//결제 : payment()
	public void payment() {
		if(orderCount == 0) {
			System.out.println("=> 주문내역 존재X, 주문 먼저 해주세요");
		} else {
			paymentItem = new LunchPaymentItem();
			int total = totalPayment();
			System.out.println("=> 결제 예정 금액 : " + total);
			System.out.print("결제할 요금 입력 > ");
			
			if(scan.hasNextInt()) {
				amount += scan.nextInt();
				System.out.println("총 입력 금액 : " + amount);
				if(amount >= total) {
					change = amount - total;
					
					paymentItem = new LunchPaymentItem();
					paymentItem.name = orderItemList[0].name + "등 ...";
					paymentItem.totalPayment = total;
					paymentItem.amount = amount;
					paymentItem.change = change;
					System.out.println("=> 결제 성공!!!");
					
					//주문리스트 초기화
					orderItemListInit();
					
				}else {
					System.out.println("요금이 부족합니다. 다시 입력해주세요");
					payment();
				}
			} else {
				System.out.println("올바르지 않은 입력값입니다. 다시 입력해주세요");
				scan.next();
			}	//if(scan.hasNextInt())	
		}
		menuManager.showMainMenu();
	}
	
	//결제 내역 : paymentList()
	public void paymentList() {
		if(paymentItem == null) {
			System.out.println("=> 결제 내역X. 주문을 진행해주세요");
			menuManager.showMainMenu();
		} else {
			System.out.println("----------------------------------------------");
			System.out.println("주문명\t\t결제금액\t총입금액\t잔돈");
			System.out.println("----------------------------------------------");
			System.out.print(paymentItem.name + "\t");
			System.out.print(paymentItem.totalPayment + "\t");
			System.out.print(paymentItem.amount + "\t");
			System.out.print(paymentItem.change + "\n");
			System.out.println("----------------------------------------------");
		}
		menuManager.showMainMenu();
	}
	
	
	
}//class
