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
	

		System.out.print("시작할 단 > ");
		start = scan.nextInt();
		
		System.out.print("끝낼 단 > ");
		end = scan.nextInt();
		
		
		for(int i=1; i<=9; i++) {		//아우터는 세로
			for(int j=start; j<=end; j++) {	//이너는 가로
				System.out.print(j + " X " + i + " = " + (i*j) + "\t");
			}
			System.out.println("");
		}
		
		
		scan.close();
	}

}
