package com.beaver.dec191.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.beaver.http.client.BeaverHttpClient;


// AJAX - JavaScript에서 XML 파싱
//		=> XML 형식이 많이 안쓰임
//	가독성이 좋으면서 JavaScript에 친화된 형태가 없을까?

// JSON (JavaScript Object Notation)
//		DB에 있는 데이터를 JavaScript문법으로 표현한 것
//		XML보다도 훨~~~씬 좋음

// Java 배열 : { 1, 2, 3 }
// JS 배열 : [ 1, 2, 3 ]					// 대괄호

// Java 객체 : Dog d = new Dog();
//				d.setName("멍멍2");
//				d.setAge(3);
// JS 객체 : { name : "멍멍3", age : 3 } ;	// 중괄호

public class WeatherMain {
	public static void main(String[] args) {
		// https://api.openweathermap.org/data/2.5/weather?q=hawai&appid=42008a8c8e7402a3fc9d3b1a7df8fee9
		// &units=metric&lang=kr
		
		// 도시의 이름을 직접 입력
		// 데이터를 출력
		
		Scanner k = new Scanner(System.in);
		System.out.println("날씨를 보고싶은 도시를 영어로 입력하세요 : ");
		String city = k.next();
		String adrress = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=42008a8c8e7402a3fc9d3b1a7df8fee9&units=metric&lang=kr"; // 도시입력, 섭씨온도, 한국어
		
//		System.out.println(adrress);
		try {
			InputStream is = BeaverHttpClient.download(adrress);
			String str = BeaverHttpClient.convert(is, "UTF-8");	// 이걸 했어야 했음
//			System.out.println(str); // 데이터 가져오는거
			////////////////////////////////////////////////////////////////
			//파싱하려면 객체가 하나 필요
			JSONParser jp = new JSONParser();
			
			// [] : 배열
//			JSONArray ja = (JSONArray) jp.parse(str);
//			System.out.println(ja);
			
			// {} : 객체 /// 웨더 파일의 제일 처음에있는 { 중괄호를 보면 하나의 객체란걸 알 수 있다
			// 객체 전체에 대한 접근
			JSONObject jo = (JSONObject) jp.parse(str);
			System.out.println(jo);
			
			// 나라 이름
			JSONObject sys = (JSONObject) jo.get("sys");
			String country = (String) sys.get("country");
			System.out.println(country);
			
			// 도시 이름
			String cityName = (String) jo.get("name");
			System.out.println(cityName);
			
			// description
			JSONArray ja2 = (JSONArray) jo.get("weather");
			JSONObject jo2 = (JSONObject) ja2.get(0);
			String description = (String) jo2.get("description");
			System.out.println(description);
			
			// 내가
//			JSONArray weather = (JSONArray) jp.parse("weather");
//			String description = (String) weather.get(1);
//			System.out.println(description);
			
			// 기온
			JSONObject main = (JSONObject) jo.get("main");
			double temp = (double) main.get("temp");
			System.out.println(temp);
			
			// 체감온도
			double feelslike = (double) main.get("feelslike"); // 이거 안됨
			System.out.println(feelslike);
			// 최저기온
			double tempMin = (double) main.get("tempMin");
			System.out.println(tempMin);
			// 최고기온
			double tempMax = (double) main.get("tempMax");
			System.out.println(tempMax);
			// 기압
			long pressure = (long) main.get("pressure");
			System.out.println(pressure);
			// 습도
			long humidity = (long) main.get("humidity");
			System.out.println(humidity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}