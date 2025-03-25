
public class Person {
	String name;
	int age;
	String division;
	
	public Person() {
	}

	public Person(String name, int age, String division) {
		super();
		this.name = name;
		this.age = age;
		this.division = division;
	}

	
	public void printInfo() {
		System.out.printf("\t이름은 : %s\n",name);
		System.out.printf("\t나이는 : %d살\n", age);
		System.out.printf("\t소속은 : %s\n", division);
	}
	
}
