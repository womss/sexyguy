
// 가위바위보
//	1. 등장인물 => 심판 / 강아지 / 고양이
//						(U)	  (C)
//			=> 다 같이 한자리에 있음
//			=> 심판한테는 룰북이 있음
//			1을 입력하면 가위 / 2를 입력하면 바위 / 3을 입력하면 보
//	2. 각 개체들의 속성 ? 행동 ?
//	3. 강아지가 한 판 질동안 몇 승 / 몇 무 했는지

public class OMain1 {
	
	
	public static void main(String[] args) {
		Referee r = new Referee();
		Dog d = new Dog();
		Cat c = new Cat();
		r.print(d,c);
	}
}









