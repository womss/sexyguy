
public class Animal {
	// 속성
	String sort;
	int age;
	
	// 기본 생성자
	public Animal() { // 기본 생성자를 만들지 않아도 객체를 만들면 컴파일러에서 자동 생성이 되기 때문에 생성자 오버로딩만 만들고 객체를 활용하는경우에는 무리없이 돌아가나
						//객체를 안만들고 오버로딩을 만드는 경우엔 생성자가 안생겼기 때문에 안된다
	}
	
	// 생성자 오버로딩 
	public Animal(String sort, int age) {
		super();
		this.sort = sort;
		this.age = age;
	}
	
	// 정보 출력 method
	public void printInfo() {
		System.out.printf("동물의 종류는 : %s\n", sort);
		System.out.printf("동물의 나이는 : %d\n", age);
	}
	
}
