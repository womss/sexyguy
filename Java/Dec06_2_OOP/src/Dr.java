//지역변수(Local Variable)
//		메소드 안에서 만든 변수
//		그 행동을 하는 동안만 필요한 임시변수
// 메소드 파라미터 (Parameter)
//		그 행동을 하는데 필요한 재료
// 리턴되는 값
//		그 행동을 한 후의 결과물 이 리턴값
// 멤버변수 (Member Variable)
//		그 객체의 속성



public class Dr {
	String name;
	int age;
	
	
	// 손님 부르기
	// 재료 : 불러올 대상
	public void dr1() {
		System.out.println("다음 환자분 들어오세요");
	}
	public void dr2() {
		System.out.println("어디가 불편해서 오셨죠?");
	}
	public void dr3() {
		System.out.println("네~ 키랑 몸무게가 어떻게 되시죠?");
	}
	public double dr4(double gu3 ,double gu3_1) {
		System.out.println(gu3); //키
		System.out.println(gu3_1); // 몸무게
		gu3 /= 100;
		double BMI = (gu3_1 / (gu3 * gu3));
		System.out.printf("네 BMI 지수가 [%.1f] 나오시네요\n", BMI);
		return BMI;
		
	}
	public void dr5(double BMI) {
		if (BMI < 18.5) {
			System.out.println("저체중입니다 찌우셔야겠네요");
		} else if ((BMI > 18.5) && (BMI < 25)) {
			System.out.println("정상체중입니다 유지할수 있도록 하세요");
		}else if ((BMI >= 25) && (BMI < 30)) {
			System.out.println("과체중입니다 좀 더 활동적으로 다니세요");
		}else if ((BMI >= 30) && (BMI < 35)) {
			System.out.println("경도비만입니다 좀 더 활동적으로 다니세요");
		}else if ((BMI >= 35) && (BMI < 40)) {
			System.out.println("중증도비만입니다 운동하지 않으면 위험합니다");
		}else if (BMI >= 40){
			System.out.println("고도비만입니다 빼지 않으면 위험합니다");
		}
		
	}



	// 키 묻기(cm)
	// 재료 : 물어볼 대상
	// 결과 : 손님의 키
	
	// 몸무게 묻기 (kg)
	// 재료 : 물어볼 대상
	// 결과 : 손님의 몸무게
	
	public void printDr() {
		System.out.println(" << 의사 >> ");
		System.out.println(name);
		System.out.println(age);
		System.out.println("================");
		
		
		
	}
//}
	public void start(guest g) {
		dr1();
		g.gu1(); // 안녕하세요 의사 선생님
		dr2();
		g.gu2(); // 체중이 많이 나가는것 같아서요
		dr3();
		; // 키는
		 // 몸무게는
		double BMI = dr4(g.gu3(),g.gu3_1()); // 네 BMI 지수가
		String gu4 = g.gu4();
		dr5(BMI);
	}
}
