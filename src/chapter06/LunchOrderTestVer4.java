package chapter06;

import java.util.Scanner;

/* 
 * 음식 주문/결제 프로그램(콘솔)
 * - 음식을 주문(1), 결제(2), 프로그램 종료(9)하는 메뉴로 구성된다.
 * - 프로그램 종료를 제외하고 나머지 메뉴는 반복 선택 가능하다.
 * - 메뉴 선택 시 체크하는 기능은 switch~case를 이용하여 구연한다.
 * 
 * <추가 사항>
 * (1) 예외사항 처리 : 메뉴 선택, 결제금액 입력 시 정수형 타입이 아닌 경우 메세지 출력 후 재입력을 유도함
 * (2) 입력값이 정확할 때까지 재입력을 유도하여 진행, flag 변수를 이용하여 반복
 * (3) 결제 금액이 부족한 경우 재입력을 통해 금액을 누적으로 계산하여 저장 후 결제
 * 
 * 혼자 개수 추가해보는 프로그램
 */
public class LunchOrderTestVer4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean menuFlag = true;
		int menu = -1;
		
		//주문 음식 리스트
		String[] menuList = {"햄버거(🍔)", "피  자(🍕)", "라  멘(🍜)", "샐러드(🥗)"};
		int[] priceList = {100, 200, 300, 400};
		int[] menuCountList = new int[4];			//메뉴 카운팅 배열
		
		//주문 리스트 선언 및 생성
		System.out.print("주문 리스트 크기 > ");
		final int MAX_SIZE = scan.nextInt();
		String[] orderMenuList = new String[MAX_SIZE];
		int[] orderPriceList = new int[MAX_SIZE];
		int count = 0;
		
		//결제 리스트 선언 및 생성
		String[] paymentNameList = new String[10];	//여기서 10은 결제 리스트에 저장 될 수 있는 최대 숫자
		int[][] paymentPriceList = new int[10][3];	//여기서 3은 가격, 입금액, 잔돈 이렇게 3개
		int paymentCount = 0;
		
				
		System.out.println("*******************************************");
		System.out.println("\tWelcome to Food Mart!!!");
		System.out.println("*******************************************");
		System.out.println("\t1. 음식 주문");		
		System.out.println("\t2. 주문 내역");		
		System.out.println("\t3. 음식 결제");		
		System.out.println("\t4. 결제 내역");		
		System.out.println("\t9. 프로그램 종료");		
		System.out.println("*******************************************");
		
		while(menuFlag) {
			System.out.print("메뉴 > ");
			menu = scan.nextInt();
			switch(menu) {
				case 1 :	//음식 주문
					if(count == MAX_SIZE) {		//주문을 이미 최대치까지 받았을 경우 
						System.out.println("=> 주문은 최대 " + MAX_SIZE + "개까지 가능! 결제 먼저 해주세요");
						break;
					}
					boolean orderFlag = true;
					while(orderFlag) {		
						System.out.println("*******************************************");
						System.out.println("\t1. 햄버거(🍔):100\t2. 피자(🍕):200");		
						System.out.println("\t3. 라멘(🍜):300\t4. 샐러드(🥗):400");		
						System.out.println("*******************************************");
						System.out.print("주문 메뉴(숫자로) > ");
						if(scan.hasNextInt()){
							int menuNo = scan.nextInt();
							
//							if(1<=menuNo && menuNo<=4) {	//주문 메뉴 선택
//								orderMenuList[count] = menuList[menuNo-1];
//								orderPriceList[count] = priceList[menuNo-1];
//								
//								System.out.println(orderMenuList[count] + " 주문 완료");
//								count++;
//							}else {
//									System.out.println("메뉴 준비중 입니다.");
//							}
							
							switch(menuNo) {				//주문 메뉴 선택
								case 1:	
									orderMenuList[count] = menuList[menuNo-1];
									orderPriceList[count] = priceList[menuNo-1];
									menuCountList[0] += 1;
									break;
								case 2:	
									orderMenuList[count] = menuList[menuNo-1];
									orderPriceList[count] = priceList[menuNo-1];
									menuCountList[1] += 1;
									break;
								case 3:	
									orderMenuList[count] = menuList[menuNo-1];
									orderPriceList[count] = priceList[menuNo-1];
									menuCountList[2] += 1;
									break;
								case 4:	
									orderMenuList[count] = menuList[menuNo-1];
									orderPriceList[count] = priceList[menuNo-1];
									menuCountList[3] += 1;
									break;
								default : 
									System.out.println("메뉴 준비중 입니다.");
							}//switch
							count++;
							//주문 개수 체크
							if(count == MAX_SIZE) {		//사실 이걸 위로 옮겨야 count값이 MAX_SIZE값이 되었을 때 메뉴에서 다시 주문으로 못 들어옴
								System.out.println("=> 주문은 최대 " + MAX_SIZE + "개까지 가능!!!!!");
								orderFlag = false;
							} else {
								System.out.print("계속 주문?(계속:아무키나, 종료:n)");
								if(scan.next().equals("n")) {		//여기서 scan에 변수 선언을 하지 않는 이유는 다른곳에서 쓸 일이 없기 때문
									orderFlag = false;
								}
							}
							
//							System.out.println("주문하신 메뉴는 " + menuName + ", 가격은 " + menuPrice + "원 입니다.");
							
							
						} else{
							System.out.println("올바르지 않은 입력값입니다. 다시 입력해주세요");
							scan.next();	//작업의 끝을 위해서 scan값을 초기화
						}	//if(scan.hasNextInt())
					}//while(orderFlag)

					break;
				case 2 :	//음식 주문 리스트
					int total = 0;
					if(count != 0) {
						System.out.println("----------------------------------------------");
						for(int i=0; i<3; i++) {
							if(menuCountList[i]!=0) {
								System.out.print(orderMenuList[i] + " " + menuCountList[i] + "개 ");
								total += orderPriceList[i] * menuCountList[i];
							}
						}
						System.out.println();
						System.out.println("총 가격 : " + total);
						System.out.println("----------------------------------------------");
					} else {
						System.out.println("주문하신 메뉴가 없습니다. 주문을 먼저 해주세요");
					}
					break;
				case 3 : 	//음식 결제
					if(count !=0) {
						boolean paymentFlag = true;
						int totalPayment = 0;
						int charge = 0;
						int change = 0;
						
						for(int i=0; i<count; i++) {
							totalPayment += orderPriceList[i];
						}
						
						while(paymentFlag) {	//결제 요금 부족시 반복 실행
							System.out.println("=> 결제 예정 금액 : " + totalPayment);
							System.out.print("결제할 요금 입력 > ");
							
							if(scan.hasNextInt()) {
								charge += scan.nextInt();
								System.out.println("총 입력 금액 : " + charge);
								if(charge >= totalPayment) {
									change = charge - totalPayment;
									paymentFlag = false;
								}else {
									System.out.println("요금이 부족합니다. 다시 입력해주세요");
								}
							} else {
								System.out.println("올바르지 않은 입력값입니다. 다시 입력해주세요");
								scan.next();
							}	//if(scan.hasNextInt())			
						}//while
						
						//paymentNameList, paymentPriceList에 값 넣기
						paymentNameList[paymentCount] = orderMenuList[0] + "등..";	//결제 내역 리스트에 첫번째 메뉴 + 등..
						paymentPriceList[paymentCount][0] = totalPayment;			//첫번째 위치에 결제 예정 금액
						paymentPriceList[paymentCount][1] = charge;					//두번째 위치에 결제 금액
						paymentPriceList[paymentCount][2] = change;					//세번째 위치에 잔돈
						
						System.out.println("=> 결제 완료");
						//결제 내역 리스트
						System.out.println("------------------------------------------------");
						System.out.println("메뉴명\t\t가격\t입금액\t잔돈");
						System.out.println("------------------------------------------------");
						System.out.print(paymentNameList[paymentCount] + "\t");
						for(int j=0; j<3; j++) {
							System.out.print(paymentPriceList[paymentCount][j] + "\t");
						}
						System.out.println();
						System.out.println("------------------------------------------------");
						
						
						//orderMenuList, orderPriceList 초기화
						for(int i=0; i<count; i++) {			//기존 배열에 초기값을 선언
							orderMenuList[i] = null;
							orderPriceList[i] = 0;
							menuCountList[i] = 0;
							
						}
//						orderMenuList = new String[MAX_SIZE];	//새로운 배열은 선언
//						orderPriceList = new int[MAX_SIZE];
						
						count = 0;
						paymentCount++;
					} else {
						System.out.println("주문하신 메뉴가 없습니다. 주문을 먼저 해주세요");
					}
					break;
				case 4 :
					if(paymentCount != 0) {
						System.out.println("------------------------------------------------");
						System.out.println("No\t메뉴명\t\t가격\t입금액\t잔돈");
						System.out.println("------------------------------------------------");
						for(int i=0; i<paymentCount; i++) {
							System.out.print((i+1) + "\t" + paymentNameList[i] + "\t");
							for(int j=0; j<3; j++) {
								System.out.print(paymentPriceList[i][j] + "\t");
							}
							System.out.println();
						}
						System.out.println("------------------------------------------------");
					} else {
						System.out.println("결제 내역이 없습니다.");
					}
					break;
				case 9 : 
					System.out.println("프로그램을 종료합니다.");
					menuFlag = false;
					break;
				default : 
					System.out.println("=> 메뉴 준비중!!!");
			}
		}//while(menuFlag)
		
		
		
	}//main

}
