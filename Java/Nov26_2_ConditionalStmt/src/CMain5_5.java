import java.util.Scanner;


public class CMain5_5 {
			// 직업 : 
			//		DBA (상위 데이터베이스 관리)
			//			서버에 관한 전원관리		4
			//			백업/복구				3
			//			명령어로 CRUD			2
			//			서비스 활용				1
			//		DBP (데이터베이스 프로그래머)
			//			명령어로 CRUD			2
			//			서비스 활용				1
			//		DBU (사용자)
			//			서비스 활용				1
		
	public static String db() {
		Scanner k = new Scanner(System.in);
		System.out.println("직업 : ");
		String j = k.next();
		return j;
		
	}
	
	
	public static void match(String j) {
		switch (j) {
		case "DBA":
			System.out.println("서버에 관한 전원관리");			
			System.out.println("백업/복구");
		case "DBP":
			System.out.println("명령어로 CRUD");
		case "DBU":
			System.out.println("서비스 활용");
			break;

		default:
			System.out.println("산와머니");
			break;
		}
		
		
	}
	public static void main(String[] args) {
		String jj = db();
		match(jj);
	}
}
	
	

