package com.beaver.dec172.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class EncodingMain {
	// Encoding : 정보의 형태나 형식을 변환하는 처리방식
	// 컴퓨터 : 전자기계 (전기가 흐르거나, 안흐르거나)
	// 'ㅋ' => 전기의 흐름으로 표현 (ex: 모스 부호) => encoding
	
	// Decoding : 인코딩 된 데이터에 대한 통신 정송 및 파일을
	//				원래의 상태로 변환
	// 전기의 흐름 => decoding => 'ㅋ'
	
	// encoding 방식은 여러 종류가 있음 !
	// 설날 -A-> 1010 -A-> 설날
	// 설날 -B-> 0101 -C-> 추석
	
	// 전세계적으로 주력 : UTF-8 (Unincoding Transform Format)
	// 한국만 타겟 : EUC-KR
	// MS 전용 : MS949
	
	public static void main(String[] args) {
//		FileOutputStream fos = null;
//		try {
//			fos = new FileOutputStream("C:\\Users\\sdedu\\Desktop\\Hi\\beaver.txt", true);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		OutputStreamWriter osw = null;
//		try {
//			osw = new OutputStreamWriter(fos, "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		BufferedWriter bw = new BufferedWriter(osw);
//		try {
//			bw.write("ksdfklsdjfksldfjsklasdmmasdl");
//			bw.append("\r\n"); // 엔터처리 4-5년 전까지는 둘중 하나만 안해도 안됐는데 지금은 하나만해도 가능하지만 파일처리에서는 둘 다 쓰는걸로
//			bw.append("으아아아아아ㅏ아아아아아ㅏ\r\n");
//			bw.append("으아아아아아ㅏ아아아아아ㅏ" + "\r\n");
//			bw.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			bw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		// 불러오기 Decoding
		
		
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\sdedu\\Desktop\\Hi\\beaver.txt");
			
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
