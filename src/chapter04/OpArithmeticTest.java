package chapter04;
/*
 * 사칙 연산자 : +, -, *, /, %
 */
public class OpArithmeticTest {

	public static void main(String[] args) {
		int number1 = 5;
		int number2 = 2;
		
		System.out.println(number1 + number2);
		System.out.println("number1 + number2 = " + (number1 + number2));	//앞에 문자열이 나오면 뒤에 나오는 +는 무조건 접합 연산자, 이를 막기 위해 괄호를 씀
		System.out.println("number1 - number2 = " + (number1 - number2));
		System.out.println("number1 * number2 = " + (number1 * number2));
		System.out.println("number1 / number2 = " + (number1 / number2));
		System.out.println("number1 % number2 = " + (number1 % number2));
		
		
		
	}

}
