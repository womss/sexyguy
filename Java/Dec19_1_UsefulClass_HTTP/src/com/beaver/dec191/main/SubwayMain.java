package com.beaver.dec191.main;

import java.io.InputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.beaver.http.client.BeaverHttpClient;

// http://openapi.seoul.go.kr:8088/(인증키)/JSON/TbSeoulmetroStOrigin/1/5/
// 4f626857416f6c6c3632586a416843
// 지하철 역명
// 호선
// 역명 유래
// 출력

public class SubwayMain {
	public static void main(String[] args) {
		try {
			String adrress = "http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/JSON/TbSeoulmetroStOrigin/1/275/";
			
			InputStream is = BeaverHttpClient.download(adrress);
			String str = BeaverHttpClient.convert(is, "UTF-8");
			
			JSONParser jp = new JSONParser();
			
			JSONObject jo = (JSONObject) jp.parse(str); // 받아온 값을 객체로 변환
			
			JSONObject metro = (JSONObject) jo.get("TbSeoulmetroStOrigin");
			
			JSONArray row = (JSONArray) metro.get("row");
			
			JSONObject data = null;
//			System.out.println(str);
			for (int i = 0; i < row.size(); i++) {
				data = (JSONObject) row.get(i);
				System.out.println(data.get("STTN"));
				System.out.println(data.get("SBWY_ROUT_LN"));
				System.out.println(data.get("STTN_ORGN"));
				System.out.println("=================================");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
//		String adrress = "http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/JSON/TbSeoulmetroStOrigin/1/275/";
		
		
//		try {
//			InputStream is = BeaverHttpClient.download(adrress);
//			String str = BeaverHttpClient.convert(is, "UTF-8");
//			
//			JSONParser jp = new JSONParser();
//			JSONObject jo = (JSONObject) jp.parse(str);
//			//TbSeoulmetroStOrigin 객체
//			JSONObject TbSeoulmetroStOrigin = (JSONObject) jo.get("TbSeoulmetroStOrigin");
//			// row객체
//			JSONArray row1 = (JSONArray) TbSeoulmetroStOrigin.get("row");
//			//지하철 역명
//			JSONObject sttn = (JSONObject) row1.get(1);
////			String stst = (String) sttn.get("sttn");
//			System.out.println(sttn);
//			//호선
////			JSONObject SBWY_ROUT_LN = (JSONObject) row1.get(2);
////			System.out.println(SBWY_ROUT_LN);
////			//역명유래
////			JSONObject STTN_ORGN = (JSONObject) row1.get(3);
////			System.out.println(STTN_ORGN);
			
			
			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
