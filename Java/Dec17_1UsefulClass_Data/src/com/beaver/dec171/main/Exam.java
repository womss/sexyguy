package com.beaver.dec171.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Exam {
	public static void main(String[] args) {
		// 학생의 (이름/생년월일(yyyy.MM.dd)/국어/수학/영어 )
		//		를 입력 받아서
		// 학생의 이름, 생년월일(요일), 나이, 총점, 평균 값을 출력
		// StringTokenizer
				
			Scanner k = new Scanner(System.in);
			System.out.println("이름/생년월일(yyyy.MM.dd)/국어점수/수학점수/영어점수 입력");
			String s = k.next();
			
			StringTokenizer st = new StringTokenizer(s, "/");
			System.out.printf("이름 : %s", st.nextToken());
			
			try {
				String bd = st.nextToken();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				Date birthday = sdf.parse(bd);
			
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
				String birthdayStr = sdf2.format(birthday);
				System.out.printf("생일 : %s\n", birthdayStr);
				
				SimpleDateFormat yearFmt = new SimpleDateFormat("yyyy");
				String nowYr = yearFmt.format(new Date()); // 올해의 연도와 태어난 연도
				int ny = Integer.parseInt(nowYr);
				
				String birthdayYr = yearFmt.format(birthday);
				int by = Integer.parseInt(birthdayYr);
				
				System.out.printf("나이 : %d살\n", ny - by);
				System.out.printf("나이 : %d살\n", new Date().getYear() - birthday.getYear());
				
				int kor = Integer.parseInt(st.nextToken());
				int math = Integer.parseInt(st.nextToken());
				int eng = Integer.parseInt(st.nextToken());
				
				System.out.printf("국어 : %d점\n", kor);
				System.out.printf("수학 : %d점\n", math);
				System.out.printf("영어 : %d점\n", eng);
				
				System.out.printf("총점 : %d점\n", kor + math + eng);
				System.out.printf("총점 : %d점\n", (double) (kor + math + eng) / 3);
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
				
				
	}
}
