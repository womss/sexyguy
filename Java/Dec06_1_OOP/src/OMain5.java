// ???
//		???
// Stack
//		변수를 만들때마다 아래에서부터 차곡차곡 쌓임
//		프로그램이 종료되면 알아서 다 정리
// Heap
//		컴퓨터가 적당하다고 판단한 위치에 만든다
//		자동정리 X (핸드폰 메모리 정리하는 느낌으로 정리해야...)

// Garbage Collection : Heap영역 자동정리 시스템(*** 면접)
//	C나 C++ 에서는 가비지 컬렉션이 없어서
//	프로그래머가 수동으로 메모리 할당과 해제를 일일히 해줘야 하는데
//	Java는 JVM에 탑재되어 있는 가바지 컬렉터(Garbage Collector)가
// 	메모리 관리를 대행해주기 때문에
//	개발자 입장에서 메모리 관리, 메모리 누수(Leak) 문제에서
//	완벽하게 관리하지 않아도 되어 개발에만 집중할 수 있다
//		언제 ? - 그 번지에 더이상 접근할 방법이 없어지면 발동!
//		단점 : 직접 눈으로 확인할 방법이 없음
//		System.gc(); 라는 기능으로 정리를 할 수는 있지만,
//			호출해서 사용하는 거 자체가
//			시스템 성능에 영향을 많이 주기 때문에 절대 사용 X!!

public class OMain5 {
	// 마스크
	//	이름
	//	구매처
	//	가격
	//	정보 출력
	
	public static void main(String[] args) {
		Mask m1 = new Mask();
		m1.name = "가면라이더 마스크";
		m1.shop = "나몰스토어";
		m1.price = 88900;
		m1.printInfo();
		System.out.println("-------------------------------");
		Mask m2 = m1;	// m1은 m2라는 별명이 하나 더 생김
		m1 = null;
		System.out.println(m1); // 아무 번지도 안가리킴 *** (null)
		System.out.println(m2);
		m2 = null;
///////////////////////////////////////////////////마스크의 정보가 사라지는 시점
		//										Garbage Collection이 발동 !
		System.out.println(m2);
		m2.printInfo(); // m2의 정보를 출력하는게 불가능
		
		
	}
	
	
}
// 프로그램이 종료되면 Stack영역이 정리되고
//		=> Heap 영역에 접근을 못하게 되니 Garbage Collection이 발동