import java.util.Random;

public class com {

	
	public void askCom() {
		System.out.println("몇개 하실 ?");
	}
	
	public int userChoice(user u) {
		System.out.println("입력한 갯수만큼 돌립니다 : ");
		u.userNum = u.answerUser();
		if (u.userNum > 0 && u.userNum <= 20) {
			System.out.println("===========");
			System.out.printf(" %d개로 돌립니다", u.userNum);
			System.out.println("===========");
		}else {
				System.out.println("=================");
				System.out.println("20개 아래로 입력해주세요");
				System.out.println("=================");
			}
			return (u.userNum >= 1 && u.userNum <= 20) ? u.userNum : userChoice(u);
		}
	public void rolling(user u, Random r) {
		u.comPic = r.nextInt(u.userNum)+1;	// 컴퓨터가 유저가 고른 수 만큼에서 랜덤으로 뽑은 수
		if (u.comPic % 2 == 0) { // 컴퓨터가 뽑은 수가 2로 나눠 없어진다면
			u.resultc = "짝";			// 짝
		} else if (u.comPic % 2 == 1) {
			u.resultc = "홀";			// 안없어지면 홀
		}
		
	}
	public void roll(user u) {
		System.out.println("홀 / 짝");
		System.out.println("사용자의 배팅은 : ");
		u.userBat = u.answerBat();
		if (u.userBat.equals("홀") || u.userBat.equals("짝")) {
			return;
		}else {
			roll(u); // roll(user u);
		}
	}
	public void match(user u) { // 앞으로 이 메소드에서는 u.이라 하면 u즉 user에서 참조 하겠다 이렇게 ┐
		if (u.resultc.equals(u.userBat)) {
			System.out.printf("사용자의 배팅은 %s !, 컴퓨터가 내놓은 값은 %d개 !, 따라서 %s !", u.userBat, u.comPic, u.resultc);
			System.out.println("정답 !");
		} else {
			System.out.printf("사용자의 배팅은 %s !, 컴퓨터가 내놓은 값은 %d개 !, 따라서 %s !", u.userBat, u.comPic, u.resultc);
			System.out.println("오답 !");
		}
	}
	public void start(user u, Random r) {
		
		askCom();
		userChoice(u); // 파라미터에 user가 있으면 객체만
		rolling(u,r);
		roll(u);
		match(u);
	}
}
