package chapter03;
/*
 * 제어 문자 실습
 */
public class EscapeTest {

	public static void main(String[] args) {
		String greet = "안녕하세요~\n\n반갑습니다.\t\t홍길동입니다.";
		String name = "\'홍길동\'";	// '홍길동' 해도 나오긴 하는데 다른 프로그램 같은 곳에서 에러날 수 있음
		String name2 = "\"홍길동\"";	// "홍길동" 은 안됨
		
		System.out.println(greet);
		System.out.println(name);
		System.out.println(name2);
		
	}

}
