import java.util.Scanner;

public class KIMain {
	public static void main(String[] args) {
		
		// 오늘 기분은 어떤가요 ?
		// 오늘 컨디션 점수는 ?
		// 대중교통 몇 번 갈아타고 오셨나요 ?
		// 밤에 푹 주무셨나요 ? (잘 잤으면 true / 아니면 false)
		// 몇 시간 주무셨나요 ? (ex : 6.0시간)
		
		// Scanner로 입력받아서 출력까지
		
		Scanner keyboard = new Scanner(System.in);
		
		
		//String feeling = "good";
		//double con = 67.8;
		//int bus = 1;
		//boolean nap = false;
		//double how = 5.5;
		
		System.out.print("오늘의 기분 : ");
		String feeling = keyboard.next();
		System.out.print("오늘의 컨디션 : ");
		double con = keyboard.nextDouble();
		System.out.print("대중교통 환승 횟수 : ");
		int bus = keyboard.nextInt();
		System.out.print("밤에 푹 잤는지 : ");
		boolean nap = keyboard.nextBoolean();
		System.out.print("몇 시간 잤는지 : ");
		double how = keyboard.nextDouble();
		
		System.out.println("----------------------------");
	
		
		System.out.printf("오늘의 기분 : %s\n", feeling);
		System.out.printf("오늘의 컨디션 : %.1f점\n", con);
		System.out.printf("대중교통 환승 횟수 : %d번\n", bus);
		System.out.printf("밤에 푹 잤는지 : %b\n", nap);
		System.out.printf("몇 시간 잤는지 : %.1f시간\n", how);
		
		
		
		
	}
}
