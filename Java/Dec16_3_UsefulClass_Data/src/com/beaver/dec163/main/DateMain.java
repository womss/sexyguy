package com.beaver.dec163.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

// Date.java : 아~~~~~~주 옛날에 (1900년대) 만들어진 Class
//		Y2K에 관심이 없던 시절
//		1970년대 이전의 컴퓨터 : 속도가 느리고, 장치의 용량도 적었다
//		연도처리를 4byte가 아닌 연도 끝에 2자리만 2byte로 할당
//			=> 컴퓨터의 오작동 가능성이 높아짐

// deprecated
//		세월이 흐르고, 컴퓨터도 발전 => 옛날에 만들어 놓은걸 못쓰겠음
//		프로그래밍언어도 업데이트가 되어야 하는데...
//		없애거나 / 기능을 수정할 계획이 생겨버림
//		현재 자바버전에서는 OK!!! / 다음 버전에 없어져도 불만갖지 마라!!

// Date : 날짜 / 시간 // Date는 deprecated
public class DateMain {
	public static void main(String[] args) {
		// LocalDate
		System.out.println(LocalDate.now()); // 날짜
		System.out.println(LocalTime.now()); // 시간
		System.out.println(LocalDateTime.now()); // 날짜/시간
		System.out.println(LocalDate.of(2025, 12, 16)); // 시간
		
		// Calendar Class
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR)+"년");
		System.out.println(c.get(Calendar.MONTH)+1+"월"); // 0 ~ 11 (1월 ~ 12월)
		System.out.println(c.get(Calendar.DAY_OF_MONTH)+"일");
		System.out.println(c.get(Calendar.DAY_OF_WEEK)+" 1 ~ 7 (일 ~ 토)"); // 1 ~ 7 (일 ~ 토)
		System.out.println(c.get(Calendar.HOUR)+"시");
		System.out.println(c.get(Calendar.MINUTE)+"분");
		System.out.println(c.get(Calendar.SECOND)+"초");
		
		// 기본 생성 => 현재 시간 / 날짜
		Date now = new Date();
		System.out.println(now);
		
		// 연도
		System.out.println(now.getYear() + 1900);
		// 월
		System.out.println(now.getMonth() + 1 +"월");
		// 일
		System.out.println(now.getDate());
		// 요일
		System.out.println(now.getDay()); // 0 ~ 6 (일 ~ 토)
		String[] day = {"일", "월", "화", "수", "목", "금", "토"};
		System.out.println(day[now.getDay()]+ "요일");
		System.out.println("----------------------------");
		
		// 특정 시간 날짜 (연, 월, 일, 시, 분, 초)
		Date d2 = new Date(1999, 2, 28);
		
		// Date - 형식 지정 -> String
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E a hh:mm", Locale.KOREA); // MM 월은 대문자 , 요일 E도 대문자 나머지 소문자
		
		String s1 = sdf.format(now);
		System.out.println(s1);
		System.out.println("---------------------");
		
		// String - 형식 지정 -> Date
		String s2 = "2000/12/16";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date d3 = sdf2.parse(s2);
			System.out.println(d3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	System.out.println("---------------------------------");	
	
	// 10년전 크리스마스는 무슨요일?
	try {
		String chrismas = "2014.12.25";
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy.MM.dd");
		Date chrismas2 = sdf3.parse(chrismas);
//		System.out.println(chrismas2);
//		System.out.println("------------");
		System.out.println(day[chrismas2.getDay()]+ "요일");		//
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("E");
		String chrismas3 = sdf4.format(chrismas2);
		System.out.println(chrismas3 + "요일");
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
		
		
		
		
		
		
		
		
		
	}
}


















