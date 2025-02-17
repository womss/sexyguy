package com.beaver.dec171.main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TextMain2 {
	public static void main(String[] args) {
		// 뭔가 입력을 받을건데
		// a/b/c/d/e/f/g/...
		// ex) 1/2/a/3 => 총합 : 6 / 평균 : 2
		// 숫자라면.. 총합, 평균을 구해서 출력
		// 글자라면.. 넘기게
		
		Scanner k = new Scanner(System.in);
		System.out.println("입력 a/b/c/d/... : ");
		String s = k.next(); // 뭔가 입력 받을건데
		
		StringTokenizer st = new StringTokenizer(s,"/");
		int n = 0;
		int sum = 0;
		int count = 0;
		
		while (st.hasMoreTokens()) {
			try {
				n = Integer.parseInt(st.nextToken());
				count++;
				sum += n;
			} catch (Exception e) {
			}
		}
		System.out.printf("총합 : %d\n", sum);
		System.out.printf("평균 : %.2f\n", (double) sum / count);
		System.out.println("===========================");
		
		String[] arr =  s.split("/");
		int nArr = 0;
		int sumArr = 0;
		int countArr = 0;
		
		for (int i = 0; i < arr.length; i++) {
			try {
				nArr = Integer.parseInt(arr[i]);
				countArr++;
				sumArr += nArr;
			} catch (Exception e) {
				System.out.println(arr[i] + "때문에 exception 발생 !");
			}
		}
		
		System.out.printf("총합 : %d\n", sumArr);
		System.out.printf("평균 : %.2f\n", (double) sumArr / countArr);
		
		
//		String a = "";
//		int n = 0;
//		while (st.hasMoreTokens()) {
//			System.out.println(a = st.nextToken()); 
//			Integer a1 = Integer.parseInt(a);
//			int a2 = a1;
//			n += a2;
//			System.out.println(n);{
//			}
//		}
	}
}































