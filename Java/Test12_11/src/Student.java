
public class Student {
	String name;
	int grade;
	int classnumber;
	School school;

	public Student() {
	}

	
	public Student(String name, int grade, int classnumber, School school) {
		this.name = name;
		this.grade = grade;
		this.classnumber = classnumber;
		this.school = school;
	}

	public void printStudent() {
		System.out.printf(" 이름 : %s │ %d학년 │ %d번\n", name, grade, classnumber);
		if (name != null) {
			System.out.printf("학생은 다음 학교에 다닙니다\n");
			school.printSchool();
			
		}
	}
	
}
