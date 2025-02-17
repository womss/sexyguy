
public class VMain2 {
	public static void main(String[] args) {
		// 아메리카노
		String name = "아메리카노";
		// 2000원
		int price1 = 2000;
		// 300ml
		int volume = 300;
		// 원두향
		String smell1 = "원두향";
		// 카페인 첨가량 : 99.9%
		double caffein = 99.9;
		// 무색
		char colorr = '무';
		// 발도스
		String company = "발도스";
		// 재활용 해야함 (true/false)
		boolean recycle = true;
		
		
		
		System.out.printf("이름 : %s\n", name);
		System.out.printf("가격 : %,d원\n", price1);
		System.out.printf("용량 : %dml\n", volume);
		System.out.printf("향 : %s\n", smell1);
		System.out.printf("카페인 : %.1f%%\n", caffein);
		System.out.printf("색 : %c\n", colorr);
		System.out.printf("회사 : %s\n", company);
		System.out.printf("재활용 : %s\n", recycle);
		System.out.println("----------------------------");
		
		
		// 내가 한거
		String cof = "커피";
		String coffe = "아메리카노";
		
		String pric = "가격";
		int price = 2000;

		String m = "용량";
		int ml = 300;
		
		String smell = "원두향";
		
		double caffeine = 99.9;
		
		String color = "무색";
		
		String cafe = "발도스";
		
		boolean recycling = true;
		
		
		System.out.println(cof + " : " + coffe);
		System.out.println(pric + " : " + price + "원");
		System.out.println(m + " : " + ml + "ml");
		System.out.println("향 : " + smell);
		System.out.println("카페인 함량 : " + caffeine+"%");
		System.out.println("커피 색 : " + color);
		System.out.println("카페 이름 : " + cafe);
		System.out.println("재활용 해야함 : " + recycling);
		
		System.out.println("----------------------------");
		
		// 점심식사 메뉴(이름), 가격, 칼로리, 평점, 나중에 또 먹을건지
		
		String menu = "돈코츠 라멘";
		int pricee = 9000;
		double kcal = 565.5;
		double score = 3.3;
		String again = "no";
		
		//--------------------------------------------------------
		
		boolean eat = true;
		
		System.out.printf("식사 메뉴 : %s\n", menu);
		System.out.printf("가격 : %,d원\n", pricee);
		System.out.printf("칼로리 : %.1fkcal\n", kcal);
		System.out.printf("평점 : %.1f점(5점만점)\n", score);
		System.out.printf("나중에 또 먹을건지 : %b\n", eat);
		
		
		System.out.println("----------------------------");
		
		// 이름, 오늘 날짜 (연,월,일), 사는 곳(지역)
		// 시력, java 경험 유무에 대한 내용을 변수에 담아 출력
		
		String nname = "차성민";
		int y = 2024;
		int mo = 11;
		int d = 20;
		String live = "성북구";
		double leye = 0.2;
		double reye = 0.3;
		boolean ja = false;
		
		
		System.out.printf("이름 : %s\n", nname);
		System.out.printf("TO DAY : %d년%02d월%02d일\n", y,mo,d);
		System.out.printf("거주지 : %s\n", live);
		System.out.printf("시력 : 왼쪽%.1f 오른쪽%.1f\n", leye, reye);
		System.out.printf("java경험 유무 : %b\n", ja);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
}









