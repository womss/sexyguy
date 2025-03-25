package com.beaver.dec193.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
// 192.168.0.12
// 192.168.0.13
public class SCMain {
	public static void main(String[] args) {
		Socket s = null;
		try {
			s = new Socket("192.168.0.13", 0001); // 서버쪽 ip주소, 포트번호
			System.out.println("연결됨 !");
			Scanner k = new Scanner(System.in);
			
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			while (true) {
				System.out.printf("상대] %s\n", br.readLine());
				
				System.out.println("나] ");
				String msg = k.nextLine();
				bw.write(msg + "\r\n");
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
