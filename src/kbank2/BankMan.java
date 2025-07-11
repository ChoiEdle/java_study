package kbank2;

public class BankMan {
	//Field
	String name;
	AccountPaperVo accountPaper;
	AccountVo[] accountList;
	BankSystem kbsystem;
	
	
	//Constructor
	public BankMan() {
		
	}
	public BankMan(String name, BankSystem kbsystem) {
		this.name = name;
		this.kbsystem = kbsystem;
		createAccountList();
	}
	
	
	//Method
	public void createAccountList() {
		String[] names = {"홍길동", "이순신", "김유신"};
		String[] numbers = {"k-1234", "k-3456", "k-7890"};
		String[] passwords = {"1234", "3456", "5678"};
		int[] totalMoney = {500, 1000, 700};
		accountList = new AccountVo[names.length];
		for(int i=0; i<names.length; i++) {
			AccountVo account = new AccountVo();
			account.setName(names[i]);
			account.setAccountNumber(numbers[i]);
			account.setPassword(passwords[i]);
			account.setMoney(totalMoney[i]);
			accountList[i] = account;
		}
	}
	
	
	
}
