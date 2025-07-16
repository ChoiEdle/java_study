package chapter12;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap map = new HashMap();				//이것도 제너릭 설정을 안해줘서 노란불이 들어오는듯
		HashMap<String, String> map2 = new HashMap<String, String>();
		
		map2.put("name", "hong");
		map2.put("age", "10");
		
		map.put("name", "홍길동");
		map.put("age", 10);
		map.put("scan", new Scanner(System.in));
		
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map.get("scan"));
		
		
		
	}

}
