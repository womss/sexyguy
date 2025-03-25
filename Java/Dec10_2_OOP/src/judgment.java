
public class judgment {
	int fnumber = 0;
	int mnumber = 0;
	int count = 0;
	
//	public void callMe() {
//		System.out.println("Up & Down 게임을 시작합니다");
//	}
	public int askFriend(friend f) {
		System.out.println("몇으로 할 지 종이에 적으시오(1 ~ 100) : ");
		fnumber = f.answerNumber(); // 친구는 대답을 하겠죠
		return fnumber;
	}
	public int askMe(me m) {
		System.out.println("친구가 적은 숫자는? : ");
		mnumber = m.answerNumber(); // 내가 친구 답을 예상해서 말하고
		return mnumber;
	}
	public void match(int fnum, int mnum, int count) {
		if (fnumber > mnumber) { // 친구 숫자가 내 숫자보다 클때
			System.out.println(" < U P ! > "); // up 높여야한다고 말하고
			count++;
		} else if (fnumber < mnumber) { // 친구숫자가 내 숫잡보다 작을때
			System.out.println(" < D O W N ! >"); // down 줄여야한다고 말하고
			count++;
		} else {
			System.out.println(" 정답 ! "); // 어느것도 아닐때는 정답이라고 출력
			count++;
		}return (fnumber > mnumber && fnumber < mnumber) ? askMe(m) : correct(); // 친구의 숫자보다 크거나 작으면 askMe(m)를 실행 : 아닐때(정답일때)는 correct()실행
	}
	public void correct() {
		System.out.printf("%d번만에 맞히셨습니다", count);
	}
	public void start(friend f, me m) {
		int fnum = askFriend(f);
		int mnum = askMe(m);
		match(fnum, mnum, count);
	}
	
	
}
