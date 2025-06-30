package chapter06;

public class MultipleArrayTest02 {

	public static void main(String[] args) {
		//가변형 배열 생성 : 3행의 구조에 열은 1부터 하나씩 증가하는 구조
		int[][] matrix = new int[5][];
		int[][] matrix2 = new int[3][];
		
		matrix[0] = new int[1];		
		matrix[1] = new int[2];
		matrix[2] = new int[3];
		matrix[3] = new int[2];
		matrix[4] = new int[1];
		
		int count = 1;	//증감을 해줄 변수 선언
		
		for(int i=0; i<matrix2.length; i++) {	
			matrix2[i] = new int[i+1];
			for(int j=0; j<matrix2[i].length; j++) {
				matrix2[i][j] = count;
				count++;
			}
		}
		
		count = 10;		//초기화
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = count;
				count += 10;
				System.out.print(i + ", " + j + " = " + matrix[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("----------------------------------------------------");
		for(int i=0; i<matrix2.length; i++) {
			for(int j=0; j<matrix2[i].length; j++) {
				System.out.print(i + ", " + j + " = " + matrix2[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
