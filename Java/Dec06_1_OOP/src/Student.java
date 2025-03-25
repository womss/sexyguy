//라이브러리용 Class (Library) 수많은 클래스중 뽑아서 쓰겠다
//	(API : Application Program Interface)
//		: 다른 Class에서 이용할 목적
// 프로그램에서 실행되는 Class가 여러개,
//		단 하나를 빼고는 전부 라이브러리용!!!
//		: 제외됐던 하나의 Class : 실행용 (Main)

public class Student {
	// 멤버 변수 만들어 봅시다@@@@@@@@@@@@@@@@@@@@@@@@@@
	// 멤버변수(Member Variable) / 필드 (Field)
	//		: 객체의 데이터가 저장되는 곳
	// 초기값이 지정되지 않은 멤버변수는
	//	객체 생성시 자동으로 기본 초기값을 설정
	int  student;
	String studentName;
	String studentAddress;
	
	// method (메소드) : 객체의 동작에 해당하는 실행 블록
	//		중괄호 블록을 의미 >> 이름 붙인것이 method명(동사스럽게 짓기)
	//		메소드를 호출시, (이 영역 안의) 모든 코드를 일괄적으로 실행
	//		객체 간의 데이터 전달 수단
	public void showStudentInfo() {
		System.out.println(studentName + " " + studentAddress);
	}
	
}
