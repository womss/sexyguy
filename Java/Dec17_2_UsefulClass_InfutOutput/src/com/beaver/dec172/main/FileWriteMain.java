package com.beaver.dec172.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class FileWriteMain {
	// CPU : 연산장치
	// RAM : 저장장치(임시) - 재부팅하면 날아감
	//			static / heap - 프로그램을 끄면(종료하면) 날아감
	// HDD(SSD) : 저장장치(영구) - 파일
	// GPU : 그래픽처리용 ( CPU + RAM + HDD )
	
	// 프로그램에서는 데이터를 외부에서 읽고,
	//	다시 외부로 출력하는 작업이 자주 일어나는데
	// 데이터는 사용자로부터 키보드를 통해서 입력될 수도 있고,
	//		(Scanner의 system.in)
	// 파일,네트워크에서도 입력될 수 있음 (???)		(Input)
	
	// 반대로 데이터는 모니터를 통해서 출력될 수도 있고,
	//		(System.out.println())
	// 파일,네트워크에서도 출력될 수 있음 (???)		(output)
	// System.in => InputStream
	// System.out => PrintStream
	
	// 'Stream' 빨대
	//		기본형
	//			InputStream : 장치 => 프로그램으로 입력 (1byte씩)
	//			InputStreamReader : (2byte씩) (빨대 크기 Up!) + 인코딩방식
	//			BufferedReader : (1String - line) (빨대 크기 Up!)
	
	//			OutputStream : 프로그램 결과를 => 장치로 출력 (1byte씩)
	//			OutputStreamWriter : (2byte씩) + 인코딩방식
	//			BufferedWriter : (1String - line) (빨대 크기 Up!)
	
	//		개조형 (특수목적에 맞게)
	//			printStream (OutputStream 개조)
	//			- 쓰기 편하게 유용한 메소드들 추가
	//			FileReader (InputStreamReader 개조)
	//			- 파일에서 데이터를 읽어오기 편하게
	//			FileWriter (OuputStreamWriter 개조)
	//			-데이터 출력하기 편하게
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("입력 : ");
		String cmt = k.next();
		
		// FileWriter
		//		프로그램 => 파일(OutputStreamWriter 개조형)
		//		파일이 없으면 만들어 줌
		//		파일이 저장될 폴더는 안만들어줌
		//		Linux의 경로 : 
		//			C:/User/sdedu/Desktop/asdf/beaver1.txt
		//			=> /(슬래시)로 경로설정
		//		Windows의 경로 :
		//			C:\\User\\sdedu\\Desktop\\asdf\\beaver1.txt
		//			=> \\(역 슬래시)로 경로설정 or /로도 설정 가능 O
		
		//		Java에서 \는 : \t, \r, \n, \0, ... 에 사용 ///이스케이프 문자
		
		
		// fw 위에 bw 덧씌운 상태
		// 연관된 것들 중에서 하나만 닫으면 다 처리
		BufferedWriter bw = null;
		try {
			// 지정한 파일이 이미 존재하고 있으면 덮어쓰기 때문에
			// 기존에 있던 파일의 내용은 사라지게 됨
			// 기존의 내용 뒤에 덧붙이고 싶으면(데이터를 추가하고 싶다면)
			// 두 번째 파라미터 값으로 true를 주면 됨
			
			// Encoding 방식 지정 X => ANSI로 인코딩됨 ///자동으로 인코딩 됨
			
			FileWriter fw = new FileWriter("C:\\Users\\sdedu\\Desktop\\Hi\\beaver1.txt", true);

			// 한 바이트씩 입출력하기보다는
			//	'버퍼'를 이용해서 한번에 여러 바이트를 입출력하는 것이 효율적!
			//		=> 대부분의 입출력 작업에서 사용
			//	버퍼 : CPU와 HDD 사이에서 사용되는 임시 저장 공간
			//	버퍼링 : <데이터>를 버퍼로 저장하는 동작
			//		=> 실행성능 향상 시킬 수 있음
			
			bw = new BufferedWriter(fw);
			bw.write(cmt + "\r\n");
			bw.write("------------------------\r\n");
			bw.flush(); // 버퍼 용량이 다 안채워져도
						// 강제적으로 내보내기 (모든 데이터 다 보내기)
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
}
