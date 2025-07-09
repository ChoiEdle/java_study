package vending_machine_ver2;

import java.util.Scanner;

public class User {
	//Field
	//이름, 입력을 위한 스케너 객체
	String name;
	Scanner scan;
	
	//Constructor
	public User() {
		scan = new Scanner(System.in);
	}
	
	//Method
	//getter 메소드 생성
	public String getName() {
		return name;
	}
	
	public Scanner getScan() {
		return scan;
	}
	
}
