package com.beaver.dec182.main;

import java.io.InputStream;															// 데이터를 읽어오는 파이프 역할
import org.kxml2.io.KXmlParser;														// XML 데이터를 읽어서 원하는 부분을 찾기 위해 XmlPullParser라는 도구를 사용해요.
import org.xmlpull.v1.XmlPullParser;												// XML은 데이터를 저장하고 교환하기 위한 파일 형식
import org.xmlpull.v1.XmlPullParserFactory;											// 

import com.beaver.http.client.BeaverHttpClient;										// BeaverHttpClient는 인터넷에서 데이터를 다운로드하는 도구

//https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=%2Bul7PBaB6fktxtyITw1S%2BPoGnJGWOQc39os3m5JmwbOG9u2lhl2inAFcbJXcgwFlnmrYzlNOwo4sppf7J8sr1A%3D%3D&returnType=xml&numOfRows=100&pageNo=1&sidoName=%EC%84%9C%EC%9A%B8&ver=1.0

// 서울시 각 구의
// khaiValue : 통합대기환경수치
// so2Value : 아황산가스 농도
// coValue : 일산화탄소 농도
// pm10Value : 미세먼지 농도
// pm25Value : 초미세먼지 농도
// stationName : 측정소 명
// o3Value : 오존 농도
public class AirPollMain1 {
	public static void main(String[] args) {
		try {
			// 서울시 대기오염 정보를 제공하는 API
			String address = "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=%2Bul7PBaB6fktxtyITw1S%2BPoGnJGWOQc39os3m5JmwbOG9u2lhl2inAFcbJXcgwFlnmrYzlNOwo4sppf7J8sr1A%3D%3D&returnType=xml&numOfRows=100&pageNo=1&sidoName=%EC%84%9C%EC%9A%B8&ver=1.0";
			InputStream is = BeaverHttpClient.download(address);					// BeaverHttpClient를 사용해서 인터넷에서 데이터를 가져오고, 그 데이터를 읽을 수 있게 InputStream에 저장
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();			// XML 데이터를 읽기 위한 공장을 만드는 거
			KXmlParser xpp = (KXmlParser) xppf.newPullParser();						// 데이터를 한 줄씩 읽어오는 역할
			xpp.setInput(is, "UTF-8");												// XML 데이터를 UTF-8(문자 인코딩 방식)로 읽겠다는 뜻
			
			int type = xpp.getEventType();											// XML을 읽으면서 현재 어디까지 읽었는지 기록
			String tagName = null;													// XML 태그 이름을 저장할 공간
			
			while (type != XmlPullParser.END_DOCUMENT) {							// XML 파일의 끝까지 반복하면서 데이터를 읽겠다는 뜻
				if (type == XmlPullParser.START_TAG) {								// XML의 태그(예: <khaiValue> 등)가 시작됐다는 뜻
					tagName = xpp.getName();										// 태그 이름을 tagName에 저장
				} else if (type == XmlPullParser.TEXT) {							// 태그 안의 내용을 읽고
					if (tagName.equals("khaiValue")) {								// 만약 태그 이름이 khaiValue라면
						System.out.printf("통합대기환경수치 : %s\t", xpp.getText());		// "통합대기환경수치"를 출력
					} else if (tagName.equals("so2Value")) {
						System.out.printf("아황산가스 농도 : %s\t", xpp.getText());
					} else if (tagName.equals("coValue")) {
						System.out.printf("일산화탄소 농도 : %s\t", xpp.getText());
					} else if (tagName.equals("pm10Value")) {
						System.out.printf("미세먼지 농도 : %s\t", xpp.getText());
					} else if (tagName.equals("pm25Value")) {
						System.out.printf("초미세먼지 농도 : %s\t", xpp.getText());
					} else if (tagName.equals("stationName")) {
						System.out.printf("측정소 명 : %s\t", xpp.getText());
					} else if (tagName.equals("o3Value")) {
						System.out.printf("오존 농도 : %s\t\n", xpp.getText());
						System.out.println("===================================================================================================================================");
					}
				} else if (type == XmlPullParser.END_TAG) {							// 태그가 끝났다는 표시를 하고
					// XML에서는 띄어쓰기를 텍스트로 인식하는 경우가 있음
					tagName = "";													// tagName을 비움
				}
				xpp.next();															// next()는 XML의 다음 부분으로 이동
				type = xpp.getEventType();											// 이동한 위치의 정보를 다시 type에 저장
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
