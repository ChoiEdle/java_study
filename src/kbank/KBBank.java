package kbank;

public class KBBank {

	public static void main(String[] args) {
		Customer customer = new Customer("홍길동");
		BankMan bankMan = new BankMan("박보검"); 
		int moveMoney = bankMan.pushMoney();
		customer.giveMoney(moveMoney);
	}

}
