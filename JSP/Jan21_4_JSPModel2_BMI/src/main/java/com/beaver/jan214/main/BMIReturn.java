// M.java
package com.beaver.jan214.main;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BMIReturn {
	public static void cal(HttpServletRequest request) throws IOException { // 요청객체
		String name = request.getParameter("name");
		double x = Double.parseDouble(request.getParameter("height"));
		double y = Double.parseDouble(request.getParameter("weight"));
		String path = request.getServletContext().getRealPath("img"); // WEB-INF폴더 안에 img 폴더 생성
		
															// 파일 용량 				인코딩 방식			중복이름 방지
		MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		String image = mr.getFilesystemName("photo");
		image = URLEncoder.encode(image, "UTF-8");
		image = image.replace("+", " ");
		
		int bmi = (int) (y / (x * x)/10000);
		
		
		request.setAttribute("bmi", bmi); // 새로 만든 값 리퀘스트 어트리뷰트
	}
}
