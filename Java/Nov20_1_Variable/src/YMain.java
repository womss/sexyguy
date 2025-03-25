
public class YMain {
	public static void main(String[] args) throws InterruptedException {
		// 집까지 얼마나 걸렸는지 (시간) : ex) 1.5시간
		// 저녁 식사 메뉴 : ???
		// 수업 후에 뭐했는지 ? : ???
		// 취침 시간 : ?시 ?분
		// 수업 소감 : ~~~
		// 수업 성취도 : ?.?%
		// 출력
		// 5초정도 딜레이를 걸어서 => .bat로 실행까지
		
		System.out.printf("귀가 소요 시간 : %.1f시간\n", 1.5);
		System.out.printf("저녁 식사 메뉴 : %s\n","애호박전");
		System.out.printf("수업 후의 일정 : %s\n", "귀가");
		System.out.printf("취침     시간 : %d시 %d분\n", 11, 10);
		System.out.printf("수업     소감 : %s\n","설명이 상세하고 진도가 적당해서 좋음");
		System.out.printf("수업    성취도 : %.1f%%\n", 65.5);
		
		Thread.sleep(5000);
	
		
	}
}












