public class referee {
	
	// 나 호출
	public me2 callme() {
		System.out.println("judgment : ya nawa !");
		System.out.println("me : 이몸등장");
		return new me2();
	}
	// 친구에게 답 요구
	public int askFriAns(friend2 f) {
		int friAns = f.writeFriAns();
		return friAns;
	}
	
	// 나에게 답 요구
	public int askMyAns(me2 mm) {
		int myAns = mm.tellMyAns();
		if (myAns < 1 || myAns > 100) {
			System.out.println("喝 !!!!");
		}
		return (myAns >= 1 && myAns <= 100) ? myAns : askMyAns(mm);
	}
	// 판정 (맞출때까지)
	public boolean judge(int answer, int myAnswer) {
		if (answer == myAnswer) {
			System.out.println("...!");
		} else if (answer > myAnswer) {
			System.out.println("UP !");
		} else {
			System.out.println("DOWN !");
		}
		return (answer == myAnswer);
	}
	//시도 횟수
	public void countTry(int turn) {
		System.out.println("=============");
		System.out.printf("%d번째 시도만에 정답 !\n", turn);
		System.out.println("=============");
	}
	public void start(friend2 f) {
		me2 mm = callme();
		int answer = askFriAns(f);
		int myAnswer = 0;
		boolean endGame = false;
		for (int turn = 1; true; turn++) {
			myAnswer = askMyAns(mm);
			endGame = judge(answer, myAnswer);
			if (endGame) {
				countTry(turn);
				break;
			}
		}
	}
	
	
}
