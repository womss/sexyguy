package com.beaver.Jan171.main;

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


@WebServlet("/BMIOutput")
public class BMIOutput extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String height = request.getParameter("height");
		double height1 = Double.parseDouble(height);
		String weight = request.getParameter("weight");
		double weight1 = Double.parseDouble(weight);
		String photo = request.getParameter("photo");
		
		int bmi = (int) (weight1 / ((height1 * height1)/10000));
		PrintWriter out = response.getWriter();
		
		
		
		out.print("<html>");
		out.print("<head><title>BMI</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		
		out.printf("<h1>이름 : %s</h2>", name);
		out.printf("<h1>키 : %.1fcm</h1>", height1);
		out.printf("<h1>몸무게 :%.1fkg</h1>", weight1);
		out.printf("<h1>bmi :%d</h1>", bmi);
		out.printf("<h3>bmi검사 	결과는</h3>");
		if (bmi < 18.5) {
			out.printf("<h2>저체중입니다</h2>");
		} else if (bmi >= 18.5 || bmi < 25) {
			out.printf("<h2>정상입니다</h2>");
		} else if (bmi >= 25 || bmi < 30) {
			out.printf("<h2>과체중입니다</h2>");
		} else if (bmi >= 30 || bmi < 35) {
			out.printf("<h2>경도비만입니다</h2>");
		} else if (bmi >= 35 || bmi < 40) {
			out.printf("<h2>중증도비만입니다</h2>");
		} else if (bmi >= 40) {
			out.printf("<h2>고도비만입니다</h2>");
		}
		
		out.printf("<img src='%s'>", photo);
//		out.printf("<a href='%s'>보기</a>", photo);
		// 주소 요청파라미터를 보면 값은 불러와졌는데
		// 파일 자체가 업로드가 안되었으니 안불러와지겠죠...?
//		out.printf("<h1>%s</h1>", fileName2);
		
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String path = request.getServletContext().getRealPath("img");
		System.out.println(path);
		MultipartRequest mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "UTF-8",new DefaultFileRenamePolicy());
		
		String name = mr.getParameter("name");			// 이름
		
		String height = mr.getParameter("height");		// 키 (문자열로 받아옴)
		double height1 = Double.parseDouble(height);		// 키 (문자 => 숫자로 변환)
		
		String weight = mr.getParameter("weight");		// 몸무게 (문자열로 받아옴)
		double weight1 = Double.parseDouble(weight);		// 몸무게 (문자 => 숫자로 변환)
		
		String photo = mr.getFilesystemName("photo");		// 사진 (문자열로 받아옴)
		photo = URLEncoder.encode(photo, "UTF-8");			// ??
		
		PrintWriter out = response.getWriter();
		
		int bmi = (int) (weight1 / ((height1 * height1)/10000));
		
		
		out.print("<html>");
		out.print("<head><title>BMI</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		
		out.printf("<h1>이름 : %s</h2>", name);
		out.printf("<h1>키 : %.1fcm</h1>", height1);
		out.printf("<h1>몸무게 :%.1fkg</h1>", weight1);
		out.printf("<h1>bmi :%d</h1>", bmi);
		out.printf("<h3>bmi검사 	결과는</h3>");
		if (bmi < 18.5) {
			out.printf("<h2>저체중입니다</h2>");
		} else if (bmi >= 18.5 && bmi < 25) {
			out.printf("<h2>정상입니다</h2>");
		} else if (bmi >= 25 && bmi < 30) {
			out.printf("<h2>과체중입니다</h2>");
		} else if (bmi >= 30 && bmi < 35) {
			out.printf("<h2>경도비만입니다</h2>");
		} else if (bmi >= 35 && bmi < 40) {
			out.printf("<h2>중증도비만입니다</h2>");
		} else if (bmi >= 40) {
			out.printf("<h2>고도비만입니다</h2>");
		}
		
		out.printf("<img src='img/%s'>", photo);
		out.print("</body>");
		out.print("</html>");
	}

}
