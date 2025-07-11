package kbank2;

public class KBBankTest {

	public static void main(String[] args) {
		BankSystem kbsystem = new BankSystem("KB");
		kbsystem.showAccountList();		//dmsgodtltmxpa ghkrdls
		//입출금 용지 한장 비치됨
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();		//싱글톤
		
		BankMan staffPark = new BankMan("박보검", kbsystem);	//은행직원 생성시 고객리스트 정보 가짐
		
		Customer hong = new Customer("홍길동", null, "1234", 100);
		hong.setAccountPaper(accountPaper);
//		hong.getAccountPaper().showInfo();	//static이라 이렇게 쓸필요없다고 노란 메세지 뜸
//		AccountPaperVo.showInfo();
		
		//은행직원이 고객의 용지를 받는다.
		staffPark.setAccountPaper(hong.getAccountPaper());
		staffPark.vaildateCheck();		//고객에게 전달받은 출금용지에 빈값이 있는지 체크!
		
		
	}

}
