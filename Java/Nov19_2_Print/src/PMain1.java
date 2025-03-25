// 프로그래밍 '언어'
//  => 왜? (x)
//  외울 필요는 X / 이런 기능이구나 ~ 정도만
//   왜? 업데이트를 하면서 필요없는 기능은 삭제하기 때문
public class PMain1 {

	public static void main(String[] args) {

		// syso : 출력(Print) 기능
		System.out.println();

		// Print의 형태
		// 1. println : Console창에 데이터를 출력하고, 줄 바꿈 (출력에서 제일 많이사용)
		// => 괄호 안에 값을 넣지 않으면 : 콘솔 창에서의 줄 바꿈 역할
		// 2. print : Console창에 데이터를 출력하고,
		// 줄 바꿈기능 X (println 보다는 덜 사용)
		// 3. printf : Console창에 특정 데이터에 형식을 지정해서 데이터를 출력
		// ex) 소수점 자릿수를 몇번째 자리까지 보여줄 것인가...

		System.out.println("println : 글자 출력 + 줄바꿈기능");
		System.out.print("print : 글자 출력");
		System.out.println();
		System.out.printf("print : 이거는 이따가 자세히 볼게요 !");
		System.out.println();

		// ??? : syso를 자동완성하면 => println만 나오는데
		// 왜 print랑 printf는 자동완성이 없나?
		// => println을 제일 많이 사용하기 때문에

		// syso를 이용
		// 괄호안에 숫자 2개를 넣어서 사칙연산에 대한 결과를 출력

		System.out.println(2 + 2 + 12 + 345 + 3636 + 56);
		System.out.println("31-1");
		System.out.println("31/1=" + (31 / 1));
		System.out.println(31 / 1);

		// ??? : 숫자 계산할 때는 큰따옴표를 사용하지 않았을까?
		// => 큰따옴표 사이에 뭔가 내용을 넣으면...
		// => '문자'로 인식
		
		System.
		out.
		println("as"+
				"asf"+
				"adsfgsdfgher");
		System. out. println("afsfdgw");
System.out.println("zzzzzz");
		// 띄어쓰기, 줄바꿈, 들여쓰기 => 전혀 관심없음
		// 단순히 사람의 가독성을 위해서 사용하는 것
		// 한글자당 2byte의 용량을 차지
		// 이 파일을 압축 => 띄어쓰기, 줄바꿈, 들여쓰기를 없앰
		// 		=>용량을 줄임

		// 가독성을 좋게 할것인가 vs 용량을 줄여서 컴퓨터의 자원을 아낄것인가
		// 가독성이 더 중요, 일단 코드 짜고 정렬 단축키 애용



	}
}
