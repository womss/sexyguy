package com.beaver.dec191.main;

import java.awt.Event;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.event.DocumentEvent.EventType;

import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.beaver.http.client.BeaverHttpClient;

public class NaverNewsMain {
	public static void main(String[] args) {
		// ID : 3SBst2M9XTbjQ1PHzeUk
		// Secret : Ey1rX_2fOS
		
		// 인터넷 주소 체계
		// 프로토콜 / 컴퓨터주소 / 폴더명 파일명 /
		//	프로토콜:// - 통신방식
		//	컴퓨터의 주소/
		//	폴더명/폴더명/.../파일명
		//	? 다음에 나오는
		//		변수명=값&변수명=값&...
		//		=> 요청 파라미터
		//			: 클라이언트가 서버에게 공개적으로 전달할 정보
		
		// 주소창에 한글, 특수문자 바로 들어가면 안됨
		//	ex) ㅋ => %2D (URL 인코딩)
		
		// https://openapi.naver.com/v1/search/news.xml
		
		try {
			Scanner k = new Scanner(System.in);
			System.out.print("검색어 : ");
			String search = k.next();
			System.out.println(search);
			search = URLEncoder.encode(search, "UTF-8");
			System.out.println(search);
			
			String address = "https://openapi.naver.com/v1/search/news.xml";
			address += "?query=" + search;
			
//			InputStream is = BeaverHttpClient.download(address);
//			String result = BeaverHttpClient.convert(is, "UTF-8");
//			System.out.println(result);
			
			// https://developers.naver.com/docs/serviceapi/search/news/news.md#%EB%89%B4%EC%8A%A4-%EA%B2%80%EC%83%89-api-%EB%A0%88%ED%8D%BC%EB%9F%B0%EC%8A%A4
			// 참고사항 본 시점
			// HttpsURLConnection 활용 => 안에 있는 기능
			
//			URL u = new URL(address);
//			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
//			
//			// 요청 헤더 /요청 예
//			huc.addRequestProperty("X-Naver-Client-Id", "3SBst2M9XTbjQ1PHzeUk");
//			huc.addRequestProperty("X-Naver-Client-Secret", "Ey1rX_2fOS");
//			
//			InputStream is = huc.getInputStream();
//			String result = BeaverHttpClient.convert(is, "UTF-8");
//			System.out.println(result);
////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			// 너무 번거로우니까
			
			
			// 뉴스의 title / description 출력
			// <title>Naver Open API - ???
			// <description>Naver Search Result => 안나오게
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("X-Naver-Client-Id", "3SBst2M9XTbjQ1PHzeUk");
			headers.put("X-Naver-Client-Secret", "Ey1rX_2fOS");
			
			InputStream is = BeaverHttpClient.download(address, headers);
//			String result = BeaverHttpClient.convert(is, "UTF-8");
			System.out.println("===============");
//			System.out.println(result);
			
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();			// XML 데이터를 읽기 위한 공장을 만드는 거
			KXmlParser xpp = (KXmlParser) xppf.newPullParser();						// 데이터를 한 줄씩 읽어오는 역할
			xpp.setInput(is, "UTF-8");	
			
			int type = xpp.getEventType();											
			String tagName = null;	
			int count = 0;
			
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (type == XmlPullParser.TEXT) {
					if (tagName.equals("title")) {
						System.out.printf("기사 제목 : %s\t", xpp.getText());
					} else if (tagName.equals("pubDate")) {
						System.out.printf("기사 게시일 : %s\t", xpp.getText());
						count++;
						System.out.println("==============================");
						
					}
				} else if (type == XmlPullParser.END_TAG) {
					tagName = "";
				}
				xpp.next();														
				type = xpp.getEventType();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
