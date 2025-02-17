package com.beaver.dec182.main;

import java.io.InputStream;
import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.beaver.http.client.BeaverHttpClient;

public class ParkMain {
	// http://openAPI.seoul.go.kr:8088/(인증키)/xml/SearchParkInfoService/1/5/	<= 130으로
	// 4f626857416f6c6c3632586a416843
	// 공원명, 공원 개요, 개원일, 공원 주소, 전화번호 출력
	
	public static void main(String[] args) {
		
		try {
			String address = "http://openAPI.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/SearchParkInfoService/1/130/";
			// 작은 빨대
			InputStream is = BeaverHttpClient.download(address);
			// 파싱하기 위한 준비물
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			KXmlParser xpp = (KXmlParser) xppf.newPullParser();
			xpp.setInput(is, "UTF-8");
			
			int type = xpp.getEventType();
			String tagName = null;
			
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName=xpp.getName();
				} else if (type == XmlPullParser.TEXT) {
					if (tagName.equals("P_PARK")) {
						System.out.printf("공원명 : %s\t\n", xpp.getText());
					} else if (tagName.equals("P_LIST_CONTENT")) {
						System.out.printf("공원 개요 : %s\t\n", xpp.getText());
					}else if (tagName.equals("OPEN_DT")) {
						System.out.printf("공원 개원일 : %s\t\n", xpp.getText());
					}else if (tagName.equals("P_ADDR")) {
						System.out.printf("공원 주소 : %s\t\n", xpp.getText());
					}else if (tagName.equals("P_ADMINTEL")) {
						System.out.printf("공원 전화번호 : %s\t\n", xpp.getText());
						System.out.println("=================================================================");
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
