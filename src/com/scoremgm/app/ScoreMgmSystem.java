package com.scoremgm.app;
/**
 * 메뉴 생성 및 출력
 */
public class ScoreMgmSystem {
	//Field
	
	//Constructor
	public ScoreMgmSystem() {
		showMenu();
	}
	
	//Method
	/**
	 * 메뉴 출력
	 */
	public void showMenu() {
		System.out.println("===== 학생 성적 관리 시스템 =====");
		System.out.println("1. 등록");
		System.out.println("2. 조회");
		System.out.println("3. 검색");
		System.out.println("4. 수정");
		System.out.println("5. 삭제");
		System.out.println("6. 종료");
	}
	
}
