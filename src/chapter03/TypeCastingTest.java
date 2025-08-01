package chapter03;
/*
 * 형변환 : 자동(묵시적) 형변환, 강제(명시적) 형변환
 */
public class TypeCastingTest {

	public static void main(String[] args) {
		//자동(묵시적) 형변환 : 작은 데이터 > 큰 데이터
		byte bdata = 1;
		short sdata = bdata;
		int idata = sdata;
		long ldata = idata;
		
		int number = 100;
		float fnumber = number; 	//같은 4btye지만 실수가 더 크기 때문에 
		
		char str = 'A';
		int strNumber = str;
		
		//강제(명시적) 형변환 : 큰 데이터 타입 > 작은 데이터 타입 // 데이터 유실 주의
		int inumber = 1234567890;
		byte bnumber = (byte)inumber;
		
		double dnumber = 12345.37;
		int inumber2 = (int)dnumber;
		
		System.out.println("-- 자동 형변환 --");
		System.out.println("" + ldata);
		System.out.println("" + fnumber);
		System.out.println("" + strNumber);
		System.out.println("\n-- 강제 형변환 --");
		System.out.println("" + bnumber);
		System.out.println("" + inumber2);

	}

}
