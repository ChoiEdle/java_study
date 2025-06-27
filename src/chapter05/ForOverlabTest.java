package chapter05;

import java.util.Scanner;

/*
 * 중첩for문
 */
public class ForOverlabTest {

	public static void main(String[] args) {
		//2단 ~ 5단
		Scanner scan = new Scanner(System.in);
		int start = 0, end = 0;
		boolean flag = true;	//boolean 변수로는 보통 flag를 사용
		
	
		while(flag) {
			System.out.print("start > ");
			start = scan.nextInt();
			
			System.out.print("end > ");
			end = scan.nextInt();
			
			//실행여부 체크
			
			if(start==0 && end==0) {
				//while 블록을 빠져 나간 후 종료
				flag = false;
			} else {
				for(int i=1; i<=9; i++) {		//아우터는 행
					for(int j=start; j<=end; j++) {	//이너는 열
						System.out.print(j + " X " + i + " = " + (i*j) + "\t");
					}
					System.out.println("");
				}//for				
				System.out.println("프로그램 종료 : start, end 모두 0 입력");
			}//else
		}//while
		
		System.out.println("-- 프로그램 종료 --");
		System.exit(0);
		
	}

}
