import java.util.Scanner;

public class CMain3 {
	// 평일 스케쥴 출력해주는 프로그램
	
	// 시간을 입력 받아서 (24시간 단위)
	//	=> 해당시간에 속하는 내용을 출력
	//	=> (입력한 시간이) 시간 범위가 아니면 다시 입력
	
	// 오전 9시 ~ 오후 6시 : 학원에서 공부 				//h>=9 ~ h<=18
	// 오전 9시, 오후 6시 : QR찍기					//h=9,h=18		@
	// 오후 1시 ~ 오후 2시 전: 점심시간					//h= 13		@
	// 오후 6시 넘어서 ~ 오후 8시 : 집에 가는 시간		//h>=18 ~ h<=20
	// 오전 6시 ~ 오전 9시 전 : 기상 + 씻기 + 학원가기	//h>=6 ~ h>9
	// 오후 8시 ~ 오전 6시 : 여가시간 + 취침			//h>=20 ~ <=24
												//h>=0 ~ <=6
												// 0,6,9,13,18,20,24
	
	// 시간을 입력받는 함수
	
	// 시간을 출력하는 함수
	
	// 결과를 출력하는 함수
	
	public static int h() {
		Scanner k = new Scanner(System.in);
		System.out.printf("스케쥴 체크 시간 입력\n24시간제로 입력해 주세요: ");
		int h = k.nextInt();
		if (!(h >= 0 && h <= 23)) {
			System.err.printf("%02d시는 없습니다", h);
		}
		int s = h >=0 && h<23 ? h : h();
		return s;
	}
	
	public static void printHour(int h) {
		System.out.println("=====================");
		System.out.printf("\t%02d시 !\n", h);
		System.out.println("=====================");
	}
	public static void printResult(int h) {
		if (h >= 9 && h <= 18) {
			System.out.println("학원에서 공부를 합니다");
			if (h == 9 || h == 18) {
				System.out.println("QR찍기");
			}else if (h >= 13 && h < 14) {
				System.out.println("밥");
			}
		}
		else if (h > 18 && h <= 20) {
			System.out.println("귀가");
		}
		else if (h >= 6 && h < 9) {
			System.out.println("일어나기 + 씻기 + 학원가기");
		}
		else {
			System.out.println("여가시간 + 취침");
		}
	}
	
	
		
		
//		switch (h) {
//		case 9: case 18:
//			System.out.println("QR찍기");
//		break;
//		case 13:
//			System.out.println("밥먹자");
//		case 
//		case h:
//			if (h>=0 && h<6) || h >= 20 && h <= 24) {									
//				System.out.println("여가시간 + 취침");
//			}
//			else if (h>=6 && h<9) {
//				System.out.println("기상 + 씻기 + 학원가기");
//			}
//			else if (h) {
//				
//			}
//			break;
//
//		default:
//			break;
//		}
	
	
	public static void main(String[] args) {
		int h = h();
		//System.out.printf("스케쥴 확인 체크 시간 : %d시", h);
		printHour(h);
		printResult(h);

	}
}
