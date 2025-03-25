
public class Referee2 {
	
	String[] rulebook = new String[] {" ", "가위", "바위", "보" };
	
	public void readRulebook() {
		System.out.println("==============");
		for (int i = 1; i < rulebook.length; i++) {
			System.out.printf("%d. %s\n", i, rulebook[i]);
		}
		System.out.println("==============");
	}
	
	public int askAns(Dog2 d) { //												┐
		System.out.print("댕댕이 뭐낼래? : ");
		int dogAns = d.fire();
		return (dogAns >= 1 && dogAns <= 3) ? dogAns : askAns(d);
	}
	
	public int askAns(Cat2 c) { //												┘ 오버로딩?
		int catAns = c.fire();
		return catAns;
	}
	// 누가 뭐 냈는지
	public void printHand(Dog2 d, Cat2 c) {
		System.out.printf("댕댕이는 %s\n", rulebook[d.hand]);
		System.out.printf("고양이는 %s\n", rulebook[c.hand]);
	}
	
	// 판정
	public boolean judgeWin(Dog2 d, Cat2 c) {
		int result = d.hand - c.hand;
		if (result == 0) {
			System.out.println("비겼다 !");
			d.draw++;
		} else if (result == -1 || result == 2) {
			System.out.println("고양이가 이겼다 !");
		} else {
			System.out.println("댕댕이가 이겼다 !");
			d.win++;
		}
		return (result == -1 || result == 2);
	}
	
	public void sayDogWin(Dog2 d) {
		System.out.printf("댕댕이는 %d번 비겼고, %d개의 간식을 얻을거야 !\n", d.draw, d.win);
	}
	
	// 시작
	public void start(Dog2 d, Cat2 c) {
		readRulebook();
		while (true) {
			d.hand = askAns(d);
			c.hand = askAns(c);
			printHand(d, c);
			System.out.println("=================");
			if (judgeWin(d, c)) {
				sayDogWin(d);
				break;
			}
		}
	}
	
}










