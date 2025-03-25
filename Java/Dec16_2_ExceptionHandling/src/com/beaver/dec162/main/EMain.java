package com.beaver.dec162.main;

import java.util.Scanner;

public class EMain {
	public static void main(String[] args) {
		// 프로그램 실행 => 콘솔창에 빨간글씨로 ~~~나오는 것 ?
		//		=> 에러/경고/버그/오류알림 ???
		
		// error
		//		한국어 -번역-> 영어
		//		사과			aplle
		//		바나나		banana
		//		띱퀭			???
		// Java의 문법에 안맞게 써서 컴파일이 불가능한 상태
		//	개발자 잘못
		//	완성본은 나오지 않음
		
		// warning
		//		지저분한 코드
		//		개발자 잘못 !
		//		컴파일은 가능하니 => 완성본은 나옴
		//				(실행하는데 문제없음 O)
		//		이클립스가 잔소리를 함...
		//		ex) Scanner 객체 만들고 나서 => 이 기능을 안닫음
		
		// exception
		//		프로그램은 100% 완성
		//		실행할 때 뭔가 외부적인 요인에 의해서
		//			작동이 제대로 안되는 상황
		//		개발자 잘못은 아님
		//		개발자 입장 => 개발자가 상황을 예측해서 대책은 세워놓자!
		
		// x : ? y : ? 입력받아서
		// 더한 값, 뺀 값, 곱한 값, 나눈 값을 출력 (정수로만)
		
		Scanner k = new Scanner(System.in);
		System.out.println("x : ");
		int x = k.nextInt();
		
		System.out.println("y : ");
		int y = k.nextInt();
		
		System.out.println(x + y);
		System.out.println(x - y);
		System.out.println(x * y);
		System.out.println(x / y);
		
		// 만약에 y값에다가 0을 넣으면...?
		
		// Exception 처리를 할 수 있는 방법!
//		try {
//			일단 이 부분을 실행 - (내용)
//		} catch (예외유형명 변수명) {
//			try쪽을 실행하다가 해당 유형의 예외가 발생하면
//			이 블록을 실행
//			만약, 예외 없이 정상적으로 실행됐을 경우,
//			catch부분은 그냥 지나치고 다음 코드를 실행
//		} catch (Exception e) {
//			...
//		} finally {
//			정상적으로 프로그램이 실행됐던지, 
//			예외가 터졌던지 상관없이 실행
//			이 블록은 필수적으로 작성 X
//			return보다 먼저 실행
//		}
		// 두가지 문제가 동시에 발생한 경우?
		//		=> 먼저 등장하는 catch의 내용만 실행
		// Java의 입장에서는 첫번째 예외가 발생했을 때
		//	즉시 실행 중지 후 해당 예외처리부분으로 넘어가기 때문!
		
		// x : 10, y : 0 => 75 - 76 (Arith) ... 80 - 81
		// x : 10, y : 1 => 75 - 76 - 77, // 77 - 78 - 79 (Index) - 82 - 83
		// x : 2, y : 1 => 75 - 76 - 77, // 78 - ar [2] // 79
//		try {
//			int d = x / y;
//			System.out.println(d);
//			int[] ar = {1, 2, 3};
//			System.out.println(ar[x]);
//		} catch (ArithmeticException ae) {
//			System.out.println("아 ~ 0으로 어떻게 나누냐고 ~ ㅋㅋㅋ");
//		} catch (IndexOutOfBoundsException ioe) {
//			System.out.println("아 ~ 배열 인덱스 범위가 넘었다고 ~ ㅋㅋㅋ");
//		}
		try {
			int d = x / y;
			System.out.println(d);
			int[] ar = {1, 2, 3};
			System.out.println(ar[x]);
		} catch (Exception e) { // 모~~~든 exception을 다 잡아줌
			System.out.println("능지 떡락ㅋ");
			e.printStackTrace();	// 상황 출력 (개발자용)
		} finally {
			System.out.println("엌ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
		}
	}
}
























