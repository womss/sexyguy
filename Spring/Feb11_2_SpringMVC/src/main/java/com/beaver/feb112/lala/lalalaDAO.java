package com.beaver.feb112.lala;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class lalalaDAO {
	
	
	
	// Spring - MyBatis - Maven
		//	유지보수에 용이
		
		// 클라이언트가 회원에대한 정보를 등록했을때 회원가입을 한 시간을
		//	연/월/일 의 형태로 요청...
		
		@Autowired
		private SimpleDateFormat sdf;
		
		// 위에게 잘 동작하는지 테스트해보기 위한 메소드 하나 만들기
		public void test() {
			System.out.println();
		}
}
