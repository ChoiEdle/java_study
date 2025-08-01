package com.bookmgm.application;

import java.util.Scanner;

import com.bookmgm.service.BookService;
import com.bookmgm.service.DefaultBookService;

public class BookManagementApplication {
	public static final int REGISTER = 1;
	public static final int LIST = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int DELETE = 5;
	public static final int EXIT = 6;
	public static final int CHANGE = 99;
	public Scanner scan;
	public BookService service;
	
	public BookManagementApplication() {
		scan = new Scanner(System.in);
		service = new DefaultBookService(this);
		showMenu();
	}
	
	
	
	/**
	 * 메뉴 출력
	 */
	public void showMenu() {
		//배열을 이용하여 메뉴 출력
		String[] labels = {"도서 등록", "도서 목록 조회", "도서 검색", "도서 수정", "도서 삭제", "종료"};
		
		System.out.println("==== 📕📖📚 도서 관리 프로그램 📕📖📚 ====");
		System.out.println("전체 도서수 : " + service.getCount());
		System.out.println("-----------------------------------------");
		for(int i=0; i<labels.length; i++) {
			System.out.println((i+1) + ". " + labels[i]);
		}
		System.out.println("-----------------------------------------");
		
		selectMenu();
	}
	
	/**
	 * 메뉴 선택
	 */
	public void selectMenu() {
		System.out.print("메뉴(숫자) > ");
		if(scan.hasNextInt()) {
			int menu = scan.nextInt();
			switch(menu) {
				case REGISTER : 
					service.register();
					break;
				case LIST :
					service.list();
					break;
				case SEARCH : 
					service.search();
					break;
				case UPDATE : 
					service.update();
					break;
				case DELETE : 
					service.delete();
					break;
				case EXIT : 
					service.exit();
					break;
				case CHANGE : 
					service.libraryChange();
					break;
				default :
					System.out.println("=> 메뉴 준비중 입니다.");
					selectMenu();
			}
		} else {
			System.out.println("=> 옳바르지 않은 형식입니다. 다시 입력해주세요.");
			scan.next();
			selectMenu();
		}
	}
	
	public static void main(String[] args) {
		new BookManagementApplication();
	}

}
