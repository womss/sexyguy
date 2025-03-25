// 알고리즘의 시대 => 유지보수의 시대

// 절차지향 프로그래밍 (Procedural Programming) (1960년대 이전)
//		순서대로 잘 프로그래밍해서 결과를 잘 내자
//		변수 하나 덜 쓰고, 효율적으로 코드 짰음
//		조건문, 반복문, ...
//		장점 : 처리속도, 실행속도가 빠르다

// 객체지향 프로그래밍 (Object-Oriented Programmig) (1960년대 이후)
//		퍼지게 된 것은 1980년대 이후부터인데
//		Java가 1990년에 등장한 이후로 본격적으로 사용되기 시작함!
//		(물론 이전에 C로도 활용했음)
//		OOP의 목표는 실생활을 표현,묘사하자 ! (우리가 살고 있는 현실을 모델링 해보자는)
//		장점 : 코드의 재사용성, 유지보수에 용이, 대규모 프로젝트에 적합

public class OMain1 {
	public static void main(String[] args) {
		// 강의장이 있는 건물 뒤편에는 카페가 하나 있는데
		//	그 카페의 정보를 표현
		
		// 카페 이름이 발도스
		String name = "발도스" ;
		// 카페 위치가 건물 뒤편
		String location = "건물 뒤편";
		// 거리가 100.3m
		double distance = 100.3;
		// 출력
		System.out.println(name);
		System.out.println(location);
		System.out.println(distance);
		System.out.println("==========================");
		System.out.println( "카페 이름 : 발도스");
		System.out.println( "카페 위치 : 건물 뒤편");
		System.out.println( "카페까지 거리 : 100.3m");
		System.out.println("==========================");
		
		// OOP로 발도스를 표현
		// 객체(Object) : 실생활에 존재하는 모든것
		//		(컴퓨터, 자동차, 사람, 책, 티비, 모니터, ...) ///보이지 않는것도 표현할 수 있다면 포함
		//	( = 인스턴스(Instance))
		//		: class안에서 만들어진 객체를
		//			해당 클래스의 인스턴스라고 함
		//		[사람] //에대한 객체를 만들었다 가정
		//		- 속성 : 이름, 나이, ..., 사는곳
		//		- 동작 : 웃다, 울다, 걷다, ...
		//		[에어컨]
		//		- 속성 : 온도, 바람, 풍향, ...
		//		- 동작 : 켜다, 끄다
		//		붕어빵을 만드려면			붕어빵 틀이 필요!
		//		객체를 만드려면			'class'라는 것이 필요
		// 객체를 사용해서 하나의 완성품을 만들어내는 프로그래밍 기법이
		//		=> 객체지향 프로그래밍
		//		=> 앞으로는 class를 엄청 만들 것
		
		Cafe c = new Cafe();	// 새로운 카페 하나
//		Random r = new Random();
//		Scanner k = new Scanner(System.in);
		c.name = "발도스";
		c.location = "건물뒤편";
		c.distance = 100.3;
		System.out.println(c.name);
		System.out.println(c.location);
		System.out.println(c.distance);

		
	}
}










