
public class AMain2 {
	
	// 저장한 폴더
	
	
	
	// public / static : 좀 더 나중에
	// void : 리턴타입자리인데... 리턴할게 없다
	// main : 함수명
	
	// String[] args의 정체는 ??
	//	외부에서 값을 받아오기 위해 사용하는 파라미터
	//	args 자료형은 문자열(String)을 배열([])로 사용하겠다
	//	파라미터의 모든 값은 *** 문자열(String) 로 전달됨
	//	숫자나 다른 자료형으로 사용하려면 형 변환이 필요
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		Thread.sleep(10000);
}
}
