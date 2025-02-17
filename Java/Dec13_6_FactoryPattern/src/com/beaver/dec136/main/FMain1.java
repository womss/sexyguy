package com.beaver.dec136.main;

import com.beaver.dec136.register.Academy;
import com.beaver.dec136.register.Student;

// 학원에서 학생을 상담한 후 해당 커리큘럼 대기자로 등록하려고 함
//	학생의 정보는 이름 / 나이
// 등록 순서대로 번호를 부여하고 싶은데 어떻게 해야할까?

// 객체가 필요없다 : static 메소드 기반
// 객체가 필요하다 :
//		하나 : Singleton 패턴
//		여러개 :
//			대량생산, 자동화된 : Factory 패턴
//			나머지 : 여태껏 우리가 했던걸로!


public class FMain1 {
	public static void main(String[] args) {
		Academy ac = new Academy();
		
		Student s1 = ac.consult("aa", 21);
		s1.printInfo();

		Student s2 = ac.consult("bb", 22);
		s2.printInfo();
		
		Student s3 = ac.consult("cc", 23);
		s3.printInfo();
		
		
		
		
		
		
		
//	Student s1 = new Student("일수", 10, true);
//	s1.printInfo();
//	s1.setNum(3);
//	
//	s1.setNum(3);
	
	
	}
}
