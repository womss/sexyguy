
// Part1 : 절차지향 프로그래밍(순서대로 잘 써서 결과를 잘 내자)
// Part2 : 객체지향 프로그래밍
// Part3 : 기타 등등... 외부 라이브러리

// 조건문
// 반복문
// 배열
// ------------------------> 정보올림피아드 문제
// Part2...

import java.util.Scanner;

public class RMain2 {
	public static void main(String[] args) {
		// 누구 : 
		//		매니저
		//			시스템관리
		//			학생관리
		//			수업관련 업무
		//		강사
		//			학생관리
		//			수업관련 업무
		//		학생
		//			수업관련 업무
		//	를 반복하다가 "끝이라고 입력하면 프로그램 종료 if + break
		Scanner k = new Scanner(System.in);
		String n = "";
		for (int i = 0; true; i++) {
			System.out.println(" 직책 입력 : ");
			String name = k.next();
			
			switch (n) {
			case "매니저":
				System.out.println("시스템관리");
			case "강사":
				System.out.println("학생관리");
			case "학생":
				System.out.println("수업관련 업무");
				break;
//				if (name.equals("끝")) {
//					break;
//				}System.out.println();
			
			}
		}
		}
		
		
		
	}

