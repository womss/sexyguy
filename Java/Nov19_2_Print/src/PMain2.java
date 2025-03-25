
public class PMain2 {
	public static void main(String[] args) {
		// Escape Sequence (이스케이프 문자)
		//	: 특수한 문자나 특수한 기능을 표현할 때 \ 를 사용해서 표현
		
		// \t : Tap키 (줄 맞추는 용도)
		// \n : New Line (줄만 맞추는 용도)
		// \r : Carriage Return (커서를 맨 앞으로)
		// \r\n : Enter키의 기능
		// \b : Backspace키
		//		C언어 - 한 글자 : 1byte
		//		Java - 한 글자 : 2byte 그래서 자바에서 \b를 쓰면 특수문자 혹은 꺠져 보임 그래서 Java에서 안씀
		// \0 : 빈칸(Space키)
		
		
		// 문장 4개 생성 중간중간 이스케이프 문자 활용 출력
		
		System.out.print("안녕하세요\r\n반갑습니다\t감사합니다\r실례합니다\n죄송합니다");
		System.out.println("오늘날짜\t: 2024.11.19");
		System.out.println("요일\t: 화요일");
		
		
		// 현재 : 가볍게 확인용도로 사용하는 콘솔창이라서
		//  \r이나 \n 둘 중 하나만 있어도 enter키 처리가 가능
		// 파일처리 / 통신 : \n이나 \r 하나만 쓰게 되면 다 뒤집어질 수도 있다
		// => 이클립스 안에서는 \r과 \n을 구분하기는 어려움
		
		// \(^_^)/ 출력
		
		System.out.println("\\(^_^)/\"안녕!\"");
		
		// (".") 출력
		
		System.out.println("(\".\")\"뭐\"");
		
		
		
		
		
		
		
	}
}
