package chapter05;

import java.util.Scanner;

public class GugudanVer1 {

	public static void main(String[] args) {
		//출력하는 구구단을 콘솔로 입력받아 실행
		Scanner scan = new Scanner(System.in);
		int dan = 0;			
		System.out.println("출력하실 구구단을 입력해주세요.");
		
		while(true) {
			System.out.print("dan(종료:0) > ");
			dan = scan.nextInt();
			
			if(dan != 0) {
				System.out.println("" + dan + "단");
				System.out.println("---------------------");
				for(int i=1; i<=9; i++) {
					System.out.println("" + dan + " × " + i + " = " + (dan*i));
				}	
			}else {
				System.out.println("구구단을 종료합니다.");
//				System.exit(0);		//나는 여기에 종료 명령어 말고 boolean값의 true를 갖는 변수로 선언해서 while조건식에 넣고 여기서 false로 변경하는 방식을 생각함
			}
		}//whhile
		
		
	}//main

}//class
