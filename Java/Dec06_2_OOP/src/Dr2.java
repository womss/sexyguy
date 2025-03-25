//지역변수(Local Variable)
//		메소드 안에서 만든 변수
//		그 행동을 하는 동안만 필요한 임시변수
// 메소드 파라미터 (Parameter)
//		그 행동을 하는데 필요한 재료
// 리턴되는 값
//		그 행동을 한 후의 결과물 이 리턴값
// 멤버변수 (Member Variable)
//		그 객체의 속성



public class Dr2 {
	String name;
	int age;

	
	public void printDr() {
		System.out.println(" << 의사 >> ");
		System.out.println(name);
		System.out.println(age);
		System.out.println("================");
	}
		// 손님 부르기
		// 재료 : 불러올 대상
		public void callGuest(guest2 g) {
			System.out.printf("%s : %s씨 일로 와봐유 ~ \n", name, g.name);
		}
		
		
		
		// 키 묻기(cm)
		// 재료 : 물어볼 대상
		// 결과 : 손님의 키
		public double askHeight(guest2 g) {
			System.out.println("키(cm) : ");
			double h = g.answerHeight();
			if (h >= 1 && h <= 300) {
				System.out.println("=============");
				System.out.println("나보다 좀 작네 ㅋ");
				System.out.println("=============");
			} else {
				System.out.println("=============");
				System.out.println("어허 ! 장난 ㄴ!!!");
				System.out.println("=============");
			}
			return (h >= 1 && h <= 300) ? h / 100 : askHeight(g);
		}
		
		
		// 몸무게 묻기 (kg)
		// 재료 : 물어볼 대상
		// 결과 : 손님의 몸무게
		public double askWeight(guest2 g) {
			System.out.println("몸무게(kg) : ");
			double w = g.answerWeight();
			if (w >= 1) {
				System.out.println("=========");
				System.out.println("...ㅋ");
				System.out.println("=========");
			} else {
				System.out.println("=========");
				System.out.println("...? 진심 사람이세요 ?");
				System.out.println("=========");
			}
			return (w >= 1) ? w : askWeight(g);
		}
		
		// BMI 계산
		// 재료 : 손님정보(키, 몸무게)
		// 결과 : BMI 값
		public double calcBMI(guest2 g) {
			return g.weight / (g.height + g.height);
		}
		
		// 판정해서 결과내기
		public String judgeBMI(guest2 g) {
			if (g.bmi >= 40) {
				return "고도비만";
			} else if (g.bmi >= 35) {
				return "중증도비만";
			} else if (g.bmi >= 35) {
				return "경도비만";
			} else if (g.bmi >= 35) {
				return "과체중";
			} else if (g.bmi >= 35) {
				return "정상";
		}else {
			return "저체중";
		}
		}
			
		// 결과 알려주기(출력하기)
		public void tellResult(guest2 g) {
			System.out.printf("%s씨의 키는 %.1fcm이고, 몸무게는 %.1fkg...\n", g.name, g.height * 100, g.weight);
			System.out.println("체질량지수(BMI) ");
		}
		
		// 위의 과정들을 실행할 부분
		public void start(guest2 g) {
			callGuest(g);
			g.enter();
			g.height = askHeight(g);
			g.weight = askWeight(g);
			g.bmi = calcBMI(g);
			g.bmiResult = judgeBMI(g);
			tellResult(g);
			g.exit();
		}
		
		
		
//}
//	public void start(guest()) {
//		dr1();
//		gu1();
//		gu2();
//		gu3();
//	}
}
