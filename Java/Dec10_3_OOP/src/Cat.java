import java.util.Random;

public class Cat {
	Random brain = new Random();
	
	public int think() {
		int think = brain.nextInt(3)+1;
		System.out.println("고양이가 답을 정했다 !");
		return think;
	}
}
