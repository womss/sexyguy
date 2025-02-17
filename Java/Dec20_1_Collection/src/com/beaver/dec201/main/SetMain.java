package com.beaver.dec201.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

// Set 계열
//		가변사이즈
//		중복데이터 자동 삭제
//			같은 내용 여러번 들어오면 하나만 남김
//		순서가 랜덤
//		HashSet, TreeSet, ...
//			=> 실전에서는 그닥 유용하지 않음

public class SetMain {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("ㅁㅁ");
		hs.add("ㄴㄴ");
		hs.add("ㅎㅎ");
		hs.add("ㄹㄹ");
		hs.add("ㅎㅎ");
		hs.add("ㄹㄹ");
		System.out.println(hs.size());
		
		for (String s : hs) {
			System.out.println(s);
		}
		System.out.println("-------------------------");
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(123);
		al.add(1011);
		al.add(1819);
		al.add(123);
		al.add(456);
		al.add(789);
		al.add(20201);
		al.add(1011);
		al.add(123);
		al.add(789);
		
		// 중복 제거
		HashSet<Integer> hs2 = new HashSet<Integer>(al);
		for (Integer i : hs2) {
			System.out.println(i);
		}
		System.out.println("------------------");
		
		al = new ArrayList<Integer>(hs2); // 중복 제거 후 다시 list로
		
		// 내림차순 정렬 출력
		Comparator<Integer> c = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		};
		al.sort(c);
		for (Integer i : al) {
			System.out.println(i);
		}
	}
}
