package kbank;

public class KBBank {

	public static void main(String[] args) {
		Customer customer = new Customer("홍길동");
		BankMan bankMan = new BankMan("박보검"); 
		customer.giveMoney(bankMan.pushMoney());	//직원이 건낸 돈을 고객이 받아감
	}

}
