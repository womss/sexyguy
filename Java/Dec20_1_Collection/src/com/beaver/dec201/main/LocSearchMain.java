package com.beaver.dec201.main;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.beaver.http.client.BeaverHttpClient;

// d60e7b520e40df4491da9f66b7d43c3d
// 37.6155415 / 127.0785181 ( y / x )
// https://dapi.kakao.com/v2/local/search/keyword.json

public class LocSearchMain {
	public static void main(String[] args) {
		// 중심좌표 반경 5km이내에
		//	검색한 키워드(입력)가 포함된 가게들을 거리 기준으로 정렬
		//강사님
		try {
			Scanner k = new Scanner(System.in);
			System.out.println("지도 검색 : ");
			String search = k.next();
			//인코딩 빼먹음;
			search = URLEncoder.encode(search, "UTF-8");
			System.out.println(search);
			
			String address = "https://dapi.kakao.com/v2/local/search/keyword.json";
			address += "?query=" + search;	// 검색어
			address += "&x=127.0785181&y=37.6155415"; // 중심 좌표
			address += "&radius=5000"; 		// 주변 반경거리
			address += "&sort=distance";	// 정렬 방법
			
			// Authorization: KakaoAK ${REST_API_KEY}
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("Authorization", "KakaoAK d60e7b520e40df4491da9f66b7d43c3d");
			InputStream is = BeaverHttpClient.download(address, headers);
			String str = BeaverHttpClient.convert(is, "UTF-8");
//			System.out.println(str);
		//강사님
			
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(str);
//			JSONArray documents = (JSONArray) jo.get("documents");
//			JSONObject data = null;
//			
//			for (int i = 0; i < documents.size(); i++) {
//				data = (JSONObject) documents.get(i);
//				// 주소
//				System.out.println(data.get("address_name"));
//				// 중심좌표와의 거리
//				System.out.println(data.get("SBWY_ROUT_LN"));
//				// 전화번호
//				System.out.println(data.get("distance"));
//				// 상호명
//				System.out.println(data.get("place_name"));
//				System.out.println("=================================");
//			}
			JSONObject meta = (JSONObject) jo.get("meta");								//마테
			System.out.printf("총 검색 결과 수 : %s개\n",meta.get("total_count"));
			System.out.println("=================================");
			// 총 검색 결과 수
			
			JSONArray ja = (JSONArray) jo.get("documents");
			JSONObject jo3 = null;
			for (int i = 0; i < ja.size(); i++) {
				jo3 = (JSONObject) ja.get(i);
				System.out.printf("주소 : %s\n", jo3.get("address_name"));
				System.out.printf("전화번호 : %s\n", jo3.get("phone"));
				System.out.printf("상호명 : %s\n", jo3.get("place_name"));
				System.out.printf("거리 : %sm\n", jo3.get("distance"));
				System.out.println("_________________________________________________");
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
			
			
			
			
			
		
		// 총 검색 결과 수
		// 주소
		// 전화번호
		// 상호명
		// 중심좌표와의 거리
		// 정보를 출력
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//내가
//		String restApi = "d60e7b520e40df4491da9f66b7d43c3d";
//		String x = "x=127.0785181";
//		String y = "y=37.6155415";
//		String search = "";
//		String apiUrl = "https://dapi.kakao.com/v2/local/search/keyword.json";
//		try {
//			Scanner k = new Scanner(System.in);
//			System.out.println("지도 검색 : ");
//			search = k.next();
//			
//			String address = "https://dapi.kakao.com/v2/local/search/keyword.json&?y=37.6155415&x=127.0785181&radius=20000/Authorization: KakaoAK $"+restApi+"/?query="+search;
//			String address1 = "https://dapi.kakao.com/v2/local/search/keyword.json/Authorization: KakaoAK d60e7b520e40df4491da9f66b7d43c3d?query="+search;
//			String address2 = "";
//			
//			
//			InputStream is = BeaverHttpClient.download(address1);
//			String str = BeaverHttpClient.convert(is, "UTF-8");
//			
//			JSONParser jp = new JSONParser();
//			
//			JSONObject jo = (JSONObject) jp.parse(str);
//			JSONObject metro = (JSONObject) jo.get("TbSeoulmetroStOrigin");
//			
//			JSONArray row = (JSONArray) metro.get("row");
//			System.out.println(jp);
//			
//			
//			
//			
//			
//			
//			
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		
		
		
		
	}
}
