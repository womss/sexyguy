package com.beaver.jan214.main;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// MVC중 Model에 해당
public class Doctor {
	
	public static void calculate(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");// 인코딩
			String path = request.getServletContext().getRealPath("img"); // WEB-INF폴더 안에 img 폴더 생성 // 업로드 할 경로
			System.out.println(path);
			
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy()); // 리퀘스트를 잡아먹어버린

			// 싹 받아옴
			String name = mr.getParameter("name");
			double height = Double.parseDouble(mr.getParameter("height"));
			double weight = Double.parseDouble(mr.getParameter("weight"));
			height /= 100; // 미터단위로 바꿔주고
			double bmi = weight / (height * height);
			String result = "저체중";
			if (bmi >= 40) {
				result = "고도비만";
			} else if (bmi >= 35) {
				result = "중증도비만";
			} else if (bmi >= 30) {
				result = "경도비만";
			} else if (bmi >= 25) {
				result = "과체중";
			} else if (bmi >= 18.5) {
				result = "정상";
			}

			// BMI 수치 => 소수점 둘째자리까지만 (** html쪽에서는 안되니 여기서 해결)
			String bmi2 = String.format("%.2f", bmi);
			double bmi3 = Double.parseDouble(bmi2);

			String image = mr.getFilesystemName("photo"); // 한글이 들어가면 인식을 못하는 경우도 있어서
			image = URLEncoder.encode(image, "UTF-8");	// url인코딩 작업
			image = image.replace("+", " ");
			
			// 하나하나 보내는 방법도 있지만
			// 객체를 만들어서 필요한 정보를 담아 한꺼번에 보내자!
			Guest g = new Guest(name, height, weight, bmi3, image, result); // 순서 지켜서 (맨위에 적은 private순서임) ★★★★★
//			mr.setAttribute("g", g);
//				MultipartRequest 에는 setAttribute 메소드가 없음
//				MultipartRequest는 단순히 form과 파일 등을 받아오기 위한 용도
			request.setAttribute("g", g); // ★★★★★
				// 그래서 HttpServlet 클래스를 활용해서만
				//	Attribute를 생성할 수 있음!!!
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
}







































