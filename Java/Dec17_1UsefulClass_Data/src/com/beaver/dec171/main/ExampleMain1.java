package com.beaver.dec171.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExampleMain1 {
	public static void main(String[] args) {
		// 학생의 (이름/생년월일(yyyy.MM.dd)/국어/수학/영어 )
		//		를 입력 받아서
		// 학생의 이름, 생년월일(요일), 나이, 총점, 평균 값을 출력
		// split
		
		
		Scanner k = new Scanner(System.in);
		System.out.println("이름/생년월일(yyyy.MM.dd)/국어점수/수학점수/영어점수 입력");
		String a = k.next();
		
		String[] sDta =  a.split("/");										// 입력받은 문자열을 /로 나누어서 조각, 각각은 sDta라는 토큰 목록으로 저장
		System.out.printf("학생의 이름 : %s\n", sDta[0]);
		
		// 강사님
		try {
			// 생일(나이)
			String bd = sDta[1]; 											// sDta[1]에 저장된 생년월일(예: 2010.05.12)을 bd라는 변수에 저장
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd"); 		// SimpleDateFormat은 문자열을 날짜로 바꾸거나, 날짜를 문자열로 바꿀 때 사용
			Date birthday = sdf.parse(bd); 									// sdf.parse(bd)는 문자열 bd를 **날짜(Date)**로 바꾸고 birthday 변수에는 날짜가 저장
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd E");	//"yyyy/MM/dd E"는 날짜를 년/월/일 요일 형식으로 바꿔줌 예: 2010/05/12 수
			String birthdayStr = sdf2.format(birthday);						// birthday에 저장된 날짜를 sdf2 형식으로 바꿔서 birthdayStr에 저장
			System.out.printf("생일 : %s\n", birthdayStr);
			
			Date now = new Date();											// Date는 현재 날짜와 시간을 가져옴
			//---------------------
			SimpleDateFormat yrFmt = new SimpleDateFormat("yyyy"); 			// "yyyy" 형식은 연도만 가져오는 형식
			String nowYr = yrFmt.format(now);								// 현재 날짜에서 연도만 가져와서 nowYr에 저장
			String birthdayYr = yrFmt.format(birthday);						// 생일 날짜에서 연도만 가져와서 birthdayYr에 저장
			
			int ny = Integer.parseInt(nowYr);								// 문자열 nowYr과
			int by = Integer.parseInt(birthdayYr);							// birthdayYr을 숫자로 바꿈 예: "2024" → 2024
			int age = ny - by;												// 현재 연도에서 생년월일 연도를 빼서 나이를 계산해
			System.out.printf("나이 : %d살\n", age);							// 결과: "나이 : 14살"
			//---------------------이게 귀찮다면
			System.out.printf("나이 : %d살\n", now.getYear() - birthday.getYear());
			//---------------------이렇게
			int kor = Integer.parseInt(sDta[2]);							// 국어
			int math = Integer.parseInt(sDta[3]);							// 수학
			int eng = Integer.parseInt(sDta[4]);							// 영어 점수를 문자열에서 숫자로 바꿈
			
			System.out.printf("국어 : %d점\n", kor);
			System.out.printf("수학 : %d점\n", math);
			System.out.printf("영어 : %d점\n", eng);
			
			System.out.printf("총점 : %d점\n", kor + math + eng);
			System.out.printf("평균 : %.2f점\n", (double) (kor + math + eng) / 3);
			
			
		} catch (Exception e) {
		}
		
		//내가 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		try {
			SimpleDateFormat aaa = new SimpleDateFormat("yyyy.MM.dd");
			Date birth = aaa.parse(sDta[1]);
			System.out.printf("학생의 생년월일 : %s\n", birth);
			int bb = birth.getYear(); 
			Date age1 = new Date();
			String bbb = aaa.format(age1);
			int y1 = age1.getYear();
			int y2 = y1 - bb;
			System.out.println(y2+"살");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("=========================================");
		SimpleDateFormat age = new SimpleDateFormat("yyyy");
//		try {
//			birt
//			
//			System.out.println("학생의 나이 : " + ((age1.getYear() + 3900)- yyyy1) + "살");
//		} catch (Exception e) {
//		}
//		System.out.println(age1.getYear() + 1900 );
//		System.out.println(((age1.getYear() + 1900)- yyyy1) + "살");
		System.out.printf("국어 점수 : %s\n", sDta[2]);
		System.out.printf("수학 점수 : %s\n", sDta[3]);
		System.out.printf("영어 점수 : %s\n", sDta[4]);
//		int[] aat = Integer.parseInt(aa[2]);
		int sDta2 = Integer.parseInt(sDta[2]);
		int sDta3 = Integer.parseInt(sDta[3]);
		int sDta4 = Integer.parseInt(sDta[4]);
		System.out.printf("총점 : %s\n", (sDta2+sDta3+sDta4));
		System.out.printf("평균 점수 : %s\n", (sDta2+sDta3+sDta4) / 3);
		
	}
}
