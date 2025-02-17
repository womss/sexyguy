
public class FMain3 {
	public static void test(int q) { // q (blue) : 파라미터
		System.out.println(q); // 10 (q/blue) 순서 ★★
		q = 20;
		System.out.println(q); // 20 (q/blue) 순서 ★★★		  <┐
		// test 영역으로 넘어온 이상 해당 내용을 다 끝내고				   
		// main 영역으로 다시 돌아감 (main => test => main)
		
	}
	
	public static void main(String[] args) {
		int q = 10;				// q (red) : 지역변수
		System.out.println(q); // 10 (q/red) 순서★			    ∧
		test(q);				// test함수 호출, q (blue) 변수 생성 ┘
		System.out.println(q); // 10 (q/red) 순서 ★★★★
		// 더 이상 내용이 없으니 프로그램이 종료
		
		
		
		
		
		
		
	}
}
