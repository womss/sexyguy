
public class Company {
	String name;
	String location;
	int human;

	
	
	public Company() {
		
	}
	
	public Company(String name, String location, int human) {
		super();
		this.name = name;
		this.location = location;
		this.human = human;
	}
	
	public void printInfo() {
		System.out.printf("회사 이름 : %s\n", name);
		System.out.printf("회사 위치 : %s\n", location);
		System.out.printf("회사 직원 수 : %d\n", human);
	}
	
}
