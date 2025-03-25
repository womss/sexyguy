
public class Student extends Person {
	int grade;
	
	public Student() {
	}

	
	public Student(String name, int age, String division, int grade) {
		super(name, age, division);
		this.grade = grade;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf("\t학년  : %d학년\n", grade);
	}
	
}
