
public class PMain3 {
	public static void main(String[] args) {
		//print
		//System.out.print("1asdf");
		//System.out.print("2asdf");
		
		// printf (Formatting - 형식 지정)
		//System.out.printf("%?", 값); 의 형태로 사용
		
		// 정수 (decimal)
		// %d : 정수 데이터가 들어올 자리(10진수) => 모든 언어 공통
		// %xd : 빈자리가 띄어쓰기로 채워져서 출력
		// %0xd : 빈자리를 0으로 채워서 x자리의 숫자로 만들어줌
		System.out.printf("%d\n", 1);
		System.out.printf("%3d\n", 1);
		System.out.printf("%010d\n", 1);
		System.out.println("------------");
		
		// 실수 (float)
		//	%f : 실수 데이터가 들어올 자리
		//	%.xf : 소수점 이하의 자릿수 (잘리는 부분은 반올림 처리
		// 		빈자리는 0으로 채워줌
		System.out.printf("%f\n", 123.456789);
		System.out.printf("%.3f\n", 123.456789);
		System.out.printf("%.10f\n", 123.456789);
		System.out.println("-----------");
		
		// 문자열 (String)
		// %s : 글자데이터가 들어올 자리
		// 숫자 : 그냥 입력하면 됨
		// 글자 : 그냥 입력하게 되면 Java 문법으로 해석 => 오류
		//		=> "내용" (큰따옴표 안에 글자 넣기)
		System.out.printf("%s\n", "오늘 하루가 끝나가네요");
		System.out.println("-----------------");
		
		
		// 오늘 날짜 기준으로 연도		=> xxxx년
		System.out.printf("%d년\n", 2024);
		System.out.printf("%4d년\n", 2024);
		System.out.printf("%4d%s\n", 2024,"년");
	
		// 월					=> xx월
		System.out.printf("%d월\n", 11);
		System.out.printf("%02d월\n", 11);
		System.out.printf("%02d%s\n", 11,"월");
		// 일					=> xx일
		System.out.printf("%d일\n", 19);
		System.out.printf("%02d일\n", 19);
		System.out.printf("%02d%s\n", 19,"일");
		
		System.out.printf("%s\n", "2024년\0"+"11월\0"+"19일");
		System.out.printf("%s\n", "2024"+"년\0"+"11월\0"+"19일");
		System.out.printf("%d년\n", 2024);
		System.out.printf("%d%s\n", 2024, "년");
		
		// 연-월-일의 형태로 붙여서
		//	ex) 날짜 : xxxx-xx-xx
		System.out.printf("날짜 : %4d-%02d-%02d\n", 2024, 11, 19);
		// 날씨 : 추움
		System.out.printf("날씨 : %s\n", "추움");
		// 기온 : 10.5도
		System.out.printf("기온 : %.1f℃\n", 10.5);
		// 습도 : 41%
		// %% : %를 글자로 표현하고 싶을 때 (printf에서만)
		System.out.printf("습도 : %d%%\n", 41);
		
		
		System.out.printf("%s\n", "2024년"+"-11월"+"-19일");
		System.out.printf("%s\n", "날씨 : ");
		
//		System.out.printf("날짜 : %");	
		
		
		
	}	
}
