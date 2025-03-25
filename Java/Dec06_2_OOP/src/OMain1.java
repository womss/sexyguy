// Coder : 개발자
// Programmer : Coder + 설계 ***

public class OMain1 {
	public static void main(String[] args) {
	// 의사 (이름, 나이)
	Dr dre = new Dr();
	dre.name = "dre";
	dre.age = 56;
	dre.printDr();
	
	
	
	
	// 손님 (이름, 나이)
	guest g = new guest();
	g.name = "snoop";
	g.age = 54;
	g.printCo();
	
	
	
	// 의사가 진료실에 있는 상황에서
	//	손님 들어오라고 함
	// 의사는 손님에게 키랑 몸무게를 물어봄
	// 손님은 의사한테 키랑 몸무게에 대해 대답
	// 의사는 키.몸무게에 대한 정보를 가지고 BMI지수를 계산
	// 그 계산결과에 따라 판정(ex:고도비만 or 과체중 or 정상)
	// 손님에게 알려주기
	
	
	dre.start(g);
	
}
}



