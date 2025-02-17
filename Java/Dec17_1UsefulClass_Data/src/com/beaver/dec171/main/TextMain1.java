package com.beaver.dec171.main;

import java.util.StringTokenizer;

// 파일.네트워크를 통해서 데이터를 받아오면 : 글자형태
// 파일.네트워크를 통해서 데이터를 줄 때 : 글자형태
// 한글처리가 까다로워질 수 있음 !
public class TextMain1 {
	public static void main(String[] args) {
		String s1 = "으아아아아아아"; // 정식? No / 약식 Yes !
		
		String s2 = new String("곧 있으면 새해 ! 너무 신나요 !");
		
		// 외우지 말고 찾아보기 !!! (자동완성에 있는 기능 읽어보면서)
		
		// s2에서 2번째에 있는 글자 출력
		// chatAt() : 특정 위치에 있는 글자를 뽑아낼 때
		System.out.println(s2.charAt(2));

		// s2는 총 몇글자인지 출력
		// length() : 총 글자수를 알고 싶을 때
		System.out.println(s2.length());
		
		// s2가 '곧' 이라는 단어로 시작하는지
		// startsWith() : 시작하는 단어가 맞는지 확인할 때 (true / false)
		System.out.println(s2.startsWith("곧"));
		
		// s2에 '너무'라는 단어가 있는지
		// contains() : 찾는 글자가 있는지 (true / false)
		System.out.println(s2.contains("너무"));
		
		// s2에서 '새해'를 '연말'로 바꿔서 출력
		// replace() : 특정 글자를 다른 글자로 바꿀 때
		System.out.println(s2.replace("새해", "연말"));
		
		// s2에서 2~5번째 글자만 출력
		// substring() : 원하는 위치의 글자를 뽑을 때
		//			(시작위치, 끝위치 - 1)
		// subSequence() : 원하는 위치의 글자를 뽑을 때 // 다른 기능으로 subSequence가 있지만 잘 안씀
		//			(시작위치, 끝위치 - 1)
		System.out.println(s2.substring(2, 6));
		System.out.println("-------------------------------");
		
		// String 객체를 생성하는데 형식을 잡아서
		String s3 = String.format("무게 : %.2fkg", 123.456789); /// 그냥 출력하는거랑 무슨상관이지?
		System.out.println(s3);
		System.out.println("----------------------------");
		
		// s2에 글자를 추가
		s2 = s2 + " 내년에는 모두 다 잘 됐으면 좋겠어요!";
		System.out.println(s2);
		s2 += "모두 부자되세요 ~ ^-^";
		System.out.println(s2);
		
		s2 = new String(s2 + "ㅎㅎㅎㅎㅎ");
		System.out.println(s2);
		
		// String 대량으로 추가
		StringBuffer sb = new StringBuffer(s2);
		sb.append(" 일은 적게하되 돈은 많이 벌게 해주세요!");
		sb.append(" ㅋㅋㅋㅋㅋ");
		sb.append(" 근데 주말에도 바쁘네요 ?");
//		System.out.println(sb.getClass()); /// 버퍼라는곳에 담김
		
		String s4 = sb.toString();
		System.out.println(s4);
		System.out.println("====================");
		
		// String 분리
		String s5 = "김비버,박비버,최비버,저스틴비버";
		// 1. split()
		String[] s5Ar = s5.split(",");
		System.out.println(s5Ar[0]);
		System.out.println(s5Ar[3]);
		System.out.println("-------------------------------");
		
		// 2. StringTokenizer
		StringTokenizer st = new StringTokenizer(s5, ","); // 일종의 토큰이라는 이름으로 저장됨
		// 무조건 순서대로 나옴
//		System.out.println(st.nextToken()); // 그 토큰에 접근하려면
//		System.out.println(st.nextToken()); 
//		System.out.println(st.nextToken()); 
//		System.out.println(st.nextToken()); 
		
		while (st.hasMoreTokens()) { // 반복문형식 + 순서대로 나옴
			System.out.println(st.nextToken());
		}
		
		// 속도적인 면 : StringTokenizer
		// data속에서 변수가 많다면 : split
		
	}
}














