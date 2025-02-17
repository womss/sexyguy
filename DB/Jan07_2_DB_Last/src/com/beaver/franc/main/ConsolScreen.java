package com.beaver.franc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.beaver.franc.Reservation.Reservation;
import com.beaver.franc.Restaurant.Restaurant;

// 사용자가 콘솔을 볼  수 있거나, 콘솔에 입력할 수 있게 (MVC의 V)
// 아래 메뉴를 볼 수 있는 기능도 있었으면 !

// 1. 예약하기(직접 입력, 날짜는 연-월-일/시:분)					-- 예약 테이블에 넣기
// "insert into booking values(booking_seq.nextval, ?, TO_DATE(?, 'YYYY-MM-DD HH24:MI'),? ,?)";
// 2. 매장 등록(지점명, 지점장, 좌석수)							-- 매장 테이블에 넣기
// "insert into market values(market_seq.nextval, '쿠우쿠우', '쿠덕배', 80)";
// 3. 전체 예약 확인(날짜는 연-월-일 요일 오전/오후 시:분)			-- 예약 테이블 전체 조회
// "select * from booking";
// 4. 전체 매장 조회( 지정명(좌석수) - 지점장 이름 ) <= 이렇게 나오게	-- 매장 테이블 전체 조회
// "select * from market";
// 5. 매장 찾기 (최소 좌석 수 입력 => 좌석 수 이상의 매장의 정보 출력)	-- 매장 테이블 조건부 조회
// "select * from market where m_seat >= ?;
// 6. 예약 찾기 (예약자 이름 입력 => 해당 예약 정보 출력)				-- 예약 테이블 조건부 조회
// "select *
//		from booking
//		where b_n = ?
// 7. 예약 정보 수정 (예약 번호를 입력하면, 연락처를 변경)				-- 예약 테이블 조건부 수정
// 8. 예약 취소 (예약 번호로 취소)								-- 예약 테이블 조건부 삭제
// 9. 종료


public class ConsolScreen {
	public static void showWelcome() {
		System.out.println("=========================");
		System.out.println("정성을 다하는 식당 ㅇㅇㅇ입니다");
		System.out.println("친절히 모시겠습니다");
		System.out.println("=========================");
	}
	
	public static int showMainMenu() {
		Scanner k = new Scanner(System.in);
		System.out.println("=========================");
		System.out.println("1. 예약하기");
		System.out.println("2. 매장 등록");
		System.out.println("3. 전체 예약 확인");
		System.out.println("4. 전체 매장 조회");
		System.out.println("5. 매장 찾기");
		System.out.println("6. 예약 찾기");
		System.out.println("7. 예약 정보 수정");
		System.out.println("8. 예약 취소");
		System.out.println("9. 종료");
		System.out.println("=========================");
		System.out.println("번호 입력> ");
		int menu = k.nextInt();
		//여기
		if ( (menu < 1 || menu > 9)) {
			System.out.println("잘못된 입력입니다. 다시 입력하세요.");
		}
		return (menu >= 1 || menu <= 9) ? menu : showMainMenu();
	}
	
	public static void printResult(String result) {
		System.out.println(result);
	}
	
	// 9. 종료
	public static void exit() {
		System.out.println("=========================");
		System.out.println("이용해주셔서 감사합니다.");
		System.out.println("다음에 또 이용해주세요.");
		System.out.println("=========================");
	}
	
	
	
//	1. 예약하기(직접 입력, 날짜는 연-월-일/시:분)	
	public static Reservation showRsvMenu() throws ParseException {
		Scanner k = new Scanner(System.in);
		
		System.out.println("예약자 이름 : ");
		String name = k.next();
		
		System.out.println("예약 날짜(YYYY-MM-DD/HH:mm) : ");
		String when = k.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm"); // 날짜 변환
		Date when2 = sdf.parse(when);
		
		System.out.println("예약자 연락처 : ");
		String phoneNum = k.next();
		
		System.out.println("예약 지점명 : ");
		String location = k.next();
		// 리턴으로는 name, when, phoneNum,location을 못담아내니
		// (예약자 클래스만듬)
		Reservation r = new Reservation(0, name, when2, phoneNum, location);
		return r;
	}
	
//	2. 매장 등록(지점명, 지점장, 좌석수)
	public static  Restaurant showRstMenu() {
		Scanner k = new Scanner(System.in);
		
		System.out.println("지점명 : ");
		String location = k.next();
		
		System.out.println("지점장 : ");
		String owner = k.next();
		
		System.out.println("좌석 수 : ");
		int seat = k.nextInt();
		
//		Restaurant r = new Restaurant(location, owner, seat);  이렇게 말고
//		return r;
		return new Restaurant(location, owner, seat);		// 이렇게도 가능
	}
//	3. 전체 예약 확인(날짜는 연-월-일 요일 오전/오후 시:분)
	public static void showRsvResultMenu(ArrayList<Reservation> rsvs) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E a hh:mm");
		for (Reservation r : rsvs) {
			System.out.printf("%d) ", r.getNo());
			System.out.printf("[%s - ", r.getName());
			System.out.printf("%s] - ", r.getPhone());
			System.out.print(r.getLocation() + " - ");
			System.out.println(sdf.format(r.getWhen()));
		}
	}
//	4. 전체 매장 조회( 지정명(좌석수) - 지점장 이름 )
	public static void showRstResultMenu(ArrayList<Restaurant> rsts) {
		for (Restaurant r : rsts) {
			System.out.printf("%s(%d석) - ", r.getLocation(), r.getSeat());
			System.out.printf("[%s]\n", r.getOwner());
//			System.out.printf("[%s", r.getLocation() + " 점");
//			System.out.printf("%s - ", r.getOwner());
//			System.out.printf("%d - ", r.getSeat() + " 석]");
	}
	}
//	5. 매장 찾기 (최소 좌석 수 입력 => 좌석 수 이상의 매장의 정보 출력)
	public static Restaurant showSearchRstMenu() {
		Scanner k = new Scanner(System.in);
		System.out.println("최소 좌석 수 : ");
		int seat = k.nextInt();
		return new Restaurant(null, null, seat);
	}
//	6. 예약 찾기 (예약자 이름 입력 => 해당 예약 정보 출력)
	public static Reservation showSearchRsvMenu() {
		Scanner k = new Scanner(System.in);
		System.out.println("예약자명 : ");
		String name = k.next();
		return new Reservation(0, name, null, null, null);
	}
//	7. 예약 정보 수정 (예약 번호를 입력하면, 연락처를 변경)
	public static Reservation showUpdateRsvMenu() {
		Scanner k = new Scanner(System.in);
		System.out.println("예약 번호 : ");
		int no = k.nextInt();
		
		System.out.println("변경할 연락처 : ");
		String number = k.next();
		
		return new Reservation(no, null, null, number, null);
	}
	// 8. 예약 취소 (예약 번호로 취소)
	public static Reservation cancelReservation() {
		Scanner k = new Scanner(System.in);
		System.out.println("취소할 예약 번호 : ");
		int no = k.nextInt();
		
		return new Reservation(no, null, null, null, null);
	}
}
	
