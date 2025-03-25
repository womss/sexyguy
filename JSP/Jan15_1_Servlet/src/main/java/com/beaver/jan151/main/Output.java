package com.beaver.jan151.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/Output")
public class Output extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String fileName1 = request.getParameter("photo");
		String fileName2 = request.getParameter("etc");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>web</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		
		out.printf("<h1>제목 : %s</h2>", title);
		out.printf("<h1>파일명 : %s</h1>", fileName1);
		out.printf("<img src='%s'>", fileName1);
		// 주소 요청파라미터를 보면 값은 불러와졌는데
		// 파일 자체가 업로드가 안되었으니 안불러와지겠죠...?
		out.printf("<h1>%s</h1>", fileName2);
		out.printf("<a href='%s'>다운</a>", fileName2);
		
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기존(주황색)방식으로 전송된 요청파라미터 한글처리
//		request.setCharacterEncoding("UTF-8");
		
		// 기존(주황색)방식으로 전송된 요청파라미터 값 읽기
//		String title = request.getParameter("title");
		
		response.setCharacterEncoding("UTF-8");
		
		// 파일 업로드
		// 파일이 업로드가 될 서버상의 폴더의 절대경로
		String path = request.getServletContext().getRealPath("img"); // webapp 안에 있는 img라는 뜻
		System.out.println(path); // 절대 경로의 위치
		
		// 파일 업로드
		MultipartRequest mr = new MultipartRequest(
				request, path,
				// 잡아먹고 절대경로도 가지게 한다
				// 허용할 파일의 최대크기(byte)
				10 * 1024 * 1024,
				// 요청파라미터 인코딩 방식
				"UTF-8",
				// 사용자가 업로드한 파일명 중복될 때 처리
				// 중복시에 파일명 뒤에 숫자를 붙이게 하는 방식을 채택
				new DefaultFileRenamePolicy()
				);
		
		String title = mr.getParameter("title");
		
		// 업로드한 파일명(중복처리된)
		String fileName = mr.getFilesystemName("photo");
		
		// DB에 파일명 저장할 때 => 용량을 상당히 여유있게 만들어야!!
		//		ex) f_name varchar2(200 cahr)
		// 왜?
		// 그 이유는 : 톰캣이 한글로 된 파일명 인식 못함
		//		ㅋ.png => %2A.png (URL 인코딩이면 인식 O)
		fileName = URLEncoder.encode(fileName, "UTF-8");
		
		// 아래는 알집을 가져올 때 해당
		String fileName2 = mr.getFilesystemName("etc");
		fileName2 = URLEncoder.encode(fileName2, "UTF-8");
		fileName2 = fileName2.replace("+", " ");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>web</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		
		out.printf("<h1>제목 : %s</h2>", title);
		out.printf("<h1>파일명 : %s</h1>", fileName);
		out.printf("<img src='img/%s'>", fileName); // 상대경로 O
		// 주소 요청파라미터를 보면 값은 불러와졌는데
		// 파일 자체가 업로드가 안되었으니 안불러와지겠죠...?
		out.printf("<h1>%s</h1>", fileName2);
		out.printf("<a href='img/%s'>다운</a>", fileName2);
		
		out.print("</body>");
		out.print("</html>");
	}
		
		
	}


