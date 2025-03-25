package com.beaver.dec182.main;

import java.io.InputStream;

import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.beaver.http.client.BeaverHttpClient;

// 웹서버 (클라이언트가 웹사이트에 요청 => 사이트가 응답)
//	실시간 데이터를 XML Parsing
//	(클라이언트가 데이터를 요청 => XML / JSON 응답)
//	(나중에) 그 데이터를 가지고 웹에서 이미지화를 시켜서 구현
//		data.go.kr			
//		data.seoul.go.kr	서울 공공
//		dev.naver.com		네이버 개발자 환경
//		dev.kakao.com		카카오 개발자 환경
//		...

// 기상청 DB - 날씨 관련 데이터

// DB에 있는 데이터를 사람들에게 보여줘야 하는 경우...
//		대부분의 사람들이 SQL을 할 줄 모르죠...
//		웹사이트 : 보통사람들이 DB쓰기 편하게

//		개발자가 데이터만 가져오고 싶음
//		데이터를 특정한 형식으로 표현해줘야 하는데
//		DB에 있는 데이터를 표현하는 형식 : SML, JSON 형식

// Parsing - kxm12.jar
//	필요없는 데이터는 걷어내고, 원하는 형태로 가공하는 작업

// XML (eXtensible Mark-up Language)
//		DB에 있는 데이터를 HTML형태로 표현한 것
//		<xxx>		: 시작태그 (xxx : 태그명)
//			yyy		: 텍스트(내용)
//		</xxx>		: 종료태그
// (XML 을 구성하고 있는 요소)
//	START_DOCUMENT	: 문서의 시작
//	END_DOCUMENT	: 문서의 끝
//	START_TAG		: 시작태그 <xxx>
//	END_TAG			: 종료태그 <xxx>
//	TEXT			: 텍스트 (시작태그와 종료태그 사이의 내용)

// http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1129070500
public class WeatherMain {
	public static void main(String[] args) {
		try {
			String address = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1129070500";
			//내가
			InputStream is = BeaverHttpClient.download(address);
//			String result = BeaverHttpClient.convert(is, "UTF-8");
//			System.out.println(result);
			
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			KXmlParser xpp = (KXmlParser) xppf.newPullParser();
			xpp.setInput(is, "UTF-8");
			
			int type = xpp.getEventType();
			String tagName = null;
			
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (type == XmlPullParser.TEXT) {
					if (tagName.equals("hour")) {
						System.out.printf("시간 : ~%s시\t", xpp.getText()); // 클래스.메소드
					} else if (tagName.equals("temp")) {
						System.out.printf("온도 : %s\t", xpp.getText());
					} else if (tagName.equals("wfKor")) {
						System.out.printf("날씨 : %s\t", xpp.getText());
					} else if (tagName.equals("wdKor")) {
						System.out.printf("풍향 : %s\n", xpp.getText());
						System.out.println("=============================================================");
					}
					
				} else if (type == XmlPullParser.END_TAG) {
					// XML에서는 띄어쓰기를 텍스트로 인식하는 경우가 있음
					tagName = "";
				}
				xpp.next(); //태그명을 다음걸로 넘겨주는 안그러면 첫 이프문 이름받는것에서 무한반복
				type = xpp.getEventType();
			}
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
}
