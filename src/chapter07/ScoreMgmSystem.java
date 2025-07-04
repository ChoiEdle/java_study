package chapter07;
/*
 * - 학생 10명의 점수를 입력 받는다.
 * - 한 명 입력 후 계속 입력 여부를 메세지로 출력 후 입력 받는다.
 */
import java.util.Scanner;

public class ScoreMgmSystem {
	//Field
	String admin;
	Student student;
	
	Scanner scan = new Scanner(System.in);	//모든 메소드에서 다 써야해서 전역으로 뺌
	Student[] sList = new Student[10];
	int count = 0;
	
	//Constructor
	public ScoreMgmSystem() {
		
	}
	
	//Method
	//메뉴 선택
	public void showMenu() {
		System.out.println("-------------------------------------------------");
		System.out.println("\t더조은 고등학교 1-1 성적관리 프로그램");
		System.out.println("-------------------------------------------------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 리스트 출력");
		System.out.println("3. 학생 성적 검색");
		System.out.println("4. 학생 성적 수정");
		System.out.println("5. 학생 삭제");
		System.out.println("9. 프로그램 종료 ");
		System.out.println("-------------------------------------------------");
		System.out.print("메뉴 선택(숫자)> ");
//		int menu = scan.nextInt();
//		choiceMenu(menu);
		
		menuCheck(scan.nextInt());
	}
	
	/*
	 * 선택한 메뉴에 따라 기능별 메소드 호출
	 */
	public void menuCheck(int menu) {
		switch(menu) {		
			case 1 : 
				insert(); 
				showMenu();
				break;
			case 2 : 
				showList(); 
				showMenu();
				break;
			case 3 : 
				search(); 
				showMenu();
				break;
			case 4 : 
				update(); 
				showMenu();
				break;
			case 5 : 
				remove(); 
				showMenu();
				break;
			case 9 : 
				System.out.println(" -- 프로그램을 종료합니다. -- ");
				System.exit(0);
				break;
			default : 
				System.out.println("메뉴 준비중입니다.");
				showMenu();
		}
		
		
	}
	
	public void insert() {
		System.out.println("=> 학생 정보를 등록하세요");
		sList[count] = new Student();
		System.out.print("학생명 > ");
		sList[count].name = scan.next();
		System.out.print("국어 > ");
		sList[count].kor = scan.nextInt();
		System.out.print("영어 > ");
		sList[count].eng = scan.nextInt();
		System.out.print("수학 > ");
		sList[count].math = scan.nextInt();
		count++;
		System.out.println("=> 등록 완료!! 계속 입력 하시겠습니까?(계속:아무키, 종료:n)");
		if(scan.next().equals("n")) {
			System.out.println("종료");
			showMenu();
		} else {
			insert();		//재귀호출
		}
	}
	
	public void showList() {
		if(count !=0) {
			System.out.println("--------------------------------------------------------");
			System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
			System.out.println("--------------------------------------------------------");
			for(Student student : sList) {
				if(student != null) {
					System.out.print(student.name + "\t");
					System.out.print(student.kor + "\t");
					System.out.print(student.eng + "\t");
					System.out.print(student.math + "\t");
					System.out.print(student.getTot() + "\t");
					System.out.print(student.getAvg() + "\n");
				} else {
					break;	//이게 없으면 null이 나와도 sysout은 없지만 for문은 계속 돌아감
				}
			}
			System.out.println("--------------------------------------------------------");
		} else {
			System.out.println("=> 등록된 데이터 없음, 등록부터 진행해 주세요");
		}
	}
	
	public void update() {
		if(count !=0) {
			System.out.print("[수정]학생명 검색 > ");
			String modifiedName = scan.next();
			int modiIdx = -1;
			
			for(int i=0; i<count; i++) {
				if(sList[i].name.equals(modifiedName)) {
					modiIdx = i;
				}
			}
			if(modiIdx == -1) {
				System.out.println("수정할 데이터가 존재X, 다시 입력해주세요");
			} else {
//				String oldName = sList[modiIdx].name;	//새로 생성된 객체에 학생명 복사
//				sList[modiIdx] = new Student();			//수정 방법으로 새로 만들어서 갈아버리는 방법도 있음
//				sList[modiIdx].name = oldName;
				
				System.out.print("국어 > ");
				sList[modiIdx].kor = scan.nextInt();
				System.out.print("영어 > ");
				sList[modiIdx].eng = scan.nextInt();
				System.out.print("수학 > ");
				sList[modiIdx].math = scan.nextInt();
				
				System.out.println("=> 수정 완료!!");
				System.out.println("-------------------------------------------------");
				System.out.println("\t\t수정 결과");
				System.out.println("-------------------------------------------------");
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println("-------------------------------------------------");
				System.out.print(sList[modiIdx].name + "\t");
				System.out.print(sList[modiIdx].kor + "\t");
				System.out.print(sList[modiIdx].eng + "\t");
				System.out.print(sList[modiIdx].math + "\t");
				System.out.print(sList[modiIdx].getTot() + "\t");
				System.out.print(sList[modiIdx].getAvg() + "\n");
				System.out.println("-------------------------------------------------");
				System.out.print("계속 수정 하시겠습니까(계속:아무키나누르세요, 종료:n)?");
				if(scan.next().equals("n")) {				
					showMenu();
				} else {
					update();
				}
			}
		} else {
			System.out.println("=> 등록된 데이터 없음, 등록부터 진행해 주세요");
		}

	}
	
	public void remove() {
		System.out.println("remove");
	}
	
	public void search() {
		if(count != 0) {
			System.out.println("=> 학생 정보를 검색하세요");
			System.out.print("학생명 검색 > ");
			String searchName = scan.next();
			int searchIdx = -1;
			for(int i=0; i<count; i++) {
				Student student = sList[i];
				if(student.name.equals(searchName)) {
					searchIdx = i;
				}
			}
			if(searchIdx != -1) {
				System.out.println("-------------------------------------------------");
				System.out.println("\t\t검색 결과");
				System.out.println("-------------------------------------------------");
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println("-------------------------------------------------");
				System.out.print(sList[searchIdx].name + "\t");
				System.out.print(sList[searchIdx].kor + "\t");
				System.out.print(sList[searchIdx].eng + "\t");
				System.out.print(sList[searchIdx].math + "\t");
				System.out.print(sList[searchIdx].getTot() + "\t");
				System.out.print(sList[searchIdx].getAvg() + "\n");
				System.out.println("-------------------------------------------------");
				
				System.out.println("=> 검색 완료!! 계속 입력 하시겠습니까?(계속:아무키, 종료:n)");
				if(scan.next().equals("n")) {
					System.out.println("종료");
					showMenu();
				} else {
					search();		//재귀호출
				}
			} else {
				System.out.println("해당 학생은 없습니다.");
			}
		} else {
			System.out.println("등록된 데이터 없음, 등록부터 진행해 주세요");
		}
	
	}
	
}

/*
[클래스명 : ScoreMgmSystem]
Field : admin:String, sname:Student
Constructor : ScoreMgmSystem()
Method : insert(), update(), remove(), search()
*/