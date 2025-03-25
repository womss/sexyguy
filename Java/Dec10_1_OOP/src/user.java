import java.util.Scanner;

public class user {
	Scanner userSay = new Scanner(System.in); // 멤버변수
	int userNum;		// 유저가 뽑은 수
	int comPic;			// 컴퓨터가 뽑은 수
	String resultc;		// 컴퓨터가 짝인지 홀인지 결과
//	String resultu;		// 사용자가 짝인지 홀인지 결과
	String userBat;			// 
	public int answerUser() {
		return userSay.nextInt(); // 이만큼만 돌리겠다
	}
	public String answerBat() {
		return userSay.next();
	}

}

//
//user.userBat
