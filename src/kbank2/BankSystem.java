package kbank2;

public class BankSystem {
	//Field
	String name;
	AccountVo[] accountList;
	
	
	//Constructor
	public BankSystem() {
		
	}
	public BankSystem(String name) {
		this.name = name;
		//은행 고객 리스트 생성
		accountList = createAccountList();
	}
	
	//Method
	public AccountVo[] createAccountList() {
		String[] names = {"홍길동", "이순신", "김유신"};
		String[] numbers = {"kb-1234", "kb-9876", "kb-3456"};
		String[] passwords = {"1234", "9876", "3456"};
		int[] balance = {500, 1000, 700};
		AccountVo[] list = new AccountVo[names.length];
		
		for(int i=0; i<names.length; i++) {
			AccountVo account = new AccountVo();
			account.setName(names[i]);
			account.setAccountNumber(numbers[i]);
			account.setPassword(passwords[i]);
			account.setMoney(balance[i]);
			list[i] = account;
		}
		
		return list;
	}
	
	public void showAccountList() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\t" + name +" 고객 리스트");
		System.out.println("----------------------------------------------------------------------");
		for(int i=0; i<accountList.length; i++) {
			AccountVo account = accountList[i];
			System.out.print((i+1) + ".\t");
			System.out.print(account.getName() + "\t");
			System.out.print(account.getAccountNumber() + "\t");
			System.out.print(account.getPassword() + "\t");
			System.out.print(account.getMoney() + "\n");
		}
		System.out.println("----------------------------------------------------------------------");
	}
	
	public int searchAccount(AccountPaperVo accountPaper) {
		int result = -1;
		for(int i=0; i<accountList.length; i++) {
			AccountVo account = accountList[i];
			boolean check1 = account.getName().equals(accountPaper.getName());
			boolean check2 = account.getAccountNumber().equals(accountPaper.getAccountNumber());
			boolean check3 = account.getPassword().equals(accountPaper.getPassword());
			boolean check4 = accountList[i].getMoney()>=accountPaper.getMoney();
			if(check1 && check2 && check3 && check4) {
				result = i;
				break;
			} 
		}
		return result;
	}
	
	public void confirmBalace(AccountPaperVo accountPaper) {
		int result = -1;
		for(int i=0; i<accountList.length; i++) {
			AccountVo account = accountList[i];
			boolean check1 = account.getName().equals(accountPaper.getName());
			boolean check2 = account.getAccountNumber().equals(accountPaper.getAccountNumber());
			boolean check3 = account.getPassword().equals(accountPaper.getPassword());
			if(check1 && check2 && check3) {
				result = i;
				break;
			} else {
				System.out.println("[BankSystem] 일치하는 고객정보가 없습니다.");
			}
		}
		if(result != 1) {
			System.out.println("----------------------------------------------------------------------");
			System.out.print(accountList[result].getName() + "\t");
			System.out.print(accountList[result].getAccountNumber() + "\t");
			System.out.print(accountList[result].getPassword() + "\t");
			System.out.print(accountList[result].getMoney() + "\n");
			System.out.println("----------------------------------------------------------------------");
		}
		
	}
}
