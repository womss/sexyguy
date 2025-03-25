import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class CMain5 {
	
		public static String dbput() {
			Scanner k = new Scanner(System.in);
			System.out.println(" 직업 입력 : ");
			String db = k.next();
			return db;
			
		}
		
		public static void dbsearch(String db) {
			switch (db) {
			case "DBA":
				System.out.printf("서버에 관한 전원관리\n백업/복구");
			case "DBP":
				System.out.println("명령어로 CRUD");
			case "DBU":
				System.out.println("서비스 활용");
				break;
			default:
				System.out.println("서비스 이용 예정자");
				break;
			}
			
			
		}
	public static void main(String[] args) {
		// 직업 : 
		//		DBA (상위 데이터베이스 관리)
		//			서버에 관한 전원관리
		//			백업/복구
		//			명령어로 CRUD
		//			서비스 활용
		//		DBP (데이터베이스 프로그래머)
		//			명령어로 CRUD
		//			서비스 활용
		//		DBU (사용자)
		//			서비스 활용
		String db = dbput();
		dbsearch(db);
		
		//강사님
		Scanner k = new Scanner(System.in);
		System.out.println("직업 : ");
		String role = k.next();
	
		switch (role) {
		case "DBA":
			System.out.println("전원 관리");
			System.out.println("백업/복구");
		case "DBP":
			System.out.println("명령어로 CRUD");
		case "DBU":
			System.out.println("서비스 활용");
			break;
		default:
			System.out.println("DB ~ 손해보험");
			break;
		}
		
		
		
		
	}
}
