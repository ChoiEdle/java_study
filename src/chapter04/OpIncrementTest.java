package chapter04;
/*
 * 증감 연산자 : ++, --	//보통 제어문(for)과 씀
 */
public class OpIncrementTest {

	public static void main(String[] args) {
		int number = 10;
		
		System.out.println(++number);	//11, 더하고 나서 출력함
		System.out.println(number++);	//11, 출력하고 더함
		System.out.println(number);		//12
		
		System.out.println(--number);	//11, 빼고 나서 출력함
		System.out.println(number--);	//11, 출력하고 뺌
		System.out.println(number);		//10
	}

}
