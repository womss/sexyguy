package com.gwalosa.dec131.main;

// PMain1.java에서 쓰는 Scanner는 무조건 이것만 사용하겠다!
import com.gwalosa.dec131.machine.Scanner; // 무조건 이것만 사용한다는건 다른걸 쓸 수도 있는건지? 아니면 엉켜서 하나만 써야하는이유때문에 그러는지

public class PMain1 {
	public static void main(String[] args) {
		// 객체 만들때 패키지명을 생략 가능한 경우
		//	- 자바 기본 패키지(java.lang) 소속인 경우
		/* java.lang.*/String s1 = "ㅋ";
		/* java.lang.*/System.out.println("a");
		
		// 같은 패키지 소속
		com.gwalosa.dec131.main.Beaver b = new com.gwalosa.dec131.main.Beaver();
		
		Beaver b2 = new Beaver();
		
		// 다른 패키지 소속
		com.gwalosa.dec131.machine.Scanner s = new com.gwalosa.dec131.machine.Scanner();
		
		Scanner ss = new Scanner(); 
		
		
		
	}
}










