package com.beaver.dec181.main;

import java.io.InputStream;

import com.beaver.http.client.BeaverHttpClient;

public class HMain3 {
	public static void main(String[] args) {
		try {
			InputStream is = BeaverHttpClient.download("https://www.naver.com");
			
			String result = BeaverHttpClient.convert(is, "UTF-8");
			
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
