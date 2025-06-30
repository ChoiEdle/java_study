package chapter06;

import java.util.Arrays;

/*
 * 배열 복사 : for, System.arrayCopy(), Arrays.copyOf()
 */
public class ArrayCopyTest {

	public static void main(String[] args) {
		int[] arrInt = {1,2,3};
		int[] arrInt2 = new int[5];
		int[] arrInt3 = new int[3];		//System.arrayCopy()
//		int[] arrInt4 = new int[3];		//Array.copyOf()
		
		//1. for
		for(int i=0; i<arrInt.length; i++) {
			arrInt2[i] = arrInt[i];
		}
		
		for(int i=0; i<arrInt2.length; i++) System.out.print(arrInt2[i] + "\t");
		
		System.out.println();
		
		//2. System.arrayCopy
		System.arraycopy(arrInt, 0, arrInt3, 0, arrInt.length);		//System.arraycopy(원본, 원본시작점, 복제본, 복제본시작점, 길이);
		for(int i=0; i<arrInt3.length; i++) System.out.print(arrInt3[i] + "\t");
		
		System.out.println();

		//3. Array.copyOf()
		int[] arrInt4 = Arrays.copyOf(arrInt, arrInt.length);		//int[] 복제본이름 = Arrays.copyOf(원본, 원본의복사할길이)
		for(int i=0; i<arrInt4.length; i++) System.out.print(arrInt4[i] + "\t");
		
	}

}
