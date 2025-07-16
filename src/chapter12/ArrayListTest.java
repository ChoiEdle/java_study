package chapter12;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.add("홍길동");
		list2.add(String.valueOf(123));
		list2.add(""+33);						//println처럼 맨앞에 문자열이 오면 뒤에는 자동으로 문자열 되나봄
		list2.set(0, "이순신");
		list2.add(1, "김유신");
		list2.remove(2);
		
		for(String str : list2) {
			System.out.println(str);
		}
		
		System.out.println(list.size());		//채워진 공간수 만큼 출력
		list.add(100);							//int		//노란불 들어오는 이유는 제너릭으로 타입 제한 하지 않아서
		list.add(new String("홍길동"));			//String
		list.add(123.456);						//double
		list.add(new Scanner(System.in));		//객체
		System.out.println(list.size());		//채워진 공간수 만큼 출력
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		
	}

}
