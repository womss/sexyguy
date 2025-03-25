import java.util.Random;

public class com22 {
	int coin = 20; // 속성을 안썼네;
	Random cpu = new Random();
	
	public int askHowManyCoin(user22 u) {
		System.out.println("몇 개로 할래?(2개 이상 20개 이하) : ");
		coin = u.answerHowManyCoin(); // 유저는 대답을 하겠죠
		if (coin < 2 || coin >= 21) {
			System.out.println("다시 입력 해 !!!");
		}
		return (coin >= 2 && coin <= 20) ? coin : askHowManyCoin(u);
	}//유저가 몇개로할지 정상적으로 말하고 나면
	
	// 짤짤이 시작
	public int shakeCoin(int userCoin) {// 유저가 입력한 코인개수 필요
		return cpu.nextInt(userCoin)+1;// 리턴쓰고 랜덤 추가 // 입력한 코인개수만큼 랜덤
	}
	
	public String askHJ(user22 u) {
		System.out.println("홀? 짝? : ");
		String userAns = u.answerHJ();
		return (userAns.equals("홀") || userAns.equals("짝")) ? userAns : askHJ(u);
		
	}
	
	public String judgeCoin(int shakeCoin) {
		return (shakeCoin % 2 == 0) ? "짝" : "홀";
	}
	
	public String getResult(String userAns, String comAns) {
		return userAns.equals(comAns) ? "정답" : "오답";
	}
	
	private void printResult(int shakeCoin, String result) {
		System.out.printf("동전은 %d개 뽑았고, %s이야 !\n", shakeCoin, result);
	}
	public void start(user22 u) {
		int userCoin = askHowManyCoin(u);
		int shakeCoin = shakeCoin(userCoin);
		String userAns = askHJ(u);
		String comAns = judgeCoin(shakeCoin);
		String result = getResult(userAns, comAns);
		printResult(shakeCoin, result);
	}
	
	
}
