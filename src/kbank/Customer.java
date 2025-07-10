package kbank;

public class Customer {
	//Field
	String name;
	AccountPaperVo accountPaperVo = AccountPaperVo.getInstance();
	int haveMoney;
	
	//Constructor
	public Customer() {
		
	}
	
	public Customer(String name) {
		this.name = name;
		moving();
	}
	
	//Method
	//출금용지 작성, 돈 받기	
	public void moving() {		//출금용지 작성
		accountPaperVo.setName("홍길동");
		accountPaperVo.setAddr(2222);
		accountPaperVo.setPwd(3333);
		accountPaperVo.setInOutMoney(1000000);
	}
	
	public void giveMoney(int moveMoney) {	//직원이 건내준 금액 수령
		haveMoney = moveMoney;
		System.out.println("어예 " + haveMoney + "원 겟");
	}
}
