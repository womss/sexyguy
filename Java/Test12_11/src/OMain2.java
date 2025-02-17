
public class OMain2 {

	
	public static void main(String[] args) {
		
	
	School c1 = new School("서울고등학교", "서울 종로구	");
	School c2 = new School("경기고등학교", "경기 수원");
		
		
	Student s1 = new Student("김철수", 1, 1, c1);
	Student s2 = new Student("이영희", 2, 2, c2);
	Student s3 = new Student("고영희", 1, 2, c1);
	
	s1.printStudent();
	System.out.println("----------------------------------");
	s2.printStudent();
	System.out.println("----------------------------------");
	s3.printStudent();
	
	
	
	
	
	}
	
	
	
}
