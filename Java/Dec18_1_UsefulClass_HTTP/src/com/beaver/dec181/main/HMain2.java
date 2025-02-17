package com.beaver.dec181.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HMain2 {
	// Java에 HTTP 통신이 생겼음! => HttpClient 필요없음 (HMain1 형식은 옛날방식 고로 필요없는 방식)
	
	// 보안에 대한 차이가 있음 s가 더 보안성 높음
	// http
	// https
	public static void main(String[] args) {
		try {
			String address = "https://www.naver.com";
			URL u = new URL(address);
			
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			// 응답을 받으면
			InputStream is = huc.getInputStream(); // 응답 받는걸 빨대 꽂고
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");// 빨대 키우는 과정
			BufferedReader br = new BufferedReader(isr);
			//그걸로 활용할 수 있다
			String line = null;
			while ((line = br.readLine() ) != null) {
				System.out.println(line);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
