import java.util.Random;

public class Cat2 {
	Random brain = new Random();	// 랜덤기능 추가
	int hand;
	
	
	public int fire() {
		return brain.nextInt(3)+1;
	}
}
