package chapter13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set 인터페이스
 */
public class SetTest {

	public static void main(String[] args) {
		Set<String> foods = new HashSet<String>();
		
		//1. 데이터 저장 : C(Create)
		foods.add("된장찌개");
		foods.add("김치찌개");
		foods.add("짜장면");
//		foods.add("짜장면");		//중복 데이터 저장X
		
		//2. 데이터 출력 : R(Read)
		foods.forEach(System.out::println);
		System.out.println();
		
		//3. 데이터 수정 : U(Update)
		//짜장면 --> 짬뽕
		if(foods.contains("짜장면")) foods.remove("짜장면");		//contains는 매개변수가 있는지 확인하고 boolean타입으로 리턴해주는 메소드
		foods.add("짬뽕");
		foods.forEach(System.out::println);
		System.out.println();
		
		//4. 데이터 삭제 : D(Delete)
		//김치찌개 삭제
		Iterator ie = foods.iterator();		//이건 index가 문제 일으킬게 없어서 그냥 remove 많이 사용한다고 함
		while(ie.hasNext()) {
			String str = (String)ie.next();		//제너릭으로 타입을 제한하지 않으면 Object 타입으로 생성됨
			if(str.equals("김치찌개")) {
				ie.remove();
			}
		}
		foods.forEach(System.out::println);
		System.out.println();
		
		
	}

}
