
public class CMain1 {
	public static void main(String[] args) {
		// 신발
		// 나이키 홈페이지
		
		// 이름 : ???
		// 사이즈 : ???
		// 가격 : ???
		// 브랜드 : ???
		// 정보출력
		// ---------------------------
		// 이름 : ???
		// 사이즈 : ???
		// 가격 : ???
		// 브랜드 : ???
		// 정보출력
		// ---------------------------
		
		//					┌ 이 괄호가 기본생성자
		Shoes s1 = new Shoes();
		Shoes s2 = new Shoes();
		
		s1.name = "Jam";
		s1.size = 285;
		s1.price = 139000;
		s1.printJam();
		
		s2.name = "P-6000";
		s2.size = 285;
		s2.price = 109600;
		s2.printJam();
		
		// 생성자 오버로딩 	┌
		Shoes s3 = new Shoes("신발", 285, 150000); ////여기서 받아온 값들이
		s3.printJam();
		
		s2.test(s2.name);
		System.out.println("-----");
		s2.test("zzzz");
		System.out.println("-----");
		
	}
}
