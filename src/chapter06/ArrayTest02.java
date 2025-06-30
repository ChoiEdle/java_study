package chapter06;

public class ArrayTest02 {

	public static void main(String[] args) {
		//names 문자열 변수 선언 및 생성
		String[] names;
		String names2[];
		
		names = new String[3];
		names2 = new String[5];
		
		int[] scores = new int[10];
		int scores2[] = new int[10];	//앞에 선언한 변수 형태와 뒤에 변수형태가 같아야함
		int scores3[] = {10, 20, 30};
		String[] names3 = {"홍길동", "홍길순"};

		System.out.println(names);		//주소값을 보여줌, 실제 주소값은 아님(실제는 2진법)
		System.out.println(names2);
		System.out.println(names3);
		
		
	}

}
