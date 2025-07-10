package kbank;

public class AccountVo {
	//Field
	private String name;
	private int addr;
	private int pwd;
	private int totalMoney;
	
	static AccountVo accountVo = new AccountVo();
	
	//Constructor
	private AccountVo() {
		this.name = "홍길동";
		this.addr = 2222;
		this.pwd = 3333;
		this.totalMoney = 5000000;
	}

	
	//Method
	public static AccountVo getInstance() {
		return accountVo;
	}
	
	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getName() {
		return name;
	}

	public int getAddr() {
		return addr;
	}

	public int getPwd() {
		return pwd;
	}

}
