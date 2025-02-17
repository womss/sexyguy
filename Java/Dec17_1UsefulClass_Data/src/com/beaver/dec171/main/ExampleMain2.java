package com.beaver.dec171.main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ExampleMain2 {
	public static void main(String[] args) {
		// 학생의 (이름/생년월일(yyyy.MM.dd)/국어/수학/영어 )
		//		를 입력 받아서
		// 학생의 이름, 생년월일(요일), 나이, 총점, 평균 값을 출력
		// StringTokenizer
		
		Scanner k = new Scanner(System.in);
		System.out.println("이름/생년월일(yyyy.MM.dd)/국어점수/수학점수/영어점수 입력");
		String studentInfo = k.next();
		
		StringTokenizer stInfo = new StringTokenizer(studentInfo, "/"); // 학생정보 문자열을 stInfo에 넣음
		String name = "";
		int birth = 0;
		int sum = 0;
		int count = 0;
		
		while (stInfo.hasMoreTokens()) { // 학생정보 토큰을 다 내보낼때까지 반복
			try {
				name = stInfo.nextToken(); 
				System.out.printf("학생이름 : %s", name);
				birth = Integer.parseInt(stInfo.nextToken()); 
				System.out.printf("학생 생년월일 : %d" );
				
			} catch (Exception e) {
			}
		}
		System.out.printf("총합 : %d\n", sum);
		System.out.printf("평균 : %.2f\n", (double) sum / count);
		System.out.println("===========================");
		
			
			System.out.printf("이름 : ");
			System.out.println(stInfo.nextToken());
			
			
			
			
			
			
			
			
			
			
			
			
//			System.out.printf("생일 : ");
//			System.out.println(st.nextToken());
//			System.out.printf("나이 : ");
//			System.out.println();
//			System.out.printf("총점 : ");
//			System.out.println(st.nextToken());
//			System.out.printf("평균점수 : ");
//			System.out.println(st.nextToken());
//			System.out.printf("영어점수 : ");
//			System.out.println(st.nextToken());
			
		}
	}
