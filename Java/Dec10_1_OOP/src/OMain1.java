import java.util.Random;
// 멤버 변수 : 속성 ( 소개할 때 언급할만한 것)
// 지역 변수 : 그 행동을 하는 동안에만 의미가 있는 것
// 파라미더 : 그 행동을 하는데 필요한 재료
// 리턴 : 그 행동의 결과물


public class OMain1 {
	public static void main(String[] args) {
		Random r = new Random(); // r 객체
		com c = new com();
		user u = new user();
		
		c.start(u,r);
	}
}

// 홀짝 맞추기
// 컴퓨터 vs 유저

// 시작
// 컴퓨터가 동전을 가지고 있고 (20개) 
// 컴퓨터가 유저한테 20개 중에서 몇개로 할 지를 물어보고
// 유저가 답하고 (20개 중 몇 개)
// 컴퓨터가 짤짤이 해서
// 유저한테 홀/짝 물어보고
// 판정




















