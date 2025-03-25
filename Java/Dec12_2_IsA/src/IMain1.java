// 객체간의 관계 = 상속관계
//	A is a B : Cat is a Animal
public class IMain1 {
	public static void main(String[] args) {
		Animal a = new Animal("asdf", 1);
		// 동물(Animal) Class => sort, age + 정보 출력 기능
		Cat c = new Cat();
		c.printInfo();
		System.out.println("-----------------------");
		Dog d = new Dog("포메", 5, "우리집");
		d.printInfo();
		System.out.println("-----------------------");
	
		// 상속이 필요한 이유는 코드의 중복을 없애기 위함
		// 코드의 중복이 많아지면 개발 단계에서도 힘들지만,
		//	유지 보수에도 많은 비용이 들어갈 것
		// 그래서 개발을 할 때 코드의 중복은 피하는 것이 좋음
		// OOP에서는 상속을 통해서 코드의 중복문제를 어느정도 해결할 수 있음
		
	}
}
