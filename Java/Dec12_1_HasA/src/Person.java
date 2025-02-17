
public class Person {
	String name;
	String sex;
	int phonenum;
	
	public Person() {
	}

	public Person(String name, String sex, int phonenum) {
		this.name = name;
		this.sex = sex;
		this.phonenum = phonenum;
	}
	
	public void printOner() {
		System.out.printf("이름 : %s\n성별 : %s\n휴대폰 번호 : 010%d\n", name, sex, phonenum);
	}
	
	
}
