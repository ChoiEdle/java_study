package chapter07;

public class Student {
	//Field : 멤버변수, 전역변수
	String name;
	int kor, eng, math; 
//	int tot = kor+eng+math;
//	int avg = tot/3;

	//Constructor
	public Student() {
		
	}
	//Method
	public int getTot() {
		return kor + eng + math;
	}
	
	public int getAvg() {
		return (kor + eng + math)/3;
	}
}


/*
[클래스명 : Student]
Field : name:String, kor:int, eng:int, math:int
Constructor : Student()
Method : 
*/