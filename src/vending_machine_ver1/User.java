package vending_machine_ver1;

import java.util.Scanner;

public class User {
	//Field
	String name;
	Scanner scan;
	
	//Constructor
	public User() {
		this("아무개");
	}
	
	public User(String name) {
		this.name = name;
		scan = new Scanner(System.in);
	}
	
	//Method
//	public boolean coinCheck(int coin) {
//		boolean result = false;
//		if(coin == 100 || coin == 500)
//		return result;
//	}
	
	public int insertCoin() {
		int menu = 0;
		System.out.print("["+name+"]동전 > ");
		if(scan.hasNextInt()) {
			menu = scan.nextInt();
		} else {
			System.out.println("=> 올바르지 않은 값, 다시 입력해주세요.");
			scan.next();
			insertCoin();
		}
		return menu;
	}
	
	public int selectMenu() {
		int menu = 0;
		System.out.print("["+name+"]메뉴선택 > ");
		if(scan.hasNextInt()) {
			menu = scan.nextInt();
		} else {
			System.out.println("=> 올바르지 않은 값, 다시 입력해주세요.");
			scan.next();
			insertCoin();
		}
		return menu;
	}
	
	
	
}
