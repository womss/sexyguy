import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*사용자로부터 **"이벤트 날짜"**를 입력받아 날짜 형식을 변환하는 프로그램을 작성하세요.

		입력 형식:

		yyyy-MM-dd 형식으로 날짜를 입력받습니다.
		예시: 2024-06-17
		출력 형식:

		입력받은 날짜를 yyyy년 MM월 dd일 (요일) 형식으로 변환해 출력하세요.
		예시: 2024년 06월 17일 (월요일)*/
//		Scanner k = new Scanner(System.in);
//		System.out.println("날짜 입력 (yyyy-mm-dd) : ");
//		String b = k.next();
//		
//		try {
//			
//			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
//			Date date = inputFormat.parse(b); //b 문자열을 inputFormat의 형식(yyyy-MM-dd)에 맞게 해석(파싱)해서, 해당 날짜를 Date 객체인 date에 저장한다."
//			
//			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
//			String formattedDate = outputFormat.format(date);
//			
//			System.out.println(formattedDate);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		
//		사용자로부터 **"이벤트 시작 날짜"**와 **"이벤트 종료 날짜"**를 입력받아 날짜 형식을 변환하고, 두 날짜의 차이를 계산하는 프로그램을 작성하세요.
		// 2024-06-17
		// 2024-06-20


		Scanner k = new Scanner(System.in);
		
		try {
			System.out.println("이벤트 시작 날짜 입력 (yyyy-MM-dd) : ");
			String eventSatrt = k.next();
			
			System.out.println("이벤트 종료 날짜 입력 (yyyy-MM-dd) : ");
			String eventEnd = k.next();
			
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = inputFormat.parse(eventSatrt);
			Date endDate = inputFormat.parse(eventEnd);
			int sumY = endDate.getYear() - startDate.getYear();
			int sumM = endDate.getMonth() - startDate.getMonth();
			int sumD = endDate.getDay() - startDate.getDay();
			
			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
			String startDateStr = outputFormat.format(startDate);
			String endDateStr = outputFormat.format(endDate);
			
			
			System.out.println(startDateStr);
			System.out.println(endDateStr);
			System.out.printf("이벤트 기간 : %d년 %d월 %d일간", sumY, sumM, sumD );
			
		} catch (Exception e) {
			System.out.println("날짜를 잘못 입력했습니다");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
