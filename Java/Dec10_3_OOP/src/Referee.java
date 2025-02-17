
public class Referee {
	String doS = "";
	String caS = "";
	
	int win;
	int draw;
	
//	public String dog(Dog d) { 
//		int g = d.dogBat();	// 사용자가 낸 값을 g에
//		if (g == 1) {
//			return "가위";
//		} else if (g == 2) {
//			return "바위";
//		} else if (g == 3) {
//			return "보";
//		} d.dogBat();
//		return "";
//		
//	}
	public String dog(int g) {// 사용자가 낸 값을 g에
		if (g == 1) {
			return "가위";
		} else if (g == 2) {
			return "바위";
		} else if (g == 3) {
			return "보";
		}return"";
	}
	
	public int Cat(Cat c) {
		int t = c.think();
		return t;
	}
	public void print(Dog d, Cat c) {
		while (true) {			// 2. 반복문 시작
		int cc = c.think(); 	// 3. 여기서 고양이 
		int dd = d.dogBat();
		
		if ((dd - cc == -2) || (dd - cc == 1)) { // 비교값이 ?일때 어떤걸 출력 하겠다
			System.out.printf("사용자는 %s, 고양이는 %s라서", dog (dd), dog (cc)); //@@@@
			System.out.println("이김");
			win++;
		} else if (dd == cc) {
			System.out.printf("사용자는 %s, 고양이는 %s라서", dog (dd), dog (cc)); //@@@@
			System.out.println("비김");
			draw++;
		} else {
			System.out.printf("사용자는 %s, 고양이는 %s라서", dog (dd), dog (cc)); //@@@@
			System.out.println("짐");
			System.out.printf("사용자의 전적은 %d승 %d무", win, draw);
			break;
		}

		}
		
	}
	public void start(Dog d, Cat c) {
		
		print(d,c); // 1. 프린트메소드 시작
	}
}

