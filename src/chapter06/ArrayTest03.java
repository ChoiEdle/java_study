package chapter06;

public class ArrayTest03 {

	public static void main(String[] args) {
		//배열 객체 선언 - 1에서 5까지의 데이터를 저장 후 순서대로 출력
		int[] numbers = new int[15];	//배열의 전체 크기 : 변수명.length
		
		//데이터 저장
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = i + 1;		//numbers[0] = 1; ...
		}

//		numbers[0] = 1; 
//		numbers[1] = 2; 
//		numbers[2] = 3; 
//		numbers[3] = 4; 
//		numbers[4] = 5; 

		//데이터 출력
		for(int i=0; i<numbers.length; i++) {
			System.out.println(numbers[i]);			
		}
		
//		System.out.println(numbers[0]);			
//		System.out.println(numbers[1]);			
//		System.out.println(numbers[2]);			
//		System.out.println(numbers[3]);			
//		System.out.println(numbers[4]);			
		
	}

}
