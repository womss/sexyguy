package com.beaver.dec172.main;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReadMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			// 파일 => 프로그램 (InputStreamReader 개조)
			FileReader fr = new FileReader("C:\\Users\\sdedu\\Desktop\\Hi\\beaver1.txt");
			br = new BufferedReader(fr);
			String line = null;
			while ( (line = br.readLine() ) != null ) {
				System.err.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
