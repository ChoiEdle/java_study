package chapter05;

import java.util.Scanner;

/*
 * [시작]
 * *
 * **
 * ***
 * ****
 * *****
 * [종료]
 */
public class ForOverlabStarTest {

	public static void main(String[] args) {
		int end = 0;
		
		Scanner scan = new Scanner(System.in);
		
		end = scan.nextInt();
		
		for(int i=1;i<=end;i++) {	//행
			for(int j=1;j<=i;j++) {	//열	
				if(i>=j) {
					System.out.print("🌭");
					
				}
			}
			System.out.println();
		}
		
		
	}

}


