
public class School {
	String name;
	String location;
	
	public School() {
	}

	public School(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public void printSchool() {
		System.out.printf("학교 이름 : %s, 위치 %s\n", name, location);
		
	}
	
}
