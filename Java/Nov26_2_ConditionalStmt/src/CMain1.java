import java.util.Scanner;

public class CMain1 {
	// 국어 시험 점수를 입력해서 받아오는 함수
	//
	
	public static int kor() {
		Scanner k = new Scanner(System.in);
		System.out.println(" 국어 점수 : ");
		int korsc = k.nextInt();
		// 점수에는 - 점수가 없음 / 만점을 100점
		return (korsc >= 0 && korsc <= 100 ? korsc : kor());
		
	}
	
	// 조건문 : 작성한 코드를 조건에 따라
	//			코드의 실행 흐름을 다르게 동작하도록
	//			제어하는 문법
	// if문 : 조건식의 결과가 true, false로 실행문을 결정
	
//	if (조건 A) {
//		조건 A가 만족했을 시 (참(true)일때) 이 부분이 실행
//	} else if (조건 B) {
//		조건 A (X), 조건 B (O) 이 부분이 실행
//	} else if (조건 C) {
//		조건 A/B (X), 조건 C(O) 이 부분이 실행
//	} else {
//		맞는 조건이 하나도 없으면 이 부분이 실행
//	}
	
	public static void main(String[] args) {
		
//		int kor = kor();
		//kor2()
//		System.out.println(kor);
		
		// 국어 점수가...
		// 60점 미만이면 '가'
		// 60점 이상이면 '양'
		// 70점 미만이면 '미'
		// 80점 미만이면 '우'
		// 90점 미만이면 '수' 출력
		
//		if (kkor >= 60) {
//			System.out.println("양");
//		}
//		else if (kkor >=70) {
//			System.out.println("미");
//		}
//		else if (kkor >=80) {
//			System.out.println("우");
//		}
//		else if (kkor >=90) {
//			System.out.println("수");
//		}
//		else {
//			System.out.println("가");
//		}
		
		// 강사님
		int kkor = kor();
		System.out.println(kkor);
		
		if (kkor >= 90) {
			System.out.println("수");
		}
		else if (kkor >=80) {
			System.out.println("우");
		}
		else if (kkor >=70) {
			System.out.println("미");
		}
		else if (kkor >=60) {
			System.out.println("양");
		}
		else {
			System.out.println("가");
		}
		
		
		
		
		
		//내가
//		int korsc = 50; //국어점수 50점
//		
//		if (korsc <60) {
//			String kor5 = "가";
//		}
//		else if (korsc >=60) {
//			String kor4 = "양";
//		}
//		else if (korsc >=70) {
//			String kor3 = "미";
//		}
//		else if (korsc >=80) {
//			String kor2 = "우";
//		}
//		else (korsc >=90) {
//			String kor1 = "수";
//		}
//		
//		System.out.println(korsc);
		
		
		// 국어 점수가 50점이 안되면 욕, 아니면 칭찬
		// + 점수가 50점 이상, 60점 미만이면 아쉬운 소리
		// + 점수가 30점 미만이면 퇴학처리
		
		// if문 안에 if문을 또 사용하는 것이 가능
		
		// if - if문과 if - else문의 차이
		//	if - if : 각각 다른 조건문으로 해성이 되어서 수행하게 됨 / 난 if - else
		//				효율적 x 
		// 	if - else : 하나의 조건이 만족되면
		//				나머지 부분은 수행하지 않음 => 효율적O
		
//		int kkor = kor();
//		if (kkor <50) {
//			System.out.println("xxxxxxxxxxxx");			이거 왜 안되는지 보기
//		
//			if (kkor < 30) {
//				System.out.println("NAGA!!!!!!");
//		}
		if (kkor <30) {
			System.out.println("퇴학");
		}
		else if (kkor <50) {
			System.out.println("xxxxxxxxxxxx");
		}
		else if (kkor >=50 && kkor <60) {
			System.out.println("넌 애가 왜그러니");
		}
		
		else {
			System.out.println("칭찬");
		}
		
	}
	
}






















