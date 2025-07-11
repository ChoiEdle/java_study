package kbank2;

public class KBBankTest {

	public static void main(String[] args) {
		BankSystem kbsystem = new BankSystem("KB");
		//입출금 용지 한장 비치됨
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();		//싱글톤
		
		BankMan staffPark = new BankMan("박보검", kbsystem);	//은행직원 생성시 고객리스트 정보 가짐
		staffPark.kbsystem.showAccountList();
		
		Customer hong = new Customer("홍길동", "kb-1234", "1234", 100);
		hong.setAccountPaper(accountPaper);
		
		
	}

}
