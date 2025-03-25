import java.util.Scanner;

public class KIMain1 {
	public static void main(String[] args) throws InterruptedException {
		// Scanner : Java에 내장되어 있는 기능 중 하나
		// 이 기능을 사용하기 위해서는 해당 클래스 파일로 끌고 오기 위한 'Import'라는 것이 사용됨
		// 이 Scanner라는걸 사용하려면 조건이 하나 필요한데...
		
		// new ~~~ : 객체
		
		// Scanner는 화면(이클립스의 콘솔창)으로부터
		//	데이터를 입력 받는 기능
		
		Scanner keyboard = new Scanner(System.in);
		
		// 이름을 콘솔창에 출력
		//System.out.print("이름 : ");
		//String name = keyboard.next();
		////System.out.println(name);

		// 키, 몸무게, 신발사이즈, 여행가고 싶은 곳,
		// 좋아하는 숫자, 놀고 싶은지 유무를 입력받아서 출력
		
		//System.out.print("키 : ");
		//double tall = keyboard.nextDouble();
		
		//System.out.print("몸무게 : ");
		//double wei = keyboard.nextDouble();
		
		//System.out.print("신발 사이즈 : ");
		//int sh = keyboard.nextInt();
		
		//System.out.print("여행가고 싶은 곳 : ");
		//String tr = keyboard.next();
		
		//System.out.print("좋아하는 숫자 : ");
		//int num = keyboard.nextInt();
		
		//System.out.print("놀고 싶은지 유무 : ");
		//boolean hang = keyboard.nextBoolean();
		
		//System.out.printf("이름 : %s\n", name);
		//System.out.printf("키 : %.1fcm\n", tall);
		//System.out.printf("몸무게 : %.1fkg\n", wei);
		//System.out.printf("신발 사이즈 : %dmm	\n", sh);
		//System.out.printf("여행가고 싶은 곳 : %s\n", tr);
		//System.out.printf("좋아하는 숫자 : %d\n", num);
		//System.out.printf("놀고싶은지 유무 : %b\n", hang);
		
		// .bat파일 생성 =>
		// '끄고 싶으면 아무거나 입력하세요 : '
		// 뭔가 입력해서 엔터 치면
		// 1초마다 .이 세번 나온 후 x3
		// '프로그램을 종료합니다' 라는 메시지가 출력되고
		// 0.5초후 프로그램 종료
		
		
		
		
		
//		System.out.printf("끄고 싶으면 아무키나 입력하세요");
//		String end = 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.print("끄고 싶으면 아무키나 입력하세요 : ");
		String quit = keyboard.next();
		
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.println("프로그램을 종료합니다.");
		Thread.sleep(500);
		
		//System.out.print("끄고 싶으면 아무키나 입력하세요 : ");
		//String end = keyboard.next();
		
		
		//Thread.sleep(500);
		//System.out.printf("프로그램을 종료합니다");
		//keyboard.close();
		
		
		
		
		
		
		
		
	}
}




