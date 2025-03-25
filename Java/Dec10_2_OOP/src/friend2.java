import java.util.Random;

public class friend2 {
	Random brain = new Random();
	
	
	public int writeFriAns () {
		int think = brain.nextInt(100)+1;
		// 머릿속으로 숫자 하나를 <생각>해서
		// 종이에 써서 답 제출
		
		System.out.println("친구가 답을 정했다 !");
		return think;
	}
}
