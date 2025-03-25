import java.util.Scanner;

public class TenSecond {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("첫번째 도전자님 닉네임을 입력하세요! >>> ");
		String user1 = k.next();

		System.out.println(user1 + "님 시작하려면 <Enter>를 누르세요.");
		k.nextLine();
		k.nextLine();
		// System.out.println(System.currentTimeMillis());

		long a = System.currentTimeMillis(); // 시작하려고 엔터 눌렀을 때의 시간값(밀리초)

		System.out.println("10초가 된 것 같으면 <Enter>를 누르세요.");
		k.nextLine();
		long b = System.currentTimeMillis(); // 엔터 눌러서 끝냈을 때의 시간값(밀리초)

		double result1 = (double) ((b - a) * 0.001); // 밀리초를 초로 계산

		System.out.printf("종료시간 : %.3f초\n", result1);

		System.out.print("두번째 도전자님 닉네임을 입력하세요! >>> ");
		String user2 = k.next();

		System.out.println(user2 + "님 시작하려면 <Enter>를 누르세요.");
		k.nextLine();
		k.nextLine();
		long c = System.currentTimeMillis();

		System.out.println("10초가 된 것 같으면 <Enter>를 누르세요.");
		k.nextLine();
		long d = System.currentTimeMillis();

		double result2 = (double) ((d - c) * 0.001); // 밀리초를 초로 계산

		System.out.printf("종료시간 : %.3f초\n", result2);

		if (Math.abs(result1 - 10) < Math.abs(result2 - 10)) {
			System.out.printf("%s님이 %.3f초 차이로 승리하셨습니다 !", user1, Math.abs(Math.abs(result1) - Math.abs(result2)));
		} else if (Math.abs(result1 - 10) > Math.abs(result2 - 10)) {
			System.out.printf("%s님이 %.3f초 차이로 승리하셨습니다 !", user2, Math.abs(Math.abs(result1) - Math.abs(result2)));

		}
	}
}
