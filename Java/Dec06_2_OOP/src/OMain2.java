// Coder : 개발자
// Programmer : Coder + 설계 ***

public class OMain2 {
	public static void main(String[] args) {
	// 의사 (이름, 나이)
	Dr2 dre = new Dr2();
	dre.name = "dre";
	dre.age = 56;
	dre.printDr();
	
	// 손님 (이름, 나이)
	guest2 g = new guest2();
	g.name = "snoop";
	g.age = 54;
	g.printGeust2();
	
	
	Dr2 dr2 = new Dr2();
	dr2.start(g);
	
	
}
}



