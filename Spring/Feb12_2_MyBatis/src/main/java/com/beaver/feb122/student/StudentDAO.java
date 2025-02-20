package com.beaver.feb122.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDAO {
	
	@Autowired
	private SqlSession ss;
	
	// SqlSessionTemplate
	//	SqlSession의 하위클래스
	//	뜯어본다면 (public class SqlSessionTemplate implements SqlSession)의 구조
	//		=> SqlSession의 기능은 다 들어있고 뭔가 더 추가됨
	//		=> 자동연결 / 자동해제 / 자동 commit
	
	public void regStudent(Student s, HttpServletRequest req) { // 학생 객체와 요청파라미터
		try {
			// 연결 - 자동(SqlSessionTemplete 때문에 )
			//		- connect, close 필요 X
			
			// 값을 받아오기 & 객체로 만들기 - 변수명을 일치시켰기 때문에 Spring이 해결을 자동으로 해줌
			
			// 내용 출력
//			System.out.println(s.getS_name());
//			System.out.println(s.getS_nickname());
			
			// SQL 수행 - MyBatis를 활용
			//	interface(추상메소드)를 가져온다!
			StudentMapper sm = ss.getMapper(StudentMapper.class);
			
			// interface에 있는 abstract method(추상메소드) 호출
			//	-자동-> 연결이 되어있는 mapper.xml의 해당부분이 실행
			if (sm.regStudent(s) == 1) {// 추상메소드를 호출했을 때에 영향을 받은 데이터의 수가 하나라면
				req.setAttribute("r", "학생 등록 성공");
//				ss.commit(); => commit 자동!(얘도 해주긴 함)
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "학생 등록 실패");
		}
	}
	// DB작업 끝
	public void getAllStudent(HttpServletRequest req) {
		try {
//			List<Student> student = ss.getMapper(StudentMapper.class).getAllStudent();
//			req.setAttribute("student", student);
			// 위에걸 한줄로 줄인다면
			req.setAttribute("students", ss.getMapper(StudentMapper.class).getAllStudent());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	













}















