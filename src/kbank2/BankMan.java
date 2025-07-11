package kbank2;

public class BankMan {
	//Field
	String name;
	private AccountPaperVo accountPaper;
	private AccountVo[] accountList;
	private BankSystem kbsystem;
	int checkResult;
	
	public static final int ACCOUNT_NAME = 1;
	public static final int ACCOUNT_NUMBER = 2;
	public static final int ACCOUNT_PASSWORD = 3;
	public static final int ACCOUNT_MONEY = 4;
	
	//Constructor
	public BankMan() {
		
	}
	public BankMan(String name, BankSystem kbsystem) {
		this.name = "[은행직원 : " + name + "]";
		this.kbsystem = kbsystem;
		System.out.println(this.name + " 업무 시작");
	}
	
	//Method
	/**
	 * 고객의 출금정보 유효성 체크 결과에 따라 질문
	 */
	public void ask(int status) {
		switch(status) {
			case ACCOUNT_NAME :
				System.out.println(this.name + " 이름을 입력해주세요");
				checkResult = ACCOUNT_NAME;
				break;
			case ACCOUNT_NUMBER:
				System.out.println(this.name + " 계좌번호를 입력해주세요");
				checkResult = ACCOUNT_NUMBER;
				break;
			case ACCOUNT_PASSWORD:
				System.out.println(this.name + " 패스워드를 입력해주세요");
				checkResult = ACCOUNT_PASSWORD;
				break;
			case ACCOUNT_MONEY:
				System.out.println(this.name + " 금액을 입력해주세요");
				checkResult = ACCOUNT_MONEY;
				break;
		
		}
	}
	
	/**
	 * 고객의 출금정보 유효성 체크 : 고객에게 전달받은 출금용지에 빈값이 있는지 체크!
	 */
	public void vaildateCheck() {
		System.out.println(this.name + " 고객 정보에 대한 유효성 체크를 진행한다.");
		if(accountPaper.getName() == null) {
			ask(ACCOUNT_NAME);
		} else if(accountPaper.getAccountNumber() == null) {
			ask(ACCOUNT_NUMBER);
		} else if(accountPaper.getPassword() == null) {
			ask(ACCOUNT_PASSWORD);
		} else if(accountPaper.getMoney() == 0) {
			ask(ACCOUNT_MONEY);
		} else {
			//모두 입력되어 있음
			System.out.println("모두 입력");
		}
	}
	
	public boolean vaildateCheck(AccountPaperVo updateAccountPaper) {
		boolean result = false;
		System.out.println(this.name + " 고객 정보에 대한 유효성 체크를 재진행한다.");
		this.accountPaper = updateAccountPaper;
		if(accountPaper.getName() == null) {
			ask(ACCOUNT_NAME);
		} else if(accountPaper.getAccountNumber() == null) {
			ask(ACCOUNT_NUMBER);
		} else if(accountPaper.getPassword() == null) {
			ask(ACCOUNT_PASSWORD);
		} else if(accountPaper.getMoney() == 0) {
			ask(ACCOUNT_MONEY);
		} else {
			//모두 입력되어 있음
			System.out.println("모두 입력");
			result = true;
		}
		return result;
	}
	
	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}
	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
		System.out.println(this.name + " 고객에게 출금용지 받음!");
	}
	public AccountVo[] getAccountList() {
		return accountList;
	}
	public void setAccountList(AccountVo[] accountList) {
		this.accountList = accountList;
	}
	public BankSystem getKbsystem() {
		return kbsystem;
	}
	public void setKbsystem(BankSystem kbsystem) {
		this.kbsystem = kbsystem;
	}
	/**
	 * 출금 요청 처리
	 */
	public void processWithdrawal() {
		System.out.println(this.name + " 출금요청 처리 진행 중입니다. 잠시만 기다려주세요");
		//고객계정 검색 - BankSystem > 잔고-금액
	}
	
	
//	public void createAccountList() {
//		String[] names = {"홍길동", "이순신", "김유신"};
//		String[] numbers = {"k-1234", "k-3456", "k-7890"};
//		String[] passwords = {"1234", "3456", "5678"};
//		int[] totalMoney = {500, 1000, 700};
//		accountList = new AccountVo[names.length];
//		for(int i=0; i<names.length; i++) {
//			AccountVo account = new AccountVo();
//			account.setName(names[i]);
//			account.setAccountNumber(numbers[i]);
//			account.setPassword(passwords[i]);
//			account.setMoney(totalMoney[i]);
//			accountList[i] = account;
//		}
//	}
	
	
	
}
