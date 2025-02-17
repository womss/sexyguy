package com.beaver.dec192.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SSMain {
	public static void main(String[] args) {
		ServerSocket ss = null;
		
		
		try {
			ss = new ServerSocket(); // 숫자 4자리 넣을건데 일단 비워둠
			System.out.println("...");
			
			Socket s = ss.accept();
			System.out.println("연결됨 !");
			
			Scanner k = new Scanner(System.in);
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			JFrame jf = new JFrame();
			JTextArea jta = new JTextArea();
			jf.add(jta);
			jf.setSize(500, 500);
			jf.setVisible(true);
			
			Thread t = new Thread() {
				
				@Override
				public void run() {
					super.run();
					while (true) {
						try {
							jta.append("상대] " + br.readLine() + "\r\n");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			};
			t.start();
			while (true) {
				System.out.println("나] ");
				String msg = k.next();
				bw.write(msg + "\r\n");
				jta.append("나] " + msg + "\r\n");
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			try {
				ss.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	
}
