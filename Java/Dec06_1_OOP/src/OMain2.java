
// main()이 있는 클래스 : XXXMain
public class OMain2 {
	public static void main(String[] args) {
		// 버스 Java로 표현해보자 ! 
		//	=> 표현하고 싶을때는 항상! 클래스를! 새로! 만들자! 
		// 버스번호 / 차종 / 버스회사 / 기사님이름 / 시작점
		//		=> 정보를 담아서 => 출력
		// int, double, String, ... XXX : ?!
		//		Java를 모르는 사람한테 설명하기 어렵다
		// 객체지향은 주석을 달 필요가 없다는 장점
		//	=> 뭘 표현하고 있는지 알 수 있기 때문
		//	b = 객체, instance라고 부름
		
		
		Bus b = new Bus(); // 버스 1대 완성
		
		b.number = 145;
		b.what = "city bus";
		b.company = "시내 운수";
		b.driver = "김대리";
		b.startPoint = "고속터미널";
		
//		System.out.println(b.number);
//		System.out.println(b.what);
//		System.out.println(b.company);
//		System.out.println(b.driver);
//		System.out.println(b.startPoint);
		b.printInfo();
		b.go();
		System.out.println("=====================");
		
		//핸드폰
		//		모델명
		//		제조사
		//		가격
		//		정보를 출력
		//		전화왔을 때 - '띠리링 ~' 출력
		
		phone p1 = new phone();
		System.out.println(p1); // 기본형이 아닌 것들은 다 참조형 !!
		p1.printinfo();
		System.out.println("--------");
		
		p1.model = "iphone";
		p1.made = "apple";
		p1.Price = 100000;
		p1.printinfo();
		p1.bell();
//내가	System.out.println(p.model);
//		System.out.println(p.made);
//		System.out.println(p.Price);
//		p.bell();
		
		//  엄마폰 = 내폰
		// p와 똑같은 속성값을 가진 p2 생성 - 불가능
		//		(59번줄의 방법으로는)
		// 무조건 new ~로 생성해야 가능 !!(*결론)
		phone p2 = p1;	// p1의 별명이 하나 더 추가된 상황
		System.out.println(p2); // 번지값이 같다./p1와
								// 핸드폰 하나를 2명이 공유 하고 있는 상황
		p2.Price = 80000;
		p2.printinfo();
		System.out.println("--------");
		p1.printinfo(); // 62번줄에서 p2 가격을 80000으로 변경
						//	=> p2 = p1 이라 공유
		System.out.println("--------");
	}
}













