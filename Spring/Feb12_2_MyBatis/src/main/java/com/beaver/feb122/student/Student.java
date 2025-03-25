package com.beaver.feb122.student;
// db관련해서 mybatis를 써보겠습니다
// MyBatis : ORM(Object Relationship Mapping) Framework
//	=> 객체와 데이터베이스의 데이터를 자동으로 연결(매핑)해주는 Framework
//	=> 결과를 자바 객체로
//		DB컬럼명 = Java멤버변수명 같아야함 (조건)

import java.math.BigDecimal;

// Spring MVC : 요청파라미터를 자동으로 객체로...
//		요청파라미터명 = Java멤버변수명 같아야함 (조건)

//Spring MVC + Maven + MyBatis
//		요청파라미터명 = Java멤버변수명 = DB컬럼명 (조건) ****
//		Oracle) number => Java) BigDecimal (정수, 실수 가능)
public class Student {
	private BigDecimal s_no;
	private String s_name;
	private String s_nickname;
	
public Student() {
	// TODO Auto-generated constructor stub
}

public Student(BigDecimal s_no, String s_name, String s_nickname) {
	super();
	this.s_no = s_no;
	this.s_name = s_name;
	this.s_nickname = s_nickname;
}

public BigDecimal getS_no() {
	return s_no;
}

public void setS_no(BigDecimal s_no) {
	this.s_no = s_no;
}

public String getS_name() {
	return s_name;
}

public void setS_name(String s_name) {
	this.s_name = s_name;
}

public String getS_nickname() {
	return s_nickname;
}

public void setS_nickname(String s_nickname) {
	this.s_nickname = s_nickname;
}


	
	
}
