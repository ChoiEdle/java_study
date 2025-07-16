package chapter12;

public class StringTest {

	public static void main(String[] args) {
		String name1 = "홍길동";				//stack에 잡히는 기본 데이터
		String name2 = new String("홍길동");	//heap에 있는 참조 데이터의 주소값
		String num = String.valueOf(123);
		
		System.out.println(num+10);
		System.out.println(System.identityHashCode(name1));
		System.out.println(System.identityHashCode(name2));
		
		if(name1 == name2) {
			System.out.println("동일");
		} else {
			System.out.println("다름");
		}
		
		if(name1.equals(name2)) {
			System.out.println("동일");
		} else {
			System.out.println("다름");
		}
		
		name2 = "welcomeToJava!!!";
		System.out.println(name2.toUpperCase());
		System.out.println(name2.toLowerCase());
		System.out.println(name2.length());				//String은 사실 배열로 문자 하나하나를 넣어두는 식이라 이게 된다고...
		System.out.println(name2.substring(7, 10));		//배열 순서 7부터 10전까지라는 의미
		
		String phone = "010-1234-5678";
		String[] phones = phone.split("-");				//split은 구분자()안의 문자를 기준으로 앞뒤로 나눠서 배열로 넣어줌
		System.out.println(phones[0]);
		System.out.println(phones[1]);
		System.out.println(phones[2]);
		
		String subject = "java,css,html,mysql";
		String[] subjects = subject.split(",");
		for(String a :subjects) {
			System.out.println(a);
		}
		
		String jphone = String.join(",", phones);		//split의 반대, 배열을 구분자를 넣어서 하나의 문자열로 만들어줌
		System.out.println(jphone);
		
		System.out.println(subject.contains("html"));	//contains()는 괄호안에 문자열이 포함되어있는지 boolean값으로 리턴해주는 메소드
		
	}

}
