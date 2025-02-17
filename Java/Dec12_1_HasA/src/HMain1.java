// 객체간의 관계
//		A has a B	: 사람 has a 핸드폰
//		A is a B	: 개 is a 동물

// A has a B : 포함관계
public class HMain1 {
	public static void main(String[] args) {
		// 이름이 Kim Andrew, 남자, 핸드폰번호가 010-1234-5678
		// 출력
		
		// 강남포차, 역삼동, 02-1222-3444, Kim Andrew의 식당
		// 출력 (식당 주인의 정보까지)
		Person p1 = new Person("Kim Andrew", "남자(게이)", 12345678);
		Store s1 = new Store("강남포차", "역삼동", 12223444, p1); // 이걸 하나 더 만들면 되지 않나?
		s1.printStore();
		System.out.println("--------------------------------------------------------");
		
		// 계란말이, 22000원, 강남포차에서 파는 메뉴
		// 관련된 전체 정보를 출력
		
		// 석쇠불고기, 25000원, 강남포차에서 파는 메뉴
		// 관련된 전체 정보를 출력
		
		Food f1 = new Food("계란말이", 22000, s1);
		Food f2 = new Food("석쇠불고기", 25000, s1);
		f1.printFood();
		System.out.println("--------------------------------------------------------");
		f2.printFood();
		System.out.println("--------------------------------------------------------");
		
		// 석쇠, 5000원, 석쇠불고기를 담은 접시
		Plate p = new Plate("석쇠", 5000, f2);
		// 가락시장, 송파구, 석쇠를 구매한 시장
		Market m = new Market("가락시장", "송파구",p);
		// 곽두팔, 가락시장을 좋아하는 상인
		Person1 pp = new Person1("곽두팔", m);
		
		
	
		// 곽두팔의 이름만 출력
		System.out.println(pp.name);
		System.out.println("------------------");
		// 곽두팔이 좋아하는 시장 정보를 전체 출력 // x 이거 못함
		pp.market.printMarket();
		System.out.println(pp.market);
		// 곽두팔이 좋아하는 시장은 어디에?
		System.out.println("------------------");
		System.out.println(pp.market.location);
		System.out.println("------------------");
		// 곽두팔이 좋아하는 시장에서 산 접시와 관련된 전체정보 // x
		pp.market.plate.printPlate();
		// 곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴 가격 // x
		System.out.printf("곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴 가격 : %,d원\n", pp.market.plate.f2.Price);
		System.out.println("------------------");
		// 곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴를 파는 식당 연락처 // x
		System.out.printf(" 곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴를 파는 식당 연락처 : 02%d\n", pp.market.plate.f2.where.tellNum);
		System.out.println("------------------");
		// 곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴를 파는 식당 주인의 연락처 // x
		System.out.println(pp.market.plate.f2.where.owner.phonenum);
		System.out.println("------------------");
		// 계란말이를 파는 사람 연락처 // x
		System.out.println(f2.where.owner.phonenum);
		
	}
}












