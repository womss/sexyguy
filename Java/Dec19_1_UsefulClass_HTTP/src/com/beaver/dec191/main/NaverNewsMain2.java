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

public class NaverNewsMain2 {
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
			
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("X-Naver-Client-Id", "3SBst2M9XTbjQ1PHzeUk");
			headers.put("X-Naver-Client-Secret", "Ey1rX_2fOS");
			
			InputStream is = BeaverHttpClient.download(address, headers);
//			String result = BeaverHttpClient.convert(is, "UTF-8");
			System.out.println("===============");
//			System.out.println(result);
			
			
			// 뉴스의 title / description 출력
			// <title>Naver Open API - ???
			// <description>Naver Search Result => 안나오게
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();			
			KXmlParser xpp = (KXmlParser) xppf.newPullParser();						
			xpp.setInput(is, "UTF-8");	
			
			int type = xpp.getEventType();											
			String tagName = null;	
			String text = null;
			boolean data = false;
			
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					if (tagName.equals("item")) {
						data = true;
					}
				} else if (type == XmlPullParser.TEXT) {
					if (data) {
						if (tagName.equals("title")) {
							text = xpp.getText();
							text = text.replace("<b>", "");
							text = text.replace("</b>", "");
							text = text.replace("&quot", ""); // "
							text = text.replace("&apos", ""); // '
							text = text.replace("&amp", ""); // &
							System.out.printf("제목 : %s\n", text);
						} else if (tagName.equals("description")) {
							text = xpp.getText();
							text = text.replace("<b>", "");
							text = text.replace("</b>", "");
							text = text.replace("&quot", ""); // "
							text = text.replace("&apos", ""); // '
							text = text.replace("&amp", ""); // &
							System.out.printf("내용 : %s\n", text);
							System.out.println("=====================================");
						}
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
