package kbank;

import chapter07.Singleton;

public class AccountPaperVo {
	//Field
	private String name;
	private int addr;
	private int pwd;
	private int inOutMoney;
	static AccountPaperVo accountPaperVo = new AccountPaperVo();
		
	//Constructor
	private AccountPaperVo() {
		
	}

	//Method
	public static AccountPaperVo getInstance() {
		return accountPaperVo;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAddr() {
		return addr;
	}

	public void setAddr(int addr) {
		this.addr = addr;
	}

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

	public int getInOutMoney() {
		return inOutMoney;
	}

	public void setInOutMoney(int inOutMoney) {
		this.inOutMoney = inOutMoney;
	}

}
