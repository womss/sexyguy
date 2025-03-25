import java.util.Scanner;

public class OMain1 {
	public static void main(String[] args) {
		// Shift 연산자 : 다중선택
		// shift : 옮기다. 이동하다
		// (십진수 << 정수 ) 의 형태
		// << : 앞에 있는 수(십진수)를 2진수로 바꾸고,
		//		뒤에있는 수(정수)만큼 왼쪽으로 밀어라.
		//		비어있는(오른쪽부터) 칸 수를 0으로 채우고,
		//		2진수를 다시 10진수로 바꿔라.
		//			1 << 1 = 2
		//			1(2) -> 10(2) = 2
		
		// 조건검색 ex) 카페
		//	24시간 : 1 << 0		= 1
		//	와이파이 : 1 << 1		= 2
		//	흡연실 : 1 << 2		= 4
		//	주차장 : 1 << 3		= 8
		
		// A : 1	=> 24시간
		// B : 8	=> 주차장
		// C : 13	=> 주차장 + 흡연실 + 24시간
		// D : 6	=> 흡연실 + 와이파이
		// 잘 쓰지는 않지만 이런것도 있구나 하고 인지만
		
		int c = (150 << 6);
		System.out.println(c); // ?? 150을 2진수(10010110)로 바꾸고 
								// 6만큼 왼쪽으로 밀고 (10010110.000000)
								//                       ex) 23  22 21
								// 1의 자리에 해당하는 수만 더해서 나온 값 = 9600
		// 연산자
		//		단항 연산자 : a++, a--, !a ...
		//		이항 연산자 : a + b, a > b , ...
		//		삼항 연산자 : 
		//			한글의 조건을 따져서 값을 대입할 때 사용
		//			if문으로 대체가 가능함
		//			항이 3개다 보니 문법이 길어짐
		// 조건식 ? 조건을 만족할 때 쓸 값 : 조건 불성립 시 쓸 값
		
		
		// 이름과 나이 값
		
		Scanner k = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name =k.next();
		System.out.print("나이 : ");
		int age = k.nextInt();
		System.out.printf("이름은 %s, 나이는 %d살\n",name,age);
		
		// 나이가 20살 이상이면 '안녕하세요' 를 출력
		// 나이가 20살 미만이면 'NAGA' 를 출력
		// 강사님
//		boolean aa = age >=20;
		String result = (age >=20) ? "안녕하세요" : "나가";
		System.out.println(result);
		//				ㄴㅡㅡㅡㅡㅡㅡㅡㄴString
		System.out.println((age >= 20) ? "안녕하세요" : "나가");
		
		
		// 내가
//		boolean y = (age >=20  );
//		System.out.println("안녕하세요 : 나가, y");
//		System.out.printf(y ? "안녕하세요" : "나가");
		
		// 홍길동씨 : 1강의장
		// 나이가 짝수 : 1강의장
		// 나머지는 : 2강의장
		// 강사님
		String classNo = ((age % 2 == 0) || name.equals("홍길동")) ? "1강의장" : "2강의장";
		System.out.println(classNo);
		
		//내가
//		System.out.print ^ (age%2 == 0) ? "1강의장" : "2강의장");
//		System.out.print((age%2 == 0) ? "1강의장" : "2강의장");
		
		
		// 상자 하나에 축구공이 6개 들어갈 수 있습니다.
		// 공의 갯수를 입력 받아서
		// 공을 모두 담을 상자의 갯수가 몇개인지 출력
		// ex) 공 49개 => 상자 9개
		
	
		System.out.print("공의 갯수 : ");
		int ball = k.nextInt();
		int box = ((ball % 6 == 0 ) ? ball/6 : ball/6 + 1);
		System.out.printf("상자 %d개 필요\n", box);
		
		
		
		
		

		
	
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
