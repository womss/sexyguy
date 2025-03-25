import java.util.Scanner;

public class KIMain4 {
	public static void main(String[] args) {
		// 메뉴판 (분식)
		// 떡볶이, 순대, 어묵, 튀김, ...
		// 메뉴들에 대한 가격을 입력 받아서
		// 메뉴판 모양으로 출력
		
		Scanner k = new Scanner(System.in);
		
		
		System.out.print("떡볶이 : ");
		int ri = k.nextInt();
		System.out.print("순대 : ");
		int sun = k.nextInt();
		System.out.print("어묵 : ");
		int fi = k.nextInt();
		System.out.print("튀김 : ");
		int ch = k.nextInt();
		System.out.print("콜라 : ");
		int ko = k.nextInt();
		System.out.print("사이다 : ");
		int si = k.nextInt();
		//%.7d
		System.out.println(" _______________________________");
		
		System.out.println("ㅣ___________만나 분식♬____________ㅣ");
		System.out.println("ㅣ menu...\t\t\tㅣ");
		System.out.printf("ㅣ 떡볶이 \t \t      ...%,d냥\tㅣ\n", ri);
		System.out.printf("ㅣ 순대 \t \t      ...%,d냥\tㅣ\n", sun);
		System.out.printf("ㅣ 어묵 \t \t      ...%,d냥\tㅣ\n", fi);
		System.out.printf("ㅣ 튀김 \t \t      ...%,d냥\tㅣ\n", ch);
		System.out.printf("ㅣ\t\t\t \tㅣ\n");
		System.out.printf("ㅣ 음료...\t\t \tㅣ\n");
		System.out.printf("ㅣ 콜라 \t \t      ...%,d냥\tㅣ\n", ch);
		System.out.printf("ㅣ 사이다 \t \t      ...%,d냥\tㅣ\n", ch);
		
		System.out.printf("ㅣ\t\t\t \tㅣ\n");
		System.out.println("ㅣ________________ ______________ㅣ");
		
		
		
		
		
		
		
		
		
		
	}
}
