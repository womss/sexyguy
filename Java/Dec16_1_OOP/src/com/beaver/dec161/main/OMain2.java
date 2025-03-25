// Java GUI프로그램 (graphic User Interface)
//	AWT, Swing, javaFX

// AWT : 자바 초창기에 나온 GUI (그래픽관런)라이브러리
//		운영체제(OS)에 따라서 모양이 다 달랐기 때문에,
//		종류도 상당히 제한적이었다.
// Swing : AWT 다음으로 등장한 라이브러리
//		윈도우 프로그램 - 자바로 x
//			: 느림, 더 최적화된 C언어라인이 있음
//		윈도우 프로그램 잘 안만듬... => 웹/앱쪽으로 넘어옴
//		- 결론적으로는 별로!, 디자인이 별로!
// JavaFX : Swing의 느린 처리속도를 보완해서 출시됨
//		다양한 기능들도 추가 + 따로 외관 꾸미는 것도 가능해짐
//		여전히 웹/앱쪽에서 구현하면 되기 때문에... 그닥...!

// 이런게 있다 정도만 인지하고 넘어가면 됨 // 오늘 한거?



package com.beaver.dec161.main;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.beaver.dec161.avengers.Hulk;

public class OMain2 {
	public static void main(String[] args) {
		JFrame jf = new JFrame("지구");
		JButton jb = new JButton("타노스");
		jf.add(jb);
		
		// 헐크 - actionPerformed()가 반드시 필요
		//			(미완성된 메소드)
		
		// 헐크 생성
		Hulk h = new Hulk();
		
		// 타노스가 전담영웅으로 헐크를 골랐음
		// 도움을 요청
		jb.addActionListener(h);
		
		// 크기, 눈에 보이게
		jf.setSize(500, 500);
		jf.setVisible(true);
		
		
		
	}
}































