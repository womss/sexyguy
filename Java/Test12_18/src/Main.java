import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*입력 형식:

			"yyyy-MM-dd" 형식으로 날짜를 입력받습니다.
			예: 2024-06-17
			출력 형식:

			입력받은 두 날짜를 "yyyy년 MM월 dd일 (요일)" 형식으로 출력합니다. 예: 2024년 06월 17일 (월요일)
			두 날짜 간의 일수 차이를 계산하여 출력합니다.
			예: 이벤트 기간: 3일
			추가 조건:

			**"이벤트 시작 날짜"**와 **"이벤트 종료 날짜"**를 뒤바꿔 입력했을 경우, 자동으로 시작 날짜와 종료 날짜를 맞바꿔 계산하세요.
			예: 사용자가 2024-06-20을 시작 날짜로 입력하고, 2024-06-17을 종료 날짜로 입력했을 경우에도 올바른 계산 결과를 출력해야 합니다.
			유효성 검증:

			사용자가 날짜를 잘못된 형식으로 입력했을 경우, 적절한 오류 메시지를 출력하고 프로그램을 종료하지 않고 다시 입력을 받을 수 있도록 하세요.*/
		
		Scanner k = new Scanner(System.in);
		
		try {
			System.out.println("날짜 입력 (yyyy-MM-dd) : ");
			String eventStart = k.next();
			System.out.println("날짜 입력 (yyyy-MM-dd) : ");
			String eventEnd = k.next();
			
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date eventStrD = inputFormat.parse(eventStart);
			Date eventEndD = inputFormat.parse(eventEnd);
			
			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy년 MM월 dd일 (E요일)");
			int eventSD = outputFormat.parse(eventStart);
			
			
			
			
		} catch (Exception e) {
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
