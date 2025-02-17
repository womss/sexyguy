
public class SMain1 {
	public static void main(String[] args) {
		// 과자 클래스 만들기 + 츨력기능
		// 과자 이름, 중량, 가격
		
		// 현재 main에는 과자 객체가 없는 상태 !
		// 과자 이름? => 모름
		// 과자 무게? => 모름
		// 과자 가격? => 모름
		// 과자 생산자? => 김비버 (이건 알 수 있음)
		// 스태틱으로 생성하면 객체로 만든건 알 수 없어도 스태틱은 알 수 있다 ///하지만 무분별 사용은 지양
		
//		System.out.println(Snack.manufacturer);
		
		System.out.println(Snack.MANUFACTURER);
		System.out.println("-------------------");
		System.out.println();
		Snack.printTaste();
		
		// 과자 객체 2개 만들어서 정보 출력
		
		Snack s1 = new Snack();
		
		s1.SnackName = "치토스";
		s1.Gram = 70.5;
		s1.Price = 1500;
		s1.printInfo();
		
//		Snack.name();
		Snack s2 = new Snack();
		
		s2.SnackName = "치토스";
		s2.Gram = 130.5;
		s2.Price = 3500;
		s2.printInfo();
		
		// 생산자의 값을 바꿔봅시다!
//		s2.manufacturer = "최비버"; // 생산자의 이름은 동일해야하는데 변경이 되는 문제가 발생
//		s2.printInfo();
		
		// s2.MANUFACTURER = "최비버";
		// 에러가 나는 것을 확인할 수 있음!
		
	}
}






















