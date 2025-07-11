package kbank2;

public class BankMan {
	//Field
	String name;
	private AccountPaperVo accountPaper;
	private AccountVo[] accountList;
	private BankSystem kbsystem;
	
	
	//Constructor
	public BankMan() {
		
	}
	public BankMan(String name, BankSystem kbsystem) {
		this.name = name;
		this.kbsystem = kbsystem;
	}
	
	//Method
	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}
	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
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
