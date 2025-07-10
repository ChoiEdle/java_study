package kbank;

public class BankMan {
	//Field
	String name;
	AccountPaperVo accountPaperVo = AccountPaperVo.getInstance();
	AccountVo accountVo = AccountVo.getInstance();
	int trueMoney;
	
	//Constructor
	public BankMan() {
		
	}
	public BankMan(String name) {
		this.name = name;
		checkPaper();
	}
	
	
	//Method
	//출금용지 확인, 출금, 계좌에 잔금 수정
	public void checkPaper() {
		int inOutMoney = accountPaperVo.getInOutMoney();
		int totalMoney = accountVo.getTotalMoney();
		boolean check1 = accountPaperVo.getName().equals(accountVo.getName());
		boolean check2 = accountPaperVo.getAddr()==accountVo.getAddr();
		boolean check3 = accountPaperVo.getPwd()==accountVo.getPwd();
		boolean check4 = inOutMoney<=totalMoney;
		if(check1 && check2 && check3 && check4) {
			System.out.println(inOutMoney + " 원 출금 가능!");
			trueMoney = inOutMoney;
			totalMoney -= inOutMoney;
			accountVo.setTotalMoney(totalMoney);
			System.out.println("잔액 : " + totalMoney + " 원");
		} else {
			System.out.println("이름, 계좌번호, 비밀번호가 틀렸거나 잔액이 부족합니다.");
		}
	}
	
	public int pushMoney() {
		System.out.println("여기 출금액 : " + trueMoney + "원, 잔액 : " + accountVo.getTotalMoney() + "원 입니다.");
		return trueMoney;
	}
}
