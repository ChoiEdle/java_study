package chapter07;

public class AnimalAccessModifier {
	//Field
	String name;				//같은 패키지에서만 접근 가능
	int age;					//같은 패키지에서만 접근 가능
	private String pname;		//같은 클래스 내부에서만 접근 가능
	private int page;			//같은 클래스 내부에서만 접근 가능
	
	static String sname;		//클래스 변수, static 변수
	static int sage;
	
	final String fname = "홍길동";		//final 키워드 적용 => 외부에서 값을 변경할 수 없음!!
	final int fage = 10;
	
	//상수 정의
	public static final int START = 0;
	static final public int CONTINUE = 1;
	final public static int END = -1;
	
	//Constructor
	public AnimalAccessModifier() {
	}
	public AnimalAccessModifier(String pname, int page) {
		this.pname = pname;
		this.page = page;
	}
	
	//Method
	//static method
	void getInfo() {			//같은 패키지에서만 호출 가능
		System.out.println(pname + ", " + page);
	}
	public void getInfo2() {	//모든 클래스에서 호출 가능
		System.out.println(pname + ", " + page);
	}
	static public void getInfo3() {	//모든 클래스에서 호출 가능	//static 메소드, 클래스 메소드
		System.out.println(sname + ", " + sage);		//sname과 getInfor3은 같은 메모리에 없었어서 에러가 났었음
	}
	
	//getter/setter
	public String getPname() {
		return pname;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
}
