package chapter06;

public class ArrayTest05 {

	public static void main(String[] args) {
		 int[] nList = new int[3];
//		 nList[0] = "1";	//Type mismatch
		 nList[2] = 99;		//Runtime시에 ArrayIndexOutOfException 발생 
		 					//nLsit[3]이 있는지 없는지는 실행할때 확인하기 때문에 에러는 안뜸, ctra + f11로 실행하면 에러
		 
		 
		 
		 System.out.println(nList.hashCode());
		 System.out.println(nList[2]);
		
		 for(int i=0; i<nList.length; i++) {
			 System.out.println(nList[i]);
		 }
		 
		 
		 
		 
	}

}
