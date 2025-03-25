package com.beaver.dec182.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.beaver.http.client.BeaverHttpClient;

// http://openapi.seoul.go.kr:8088/sample/xml/RealtimeCityAir/1/25/
// 4f626857416f6c6c3632586a416843
// 미세먼지 => 파싱 => 값들을 => txt파일에 담기
// (프로그램실행시의)
//	날짜,측정구,미세먼지,초미세먼지,오존,이산화질소,일산화탄소,아황산가스
//	날짜형식 : 연-월-일-오전/오후-시-요일 (프로그램 실행 날짜/시간)
//	단위 X
//	ex) 2024-12-28-오후-02-수,강남구,10,2,3,15,24
//		2024-...

public class AirPollMain2 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("C:\\Users\\sdedu\\Desktop\\Hi\\Beaver/Airpoll.txt", true); // 왜 트루?
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			// 위에는 파일 생성
			// 여기자리에 올리기
			String address = "http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/RealtimeCityAir/1/25/";
			InputStream is = BeaverHttpClient.download(address);
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = (XmlPullParser) xppf.newPullParser();
			xpp.setInput(is, "UTF-8");
			
			int type = xpp.getEventType();
			String tagName = null;
			
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) { // 파란글씨 먼저 이프문에 작성하고 사이사이에 필요한 부분 작성하기
					tagName=xpp.getName();
				} else if (type == XmlPullParser.TEXT) {
					if (tagName.equals("MSRDT")) {
						Date now = new Date();														// 여기 위로1
//						String a = xpp.getText();
//						SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMdd");    // 여기부분 다시보기
						SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd-a-hh-E");	// 여기 위로2
						String nowStr = outputFormat.format(now);									// 여기 위로3
						bw.write("측정 일시 : "+nowStr+"\n");
					} else if (tagName.equals("MSRRGN_NM")) {
						bw.write("측정 구 : "+xpp.getText()+"\n");
					} else if (tagName.equals("PM10")) {
						bw.write("미세먼지 : "+xpp.getText()+"\n");
					} else if (tagName.equals("PM25")) {
						bw.write("초미세먼지 : "+xpp.getText()+"\n");
					} else if (tagName.equals("O3")) {
						bw.write("오존 : "+xpp.getText()+"\n");
					} else if (tagName.equals("NO2")) {
						bw.write("이산화질소 : "+xpp.getText()+"\n");
					} else if (tagName.equals("CO")) {
						bw.write("일산화탄소 : "+xpp.getText()+"\n");
					} else if (tagName.equals("SO2")) {
						bw.write("아황산가스 : "+xpp.getText()+"\n");
						bw.write("======================================================================================================================================");
						bw.flush();
					}
				} else if (type == XmlPullParser.END_TAG) {
					tagName = "";
					/*
					 * <tag>
					 * 	여기	Text
					 * </tag> 
					 */
				}
				xpp.next();
				type = xpp.getEventType();
			}
			System.out.println("파일 생성 완료 !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			fos.close();
		} catch (IOException e) {  // 타이핑만하고 임포트 안하면 문제
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
