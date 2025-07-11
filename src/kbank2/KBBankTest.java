package kbank2;

public class KBBankTest {

	public static void main(String[] args) {
		BankSystem kbsystem = new BankSystem("KB");
		kbsystem.showAccountList();		//은행시스템 확인
		//입출금 용지 한장 비치됨
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();		//싱글톤
		
		BankMan staffPark = new BankMan("박보검", kbsystem);	//은행직원 생성시 고객리스트 정보 가짐
		
		Customer hong = new Customer("홍길동", "kb-1234", "1234", 0);
		boolean validateFlag = true;
		hong.setAccountPaper(accountPaper);
//		hong.getAccountPaper().showInfo();	//static이라 이렇게 쓸필요없다고 노란 메세지 뜸
		
		//은행직원이 고객의 용지를 받는다.
		staffPark.setAccountPaper(hong.getAccountPaper());
		staffPark.vaildateCheck();		//고객에게 전달받은 출금용지에 빈값이 있는지 체크!
//		hong.answer(staffPark.checkResult);
		AccountPaperVo.showInfo();
		while(validateFlag) {
			if(staffPark.vaildateCheck(hong.answer(staffPark.checkResult))) {		//고객에게 전달받은 출금용지에 빈값이 있는지 체크!
				validateFlag = false;
			}
		}
		AccountPaperVo.showInfo();
		
		staffPark.processWithdrawal();
//		kbsystem.showAccountList();
		
		kbsystem.confirmBalace(hong.getAccountPaper());		//은행시스템을 이용하여 잔액을 확인
	}

}
