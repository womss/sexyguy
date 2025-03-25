// OOP
//	static - 고오오오옹오급 기술
//	생성자
//	객체간의 관계
//		A has a B : 사람 has a 핸드폰
//		A is a B  :	개 is a 동물

public class HMain1 {
	public static void main(String[] args) {
		// 이름이 청포도, 맛이 청포도맛인 사탕
		// 정보를 출력
		
		// 이름이 롯데, 위치가 잠실, 직원수가 100명인 회사
		// 정보를 출력
		
		Candy c = new Candy("청포도", "청포도맛");
		c.printInfo();
		System.out.println("-----------------------");
		
		Company f = new Company("롯데","잠실", 100);
		f.printInfo();
		System.out.println("-----------------------");

		// 청포도 사탕을 롯데에서 만들었다! => ?
		c.brand = f;
		
		// 청포도 사탕의 제조사의 정보를 출력
		c.brand.printInfo();
		System.out.println("-----------------------");
		
		// 삼성, 수원, 300명이 다니는 회사의 정보를 출력
		
		// CPU가 i7-1234, RAM 32GB, SSD 500GB인 삼성컴퓨터
		//	컴퓨터 / 회사 정보를 출력
		Company co2 = new Company("삼성", "수원", 300);
		co2.printInfo();
		System.out.println("-----------------");
		
		Computer com = new Computer("i7-1234", 32, 500, co2);
		com.printInfo();
		System.out.println("-----------------");
	}
}
