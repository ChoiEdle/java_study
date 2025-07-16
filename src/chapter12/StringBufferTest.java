package chapter12;

public class StringBufferTest {

	public static void main(String[] args) {
		String str = "홍길동";			
		System.out.println(System.identityHashCode(str));
		str = str + "은 자바를";			
		System.out.println(System.identityHashCode(str));
		str = str + " 열심히 공부한다.";	
		System.out.println(System.identityHashCode(str));	//매번 heap에 새로 생성해서 새로운 주소값을 줌
		System.out.println(str);
		
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.capacity());		//따로 주지 않으면 초기값은 16
		sb.append("홍길동");
		System.out.println(System.identityHashCode(sb));	
		sb.append("은 자바를");
		System.out.println(System.identityHashCode(sb));	
		sb.append(" 열심히 공부한다.");
		System.out.println(System.identityHashCode(sb));	//StringBuffer는 메모리 효율성을 위해서 사용함, 저장공간을 따로 만들어 놓고 값만 추가하는 방법
		System.out.println(sb);
		
	}

}
