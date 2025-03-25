package com.beaver.dec201.main;

import java.util.ArrayList;
import java.util.Comparator;

// ArrayList
//	요소를 인덱스로 사용하는 것이 배열과 유사
//	배열 : 사이즈가 고정 => 데이터의 수가 배열의 크기보다
//						많아지면 저장이 불가능 !
//	ArrayList : 저장되는 데이터의 수에 따라서 크기가 자동적으로 변경
//				요소가 가득차게 되면 ArrayList의
//				크기를 동적으로 증가시키고, 그 반대도 마찬가지
//				자료형을 섞어서 데이터를 넣는것이 가능!
//					- 좋다 ? => 글쎄...?

// 자료형을 통일하고 싶다 !
//		< > - generic
//		자료형을 고정하는 역할
//		클래스명<자료형의 객체형> 의 형태

public class ListMain {
	public static void main(String[] args) {
		ArrayList test = new ArrayList();
		test.add("크리스마스");
		test.add(1225);
		test.add("무야호~");
		test.add(12.25);
		test.add(true);
		for (Object object : test) { // 자료형이 통일되지 않아
									// Object라는게 헷갈림
			System.out.println(object);
		}
		System.out.println("---------------------------");
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("파인애플");
//		System.out.println(al);
//		al.add(1); // 에러 ! String만 넣을 수 있음!
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(new Integer(100));
		al2.add(50); // Auto-Boxing 							// 배웠던거 찾아보기
		
		System.out.println(al2.get(0)); // 해당 인덱스 값
		System.out.println(al2.size()); // al2의 요소 갯수
		System.out.println("---------------------------");
		for (int i = 0; i < al2.size(); i++) {
			System.out.println(al2.get(i));
		}
		System.out.println("----------------------------");
		al2.add(30); // 100, 50뒤에 30이 들어감
		al2.add(1, 90); // 1번 자리에 90넣기 => 100, 90, 50, 30
		al2.set(2, 0);	// 2번 자리의 값을 0으로 바꾸기
		al2.remove(0);	// 0번 자리에 있는 값을 지움
		
		for (int i = 0; i < al2.size(); i++) {
			System.out.println(al2.get(i));
		}
		System.out.println("----------------------------");
		
		al.add("수박");
	      al.add("귤");
	      al.add("사과");
	      al.add("감");
	      al.add("asdf");
	      al2.add(84);
	      al2.add(2173);
	      al2.add(300);
	      al2.add(35);
	      
	      // 정렬 기능
	      Comparator<String> c = new Comparator<String>() {
	         
	         @Override
	         public int compare(String o1, String o2) { // 내림차순 할거냐, 오름차순 할거냐
	            return o1.compareTo(o2); // 오름차순
	         }
	      };
	      al.sort(c);
	      
	      for (String s : al) {
	         System.out.println(s);
	      }
	      System.out.println("=====================");
		
	      Comparator<Integer> v = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
//				return o1.compareTo(o2); // 오름차순
				return o2.compareTo(o1); // 내림차순
			}
		};
		al2.sort(v);
		for (Integer i : al2) {
			System.out.println(i);
		}
		
		
	}
}











